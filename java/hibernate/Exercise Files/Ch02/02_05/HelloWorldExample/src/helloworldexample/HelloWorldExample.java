/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworldexample;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Producer
 */
public class HelloWorldExample {
    private static SessionFactory factory;
    private static ServiceRegistry registry;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String m = "";
        System.out.println("Enter a message: ");
        m = in.nextLine();
        try{
            Configuration conf = new Configuration().configure();
            registry = new StandardServiceRegistryBuilder().applySettings(
            conf.getProperties()).build();
           // conf.addAnnotatedClass(Message.class);
            
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();

                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);

                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();

                // Create SessionFactory
                factory = metadata.getSessionFactoryBuilder().build();
            
            
            
            
            //factory = conf.buildSessionFactory(registry);
        } catch (Throwable ex){
            System.err.println("Failed to create session factory object"+ex);
            throw new ExceptionInInitializerError(ex);
        }
        Session session = factory.openSession();
        Transaction tx = null;
        Integer msgId = null;
        try{
            tx=session.beginTransaction();
            Message msg = new Message(m);
            msgId = (Integer) session.save(msg);
            List messages = session.createQuery("FROM Message").list();
            for(Iterator iterator = messages.iterator(); iterator.hasNext();){
                Message message = (Message)iterator.next();
                System.out.println("message: "+message.getMessage());
            }
            tx.commit();
        }catch(HibernateException e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    StandardServiceRegistryBuilder.destroy(registry);
    }
    
}
