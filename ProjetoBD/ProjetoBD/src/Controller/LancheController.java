package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Classes.Lanche;

public class LancheController {
	public Lanche inserir(EntityManager entityManager ,Lanche obj) {
		
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
		
		return obj;
	}
	
	public void remover(EntityManager entityManager ,Lanche obj) {
		entityManager.getTransaction().begin();
		entityManager.remove(obj);
		entityManager.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Lanche> listar(EntityManager entityManager){
		entityManager.getTransaction().begin();
		Query q = entityManager.createQuery("From Lanche");
		
		List<Lanche> resultList = q.getResultList();
		entityManager.getTransaction().commit();
		return resultList;
	}
	
	public Lanche obter(EntityManager entityManager, Integer id) {
		entityManager.getTransaction().begin();
		Lanche obj = entityManager.find(Lanche.class, id);
		entityManager.getTransaction().commit();
		return obj;
	}
	
	public Lanche atualizar(EntityManager entityManager ,Lanche obj) {
		entityManager.getTransaction().begin();
		entityManager.merge(obj);
		entityManager.getTransaction().commit();
		
		return obj;
	}
}
