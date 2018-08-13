package fr.epsi.java.Battle.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import fr.epsi.java.Battle.DAO.EnemyDAO;
import fr.epsi.java.Battle.model.Enemy;
import fr.epsi.java.Battle.model.Enfant;
import fr.epsi.java.Battle.model.Ninja;
import fr.epsi.java.Battle.model.Pirate;
import fr.epsi.java.Battle.model.Zombie;

public class Main {
	private static EnemyDAO eDAO = new EnemyDAO();
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Initialise la base de données avec des ennemis
	 * */
	public static void initializeEnemies() {
		Enemy e1 = new Enfant(1, "Dewey");
		Enemy e2 = new Ninja(40, "Hayato");
		Pirate e3 = new Pirate(90, "Shirley");
		Enemy e4 = new Zombie(20, "Harold");
				
		eDAO.enregistrer(e1);
		eDAO.enregistrer(e2);
		eDAO.enregistrer(e3);
		eDAO.enregistrer(e4);
	}
	
	/**
	 * Point d'entrée de l'application
	 * */
	public static void main(String[] args) {
		if( eDAO.recupererTousEnnemis().isEmpty() ) {
			initializeEnemies();
		}
		gameMain();
		
		
	}
	
	public static void gameMain(){
        int response;
        List<Enemy> enemiesList;
        do {
        	enemiesList = eDAO.recupererTousEnnemis();
        	
            System.out.println( "**************************************" );
            System.out.println( "* Liste des ennemis                  *" );
            int count = 0;
            for(Enemy e : enemiesList) {
            	System.out.println( "* "+ count + "-" + e.getClass().getSimpleName() + " : " + e.getName() + " | " + e.getHealth() + " pv" );
            	count++;
            }
            
            System.out.println( "* -1 - QUITTER                       *" );
            System.out.println( "**************************************" );
            System.out.print( "*Sélectionnez votre cible : " );
            response = scanner.nextInt();
            scanner.nextLine();
            saveEnemiesList(enemiesList);
            
        } while ( -1 > response || response >= enemiesList.size() );
        if(response == -1) {
        	System.out.println("-- APPLICATION FERMÉE --");
        	System.exit(0);
        }
        else {
        	Enemy e = enemiesList.get(response);
        	int randomDamage = ThreadLocalRandom.current().nextInt(1, 15 + 1);	//	Random entre 1 et 15
        	String text = e.receiveDamage(randomDamage);
        	System.out.println(text);
        	
        	System.out.println("-- APPUYEZ SUR ENTRÉE POUR CONTINUER --");
        	scanner.nextLine();
        	
        	gameMain();
        }
        
    }
	
	//	Sauvegarde les ennemis en base.
	public static void saveEnemiesList(List<Enemy> enemiesList) {
		for(Enemy e : enemiesList) {
			eDAO.enregistrer(e);
		}
	}
	
	
	
}
