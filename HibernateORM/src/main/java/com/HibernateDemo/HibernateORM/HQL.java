package com.HibernateDemo.HibernateORM;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HQL {

	public static void main(String[] args) {

		Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(sr);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		// many values = List
		/*Query q = session.createQuery("FROM User");
		List<User> userData = q.list();
		
		for(User u : userData) {
			System.out.println(u);
		}*/
		
		
		//one value = uniqueResult
		/*Query q = session.createQuery("FROM User WHERE userID = 2");
		User userData = (User)q.uniqueResult();

		System.out.println(userData);*/
		
		
		//Select one value in a row = Object[Array] | with more values in a row you will need List<Object[Array]>
		Query q = session.createQuery("SELECT userID, userName FROM User");
		List<Object[]> userData = (List<Object[]>)q.list();
		
		for(Object [] data : userData) {
			System.out.println(data[0] + " : " + data[1]);
		}
		
		tx.commit();
	}

}
