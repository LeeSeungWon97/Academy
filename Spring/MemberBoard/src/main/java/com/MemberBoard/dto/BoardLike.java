package com.MemberBoard.dto;

public class BoardLike {

	private int lbno;
	private String lmid;
	private String lstate;

	public int getLbno() {
		return lbno;
	}

	public void setLbno(int lbno) {
		this.lbno = lbno;
	}

	public String getLmid() {
		return lmid;
	}

	public void setLmid(String lmid) {
		this.lmid = lmid;
	}

	public String getLstate() {
		return lstate;
	}

	public void setLstate(String lstate) {
		this.lstate = lstate;
	}

	@Override
	public String toString() {
		return "BoardLike [lbno=" + lbno + ", lmid=" + lmid + ", lstate=" + lstate + "]";
	}

}
