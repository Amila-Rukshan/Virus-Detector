/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusdetector;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ARS
 */
public class MD5CheckSum {
    
    public static String getMD5HashOfFile(String filePath){
        try {   
            MessageDigest md = MessageDigest.getInstance("MD5");
            FileInputStream fis = new FileInputStream(filePath);
            
            byte[] dataBytes = new byte[1024];
            
            int nread = 0;
            while ((nread = fis.read(dataBytes)) != -1) {
                md.update(dataBytes, 0, nread);
            };
            byte[] mdbytes = md.digest();
            
            //convert the byte to hex format method 1
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < mdbytes.length; i++) {
                sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            
            //System.out.println("Digest(in hex format):: " + sb.toString());
            
            /*
                //convert the byte to hex format method 2
                StringBuffer hexString = new StringBuffer();
                for (int i=0;i<mdbytes.length;i++) {
                    String hex=Integer.toHexString(0xff & mdbytes[i]);
                    if(hex.length()==1) hexString.append('0');
                    hexString.append(hex);
                }
                System.out.println("Digest(in hex format):: " + hexString.toString());
            */
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(VirusDetector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VirusDetector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VirusDetector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean checkInfections(){
        
        
        return false;
    }
}
