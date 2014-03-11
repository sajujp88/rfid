/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rfidreader;

import IOBuffer.Tag;
import IOBuffer.iobuffer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author sajujp
 */
public class RFidReader extends Thread{

    /**
     * @param args the command line arguments
     */
    Tag t;
    private GUI myGUI;
    private boolean running = true;
    
    public RFidReader(Tag t,GUI myGUI){
        this.t=t;
        this.myGUI=myGUI;

    }
    
    public void run(){
       // 
        while(running){
           
        myGUI.setTag(t.get());
        }
        
    }
    
    public void terminate(){
        running = false;
    }
  
 
    public RFidReader getObject(){
        return this;
    }
    
}
