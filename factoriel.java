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
public class factoriel {
    
      public static void main(String[] args) {
           Scanner sc= new Scanner(System.in);
        double nbre=sc.nextDouble();
        int result=1;
       for(int i=1;i<=nbre;i++){
           result=result*i;
       }
       System.out.println(result);
    
}
}
