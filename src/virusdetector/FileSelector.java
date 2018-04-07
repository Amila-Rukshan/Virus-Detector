/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusdetector;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author ARS
 */
public class FileSelector {
    
    private static ArrayList<String> filePaths = new ArrayList<String>();
    
    static void RecursivePrint(File[] arr,int index,int level) 
     {
         // terminate condition
         if(index == arr.length)
             return;
          
         // tabs for internal levels
         for (int i = 0; i < level; i++)
             System.out.print("\t");
          
         // for files
         if(arr[index].isFile()){
             System.out.println(arr[index].getName());
             filePaths.add(arr[index].getAbsolutePath());
         }
          
         // for sub-directories
         else if(arr[index].isDirectory())
         {
             System.out.println("[" + arr[index].getName() + "]");
              
             // recursion for sub-directories
             RecursivePrint(arr[index].listFiles(), 0, level + 1);
         }
           
         // recursion for main directory
         RecursivePrint(arr,++index, level);
    }
    
    
    public static ArrayList<String> getInnerFilePaths(String path){
        // Provide full path for directory(change accordingly)  
        String maindirpath = path;
                 
        // File object
        File maindir = new File(maindirpath);
          
        if(maindir.exists() && maindir.isDirectory())
        {
            // array for files and sub-directories 
            // of directory pointed by maindir
            File arr[] = maindir.listFiles();
             
            System.out.println("**********************************************");
            System.out.println("Files from main directory : " + maindir);
            System.out.println("**********************************************");
             
            // Calling recursive method
            RecursivePrint(arr,0,0); 
       }
       return filePaths;
    }

    
}
