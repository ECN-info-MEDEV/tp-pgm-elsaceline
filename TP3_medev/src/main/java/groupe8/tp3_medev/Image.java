/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groupe8.tp3_medev;

import java.sql.Array;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.StringTokenizer;

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
    private String commentaire;
    

    public Image(int hauteur, int largeur, int max, int[][] pixels, String filepath,String commentaire) {
		this.filepath=filepath;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.max = max;
        this.pixels = pixels;
        this.commentaire=commentaire;
    }
    
    public Image(Image im){
        this.hauteur = im.hauteur;
        this.largeur = im.largeur;
        this.max = im.max;
        
        this.pixels = new int[largeur][hauteur];
        this.filepath=filepath;
        this.commentaire=im.commentaire;
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

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    
    
    
    public void read(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            
            // Lecture de l'en-tête du fichier PGM
            String magicNumber = br.readLine();
            if (!magicNumber.equals("P2") && !magicNumber.equals("P5")) {
                System.err.println("Ce n'est pas un fichier PGM valide.");
                br.close();
                return;
            }

            commentaire = br.readLine(); // Lire la ligne de commentaire
            String dimensions = br.readLine(); // Lire les dimensions (largeur et hauteur)
            max = parseInt(br.readLine()); // Lire la valeur maximale
            
            // Traiter les dimensions et la valeur maximale si nécessaire
            String delimiteur=" ";
            StringTokenizer tokenizer=new StringTokenizer(dimensions,delimiteur);
            largeur=parseInt(tokenizer.nextToken());
            hauteur=parseInt(tokenizer.nextToken());

            // Lecture des données de pixel
            String line = br.readLine();
            while (line != null) {
                StringTokenizer tokenizer2=new StringTokenizer(line,delimiteur);
                int j=0;
                for (int i = 0; i < largeur; i++) {
                    pixels[j][i]=parseInt(tokenizer2.nextToken());
                }
                j++;
            }
            
            br.close(); // Fermer le fichier après lecture
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
    
}
