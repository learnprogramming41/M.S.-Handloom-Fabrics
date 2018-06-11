/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.service;

import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Nishan Dhungana
 * @param <T>
 */
public interface GenericService<T> {
    void insert(T t) throws HibernateException;
    void update(T t) throws HibernateException;
    boolean delete(T t) throws HibernateException;
    T getById(int id) throws HibernateException;
    List<T> getAll() throws HibernateException;
}
