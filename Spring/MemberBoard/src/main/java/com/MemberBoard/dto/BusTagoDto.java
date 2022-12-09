package com.MemberBoard.dto;

public class BusTagoDto {
	private String routeno;
	private int arrtime;

	public String getRouteno() {
		return routeno;
	}

	public void setRouteno(String routeno) {
		this.routeno = routeno;
	}

	public int getArrtime() {
		return arrtime;
	}

	public void setArrtime(int arrtime) {
		this.arrtime = arrtime;
	}

	@Override
	public String toString() {
		return "BusTagoDto [routeno=" + routeno + ", arrtime=" + arrtime + "]";
	}

}
