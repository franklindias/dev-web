package util;

import model.Admin;
import model.Atributo;
import model.Classificacao;
import model.Comentario;
import model.Denuncia;
import model.Pessoa;
import model.Produto;
import model.TipoProduto;
import model.Usuario;
import model.ValorAtributo;


import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");

            cfg.addAnnotatedClass(Admin.class);
            cfg.addAnnotatedClass(Atributo.class);
            cfg.addAnnotatedClass(Classificacao.class);
            cfg.addAnnotatedClass(Comentario.class);
            cfg.addAnnotatedClass(Denuncia.class);
            cfg.addAnnotatedClass(Pessoa.class);
            cfg.addAnnotatedClass(Produto.class);
            cfg.addAnnotatedClass(TipoProduto.class);
            cfg.addAnnotatedClass(Usuario.class);
            cfg.addAnnotatedClass(ValorAtributo.class);

            StandardServiceRegistryBuilder registradorServico = new StandardServiceRegistryBuilder();
            registradorServico.applySettings(cfg.getProperties());
            StandardServiceRegistry servico = registradorServico.build();

            return cfg.buildSessionFactory(servico);
        } catch (Throwable e) {
            System.out.println("Criação inicial do objeto SessionFactory falhou. Erro: " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}