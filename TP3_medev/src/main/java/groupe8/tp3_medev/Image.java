/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groupe8.tp3_medev;

import java.sql.Array;
import java.util.ArrayList;

/**
 *
 * @author elsaa
 */
public class Image {
    private int hauteur ;
    private int largeur;
    private int max;
    private int[][] pixels ;
    private String filepath;

    public Image(int hauteur, int largeur, int max, int[][] pixels, String filepath) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.max = max;
        this.pixels = pixels;
    }
    
    public Image(Image im){
        this.hauteur = im.hauteur;
        this.largeur = im.largeur;
        this.max = im.max;
        this.pixels = new int[largeur][hauteur];
        this.filepath=filepath;
    }
    
    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int[][] getPixels() {
        return pixels;
    }

    public void setPixels(int[][] pixels) {
        this.pixels = pixels;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
    
    
    public static void read(){
        
    }
    
    
}
