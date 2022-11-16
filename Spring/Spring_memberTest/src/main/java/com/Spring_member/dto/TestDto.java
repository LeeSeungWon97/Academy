package com.Spring_member.dto;

public class TestDto {

	private String testId;
	private String testPw;
	private String testName;
	private String testBirth;

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getTestPw() {
		return testPw;
	}

	public void setTestPw(String testPw) {
		this.testPw = testPw;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestBirth() {
		return testBirth;
	}

	public void setTestBirth(String testBirth) {
		this.testBirth = testBirth;
	}

	@Override
	public String toString() {
		return "TestDto [testId=" + testId + ", testPw=" + testPw + ", testName=" + testName + ", testBirth="
				+ testBirth + "]";
	}

}
