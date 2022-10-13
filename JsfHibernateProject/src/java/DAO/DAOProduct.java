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
import pojo.Product;
import pojo.wareHouseUtil;

/**
 *
 * @author miqba
 */
public class DAOProduct {
    public List<Product> retrveTblproduct() {
        List listProduct = new ArrayList();
        Transaction transaction = null;
        Session session = wareHouseUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Product");
            listProduct = query.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listProduct;
    }  
    public List<Product> getbyID(String idProduct) {
        Product product = new Product();
        List<Product> listProduct = new ArrayList();
        Transaction transaction = null;
        Session session = wareHouseUtil.getSessionFactory().openSession();
        
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Product where id = :id");
            query.setString("id", idProduct);
            product = (Product) query.uniqueResult();
            listProduct = query.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listProduct;
    }
    public void addProduct(Product product){
        Transaction transaction = null;
        Session session = wareHouseUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void deleteUser(Integer idProduct) {
        Transaction transaction = null;
        Session session = wareHouseUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Product usr = (Product) session.load(Product.class, new Integer(idProduct));
            session.delete(usr);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void editUser(Product product) {
        Transaction transaction = null;
        Session session = wareHouseUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

