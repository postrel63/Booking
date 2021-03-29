package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static DB.jdbcUtil.*;

import DTO.OrderDTO;

public class BuyDAO {
	private static BuyDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	private BuyDAO() {
	};

	public static BuyDAO getInstance() {
		if (dao == null) {
			dao = new BuyDAO();
		}
		return dao;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int buyupdate(OrderDTO order, String loginId) {
		String sql = "SELECT BNAME, BPRICE FROM LNW_JSP.BOOKS INNER JOIN CART ON CB_NAME = BNAME WHERE USERID=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String sql2 = "INSERT INTO ORDERLIST VALUES(?,?,?,?,?,?,?)";
				try {
					pstmt = con.prepareStatement(sql2);
					pstmt.setString(1, loginId);
					pstmt.setString(2, order.getUserName());
					pstmt.setString(3, rs.getString(1));
					pstmt.setString(4, rs.getString(2));
					pstmt.setString(5, order.getUserAddress());
					pstmt.setString(6, order.getUserPN());
					pstmt.setString(7, order.getPayMethod());
					result = pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}

	public int delcart(String loginId) {
		String sql = "DELETE CART WHERE USERID=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}

	public ArrayList<OrderDTO> orderlist(String loginId) {
		ArrayList<OrderDTO> orderlist = new ArrayList<OrderDTO>();
		OrderDTO order;
		
		String sql = "SELECT * FROM ORDERLIST WHERE USERID=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				order= new OrderDTO();
				order.setUserId(rs.getString(1));
				order.setUserName(rs.getString(2));
				order.setbName(rs.getString(3));
				order.setbPrice(rs.getInt(4));
				order.setUserAddress(rs.getString(5));
				order.setUserPN(rs.getString(6));
				order.setPayMethod(rs.getString(7));
				orderlist.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return orderlist;
	}
}
