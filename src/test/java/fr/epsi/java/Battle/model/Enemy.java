package fr.epsi.java.Battle.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

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
		this.health -= damage;
		
		String text;
		if( damage < 0) {
			text = name + " a reçu " + damage + "et a été vaincu.";
		}
		else {
			text = name + " a reçu " + damage + " dégâts";
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
		this.health = health;
		this.name = name;
	}

	public Enemy() {
		this.health = 0;
		this.name = null;
	}
	
	
}
