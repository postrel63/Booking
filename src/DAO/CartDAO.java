package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static DB.jdbcUtil.*;
import DTO.CartDTO;

	public  class CartDAO {
		private static CartDAO dao;
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;

		private CartDAO() {
		};

		public static CartDAO getInstance() {
			if (dao == null) {
				dao = new CartDAO();
			}
			return dao;
		}

		public void setConnection(Connection con) {
			this.con = con;
		}

		
		
		public int cartInsert(String bName, String amount, String userId) {
			String sql = "INSERT INTO CART VALUES(CARTIDSEQ.NEXTVAL,?,?,?)";
			int result = 0;
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userId);
				pstmt.setString(2, bName);
				pstmt.setString(3, amount);
				result=pstmt.executeUpdate();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			
			return result;
		}

		public ArrayList<CartDTO> CartView(String loginId) {
			ArrayList<CartDTO> CartView = new ArrayList<CartDTO>();
			CartDTO cart;
			String sql = "SELECT * FROM LNW_JSP.BOOKS INNER JOIN CART ON CB_NAME = BNAME WHERE USERID=?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, loginId);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					cart = new CartDTO();
					cart.setbCode(rs.getInt(1));
					cart.setbName(rs.getString("BNAME"));
					cart.setbPrice(rs.getInt(5));
					cart.setbPoint(rs.getInt(8));
					cart.setCartId(rs.getInt("CARTID"));
					cart.setUserId(rs.getString("USERID"));
					cart.setAmount(rs.getInt(14));
					cart.setbFile("BFILE");
					CartView.add(cart);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
				close(rs);
			}
			return CartView;
		}

		public int CartSum(String loginId) {
			System.out.println(loginId);
			String sql ="SELECT BPRICE*AMOUNT FROM LNW_JSP.BOOKS INNER JOIN CART ON CB_NAME = BNAME WHERE USERID=?";
			int sum = 0;
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, loginId);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					System.out.println(sum);
					sum+=rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
				close(rs);
			}
			return sum;
		}

		public String cartdupli(String loginId, String bName) {
			String sql ="SELECT CB_NAME FROM CART WHERE USERID=? AND CB_NAME=?";
			String Result = null;
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, loginId);
				pstmt.setString(2, bName);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Result = rs.getString(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return Result;
		}

		public int cartdelete(String loginId, int cartId) {
			String sql = "DELETE FROM CART WHERE USERID=? AND CARTID=?";
			int result = 0;
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, loginId);
				pstmt.setInt(2, cartId);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}		
		
	}
	
