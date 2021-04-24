package com.guohuaijiang.model;

/**
 * 车辆信息
 * 
 * @author 小江
 *
 */
public class Car {
	private int id;
	private String CarClientName;
	private String CarBrand;
	private String CarNumber;
	private String CarPhoneNumber;

	public Car() {
		super();
	}

	public Car(String carClientName, String carBrand, String carNumber, String carPhoneNumber) {
		super();
		CarClientName = carClientName;
		CarBrand = carBrand;
		CarNumber = carNumber;
		CarPhoneNumber = carPhoneNumber;
	}

	public Car(int id, String carClientName, String carBrand, String carNumber, String carPhoneNumber) {
		super();
		this.id = id;
		CarClientName = carClientName;
		CarBrand = carBrand;
		CarNumber = carNumber;
		CarPhoneNumber = carPhoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarClientName() {
		return CarClientName;
	}

	public void setCarClientName(String carClientName) {
		CarClientName = carClientName;
	}

	public String getCarBrand() {
		return CarBrand;
	}

	public void setCarBrand(String carBrand) {
		CarBrand = carBrand;
	}

	public String getCarNumber() {
		return CarNumber;
	}

	public void setCarNumber(String carNumber) {
		CarNumber = carNumber;
	}

	public String getCarPhoneNumber() {
		return CarPhoneNumber;
	}

	public void setCarPhoneNumber(String carPhoneNumber) {
		CarPhoneNumber = carPhoneNumber;
	}

}
