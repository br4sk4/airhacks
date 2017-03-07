
package com.airhacks.sample.boundary;

import javax.interceptor.Interceptors;

/**
 *
 * @author airhacks.com
 */
@Interceptors(BusinessTransactionMonitoring.class)
public class SamplesSupplier {

    public String hey() {
        return "hello " + System.currentTimeMillis();
    }


}
