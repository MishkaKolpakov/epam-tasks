package model.Entity;

import java.util.Date;

public class Note {

	private String lastName;
	private String firstName;
	private String middleName;
	private String lastNameFirstnameIntitial;
	private String nickName;
	private String commentary;
	private String homePhoneNumber;
	private String mobilePhoneNumber;
	private String alternativephoneNumber;
	private String email;
	private String skype;
	private Address address;
	private String group;
	private Date createdDate;
	private Date modifiedDate;

	public String getCreatedDate() {
		return createdDate.toString();
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastNameFirstnameIntitial() {
		return lastNameFirstnameIntitial;
	}

	public void setLastNameFirstnameIntitial(String lastNameFirstnameIntitial) {
		this.lastNameFirstnameIntitial = lastNameFirstnameIntitial;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public String getAlternativephoneNumber() {
		return alternativephoneNumber;
	}

	public void setAlternativephoneNumber(String alternativephoneNumber) {
		this.alternativephoneNumber = alternativephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

}
