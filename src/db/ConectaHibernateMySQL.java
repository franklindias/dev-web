package db;

import org.hibernate.Session;

import util.HibernateUtil;

public class ConectaHibernateMySQL {
	public static void main(String[] args) {
		Session sessao = null;
		sessao = HibernateUtil.getSession();
		System.out.println("Conectou!");
		sessao.close();
	}
}