package DTO;

public class OrderDTO {
private String userId;
private String userName;
private String bName;
private int bPrice;
private String userAddress;
private String userPN;
private String payMethod;
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}


@Override
public String toString() {
	return "OrderDTO [userId=" + userId + ", userName=" + userName + ", bName=" + bName + ", bPrice=" + bPrice
			+ ", userAddress=" + userAddress + ", userPN=" + userPN + ", payMethod=" + payMethod + "]";
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getbName() {
	return bName;
}
public void setbName(String bName) {
	this.bName = bName;
}
public int getbPrice() {
	return bPrice;
}
public void setbPrice(int bPrice) {
	this.bPrice = bPrice;
}
public String getUserAddress() {
	return userAddress;
}
public void setUserAddress(String userAddress) {
	this.userAddress = userAddress;
}
public String getUserPN() {
	return userPN;
}
public void setUserPN(String userPN) {
	this.userPN = userPN;
}
public String getPayMethod() {
	return payMethod;
}
public void setPayMethod(String payMethod) {
	this.payMethod = payMethod;
}




}
