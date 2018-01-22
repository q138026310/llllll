package com.dlts.hrms.cm;

public class ServiceBean {

	private int result = 0;

	private Object data;

	public static ServiceBean newBean() {
		ServiceBean b = new ServiceBean();
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
