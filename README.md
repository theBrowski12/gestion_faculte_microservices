🎓 Projet Gestion Faculté

Ce projet est une architecture microservices Spring Boot composée de deux services principaux :

🧩 gestion_filiere : gère les filières (code, libellé, etc.)

👨‍🎓 gestion_etudiant : gère les étudiants et leur rattachement à une filière

Chaque microservice est indépendant, dispose de sa propre base de données, et communique avec les autres via des requêtes REST.

Remarque : Si la filière existe, on sauvegarde l'étudiant, sinon On le sauvegarde pas !!!

⚙️ Technologies utilisées

Java 17

Spring Boot 3

Spring Data JPA

MySQL

Spring Web (REST)

Lombok

Swagger / Springdoc OpenAPI pour la documentation

Postman pour les tests d’API

Screenshots:
**Gestion Etudiants:**
![img.png](img.png)

Gestion Filieres:
![img_1.png](img_1.png)
