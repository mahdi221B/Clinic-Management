/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import javafx.collections.ObservableList;

/**
 *
 * @author mahdi
 * @param <T>
 */
public interface IService <T>{
    public void add(T entity);

    public ObservableList<T> getAll();
    
    public void update(T entity);
    
    public void delete (T entity);
    
}
