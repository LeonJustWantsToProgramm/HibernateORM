package com.HibernateDemo.HibernateORM;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
    
	public static void main( String[] args ) {
		
    	User user = new User();
    	user.setUserID(6);
    	user.setUserName("Moin Meister");
    	user.setAge(23);
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(User.class); 
    	
    	ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
    			
    	SessionFactory sf = con.buildSessionFactory(sr);
    	
    	Session session = sf.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	
    	session.save(user);
    	
    	/* 
    	 * if you want to fetch data from SQL you can use: 
    	 * user = session.get(User.class, 1); 	(1 is the UserID)
    	 * If you do this you need to delete/comment out the session.save(user); above
    	 */
    	user = session.get(User.class, 1);
    	
    	tx.commit();
    	
    	System.out.println(user); //to show the fetched data
    }
}
