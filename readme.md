# Application Battle

## Pitch
L'application Battle est une application simple de combats contre des ennemis (type RPG tour par tour).

 ## R�gles

Dans un premier temps, vous seul, le joueur, attaquerez un groupe de monstres, qui seront attaqu�s sans jamais r�pondre.

Un ennemi poss�dera un nom, et une quantit� de points de vie.

Les ennemis peuvent �tre de diff�rents types :
 - Ninja - Ses r�flexes affut�s et ses connaissances en Aikido lui permettent de d�vier les attaques puissantes, si une attaque de 10 d�g�ts ou plus lui est inflig�e, les d�g�ts inflig�s seront r�duits � 1.
 - Pirate - Son �tat d'�bri�t� permanente lui conf�re un bonus de 50% d'absorption des d�g�ts. En r�alit�, ce n'est pas de l'absorption, il les sentira passer le lendemain matin.
 - Zombie - �tant d�j� mort, le zombie pourra ressusciter, une unique fois, lorsqu'il est vaincu. Il reviendra � la vie avec 1 point de vie.
 - Enfant - Il ne peut pas �tre bless�. Vous frapperiez des enfants, vous ?

Aucune attaque n'infligera 0 d�g�ts ou des d�g�ts n�gatifs, le minimum est forc� � 1. Sauf pour les enfants.

 
## D�roulement du jeu

Le joueur n'est pas repr�sent� par une classe, on ne pourra pour l'instant que choisir un ennemi � attaquer, et une attaque entre 1 et 15 d�g�ts sera inflig�e � l'ennemi cible.

L'�tat des ennemis pendant le combat doit �tre enregistr� en base de donn�es apr�s chaque tour.
Apr�s arr�t de l'application, on devrait donc pouvoir reprendre le combat comme il �tait quand on l'avait quitt�.

L'�tat initial des ennemis au premier d�marrage de l'application sera fixe, ce sera toujours le m�me �tat de d�part.
On ne g�rera pas encore l'�limination des ennemis de l'application lorsqu'ils sont vaincus.