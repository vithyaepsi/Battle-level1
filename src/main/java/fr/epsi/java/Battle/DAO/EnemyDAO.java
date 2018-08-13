package fr.epsi.java.Battle.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.epsi.java.Battle.model.Enemy;

/**
 * Le DAO est utilisé pour manipuler l'EntityManager, qui peut agir sur la base de données
 * On ne fera apparaître l'EntityManager nulle part dans le main(), il sera utilisé via le DAO
 *
 * Les classes du projet étant toutes des extends de la classe Enemy, et aucune classe n'ayant besoin d'une méthode supplémentaire
 * On peut se permettre de ne créer qu'un seul DAO pour toutes les classes du projet
 */
public class EnemyDAO {
	private EntityManager em;

	public EnemyDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MaPersistenceUnit");
		//	L'EntityManagerFactory peut renvoyer une nouvelle instance d'EntityManager
		this.em = emf.createEntityManager();
	}
	
	//	Le nom des méthodes ci-dessous sont délibérément en français pour montrer 
	//	qu'on ne manipule pas directement les méthodes de l'EntityManager dans le main()
	public Enemy trouverParId(int id){
		Enemy e = em.find(Enemy.class, id);
		
		return e;
	}
	
	//	Lorsqu'on persist(), on doit ouvrir une transaction, et la fermer
	public void enregistrer(Enemy e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	/**
	 *	Il n'y a pas de méthode de base permettant de directement récupérer tous les objets stockés dans l'EM
	 *	On utilisera une NamedQuery, qui est définie dans la classe Enemy
	 *	
	 * */
	public List<Enemy> recupererTousEnnemis(){
		Query q = em.createNamedQuery("findAllEnemies", Enemy.class);
        List<Enemy> listeAgence = (List<Enemy>)q.getResultList();
        
        return listeAgence;
	}
}
