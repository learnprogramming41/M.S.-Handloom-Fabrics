/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.UniqueConstraint;

/**
 *
 * @author Nishan Dhungana
 * @param <T>
 */
public interface GenericDAO<T> {
    void insert(T t);
    void update(T t);
    boolean delete(T t);
    T getById(int id);
    List<T> getAll();
}
