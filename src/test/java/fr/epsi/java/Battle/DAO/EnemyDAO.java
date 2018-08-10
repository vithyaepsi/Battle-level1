package fr.epsi.java.Battle.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.epsi.java.Battle.model.Enemy;

public class EnemyDAO {
	private EntityManager em;

	public EnemyDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MaPersistenceUnit");
		this.em = emf.createEntityManager();
	}
	
	public Enemy trouverParId(int id){
		Enemy e = em.find(Enemy.class, id);
		
		return e;
	}
	
	public void enregistrer(Enemy e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	public List<Enemy> recupererTousEnnemis(){
		Query q = em.createNamedQuery("findAllEnemies", Enemy.class);
        List<Enemy> listeAgence = (List<Enemy>)q.getResultList();
        
        return listeAgence;
	}
}
