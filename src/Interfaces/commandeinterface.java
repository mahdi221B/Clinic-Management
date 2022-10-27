/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import entities.commande;
import java.util.List;

/**
 *
 * @author miled
 */
public interface commandeinterface {
  public void Ajoutercommande(commande c)   ;
  public void updatecoamande(commande c );
  public List<commande> getallcommandes();
  public void Supprimercommande(commande c);

  
 
}
