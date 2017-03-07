
package com.airhacks.sample.audit.boundary;

import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.json.JsonObject;

/**
 *
 * @author airhacks.com
 */
public class SampleCreationListener {

    public void onNewSample(@Observes(during = TransactionPhase.AFTER_SUCCESS) JsonObject sample) {
        System.out.println("+++audit- created: " + sample);

    }

    public void onFailedAttempt(@Observes(during = TransactionPhase.AFTER_FAILURE) JsonObject sample) {
        System.out.println("---audit- creation failed: " + sample);

    }


}
