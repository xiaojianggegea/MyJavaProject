package com.guohuaijiang.model;

/**
 * 客户信息
 * 
 * @author 小江
 *
 */
public class Client {
	private int id;
	private String clientName;
	private String Gender;
	private String IDNumber;
	private String PhoneNumber;
	private String HomeAddress;
	
	

	public Client() {
		super();
	}

	public Client(String clientName, String gender, String iDNumber, String phoneNumber, String homeAddress) {
		super();
		this.clientName = clientName;
		Gender = gender;
		IDNumber = iDNumber;
		PhoneNumber = phoneNumber;
		HomeAddress = homeAddress;
	}

	public Client(int id, String clientName, String gender, String iDNumber, String phoneNumber, String homeAddress) {
		super();
		this.id = id;
		this.clientName = clientName;
		Gender = gender;
		IDNumber = iDNumber;
		PhoneNumber = phoneNumber;
		HomeAddress = homeAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getHomeAddress() {
		return HomeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		HomeAddress = homeAddress;
	}

}
