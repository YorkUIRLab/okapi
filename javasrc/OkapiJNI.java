package org;

import java.io.*;
import java.util.*;
import java.text.*;


public class OkapiJNI {

    public static OkapiJNI x = null;
    
    public native void javainit();

    public native String comm(String command);
    
    static {
    	 try {
    		 System.load("/home/okapi/bin/librelexOkapi.so");
         } catch(UnsatisfiedLinkError u) { 
              System.out.println("Failed to load Okapi library");
              u.printStackTrace();
         } catch(SecurityException s) {
             s.printStackTrace();
             System.out.println("Failed to load Okapi library");
         }
       
    }
    
}