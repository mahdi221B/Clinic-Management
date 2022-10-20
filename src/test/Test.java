package test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import entites.Categorie;
import entites.Sponsor;
import services.EvenementService;
import services.SponsorService;
import outils.TypeSponsoring;
import java.util.Date;
import java.text.SimpleDateFormat;
import services.CategorieService;


/**
 *
 * @author mahdi
 */
public class Test {
    public static void main(String[] args) {
       //EvenementService es = new EvenementService();
       //SponsorService ss = new SponsorService();
       //TypeEvenementService ess = new TypeEvenementService();
       CategorieService cs = new CategorieService();
       Categorie e = new Categorie(12,"CATEGORIE222");
       cs.update(e);
        //TypeSponsoring ts = TypeSponsoring.A;
        //Date date = new Date();
        //SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        //System.out.println(DateFor.format(date));
        //Sponsor s = new Sponsor(444333,444333,"GGG","GGG",ts.toString());
        //ss.ModifierSponsor(s);
       // ss.SupprimerSponsor(s);
       //*************************************************************************************************************
       //Evenement e = new Evenement(78497,2389,"aaa", "bbb", "lkznz", "lkdzl", "kznezek", DateFor.format(date), DateFor.format(date));
       //Evenement e = new Evenement(1,1234,33300,"hjk", "dokz", "lkznz", "lkdzl", "kznezek", DateFor.format(date), DateFor.format(date));
      // Evenement e = new Evenement(1);
       //es.AjouterEvenement(e);
       //es.ModifierEvenement(e);
       //es.SupprimerEvenement(e);
       
       //**************************************************************************************************************
      //TypeEvenement e = new TypeEvenement("Type1");
       //TypeEvenement e = new TypeEvenement(1,"Type2");
      // TypeEvenement e = new TypeEvenement(1);
       //ess.AjouterTypeEvenement(e);
       //ess.ModifierTypeEvenement(e);
       //ess.SupprimerTypeEvenement(e);
       //System.out.println(ess.getAllTypeEvenement());
      // System.out.println(es.getAll());
    }
}
