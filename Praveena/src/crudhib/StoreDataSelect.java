package crudhib;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class StoreDataSelect {
	 public static void main( String[] args )  
	    {  
	         StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	            Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	          
	        SessionFactory factory = meta.getSessionFactoryBuilder().build();  
	        Session session = factory.openSession();  
	        Transaction t = session.beginTransaction();
	        
	        Scanner sc=new Scanner(System.in);
	        System.out.println("Enter id no that you want to display");
	        int id=sc.nextInt();
	        
            Query q=session.createQuery("from Student where id=:Idno");
            q.setParameter("Idno", id);
            List l=q.list();            
            Iterator it=l.iterator();
            while(it.hasNext()){
                Student m=(Student)it.next();
                System.out.println("Name    : "+m.getFirstName());
                
                System.out.println("Name    : "+m.getLastName());
                factory.close();  
                session.close();
}
   }
}
