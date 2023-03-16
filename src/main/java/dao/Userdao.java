package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.User;

public class Userdao {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();

	public void save(User u) 
	{
		entityTransaction.begin();
		entityManager.persist(u);
		entityTransaction.commit();
		
	}
	public User find(String email)
	{
//		return entityManager.find(User.class, email);
		List<User> m=entityManager.createQuery("select x from User x where email=?1").setParameter(1, email).getResultList();
		if(m.isEmpty())
		{
		return null;
		}else
			return m.get(0);
	}
	
	
	public List<User> fetchAll()
	{
		Query query=entityManager.createQuery("select x from User x",User.class);
				return query.getResultList();
	}
	
	public void delete(User user)
	{
		entityTransaction.begin();
		entityManager.remove(user);
		entityTransaction.commit();
	}
	public void updateUser(User user)
	{
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
		
	}

}
