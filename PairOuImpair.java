/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpe;

import java.util.Scanner;
public class PairOuImpair {
    public static void main(String[] args) {
           Scanner sc= new Scanner(System.in);
        double nbre=sc.nextDouble();
        if(nbre%2==0){
            System.out.println("Ce nombre est paire");
        }else System.out.println("Ce nombre est impaire");
    }
    
}
