package com.guohuaijiang.model;

/**
 * 零件信息
 * 
 * @author 小江
 *
 */
public class Parts {
	private int id;
	private String PartsName;
	private String PartsNumber;
	private String PartsPrice;

	public Parts() {
		super();
	}

	public Parts(String partsName, String partsNumber, String partsPrice) {
		super();
		PartsName = partsName;
		PartsNumber = partsNumber;
		PartsPrice = partsPrice;
	}

	public Parts(int id, String partsName, String partsNumber, String partsPrice) {
		super();
		this.id = id;
		PartsName = partsName;
		PartsNumber = partsNumber;
		PartsPrice = partsPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPartsName() {
		return PartsName;
	}

	public void setPartsName(String partsName) {
		PartsName = partsName;
	}

	public String getPartsNumber() {
		return PartsNumber;
	}

	public void setPartsNumber(String partsNumber) {
		PartsNumber = partsNumber;
	}

	public String getPartsPrice() {
		return PartsPrice;
	}

	public void setPartsPrice(String partsPrice) {
		PartsPrice = partsPrice;
	}
}
