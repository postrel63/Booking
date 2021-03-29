package DAO;

import static DB.jdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.MemberDTO;

public class MemberDAO {
	private static MemberDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	private MemberDAO() {
	};

	public static MemberDAO getInstance() {
		if (dao == null) {
			dao = new MemberDAO();
		}
		return dao;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}
	public String checkId(String uId) {
		String sql = "SELECT USERID FROM LNW_JSP.MEMBERS WHERE USERID=?";
		String result = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,uId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return result;
	}

	public int memberJoin(MemberDTO join) {
		String sql = "INSERT INTO LNW_JSP.MEMBERS VALUES(?,?,?,?,?,?,0)";
		int result = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, join.getUserId());
			pstmt.setString(2, join.getUserPw());
			pstmt.setString(3, join.getUserName());
			pstmt.setDate(4, join.getUserBirth());
			pstmt.setNString(5, join.getUserGender());
			pstmt.setString(6, join.getUserEmail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);

		}

		return result;
	}

	public String memberLogin(String userId, String userPw) {
		String sql = "SELECT USERID FROM LNW_JSP.MEMBERS WHERE USERID=? AND USERPW=?";
		String result = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}
}
