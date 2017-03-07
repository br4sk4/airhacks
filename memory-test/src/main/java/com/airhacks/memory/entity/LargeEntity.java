
package com.airhacks.memory.entity;

/**
 *
 * @author airhacks.com
 */
public class LargeEntity {

    private String first;
    private String next;
    private String last;

    public LargeEntity(String first) {
        this.first = first;
        this.next = first + " " + System.currentTimeMillis();
        this.last = first + " " + System.currentTimeMillis();
    }



}
