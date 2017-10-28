# OptiZen
Gestion du transfert des données de zenon vers optimaint.

OptiZen est developper avec l'IDE Netbeans actuellement 8.2 qui n'est astraignant. 




## Installation

### Prérequis
#### Driver SQLServer 
L'installation de sql server passe par la réalisation des opération suivante :
1. Télécharger le driver depuis le site officiel Mircrosoft, soit via google avec la recherche "download jdbc sql driver" ou via le lien suivant si toujours actif (https://www.microsoft.com/fr-FR/download/details.aspx?id=11774),
2. Extraire le fichier dans le repertoire de votre choix. Example : "D:\APPLICATIONS\JAVA\LIB\Microsoft\",
3. Identifier votre exécutable de commande maven. Dans le developpement, Maven est situé à l'emplacement ("C:\Program Files\NetBeans 8.2\java\maven\bin\mvn.bat")
4. Assurez-vous que la JDK est bien définit dans vos variables environnement (JAVA_HOME = C:\Program Files\Java\jdk1.8.0_131\)
5. Ouvrir la ligne de commande, exécuter les commandes suivante,
```
D:
cd "D:\APPLICATIONS\JAVA\LIB\Microsoft\Microsoft JDBC Driver 6.0 for SQL Server\sqljdbc_6.0\fra\jre8"
"C:\Program Files\NetBeans 8.2\java\maven\bin\mvn.bat" install:install-file -Dfile=sqljdbc42.jar -Dpackaging=jar -DgroupId=com.microsoft.sqlserver -DartifactId=sqljdbc42 -Dversion=4.2
```
Cela doit se dérouler sans erreur.
NB : Vous pouvez être ammené à modifier le fichier POM en fonction de votre version SQL Server déclaré ici 4.2.

#### Compilation du Module
Il est impératif de complier le module complet afin de vous assurez que tous les sous modules sont disponible.
