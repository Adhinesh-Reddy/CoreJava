package com.ims.model;
// import java.util.List;

public class Category {
    private int cid;
    private String cname;
    // private List<SubCategory> subCategory;

    public Category(int cid, String cname){
        super();
        this.cid = cid;
        this.cname = cname;
        // this.subCategory = subCategory;
    }

    public Category(){
        super();
    }

    public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
    public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
    // public List<SubCategory> getSubCategory() {
    //     return subCategory;
    // }
    // public void setSubCategory(List<SubCategory> subCategory) {
    //     this.subCategory = subCategory;
    // }
}
