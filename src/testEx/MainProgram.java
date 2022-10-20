/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testEx;

import java.util.Date;
import servicesEx.ServiceExamen;
import entitesEx.Examen;

/**
 *
 * @author acila
 */
public class MainProgram {
  public static void main(String[] args){
      ServiceExamen se = new ServiceExamen();
      Examen ex = new Examen(1,1,1,new Date(12/02/2022));
     se.ajouterExamen(ex);
  }   
}
