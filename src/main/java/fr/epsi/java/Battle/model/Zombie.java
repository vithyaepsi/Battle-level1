package fr.epsi.java.Battle.model;

import javax.persistence.Entity;

@Entity
public class Zombie extends Enemy {
	
	private boolean hasResurrected;

	public Zombie(int health, String name) {
		super(health, name);
		hasResurrected = false;
	}
	
	public Zombie() {
		super();
	}

	/**
	 * Ici, lorsque un Enemy de la classe Zombie reçoit des dégâts létaux,
	 * */
	public String receiveDamage(int damage) {
		String text;
		if( health - damage <= 0 && !hasResurrected ) {
			hasResurrected = true;
			text = super.receiveDamage(damage) + "... Mais a réssuscité !";
			health = 1;
		}
		else {
			text = super.receiveDamage(damage);
		}
		
		
		return text;
	}
}
