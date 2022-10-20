/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import javafx.collections.ObservableList;
/**
 *
 * @author ThinkPad
 * @param <D>
 */
public interface IService <D>{
        public void add (D entity);
        public void update (D entity);
        public void delete (D entity);
        public ObservableList<D> getAll();
    
}
