package com.ims.model;

public class SubCategory {
    private int cid;
    private int scid;
    private String scname;
    public SubCategory(int cid, int scid, String scname){
        super();
        this.cid = cid;
        this.scid = scid;
        this.scname = scname;
    }

    public SubCategory(){
        super();
    }

    public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
    public int getScid() {
		return scid;
	}
	public void setScid(int scid) {
		this.scid = scid;
	}
    public String getScname() {
		return scname;
	}
	public void setScname(String scname) {
		this.scname = scname;
	}
}
