/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groupe8.tp3_medev;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    
    /**
     *
     * @param hauteur
     * @param largeur
     * @param max
     * @param pixels
     * @param filepath
     * @param commentaire
     */
    public Image(int hauteur, int largeur, int max, int[][] pixels, String filepath,String commentaire) {
        this.filepath=filepath;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.max = max;
        this.pixels = pixels;
        this.commentaire=commentaire;
    }
    
    /**
     *
     * @param filepath
     */
    public Image(String filepath) {
        this.filepath=filepath;
        this.hauteur = 0;
        this.largeur = 0;
        this.max = 255; 
        this.commentaire="";
    }
    
    /**
     *
     * @param im
     */
    public Image(Image im){
        this.hauteur = im.hauteur;
        this.largeur = im.largeur;
        this.max = im.max;
        
        this.pixels = new int[largeur][hauteur];
        this.filepath=im.filepath;
        this.commentaire=im.commentaire;
    }
    
    /**
     *
     * @return
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     *
     * @param hauteur
     */
    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    /**
     *
     * @return
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     *
     * @param largeur
     */
    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    /**
     *
     * @return
     */
    public int getMax() {
        return max;
    }

    /**
     *
     * @param max
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     *
     * @return
     */
    public int[][] getPixels() {
        return pixels;
    }

    /**
     *
     * @param pixels
     */
    public void setPixels(int[][] pixels) {
        this.pixels = pixels;
    }

    /**
     *
     * @return
     */
    public String getFilepath() {
        return filepath;
    }

    /**
     *
     * @param filepath
     */
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    /**
     *
     * @return
     */
    public String getCommentaire() {
        return commentaire;
    }

    /**
     *
     * @param commentaire
     */
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
    
    public void write() throws IOException{
        int compteligne=0;
        PrintWriter writer=new PrintWriter(new FileWriter(this.filepath));
        writer.println("P2");
        writer.println(this.commentaire);
        writer.println(this.largeur+" "+this.hauteur);
        writer.println(this.max);
        for (int i=0;i<this.largeur;i++){
            for (int j=0; j<this.hauteur;j++){
                compteligne+=1;
                if (compteligne<70){
                    writer.write(this.pixels[i][j]+" ");
            }
                else {
                    compteligne=0;
                    writer.println(this.pixels[i][j]+" ");
                }
        }
        
    }
}
    public void difference(Image image2) throws IOException{
        if ((this.largeur==image2.largeur)&&(this.hauteur==image2.hauteur)){
            int[][] tab=new int[this.largeur][this.hauteur];
            for (int i=0;i<this.largeur;i++){
                for (int j=0;j<this.hauteur;j++){
                    tab[i][j]=this.pixels[i][j]-image2.pixels[i][j];
            Image testdiff=new Image(this.largeur,this.hauteur,255,tab,"C:/Users/Céline/Documents/ECN/EI2/MEDEV/TP3/tp-pgm-elsaceline/testdiff","commentaire1");
            testdiff.write();
        }}}
        else{
            System.out.println("Les images ne sont pas de la même taille");
            
        }
            }
        }
        
    

