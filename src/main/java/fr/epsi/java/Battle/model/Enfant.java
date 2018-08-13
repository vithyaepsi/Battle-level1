package fr.epsi.java.Battle.model;

import javax.persistence.Entity;

/**
 * La classe enfant est un ennemi qui ne peut pas recevoir de dégâts, il est intouchable.
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
	 * La méthode receiveDamage ne doit pas infliger de dégâts à l'Enfant
	 * Étant donné que l'on refuse d'infliger des dégâts de 0
	 * on doit réimplémenter le comportement de receiveDamage sans appeler super.receiveDamage()
	 * 
	 * */
	public String receiveDamage(int damage) {
		return "L'enfant a reçu une sucette à la place de dégâts.";
	}

}
