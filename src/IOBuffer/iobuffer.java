/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IOBuffer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sajujp
 */
public class iobuffer extends Thread {
    private BufferedReader in;
    private int count=0;
    private boolean running = true;
    Tag t;
    
    public  iobuffer(Tag t,String srcfile) throws FileNotFoundException{
        this.t=t;
        in = new BufferedReader(new FileReader(srcfile));
    }
  
    
    public void run() {
        //try {
        //    in = new BufferedReader(new FileReader("/dev/ttyUSB0"));
        //} catch (FileNotFoundException ex) {
        //    Logger.getLogger(iobuffer.class.getName()).log(Level.SEVERE, null, ex);
        //}
        int c,i;
        count++;
        char[] a = new char[13];
        while(running){
        for(i=0;i<12;i++){
            try {
                //System.out.print((char) in.read());
                a[i]= (char) (0x000000ff & in.read());
            } catch (IOException ex) {
                Logger.getLogger(iobuffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        a[i]='\0';
        String tag = new String(a);
        //System.out.print(count);
        t.put(tag);
        //try {
         //   in.close();
        //} catch (IOException ex) {
         //   Logger.getLogger(iobuffer.class.getName()).log(Level.SEVERE, null, ex);
        //}
        }
    }
    
    public void terminate() throws IOException{
        running = false;
        //in.close();
    }
    
 
  
    
}
