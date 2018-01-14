package com.rest.automation.admin.dto.response;

public class BaseResponseDto {

	private int responseCode;
	
	private String resultDescription;

	public BaseResponseDto() {
		this(0,"SUCCESS");
	}
	
	public BaseResponseDto(int responseCode,String resultDescription) {
		this.responseCode = responseCode;
		this.resultDescription = resultDescription;
	}
	
	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getResultDescription() {
		return resultDescription;
	}

	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}

}
