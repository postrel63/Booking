package DTO;

import java.sql.Date;

public class MemberDTO {
private String userId;
private String userPw;
private String userName;
private Date userBirth;
private String userGender;
private String userEmail;
private int userPoint;
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getUserPw() {
	return userPw;
}
public void setUserPw(String userPw) {
	this.userPw = userPw;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public Date getUserBirth() {
	return userBirth;
}
public void setUserBirth(Date userBirth) {
	this.userBirth = userBirth;
}
public String getUserGender() {
	return userGender;
}
public void setUserGender(String userGender) {
	this.userGender = userGender;
}
public String getUserEmail() {
	return userEmail;
}
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}
public int getUserPoint() {
	return userPoint;
}
public void setUserPoint(int userPoint) {
	this.userPoint = userPoint;
}
@Override
public String toString() {
	return "MemberDTO [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userBirth=" + userBirth
			+ ", userGender=" + userGender + ", userEmail=" + userEmail + ", userPoint=" + userPoint + "]";
}

	
}
