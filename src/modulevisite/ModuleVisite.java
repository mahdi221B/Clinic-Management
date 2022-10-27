/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulevisite;
import VisiteServices.ServiceConsultation;
import VisiteEntities.Consultation;
import VisiteInterfaces. IService;
import VisiteServices.ServiceDossierpatient;
import VisiteEntities.DossierPatient;

import VisiteServices.ServiceRendezvous;
import VisiteEntities.RendezVous;
import VisiteUtils.DBconnexion;
import java.util.Date;
import VisiteInterfaces.IService;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class ModuleVisite {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
         System.out.println(DBconnexion.getInstance().getCnx());
         Consultation con =new Consultation("rihab","rihab","list","list","lis");
         //instance serviceConsultation
         ServiceConsultation sc =new ServiceConsultation();
         //instance service rendezvous
         ServiceRendezvous rv =new ServiceRendezvous();
         //instance service dossier patient
         ServiceDossierpatient pt =new ServiceDossierpatient();
         //sc.ajouter(con);
        Consultation u=new Consultation(4);
         //sc.supprimer(u);
         
        // Consultation conmof =new Consultation(18,"r","r","r","r","r");
    // sc.modifier(con);
     Consultation c =new Consultation(19);
    
     sc.supprimer(c);

     //sc.modifier(c);
       
    }
    
    
}
