package com.dlts.hrms.domain.ex;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 2677495987341056441L;

    public ServiceException(String value) {
        super(String.valueOf(value));
    }

}
