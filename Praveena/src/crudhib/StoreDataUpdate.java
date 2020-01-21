package crudhib;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;  
  
public class StoreDataUpdate {  
  
    public static void main( String[] args )  
    {  
         StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
            Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
          
        SessionFactory factory = meta.getSessionFactoryBuilder().build();  
        Session session = factory.openSession();  
        Transaction t = session.beginTransaction();  
          
        Student e1=new Student();    
           
        e1.setStdId(1);    
    e1.setFirstName("Praveena");    
    e1.setLastName("Chinthapalli");   
  
   session.update(e1);
       t.commit();

// printing the updated value in console
Student e2=session.get(Student.class,1);
     System.out.println(e2.getFirstName());
     System.out.println(e2.getLastName());
       System.out.println("successfully saved details");    
        factory.close();  
        session.close();     
    }  
}  
