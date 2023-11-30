/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package groupe8.tp3_medev;

import java.io.IOException;

/**
 *
 * @author Céline
 */
public class TP3_medev {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        int[][] tab=new int[50][50];
        for (int i=0;i<50;i++){
            for (int j=0;j<50;j++){
                tab[i][j]=0;
            }
        }
        Image test1=new Image(50,50,255,tab,"C:/Users/Céline/Documents/ECN/EI2/MEDEV/TP3/tp-pgm-elsaceline/test1","commentaire1");
        test1.write();
    }
}
