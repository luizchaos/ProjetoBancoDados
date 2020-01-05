package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Classes.Venda;

public class VendaController {
	public Venda inserir(EntityManager entityManager ,Venda obj) {
		
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
		
		return obj;
	}
	
	public void remover(EntityManager entityManager ,Venda obj) {
		entityManager.getTransaction().begin();
		entityManager.remove(obj);
		entityManager.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Venda> listar(EntityManager entityManager){
		entityManager.getTransaction().begin();
		Query q = entityManager.createQuery("From Venda");
		
		List<Venda> resultList = q.getResultList();
		entityManager.getTransaction().commit();
		return resultList;
	}
	
	public Venda obter(EntityManager entityManager, Integer id) {
		entityManager.getTransaction().begin();
		Venda obj = entityManager.find(Venda.class, id);
		entityManager.getTransaction().commit();
		return obj;
	}
	
	public Venda atualizar(EntityManager entityManager ,Venda obj) {
		entityManager.getTransaction().begin();
		entityManager.merge(obj);
		entityManager.getTransaction().commit();
		
		return obj;
	}
}
