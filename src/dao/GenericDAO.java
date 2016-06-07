package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.lang.reflect.ParameterizedType;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import util.ErroUtil;
import util.HibernateUtil;


public class GenericDAO<E> {

    private Class<E> classe;
    private Transaction transacao = null;
    private Session sessao = null;

    @SuppressWarnings("unchecked")
    public GenericDAO() {
    	
        this.classe = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

   
    public void salvar(E entidade) throws ErroUtil {
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        
        try {
            
            transacao = sessao.beginTransaction();
            
            sessao.save(entidade);
            
            transacao.commit();
        } catch (RuntimeException erro) {
            
            if (transacao != null) {
                transacao.rollback(); 
            }
            
            throw new ErroUtil("Erro ao tentar salvar!", erro);
        } finally {
            sessao.close();
        }
    }

    
    public void deletar(E entidade) throws ErroUtil {

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.delete(entidade);
            transacao.commit();
        } catch (RuntimeException erro) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw new ErroUtil("Erro ao tentar deletar!", erro);
        } finally {
            sessao.close();
        }
    }

   
    public void editar(E entidade) throws ErroUtil {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.update(entidade);
            transacao.commit();
        } catch (RuntimeException erro) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw new ErroUtil("Erro ao tentar salvar!", erro);
        } finally {
            sessao.close();
        }
    }

   
    public List<E> listar() throws ErroUtil {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria consulta = sessao.createCriteria(classe); 
            List<E> resultado = consulta.list();
            return resultado;
        } catch (RuntimeException er) {
            throw new ErroUtil("Erro ao tentar consultar os dados", er);
        } finally {
            sessao.close();
        }
    }

   
    public E buscar(Integer codigo) throws ErroUtil {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria consulta = sessao.createCriteria(classe);

            
            consulta.add(Restrictions.idEq(codigo));

            
            E resultado = (E) consulta.uniqueResult();
            return resultado;
        } catch (RuntimeException er) {
            throw new ErroUtil("Erro ao tentar consultar os dados", er);
        } finally {
            sessao.close();
        }
    }

    
    public void merge(E entidade) throws ErroUtil {
        sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            transacao = sessao.beginTransaction();
            sessao.merge(entidade);
            transacao.commit();
        } catch (RuntimeException erro) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw new ErroUtil("Erro ao tentar salvar!", erro);
        } finally {
            sessao.close();
        }
    }
}