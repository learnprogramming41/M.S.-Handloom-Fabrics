/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.dao;

import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Nishan Dhungana
 * @param <T>
 */
public interface GenericDAO<T> {
    void insert(T t) throws HibernateException;
    void update(T t) throws HibernateException;
    boolean delete(T t) throws HibernateException;
    T getById(int id) throws HibernateException;
    List<T> getAll() throws HibernateException;
}
