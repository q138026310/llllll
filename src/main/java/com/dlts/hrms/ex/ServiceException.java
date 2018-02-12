package com.dlts.hrms.ex;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 2677495987341056441L;

    public ServiceException(int value) {
        super(String.valueOf(value));
    }

}
