package com.MovieProject.dto;

public class ScheduleDto {
	private String scmvcode;
	private String scthcode;
	private String scroom;
	private String scdate;
	private String sctime;

	public String getScmvcode() {
		return scmvcode;
	}

	public void setScmvcode(String scmvcode) {
		this.scmvcode = scmvcode;
	}

	public String getScthcode() {
		return scthcode;
	}

	public void setScthcode(String scthcode) {
		this.scthcode = scthcode;
	}

	public String getScroom() {
		return scroom;
	}

	public void setScroom(String scroom) {
		this.scroom = scroom;
	}

	public String getScdate() {
		return scdate;
	}

	public void setScdate(String scdate) {
		this.scdate = scdate;
	}

	public String getSctime() {
		return sctime;
	}

	public void setSctime(String sctime) {
		this.sctime = sctime;
	}

	@Override
	public String toString() {
		return "ScheduleDto [scmvcode=" + scmvcode + ", scthcode=" + scthcode + ", scroom=" + scroom + ", scdate="
				+ scdate + ", sctime=" + sctime + "]";
	}

}
