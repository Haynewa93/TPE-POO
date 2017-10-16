/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpe;

import java.util.Scanner;

/**
 *
 * @author M FIRMIN
 */

public class palindrome {
    public static void main(String[] args){
          Scanner sc= new Scanner(System.in);
        String mot=sc.nextLine();
        int i;
    String renverse="";
      for(i=mot.length()-1;i>=0;i--){
          renverse = renverse+ mot.charAt(i);
    
}
      if(renverse.equals(mot)){
          System.out.print("Ce mot est un palindrome");
      } else           System.out.print("Ce mot n'est pas un palindrome");

       
    
}
}
