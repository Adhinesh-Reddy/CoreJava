package com.pms.model;

public class Product {
    private int pid;
    private String pname;
    private String qty;
    private String price;

    public Product(int pid, String pname, String qty, String price){
        super();
        this.pid = pid;
        this.pname = pname;
        this.qty = qty;
        this.price = price;
    }

    public Product(){
        super();
    }

    public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
    public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
    public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
    public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
    
}
