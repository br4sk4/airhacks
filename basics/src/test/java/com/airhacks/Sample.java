
package com.airhacks;

/**
 *
 * @author airhacks.com
 */
public class Sample {

    private String name;
    private int age;

    public Sample(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Sample{" + "name=" + name + '}';
    }


}
