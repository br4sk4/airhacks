
package com.airhacks;

import com.airhacks.di.SoptimInject;

@SoptimPath(path = "hello")
public class SoptimMicroservice {

    @SoptimInject
    MessageStore ms;

    String hugo;

    public void hey() {

    }

    @Override
    public String toString() {
        return "SoptimMicroservice{" + "ms=" + ms + '}';
    }


}
