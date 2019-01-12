# travel-agency-api
Projet L3 API (partie backend) du projet de réservation des api.
Cette partie permet d'exposer un webservice permettant de rechercher des hotels de les filtrer par un prix minmum / maximu et une adresse

### Architecture
Cette application a été conçue à l'aide de framework [Spring boot](http://spring.io/) :
- elle embarque une base de données intégrée [H2](http://www.h2database.com/html/main.html)
- un serveur applicatif tomcat intégrée (fournit par spring boot cf : lien plus haut)
- un script de donnée a été intégré au démarrage afin de pouvoir initialiser la bdd

**Important** Grâce à spring le déploiement et le développement d'une telle application est grandement facilitée car il fournit toute la composante d'accès aux données + serveur applicatif de manière intégrée ce qui permet.
Ceci permet de réduire toute l'application à un banal jar qu'on peut lancer avec la commande java -jar "le nom du jar final"
