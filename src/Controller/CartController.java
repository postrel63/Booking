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
import Service.CartService;

/**
 * Servlet implementation class CartController
 */
@WebServlet({ "/Books/CartInsert", "/cart/CartView", "/cart/CartDelete" })
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		CartService cartservice = new CartService();
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher;
		PrintWriter out;

		switch (request.getServletPath()) {
		// 장바구니에 상품을 넣는 컨트롤러
		case "/Books/CartInsert":
			System.out.println("cart");
			String bName = (String) request.getParameter("bName");
			String amount = (String) request.getParameter("amount");
			String loginId = (String) session.getAttribute("loginId");

			System.out.println(bName);
			System.out.println(amount);

			// 상품 중복체크 하는 부분
			String Cartdupli = cartservice.cartdupli(loginId, bName);
			if (Cartdupli != null) {
				response.setContentType("text/html; charset=UTF-8");
				out = response.getWriter();
				out.println("<script>");
				out.println("alert('이미 장바구니에 존재하는 상품입니다.')");
				out.println("history.back()");
				out.println("</script>");
				break;
			}

			int result = cartservice.cartInsert(bName, amount, loginId);
			if (result > 0) {
				response.setContentType("text/html; charset=UTF-8");
				out = response.getWriter();
				out.println("<script>");
				out.println("alert('장바구니에 담김')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				System.out.println("실패");
			}
			break;

		// 장바구니 보여주는 컨트롤러
		case "/cart/CartView":
			System.out.println("CartView");
			loginId = (String) session.getAttribute("loginId");

			ArrayList<CartDTO> CartList = new ArrayList<CartDTO>();

			CartList = cartservice.cartView(loginId);
			System.out.println("CartView에서 List 출력" + CartList);
			int CartSum = cartservice.CartSum(loginId);
			request.setAttribute("cartsum", CartSum);
			request.setAttribute("cartlist", CartList);
			dispatcher = request.getRequestDispatcher("/Cart/Cart.jsp");
			dispatcher.forward(request, response);
			break;

		// 장바구니 상품 제거 컨트롤러
		case "/cart/CartDelete":
			System.out.println("CartDelete");
			int cartId = Integer.parseInt(request.getParameter("cartId"));
			loginId = (String) session.getAttribute("loginId");
			System.out.println(cartId);
			int cartdelete = cartservice.cartdelete(loginId, cartId);

			if (cartdelete > 0) {
				response.sendRedirect("CartView");
			} else {

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
		doProcess(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
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
