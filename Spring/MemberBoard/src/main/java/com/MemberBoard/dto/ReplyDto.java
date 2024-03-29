package com.MemberBoard.dto;

public class ReplyDto {

	private int renum;
	private int rebno;
	private String rewriter;
	private String recontent;
	private String redate;
	private String restate;

	private int relikecount;
	private String relikecheck;

	public int getRenum() {
		return renum;
	}

	public void setRenum(int renum) {
		this.renum = renum;
	}

	public int getRebno() {
		return rebno;
	}

	public void setRebno(int rebno) {
		this.rebno = rebno;
	}

	public String getRewriter() {
		return rewriter;
	}

	public void setRewriter(String rewriter) {
		this.rewriter = rewriter;
	}

	public String getRecontent() {
		return recontent;
	}

	public void setRecontent(String recontent) {
		this.recontent = recontent;
	}

	public String getRedate() {
		return redate;
	}

	public void setRedate(String redate) {
		this.redate = redate;
	}

	public String getRestate() {
		return restate;
	}

	public void setRestate(String restate) {
		this.restate = restate;
	}

	public int getRelikecount() {
		return relikecount;
	}

	public void setRelikecount(int relikecount) {
		this.relikecount = relikecount;
	}

	public String getRelikecheck() {
		return relikecheck;
	}

	public void setRelikecheck(String relikecheck) {
		this.relikecheck = relikecheck;
	}

	@Override
	public String toString() {
		return "ReplyDto [renum=" + renum + ", rebno=" + rebno + ", rewriter=" + rewriter + ", recontent=" + recontent
				+ ", redate=" + redate + ", restate=" + restate + "]";
	}

}
