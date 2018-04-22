/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.dao;

import java.util.List;

/**
 *
 * @author Nishan Dhungana
 * @param <T>
 */
public interface GenericDAO<T> {
    void insert(T t) throws Exception;
    void update(T t) throws Exception;
    boolean delete(T t) throws Exception;
    T getById(int id) throws Exception;
    List<T> getAll() throws Exception;
}
