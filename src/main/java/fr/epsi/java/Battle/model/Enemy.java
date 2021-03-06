package fr.epsi.java.Battle.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 * Enemy est la classe dont va h�riter toutes les classes repr�sentant des ennemis
 * 
 * Cette classe et ses classes d�riv�es sont des @Entity
 * L'attribut @Id �tant h�rit�, il ne sera pas n�c�ssaire de le r�p�ter.
 * 
 * Pour rappel, les annotations obligatoires pour qu'une classe respecte la JPA sont @Entity et @Id
 * 
 * La namedQuery est utilis�e dans EnemyDAO.java
 * 
 * */
@Entity
@NamedQueries({
	@NamedQuery (name = "findAllEnemies", query = "SELECT e FROM Enemy e")
})
public abstract class Enemy {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	protected int health;
	private String name;
	
	public String receiveDamage(int damage) {
		if(damage <= 0) {
			damage = 1;
		}
		this.health -= damage;
		
		String text;
		if( damage < 0) {
			text = name + " a re�u " + damage + "et a �t� vaincu.";
		}
		else {
			text = name + " a re�u " + damage + " d�g�ts";
		}
		return text;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Enemy(int health, String name) {
		this();
		this.health = health;
		this.name = name;
	}

	public Enemy() {
		this.health = 0;
		this.name = null;
	}
	
	
}
