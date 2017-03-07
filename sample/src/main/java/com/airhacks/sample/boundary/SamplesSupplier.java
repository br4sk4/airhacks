
package com.airhacks.sample.boundary;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

@Interceptors(BusinessTransactionMonitoring.class)
public class SamplesSupplier {

    @Inject
    Instance<Importer> importers;

    @PostConstruct
    public void init() {
        System.out.println("Initialization happens here");
    }


    public String hey() {
        String retVal = "-";

        for (Importer importer : importers) {
            retVal += importer.importContent();
        }
        return retVal;
    }


}
