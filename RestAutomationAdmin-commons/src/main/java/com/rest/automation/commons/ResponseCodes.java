package com.rest.automation.commons;

public class ResponseCodes {

	public static final int successCode = 0;
	public static final String successDesc = "SUCCESS";
	
	public static final int failCode = -1;
	public static final String failDesc = "FAIL";
	
	public static final int exceptionCode = 500;
	public static final String exceptionDesc = "Internal Server Error";
	
	public static final int unauthorizeCode = 401;
	public static final String unauthorizeDesc = "Username / Password is not correct!";
}
