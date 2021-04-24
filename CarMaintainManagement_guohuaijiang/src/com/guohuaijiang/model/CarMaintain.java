package com.guohuaijiang.model;

/**
 * 车辆维修信息
 * 
 * @author 小江
 *
 */
public class CarMaintain {
	private int id;
	private String CarNumber;
	private String PartsName;
	private String PartsQuantity;
	private String RepairNumber;
	private String RepairWhen;
	private String RepairCost;

	public CarMaintain() {
		super();
	}

	public CarMaintain(String carNumber, String partsName, String partsQuantity, String repairNumber, String repairWhen,
			String repairCost) {
		super();
		CarNumber = carNumber;
		PartsName = partsName;
		PartsQuantity = partsQuantity;
		RepairNumber = repairNumber;
		RepairWhen = repairWhen;
		RepairCost = repairCost;
	}

	public CarMaintain(int id, String carNumber, String partsName, String partsQuantity, String repairNumber,
			String repairWhen, String repairCost) {
		super();
		this.id = id;
		CarNumber = carNumber;
		PartsName = partsName;
		PartsQuantity = partsQuantity;
		RepairNumber = repairNumber;
		RepairWhen = repairWhen;
		RepairCost = repairCost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarNumber() {
		return CarNumber;
	}

	public void setCarNumber(String carNumber) {
		CarNumber = carNumber;
	}

	public String getPartsName() {
		return PartsName;
	}

	public void setPartsName(String partsName) {
		PartsName = partsName;
	}

	public String getPartsQuantity() {
		return PartsQuantity;
	}

	public void setPartsQuantity(String partsQuantity) {
		PartsQuantity = partsQuantity;
	}

	public String getRepairNumber() {
		return RepairNumber;
	}

	public void setRepairNumber(String repairNumber) {
		RepairNumber = repairNumber;
	}

	public String getRepairWhen() {
		return RepairWhen;
	}

	public void setRepairWhen(String repairWhen) {
		RepairWhen = repairWhen;
	}

	public String getRepairCost() {
		return RepairCost;
	}

	public void setRepairCost(String repairCost) {
		RepairCost = repairCost;
	}

}
