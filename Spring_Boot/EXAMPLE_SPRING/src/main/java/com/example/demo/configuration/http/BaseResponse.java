package com.example.demo.configuration.http;


/**
 * 공통으로 사용할 응답 클래스
 * @author 두별
 * @param <T>
 */
public class BaseResponse<T> {
	private BaseResponseCode code;
	private String message;
	private T data;
	
	public BaseResponse(T data) {
		this.code = BaseResponseCode.SUCCESS;
		this.data = data;
	}
}
