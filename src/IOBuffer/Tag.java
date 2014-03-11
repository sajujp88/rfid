/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IOBuffer;

/**
 *
 * @author root
 */
public class Tag {
    private String tag;
    private boolean available = false;

    public synchronized String get() {
        while (available == false) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        available = false;
        //System.out.print("Get " + tag);
        notifyAll();
        return tag;
    }

    public synchronized void put(String value) {
        while (available == true) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        tag = value;
        available = true;
        //System.out.print("Put  " + tag);
        notifyAll();
    }
}