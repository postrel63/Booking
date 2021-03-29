package DTO;

public class CartDTO {

	
	private int cartId; //장바구니 번호
	private String userId; //구매자 아이디
	private String userName;//구매자 이름
	private int bCode; //상품 번호
	private String bName; //상품 이름
	private int amount;    //상품 수량
	private int bPrice;   //상품 가격
	private int bPoint;   //포인트
	private String bFile;
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getbCode() {
		return bCode;
	}
	public void setbCode(int bCode) {
		this.bCode = bCode;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getbPrice() {
		return bPrice;
	}
	public void setbPrice(int bPrice) {
		this.bPrice = bPrice;
	}
	public int getbPoint() {
		return bPoint;
	}
	public void setbPoint(int bPoint) {
		this.bPoint = bPoint;
	}
	public String getbFile() {
		return bFile;
	}
	public void setbFile(String bFile) {
		this.bFile = bFile;
	}
	@Override
	public String toString() {
		return "CartDTO [cartId=" + cartId + ", userId=" + userId + ", userName=" + userName + ", bCode=" + bCode
				+ ", bName=" + bName + ", amount=" + amount + ", bPrice=" + bPrice + ", bPoint=" + bPoint + ", bFile="
				+ bFile + "]";
	}
	
	
	
	
	
}
