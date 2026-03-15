# Application Web de Gestion des Produits

## Objectif
Créer une application Web JEE basée sur Spring Boot permettant de gérer des produits.  

L'application utilise les technologies suivantes :

- Spring Boot
- Spring Data JPA
- Hibernate
- Thymeleaf
- Spring Security
- Bootstrap

# 1. Création du projet Spring Boot

Nous avons créé un projet Spring Boot avec les dépendances suivantes :

- Spring Web
- Spring Data JPA
- H2 Database
- MySQL
- Thymeleaf
- Lombok
- Spring Security
- Spring Validation
![img.png](img.png)

# 2. Création de l'entité JPA Product
Création de l'entité Product avec les attributs :

- id
- name
- price
- quantity

Cette entité est annotée avec les annotations JPA.
![img_1.png](img_1.png)

3. Création du Repository

Création de l'interface ProductRepository basée sur Spring Data JPA.

Cette interface permet d'effectuer les opérations CRUD sur la base de données.


# 4. Test de la couche DAO

Test de la couche DAO au démarrage de l'application pour vérifier :

- L'ajout des produits
- L'affichage des produits

![img_2.png](img_2.png)
- login
![img_3.png](img_3.png)

# 5. Désactivation de la sécurité par défaut

Au début du projet, la sécurité par défaut de Spring Security a été désactivée pour permettre le développement de l'application.

# 6. Création du contrôleur et des vues

Création du contrôleur Spring MVC pour gérer les actions suivantes :

- Afficher la liste des produits
![img_4.png](img_4.png)
- Supprimer un produit
![img_6.png](img_6.png)
![img_5.png](img_5.png)
- Ajouter un produit
![img_8.png](img_8.png)
![img_9.png](img_9.png)
## 7. Sécurisation de l'application

L'application est sécurisée avec Spring Security.  
Après authentification, le nom de l'utilisateur apparaît dans la barre de navigation avec un menu déroulant permettant de se déconnecter.

### Barre de navigation avec utilisateur connecté
Admin
![img_10.png](img_10.png)
User1
![img_12.png](img_12.png)

L'application est sécurisée avec Spring Security.

Deux rôles sont définis :

### USER
- Peut consulter la liste des produits
![img_13.png](img_13.png)

### ADMIN
- Peut consulter les produits
- Peut ajouter un produit
- Peut supprimer un produit
![img_14.png](img_14.png)
### Accès refusé pour un utilisateur USER

Lorsqu'un utilisateur ayant le rôle USER tente d'accéder à une page réservée à l'administrateur (par exemple : ajouter un produit), l'application affiche une page "Not Authorized".
![img_15.png](img_15.png)

## 8. Fonctionnalités supplémentaires

Afin d'améliorer l'application, plusieurs fonctionnalités supplémentaires ont été ajoutées.

![img_20.png](img_20.png)
### 1. Recherche des produits

Une barre de recherche a été ajoutée permettant de filtrer les produits par nom.

![img_17.png](img_17.png)

### 2. Edition et mise à jour d'un produit

L'administrateur peut modifier les informations d'un produit existant.

![img_18.png](img_18.png)


## Conclusion

Ce projet nous a permis de comprendre le fonctionnement du framework Spring Boot et de ses composants principaux comme Spring MVC, Spring Data JPA et Spring Security pour développer une application web sécurisée.

