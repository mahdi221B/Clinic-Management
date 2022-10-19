/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import static java.awt.PageAttributes.MediaType.D;
import javafx.collections.ObservableList;
import static javafx.scene.input.KeyCode.D;
/**
 *
 * @author ce pc
 */
public interface NewInterface <D> {
    public void ajouter(D entity);
    public void modifier(D entity);
    public void supprimer(D entity);
    public  ObservableList<D> getAll();
    
    
}
