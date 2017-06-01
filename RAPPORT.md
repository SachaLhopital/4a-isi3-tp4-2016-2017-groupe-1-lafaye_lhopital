**Nom/Prénom Etudiant 1 : LAFAYE DE MICHEAUX Yoan **

**Nom/Prénom Etudiant 2 : LHOPITAL Sacha **

# Rapport TP4 - Projet

*Ce projet a été réalisé dans le cadre du cours d’ISI de Polytech Lyon - 4e Année du cycle d’Ingénieur Informatique.*

## Introduction

Ce rapport présente le compte rendu de développement et d'amélioration d'un projet de gestion de Tortues. Ce document présente notre travail, mais égalements les difficultés que nous avons rencontrés.
 
Nous commencerons par présenter les différents problèmes initialement présents dans le projet que nous avons résolu au fur et à mesure. 

Le projet comprend une application principale avec des interfaces utilisateurs en Swing. Le projet comprends également quelques tests. 

L'application implémente les notions suivantes : Pattern MVC, Pattern Observeur - Observé, Tests Unitaires, Code SMELL le plus propre possible. 
L'application implémente également les fonctionnalités suivantes : Gestion d'une multitude de Tortues (Mode manuel ou Automatique), Tortues Flocking (et Flocking Sectaire) et enfin un ensemble de tests, surtout concentré sur les fonctionnalités liées au flocking. 

Nous terminerons par une conclusion sur notre travail.


## Etude de l'existant

![Diagrame de Classe de l'existant](images/rapport/DiagrammeNonRefactorise.PNG)

Liste de problèmes à résoudre :

- Certaines variables et méthodes sont inutilisées

- Certains nom de variables et de méthodes ne sont pas très clairs :
```java
private oldSrc.Tortue courante;
```

- Le code est à la fois écrit en Anglais et en Français (par la suite nous avons décidé d'écrire le code en Français) :
```java
public void addTortue(oldSrc.Tortue o) {
    tortues.add(o);
}
```

- Certains commentaires ne sont pas pertinents :
```java
/** quelques classiques */
```

- Certains commentaires ou morceaux de code ont été copier coller

- Il y a quelques morceaux de code  "elseif" que l'on peut simplifier :
```java
if (c.equals("Avancer")) {
    [...]
}
else if (c.equals("Droite")) {
    [...]
}
else if (c.equals("Gauche")) {
    [...]
}
else if (c.equals("Lever"))
    courante.leverCrayon();
else if (c.equals("Baisser"))
    courante.baisserCrayon();
// actions des boutons du bas
else if (c.equals("Proc1"))
    proc1();
else if (c.equals("Proc2"))
    proc2();
else if (c.equals("Proc3"))
    proc3();
else if (c.equals("Effacer"))
    effacer();
else if (c.equals("Quitter"))
    quitter();
```

- Certains nom de paramètres de méthodes ne sont pas pertinants :
```java
public void poly(int n, int a){[...]}
```

- Les getters et setters ne sont pas assez utilisés

- Certains calculs sont obsolètes et peuvent être remplacés en utilisant des librairies (Java.Math par exemple).

- Il y a aussi des problèmes d'indentations du code.

## Implémentation du MVC

Pour appliquer l’architecture MVC, nous avons réorganisé les éléments de l’application en trois package (modele, vue, controleur). 

//TODO Yoan : diagramme UML éventuellement ? 
+ expliquer l'arborescence des controleurs/vues
+ expliquer le lien vue/controleur/modèle
+ expliquer observer observé 
+ expliquer difficultés éventuelles

#### Modèle

![Diagrame de Classe du modele](images/rapport/diagramModele.PNG)

Pour gérer les différentes Formes, nous avions mis en place une interface IForme qui permettais au controleur de simplement faire IForme.tracer(), plutôt que de devoir gérer le type de forme avec des méthodes différentes. Finallement se code a été supprimé car inutilisé dans notre projet final.

#### Controleur

![Diagrame de Classe du modele](images/rapport/diagramControler.PNG)

#### Vue

![Diagrame de Classe du modele](images/rapport/diagramVue.PNG)

## Extension du projet

#### Gestion de plusieurs tortues

Le but etait de pouvoir afficher lusieurs tortues et de pouvoir les selectionner de maniere independante.
La technique utilisée est d'aficher des JComponent qui ne sont en charge que du dessin de la tortue (triangle et orientation) puis 
de placer ces JComponent dans un JPannel de maniere fixée (avec la methode setBounds). En utilisant cette technique, nous avont acces aux diférents évenements sur chaque JComponent dont le Clic ... A la détecton d'un clic on peut donc selectionner une tortue de maniere simple.

#### Tortues autonomes

//Todo Yoan expliquer + problèmes rencontrés

Les tortues autonomes sont des tortues qui se mettent à jour de maniere réguliere selon un algorythe précis (aléatoire, flocking ...). Afin d'automatiser les mises à jours, chaque controlleur execute à intervale reguliere la methode miseAJour qui est en charge de mettre à jour chque tortue presente sur l'afichage. Le mode auto fonctione sur une base aléatoire (avancer de x, tourner a droite de y, tourner a gauche de z, [x,y,z] etant selectionnés aléatoirement).

````java
 Timer timer = new Timer();
        TimerTask myTask = new TimerTask() {
            @Override
            public void run() {
                miseAJour();
            }
        };

        timer.schedule(myTask, DELAI, PERIODE);
````


#### Comportement de flocking

//Todo SLH

#### Comportement de flocking sectaire

//Todo SLH

#### Tests

//Todo SLH

## Conclusion

Ce projet a été l’occasion pour nous d'améliorer un application en profondeur et de réellement nous rendre compte de l'importance que nous devons donner aux principes de développement Clean.

 