package mappingRelations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppStart {

	public static void main(String[] args) {

		Laptop laptop = new Laptop();
		laptop.setLapID(102);
		laptop.setLapName("Dell");
		
		Student student = new Student();
		student.setStudID(2);
		student.setStudName("Heinz Ketchup");
		student.setStudMarks(54);
		
		
		Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class); 
    	ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
    	SessionFactory factory = config.buildSessionFactory(registry);
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	session.save(laptop);
    	session.save(student);
    	
    	
    	/* 
    	 * if you want to fetch data from SQL you can use: 
    	 * student = session.get(Student.class, 1);
    	 * laptop = session.get(Laptop.class, 101);
    	 * If you do this you need to delete / comment out the session.save(student); above
    	 */
    	
    	tx.commit();
    	
    	//System.out.println("Student: " + student + "\nLaptop: " + laptop);
    	
	}

}
