package fr.epsi.java.Battle.model;

import javax.persistence.Entity;

@Entity
public class Ninja extends Enemy {

	public Ninja(int health, String name) {
		super(health, name);
	}
	
	public Ninja() {
		super();
	}
	
	public String receiveDamage(int damage) {
		String text;
		
		if( damage > 10 ) {
			text = super.receiveDamage(1);
		}
		else {
			text = super.receiveDamage(damage);
		}
		return text;
	}
	
}
