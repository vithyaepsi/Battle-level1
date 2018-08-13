package fr.epsi.java.Battle.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.epsi.java.Battle.model.Enemy;

/**
 * Le DAO est utilis� pour manipuler l'EntityManager, qui peut agir sur la base de donn�es
 * On ne fera appara�tre l'EntityManager nulle part dans le main(), il sera utilis� via le DAO
 *
 * Les classes du projet �tant toutes des extends de la classe Enemy, et aucune classe n'ayant besoin d'une m�thode suppl�mentaire
 * On peut se permettre de ne cr�er qu'un seul DAO pour toutes les classes du projet
 */
public class EnemyDAO {
	private EntityManager em;

	public EnemyDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MaPersistenceUnit");
		//	L'EntityManagerFactory peut renvoyer une nouvelle instance d'EntityManager
		this.em = emf.createEntityManager();
	}
	
	//	Le nom des m�thodes ci-dessous sont d�lib�r�ment en fran�ais pour montrer 
	//	qu'on ne manipule pas directement les m�thodes de l'EntityManager dans le main()
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
	 *	Il n'y a pas de m�thode de base permettant de directement r�cup�rer tous les objets stock�s dans l'EM
	 *	On utilisera une NamedQuery, qui est d�finie dans la classe Enemy
	 *	
	 * */
	public List<Enemy> recupererTousEnnemis(){
		Query q = em.createNamedQuery("findAllEnemies", Enemy.class);
        List<Enemy> listeAgence = (List<Enemy>)q.getResultList();
        
        return listeAgence;
	}
}
