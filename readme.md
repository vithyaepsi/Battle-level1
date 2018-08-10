# Application Battle

## Pitch
L'application Battle est une application simple de combats contre des ennemis (type RPG tour par tour).

 ## Règles

Dans un premier temps, vous seul, le joueur, attaquerez un groupe de monstres, qui seront attaqués sans jamais répondre.

Un ennemi possèdera un nom, et une quantité de points de vie.

Les ennemis peuvent être de différents types :
 - Ninja - Ses réflexes affutés et ses connaissances en Aikido lui permettent de dévier les attaques puissantes, si une attaque de 10 dégâts ou plus lui est infligée, les dégâts infligés seront réduits à 1.
 - Pirate - Son état d'ébriété permanente lui confère un bonus de 50% d'absorption des dégâts. En réalité, ce n'est pas de l'absorption, il les sentira passer le lendemain matin.
 - Zombie - Étant déjà mort, le zombie pourra ressusciter, une unique fois, lorsqu'il est vaincu. Il reviendra à la vie avec 1 point de vie.
 - Enfant - Il ne peut pas être blessé. Vous frapperiez des enfants, vous ?

Aucune attaque n'infligera 0 dégâts ou des dégâts négatifs, le minimum est forcé à 1. Sauf pour les enfants.

 
## Déroulement du jeu

Le joueur n'est pas représenté par une classe, on ne pourra pour l'instant que choisir un ennemi à attaquer, et une attaque entre 1 et 15 dégâts sera infligée à l'ennemi cible.

L'état des ennemis pendant le combat doit être enregistré en base de données après chaque tour.
Après arrêt de l'application, on devrait donc pouvoir reprendre le combat comme il était quand on l'avait quitté.

L'état initial des ennemis au premier démarrage de l'application sera fixe, ce sera toujours le même état de départ.
On ne gèrera pas encore l'élimination des ennemis de l'application lorsqu'ils sont vaincus.