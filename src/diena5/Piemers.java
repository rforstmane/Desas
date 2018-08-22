/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diena5;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Piemers {
    
    public void Divdimensiju(){
        
        Scanner s = new Scanner(System.in);
        //int[] OneD = new int[5]; //viendimensiju masivs
        int[][] TwoD = new int[2][2]; //divdimensiju masivs ar piecam rindam un  piecam kolonnam
        
        //12345 piemeri
        //56767
        //59753
        
        for(int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                System.out.println("Ievadi elementu: ");
                TwoD[i][j] = s.nextInt();
            }      
        }
        System.out.println("");
        System.out.println();
        
        for(int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                System.out.print(TwoD[i][j] + " ");
            }
            System.out.println(" ");
        }
                
    }
}
