package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Classes.Endereco;

public class EnderecoController {
	public Endereco inserir(EntityManager entityManager ,Endereco obj) {
		
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
		
		return obj;
	}
	
	public void remover(EntityManager entityManager ,Endereco obj) {
		entityManager.getTransaction().begin();
		entityManager.remove(obj);
		entityManager.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Endereco> listar(EntityManager entityManager){
		entityManager.getTransaction().begin();
		Query q = entityManager.createQuery("From Endereco");
		
		List<Endereco> resultList = q.getResultList();
		entityManager.getTransaction().commit();
		return resultList;
	}
	
	public Endereco obter(EntityManager entityManager, Integer id) {
		entityManager.getTransaction().begin();
		Endereco obj = entityManager.find(Endereco.class, id);
		entityManager.getTransaction().commit();
		return obj;
	}
	
	public Endereco atualizar(EntityManager entityManager ,Endereco obj) {
		entityManager.getTransaction().begin();
		entityManager.merge(obj);
		entityManager.getTransaction().commit();
		
		return obj;
	}
}
