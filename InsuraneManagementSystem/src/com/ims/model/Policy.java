package com.ims.model;


public class Policy {
    private int scid;
    private int pid;
    private String pname;

    public Policy(int scid, int pid, String pname){
        super();
        this.scid = scid;
        this.pid = pid;
        this.pname = pname;
    }

    public Policy(){
        super();
    }

    public int getScid() {
		return scid;
	}
	public void setScid(int scid) {
		this.scid = scid;
	}
    public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
    public String getCname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
}
