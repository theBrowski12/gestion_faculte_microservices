🎓 Projet Microservices : Gestion Faculté (Étudiants & Filières)

Description du projet

Ce projet est une application web basée sur Spring Boot et Thymeleaf, composée de deux microservices :

Gestion Filière (gestion_filiere) :

 >Permet de gérer les filières d’une université (CRUD : création, lecture, modification, suppression).

 >Fournit un service REST pour récupérer les informations sur les filières.

Gestion Étudiant (gestion_etudiant) :

 >Permet de gérer les étudiants (CRUD).

 >Les étudiants sont liés aux filières via un identifiant de filière.

 >Utilise un FeignClient pour récupérer les informations des filières depuis le microservice gestion_filiere.

Documentation API (Swagger)

Ce projet utilise Swagger pour documenter et tester les APIs REST. Swagger fournit une interface graphique qui permet de visualiser tous les endpoints, les paramètres attendus, et de tester les requêtes directement depuis le navigateur.

Remarque : Si la filière existe, on sauvegarde l'étudiant, sinon On le sauvegarde pas !!!

==================================================================
⚙️ Technologies utilisées

Outil / Framework	Utilisation

Spring Boot 3.x	Base des microservices.

Spring Web	Création des API REST.

Spring Data JPA	Accès à la base de données.

Thymeleaf pour le rendu des pages HTML

Bootstrap 5 pour le style

Feign Client (Spring Cloud OpenFeign)	Communication interservices.

Swagger / Springdoc OpenAPI	Documentation interactive.

MySQL	Base de données.

Maven	Gestion des dépendances.

Lombok.

Postman pour les tests d’API.

==================================================================
Screenshots:
**Gestion Filieres Page**
![img_2.png](img_2.png)
Modifier Filiere Page :
![img_3.png](img_3.png)
Gestion Filieres Swagger:
![img_1.png](img_1.png)
=========================
**Gestion Etudiants Page**
![img_4.png](img_4.png)
Modifier Etudiants Page :
![img_5.png](img_5.png)
Gestion Etudiants Swagger:
![img.png](img.png)


