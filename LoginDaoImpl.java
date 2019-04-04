package org.medex.dao;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@SuppressWarnings("deprecation")
@Transactional
@Repository
public class LoginDaoImpl implements LoginDao {
                
                //@Autowired
                @Resource(name="sessionFactory")
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
           this.sessionFactory = sessionFactory;
    }
   
    protected Session getSession(){
           return sessionFactory.openSession();
    }
    
	@Override
	public boolean selectUser(String id, String pwd) {
		Session session = sessionFactory.openSession();
        boolean role = false;
        String SQL_QUERY ="from org.medex.entity.User as o where o.id=:id and o.pwd=:pwd";
        Query query = session.createQuery(SQL_QUERY);
        query.setParameter("id",id);
        query.setParameter("pwd",pwd);
        List list = query.list();

        if ((list != null) && (list.size() > 0)) {
                        role= true;
        }
        else{
                        role= false;
        }

        session.close();
       
        return role; 
	}           
                                  
                                 
   }
