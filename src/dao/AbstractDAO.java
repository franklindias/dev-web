package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import util.ErroUtil;
import util.HibernateUtil;


public abstract class AbstractDAO<T> {
	private Class classe;
	private Session session;
	public AbstractDAO(){
		this.classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	protected Session getSession(){
		if(this.session == null || !this.session.isOpen()){
			this.session = HibernateUtil.getSession();
		}
		return this.session;
	}
	public void save(T t){
		getSession().beginTransaction();
		getSession().save(t);
		getSession().close();
	}
	public void delete(T t){
		getSession().beginTransaction();
		getSession().delete(t);
		getSession().close();
	}
	public void alter(T t){
		getSession().beginTransaction();
		getSession().update(t);
		getSession().close();
	}
	
	public List<T> findAll(){
		return getSession().createCriteria(this.classe).list();
	}
         
	public List<T> findByExample(T filtro, MatchMode matchMode, boolean ignoreCase){
		org.hibernate.criterion.Example example = org.hibernate.criterion.Example.create(filtro);
		if(matchMode != null){
			example = example.enableLike(matchMode);
		}
		if(ignoreCase){
			example = example.ignoreCase();
		}
		return getSession().createCriteria(this.classe).add(example).list();
	}
}