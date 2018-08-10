package fr.epsi.java.Battle.model;

import javax.persistence.Entity;

@Entity
public class Pirate extends Enemy {

	public Pirate(int health, String name) {
		super(health, name);
	}
	public Pirate() {
		super();
	}
	
	public String receiveDamage(int damage) {
		float calcul = damage / 2;
		String text = super.receiveDamage( Math.round(calcul) );
		return text;
	}

}
