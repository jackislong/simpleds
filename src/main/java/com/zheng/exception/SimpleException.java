package com.zheng.exception;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-16.
 */
public class SimpleException  extends RuntimeException {

    public  SimpleException(){
        super();
    };

    public SimpleException(String message){
        super(message);
    }

    public SimpleException(String message,Throwable t){
        super(message,t);
    }
}

