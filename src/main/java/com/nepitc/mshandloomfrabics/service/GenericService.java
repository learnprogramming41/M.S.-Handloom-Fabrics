/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.service;

import java.util.List;

/**
 *
 * @author Nishan Dhungana
 * @param <T>
 */
public interface GenericService<T> {
    void insert(T t);
    void update(T t);
    boolean delete(T t);
    T getById(int id);
    List<T> getAll();
}
