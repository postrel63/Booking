package Service;

import java.sql.Connection;
import static DB.jdbcUtil.*;

import DAO.MemberDAO;
import DTO.MemberDTO;

public class MemberService {

	public int memberJoin(MemberDTO join) {
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		
		
		int result = dao.memberJoin(join);
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	public String checkId(String uId) {
		
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		String resultMsg;
		String checkIdResult = dao.checkId(uId); 
		System.out.println("checkIdResult:"+checkIdResult);
		if(checkIdResult == null) {
			resultMsg = "OK";
		}else {
			resultMsg = "NO";
			
		}
		System.out.println(resultMsg);
		close(con);
		
		return resultMsg;
	
	}

	public String memberlogin(String userId, String userPw) {
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		String loginId = dao.memberLogin(userId,userPw);
		System.out.println(loginId);
		return loginId;
	}

}
