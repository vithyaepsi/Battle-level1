package fr.epsi.java.Battle.model;

import javax.persistence.Entity;

/**
 * La classe enfant est un ennemi qui ne peut pas recevoir de d�g�ts, il est intouchable.
 * */
@Entity
public class Enfant extends Enemy {

	public Enfant(int health, String name) {
		super(health, name);
	}
	
	public Enfant() {
		super();
	}
	
	/**
	 * La m�thode getDamage ne doit pas infliger de d�g�ts � l'Enfant
	 * �tant donn� que l'on refuse d'infliger des d�g�ts de 0
	 * On doit r�impl�menter le comportement de receiveDamage sans appeler super.getDamage() car 
	 * on a d�termin� que les d�g�ts minimum seraient de 1 dans cette m�thode
	 * */
	public String receiveDamage(int damage) {
		return "L'enfant a re�u une sucette � la place de d�g�ts.";
	}

}
