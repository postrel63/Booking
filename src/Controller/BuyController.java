package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.CartDTO;
import DTO.OrderDTO;
import Service.CartService;
import Service.buyService;

/**
 * Servlet implementation class BuyController
 */
@WebServlet({ "/buy/buyForm", "/buy/buyProcess","/buy/orderView" })
public class BuyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		CartService cartservice = new CartService();
		RequestDispatcher dispatcher;
		buyService buyservice = new buyService();
		HttpSession session = request.getSession();
		PrintWriter out;
		OrderDTO order = new OrderDTO();

		switch (request.getServletPath()) {
		//장바구니에 담긴 상품을 구매하기 위한 컨트롤러 ( 구매페이지를 띄워줌)
		case "/buy/buyForm":
			System.out.println("/buy/buyForm");
			String loginId = (String) session.getAttribute("loginId");

			ArrayList<CartDTO> CartList = new ArrayList<CartDTO>();

			CartList = cartservice.cartView(loginId);
			System.out.println("buyFormView에서 List 출력" + CartList);
			int CartSum = cartservice.CartSum(loginId);
			request.setAttribute("cartsum", CartSum);
			request.setAttribute("cartlist", CartList);
			dispatcher = request.getRequestDispatcher("/buy/CartBuy.jsp");
			dispatcher.forward(request, response);
			break;

			//구매페이지에 있는 상품들을 구매하는 컨트롤러( orderlist 테이블에 주문정보를 담는 과정)
		case "/buy/buyProcess":

			loginId = (String) session.getAttribute("loginId");
			System.out.println("loginId");
			System.out.println("buyProcess");

			order.setUserName(request.getParameter("userName"));
			order.setUserPN(request.getParameter("userPN"));
			order.setUserAddress(request.getParameter("useraddrss"));
			order.setPayMethod(request.getParameter("PayMethod"));

			int result = buyservice.buyProcess(order, loginId);

			if (result > 0) {
				response.setContentType("text/html; charset=UTF-8");
				out = response.getWriter();
				out.println("<script>");
				out.println("alert('구매성공')");
				out.println("history.back()");
				out.println("</script>");
				response.sendRedirect("orderView");

			}
			break;
			
			// 주문내역을 확인하기위한 컨트롤러
		case "/buy/orderView":
			System.out.println("orderView");
			loginId = (String) session.getAttribute("loginId");
			System.out.println(loginId);
			ArrayList<OrderDTO> orderlist = new ArrayList<OrderDTO>();
			orderlist = buyservice.orderlist(loginId);
			System.out.println(orderlist);
			if(orderlist != null) {
				request.setAttribute("orderlist",orderlist);
				dispatcher = request.getRequestDispatcher("orderView.jsp");
				dispatcher.forward(request, response);
			}
			
			break;
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

}
