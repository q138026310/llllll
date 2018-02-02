package com.dlts.hrms.cm;

public class Result {

	private int result = 0;

	private Object data;

	public static Result newResult() {
		Result b = new Result();
		return b;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return this.result == GlobalConstant.SUCCESS;
	}

}
