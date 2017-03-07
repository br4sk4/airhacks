
package com.airhacks.sample.boundary;

import javax.annotation.PostConstruct;
import javax.interceptor.Interceptors;

@Interceptors(BusinessTransactionMonitoring.class)
public class SamplesSupplier {

    @PostConstruct
    public void init() {
        System.out.println("Initialization happens here");
    }


    public String hey() {
        return "hello " + System.currentTimeMillis();
    }


}
