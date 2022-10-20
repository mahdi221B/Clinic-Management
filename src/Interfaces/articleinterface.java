/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import entites.articles;
import java.util.List;

/**
 *
 * @author miled
 */
public interface articleinterface {
    void Ajoutrarticle(articles a);
     void updatearticles(articles a);
     List<articles> getallarticles();
     void Supprimerarticle(articles a);
    
}
