/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package groupe8.tp3_medev;

import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Céline
 */
public class TP3_medev {


    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        //test write
        int[][] tab=new int[50][50];
        for (int i=0;i<50;i++){
            for (int j=0;j<50;j++){
                tab[i][j]=100;
            }
        }
        Image test1=new Image(50,50,255,tab,"C:/Users/Céline/Documents/ECN/EI2/MEDEV/TP3/tp-pgm-elsaceline/test1","commentaire1");
        test1.write();
        //test write 2 
        int[][] tab2=new int[50][50];
        for (int i=0;i<50;i++){
            for (int j=0;j<50;j++){
                tab2[i][j]=255;
            }
        }
        Image test2=new Image(50,50,255,tab2,"C:/Users/Céline/Documents/ECN/EI2/MEDEV/TP3/tp-pgm-elsaceline/test2","commentaire1");
        test2.write();
        //test diff
        test2.difference(test1);
        //test read
        Image baboin = new Image("C:\\Users\\elsaa\\Documents\\Centrale\\INFOSI\\MEDEV\\TP2\\tp-pgm-elsaceline\\ImagesTestPGM\\baboon.pgm");
        
        baboin.read();
        System.out.println("Pixels = " + Arrays.toString(baboin.getPixels()));
    }
}
