/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.daoimp;

import com.nepitc.mshandloomfrabics.dao.ImageDAO;
import com.nepitc.mshandloomfrabics.entity.ImageModel;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nishan Dhungana
 */
@Repository(value = "imageDaoImp")
public class ImageDAOImp extends GenericDAOImp<ImageModel> implements ImageDAO {

    @Override
    public List<String> deleteImageFromPashminaId(int pashminaId) {
        session = sessionFactory.openSession();

        try {
            final String hql = "SELECT I.publicId FROM ImageModel I WHERE I.pashmina.pashminaId = :pashminaId";
            Query query = session.createQuery(hql);
            query.setParameter("pashminaId", pashminaId);

            return query.list();
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
    }

}
