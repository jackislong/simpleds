package com.zheng.exception;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-22.
 */
public class SimpleBusException  extends   RuntimeException {
    public  SimpleBusException(){
        super();
    };

    public SimpleBusException(String message){
        super(message);
    }

    public SimpleBusException(String message,Throwable t){
        super(message,t);
    }
}
