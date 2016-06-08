package util;


import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	//COnfigura um objeto do tipo SessionFactory que irá prover todos os objetos de Sessão (Session)
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();		
	}
	//Obtem a Session
	public static Session getSession(){
		return sessionFactory.openSession();
	}
}