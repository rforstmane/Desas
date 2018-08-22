/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diena5;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

/**
 * @author ASUS
 */
public class Desas {
    // Uztaisīt funkciju, kas zīmē laukumu - divdimensiju masīv, ja nav aizpildīts, zīmējam strīpiņu
    // Uztaisīt tā, lai mainītos spēlētājs, kas ievada X vai 0
    // Ja ievada kaut ko citu, tad paprasīt vēlreiz
    // Pārbaudīt uzvaras nosacījumus un beigt spēli, ja masīvs ir aizpildīts
    // Drīkst izpildīt gājienu tikai brīvajā vietā

    Scanner s = new Scanner(System.in);
    char[][] rezgis = new char[3][3];
    String playerOne = "";
    String playerTwo = "";
    char simbols = 'A';

    public void Spelet() {
        boolean player = true;
        Zimejums();
        Laukums();
        KursSak();
        for (int i=0; i<9; i++){
           //VaiBrivs();
            Ievade(player);
            player = !player;
            Laukums();
            if (Uzvaretajs()){
                System.out.println("Ir uzvarētājs: " + playerOne);
                break;
            }
        }


    }

    private void Laukums() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(rezgis[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void Zimejums() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rezgis[i][j] = '-';
            }
        }
    }

    private void KursSak() {

        System.out.println("Izvēlies simbolu X vai O: ");

//        simbols != 'X' && simbols != 'O'
        while (!(simbols == 'X' || simbols == 'O')) {
            simbols = s.nextLine().charAt(0); // x
            simbols = Character.toUpperCase(simbols);

            if (simbols == 'X') {
                playerOne = "X";
                playerTwo = "O";
                System.out.println("Pirmais spēlētājs ir " + playerOne);
                System.out.println("Otrais spēlētājs ir " + playerTwo);
            } else if (simbols == 'O') {
                playerOne = "O";
                playerTwo = "X";
                System.out.println("Pirmais spēlētājs ir " + playerOne);
                System.out.println("Otrais spēlētājs ir " + playerTwo);
                System.out.println();
            } else {
                System.out.println("Nepareiza ievade");
                System.out.println("Izvēlies simbolu X vai O: ");
            }
        }
    }

//    private boolean VaiBrivs(){
//        for (int i=0; i<3; i++){
//            for(int j=0; j<3; j++){
//                if (rezgis[i][j]==('-')){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    private void Ievade(boolean player){
        boolean pareizaIevade = false;

        while(pareizaIevade == false){
            System.out.println("Ievadi rindu:");
            int rinda = s.nextInt();
            System.out.println("Ievadi kolonnu: ");
            int kolonna = s.nextInt();

            if ( rinda > -1 && rinda < 3 && kolonna > -1 && kolonna < 3){
                if(!(rezgis[rinda][kolonna] == '-')){
                    System.out.println("Lauks ir aiznemts");
                }else{
                    pareizaIevade = true;
                    if (player == true ){
                        rezgis[rinda][kolonna] = playerOne.charAt(0);
                    }else {
                        rezgis[rinda][kolonna] = playerTwo.charAt(0);
                    }
                }
            }else{
                System.out.println("Nepareiza ievade");
            }
        }
    }

    private boolean RindasKolonnas(char c1, char c2, char c3){
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }

    private boolean UzvaretajsRindas(){
        for ( int i=0; i<3; i++){
            if (RindasKolonnas(rezgis[i][0], rezgis[i][1], rezgis[i][2]) == true){
                return  true;
            }
        }
        return false;
    }

    private  boolean UzvaretajsKolonnas(){
        for (int i=0; i<3; i++){
            if (RindasKolonnas(rezgis[0][i], rezgis[1][i], rezgis[2][i]) == true){
                return true;
            }
        }
        return false;
    }

    private boolean UzvaretajsDiag(){
        return ((RindasKolonnas(rezgis[0][0], rezgis[1][1], rezgis[2][2])== true) || (RindasKolonnas(rezgis[0][2], rezgis[1][1], rezgis[2][0]) == true));
    }

    public boolean Uzvaretajs(){
        return (UzvaretajsRindas() || UzvaretajsKolonnas() || UzvaretajsDiag());
    }

}
