package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Classes.Cliente;

public class ClienteController {
	public Cliente inserir(EntityManager entityManager ,Cliente obj) {
		
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
		
		return obj;
	}
	
	public void remover(EntityManager entityManager ,Cliente obj) {
		entityManager.getTransaction().begin();
		entityManager.remove(obj);
		entityManager.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listar(EntityManager entityManager){
		entityManager.getTransaction().begin();
		Query q = entityManager.createQuery("From Cliente");
		
		List<Cliente> resultList = q.getResultList();
		entityManager.getTransaction().commit();
		return resultList;
	}
	
	public Cliente obter(EntityManager entityManager, Integer id) {
		entityManager.getTransaction().begin();
		Cliente obj = entityManager.find(Cliente.class, id);
		entityManager.getTransaction().commit();
		return obj;
	}
	
	public Cliente atualizar(EntityManager entityManager ,Cliente obj) {
		entityManager.getTransaction().begin();
		entityManager.merge(obj);
		entityManager.getTransaction().commit();
		
		return obj;
	}
}
