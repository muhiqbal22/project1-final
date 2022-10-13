/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Admin;
import pojo.wareHouseUtil;

/**
 *
 * @author miqba
 */
public class DAOadmin {
    public List<Admin> getBy(String uEmail, String uPass) {
        Transaction trans = null;
        Admin us = new Admin();
        List<Admin> user = new ArrayList();
        Session session = wareHouseUtil.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Admin where email=:uEmail AND password=:uPass");
            query.setString("uEmail", uEmail);
            query.setString("uPass", uPass);
            us = (Admin) query.uniqueResult();
            user = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }
    
    public String add_admin(Admin user) {
         Transaction trans = null;
        Session session = wareHouseUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(user);
            trans.commit();
            return "index";
        } catch (Exception e) {
            System.out.println(e);
        }
        return "gagalRegis";
    }
    }
    

