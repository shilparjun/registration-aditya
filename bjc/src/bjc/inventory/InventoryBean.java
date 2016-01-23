package bjc.inventory;

import java.sql.Date;

public class InventoryBean {
	
	public InventoryBean(String name, String type,int itemQuantity, int itemCost, Date itemPurDate,
			String purchasedBy, String moneyGiven,String remarks ) {
		this.name = name;
		this.type = type;
		this.itemQuantity = itemQuantity;
		this.itemCost = itemCost;
		this.itemPurDate = itemPurDate ;
		this.purchasedBy = purchasedBy;
		this.moneyGiven = moneyGiven;
		this.remarks = remarks;
	}
	public InventoryBean() {
		
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public int getItemCost() {
		return itemCost;
	}
	public void setItemCost(int itemCost) {
		this.itemCost = itemCost;
	}
	public Date getItemPurDate() {
		return itemPurDate;
	}
	public void setItemPurDate(Date itemPurDate) {
		this.itemPurDate = itemPurDate;
	}
	public String getPurchasedBy() {
		return purchasedBy;
	}
	public void setPurchasedBy(String purchasedBy) {
		this.purchasedBy = purchasedBy;
	}
	public String getEnterBy() {
		return enterBy;
	}
	public void setEnterBy(String enterBy) {
		this.enterBy = enterBy;
	}
	public String getMoneyGiven() {
		return moneyGiven;
	}
	public void setMoneyGiven(String moneyGiven) {
		this.moneyGiven = moneyGiven;
	}


	String type;
	String name ; 
	int itemQuantity ;
	int itemCost ;
	Date itemPurDate;
	String purchasedBy ;
	String enterBy;
	String moneyGiven ; //radio
	String remarks;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
