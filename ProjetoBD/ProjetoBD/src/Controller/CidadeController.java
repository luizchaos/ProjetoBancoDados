package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Classes.Cidade;

public class CidadeController {
	public Cidade inserir(EntityManager entityManager ,Cidade obj) {
		
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
		
		return obj;
	}
	
	public void remover(EntityManager entityManager ,Cidade obj) {
		entityManager.getTransaction().begin();
		entityManager.remove(obj);
		entityManager.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cidade> listar(EntityManager entityManager){
		entityManager.getTransaction().begin();
		Query q = entityManager.createQuery("From Cidade");
		
		List<Cidade> resultList = q.getResultList();
		entityManager.getTransaction().commit();
		return resultList;
	}
	
	public Cidade obter(EntityManager entityManager, Integer id) {
		entityManager.getTransaction().begin();
		Cidade obj = entityManager.find(Cidade.class, id);
		entityManager.getTransaction().commit();
		return obj;
	}
	
	public Cidade atualizar(EntityManager entityManager ,Cidade obj) {
		entityManager.getTransaction().begin();
		entityManager.merge(obj);
		entityManager.getTransaction().commit();
		
		return obj;
	}
}
