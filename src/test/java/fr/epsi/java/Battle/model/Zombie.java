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
	 * Ici, lorsque un Enemy de la classe Zombie reçoit des dégâts létaux
	 * Étant donné qu'on ne veut pas afficher les dégâts qui lui ont été ???, on n'appelle pas super.receiveDamage()
	 * Et on réimplémente ce que 
	 * */
	public String receiveDamage(int damage) {
		String text;
		if( health - damage <= 0 && !hasResurrected ) {
			health = 1;
			hasResurrected = true;
			text = super.receiveDamage(damage) + ".. Mais a réssuscité !";
		}
		else {
			text = super.receiveDamage(damage);
		}
		
		
		return text;
	}
}
