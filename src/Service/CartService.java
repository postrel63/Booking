package Service;

import static DB.jdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import DAO.CartDAO;
import DTO.CartDTO;


public class CartService {
	public int cartInsert(String bName, String amount, String userId) {
		CartDAO dao = CartDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		
		int result = dao.cartInsert(bName,amount,userId);
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		return result;
	}

	public ArrayList<CartDTO> cartView(String loginId) {
		CartDAO dao = CartDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		
		ArrayList<CartDTO> cartView = new ArrayList<CartDTO>();
		cartView = dao.CartView(loginId);
		
		if(cartView !=null) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return cartView;
	}
	
	
	//장바구니에 담긴 상품들 총액을 확인하기위한 메소드
	public int CartSum(String loginId) {
		CartDAO dao = CartDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int SumResult = dao.CartSum(loginId);
		if(SumResult>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return SumResult;
		
	}

	//장바구니에 담긴 상품들 중복체크 
	public String cartdupli(String loginId, String bName) {
		
		CartDAO dao = CartDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		String dupliResult = dao.cartdupli(loginId,bName);
		
		return dupliResult;
	}

	public int cartdelete(String loginId,int cartId) {
		CartDAO dao = CartDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int cartdelete = dao.cartdelete(loginId,cartId);
		if(cartdelete>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return cartdelete;
	}
	
	

}
