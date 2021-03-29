package Service;

import static DB.jdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import DAO.BuyDAO;
import DAO.CartDAO;
import DTO.CartDTO;
import DTO.OrderDTO;

public class buyService {

	public int buyProcess(OrderDTO order, String loginId) {
		BuyDAO dao = BuyDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		OrderDTO orderdto = new OrderDTO();
		

		//구매 페이지 상품을 orderlist 에 담는 과정
		int buyupdate = dao.buyupdate(order, loginId);
		if (buyupdate > 0) {
			commit(con);
			int delresult = dao.delcart(loginId);
			if (delresult > 0) {
				commit(con);
			} else {
				rollback(con);
			}
		} else {
			rollback(con);
		}

		return buyupdate;
	}

	public ArrayList<OrderDTO> orderlist(String loginId) {
		BuyDAO dao = BuyDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		ArrayList<OrderDTO> orderlist = new ArrayList<OrderDTO>();
		orderlist = dao.orderlist(loginId);
		
		return orderlist;
	}

}
