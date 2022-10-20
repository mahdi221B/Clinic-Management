/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entites;

/**
 *
 * @author miled
 */
public class ligne_de_commande {
 
    
    private int  id_ligne_commande;
   
    private int Qte ;
    private int  id_article;
    private int  id_commande;
    private int  id_infermier; 

    public int getId_ligne_commande() {
        return id_ligne_commande;
    }

    public void setId_ligne_commande(int id_ligne_commande) {
        this.id_ligne_commande = id_ligne_commande;
    }

    public int getQte() {
        return Qte;
    }

    public void setQte(int Qte) {
        this.Qte = Qte;
    }

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getId_infermier() {
        return id_infermier;
    }

    public void setId_infermier(int id_infermier) {
        this.id_infermier = id_infermier;
    }

    public ligne_de_commande(int id_ligne_commande, int Qte, int id_article, int id_commande, int id_infermier) {
        this.id_ligne_commande = id_ligne_commande;
        this.Qte = Qte;
        this.id_article = id_article;
        this.id_commande = id_commande;
        this.id_infermier = id_infermier;
    }
    
    public ligne_de_commande( int Qte, int id_article, int id_commande, int id_infermier) {
        this.Qte = Qte;
        this.id_article = id_article;
        this.id_commande = id_commande;
        this.id_infermier = id_infermier;
    } 
    
       public ligne_de_commande(int id_ligne_commande) {
        this.id_ligne_commande = id_ligne_commande;
        
    }
    
}
