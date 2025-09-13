# GestionnaireDesTachesV2

## Table des matières
1. [Description](#description)  
2. [Fonctionnalités](#fonctionnalités)  
3. [Technologies Utilisées](#technologies-utilisées)  
4. [Installation](#installation)  
5. [Base de Données](#base-de-données)  
6. [Exécution](#exécution)  
7. [Structure du Projet](#structure-du-projet)  
8. [Contribuer](#contribuer)  

---

## Description
**GestionnaireDesTachesV2** est une version améliorée du projet [GestionnaireDesTaches](https://github.com/HamzaAitahmed/GestionnaireDesTaches), intégrant **Angular** pour la partie front-end.  

Le projet est un outil complet pour gérer des projets, des équipes et leurs tâches associées. Il offre une interface moderne et intuitive pour :  
- Créer et gérer des projets.  
- Créer et assigner des tâches aux membres d’une équipe.  
- Gérer les équipes et leurs rôles (admin, chef de projet, chef d’équipe, membre).  
- Suivre l’avancement grâce à des statuts de tâches (En attente, En cours, Terminée).  

L’application est construite sur une architecture **full-stack moderne** :  
- **Back-end** : Spring Boot + MySQL.  
- **Front-end** : Angular.  
- **Communication** : REST API / GraphQL.  

---

## Fonctionnalités
- **Gestion des projets** : création, modification, suppression, consultation.  
- **Gestion des équipes** : ajout de membres, attribution d’un chef d’équipe.  
- **Gestion des tâches** :  
  - Création / édition / suppression de tâches.  
  - Attribution d’une tâche à un membre ou au chef de projet.  
  - Suivi via les statuts : *EN_ATTENTE*, *EN_COURS*, *TERMINEE*.  
- **Authentification** : accès sécurisé par login/mot de passe.  
- **Interface utilisateur moderne** avec Angular (dashboard, sidebar, navbar, pages CRUD).  

---

## Technologies Utilisées
- **Java 8+** : Langage de programmation back-end.  
- **Spring Boot** : Framework pour créer des microservices et APIs REST.  
- **Maven** : Gestionnaire de dépendances et build.  
- **MySQL** : Base de données relationnelle.  
- **Angular** : Framework front-end moderne pour construire l’UI.  
- **REST API** : Communication entre front et back.  
- **GraphQL** : Alternative aux REST API pour des requêtes flexibles (en cours d’intégration).  

---

## Installation

### Prérequis
- **Java 8+**  
- **Maven** (ou Maven Wrapper inclus)  
- **Node.js + npm** (pour Angular)  
- **MySQL / XAMPP**  

### Étapes
1. **Cloner le dépôt**  
   ```bash
   git clone https://github.com/HamzaAitahmed/GestionnaireDesTachesV2.git
   cd GestionnaireDesTachesV2
   ```

2. **Configurer la base de données** (voir section [Base de Données](#base-de-données)).  

3. **Back-end (Spring Boot)**  
   ```bash
   cd backend
   mvn clean install
   mvn spring-boot:run
   ```

4. **Front-end (Angular)**  
   ```bash
   cd frontend
   npm install
   ng serve -o
   ```

---

## Base de Données
1. Lancer MySQL avec **XAMPP** ou votre service MySQL préféré.  
2. Créer une base de données nommée `gestionnairedestaches` (ou un autre nom à préciser dans `application.properties`).  
3. Importer le fichier SQL disponible dans :  
   ```plaintext
   backend/gestionnairedestachesservice.sql
   ```

---

## Exécution
- **Back-end** : accessible par défaut sur  
  ```
  http://localhost:8085
  ```
- **Front-end** : accessible par défaut sur  
  ```
  http://localhost:4200
  ```
- **Connexion démo** :  
  - Email : `hamza@gmail.com`  
  - Password : `123`  

---

## Structure du Projet
```plaintext
GestionnaireDesTachesV2/
│
├── backend/                   # Code source Spring Boot
│   ├── src/main/java          # Logique métier, services, contrôleurs
│   ├── src/main/resources     # Fichiers de config + SQL
│   └── pom.xml                # Dépendances backend
│
├── frontend/                  # Code source Angular
│   ├── src/                   # Composants, services, pages
│   └── package.json           # Dépendances frontend
│
├── README.md                  # Documentation
└── .gitignore
```

---

## Contribuer
Les contributions sont les bienvenues 🚀  
1. **Fork** le projet.  
2. Créez une branche :  
   ```bash
   git checkout -b feature/ma-fonctionnalite
   ```
3. Committez vos modifications :  
   ```bash
   git commit -m "Ajout : nouvelle fonctionnalité"
   ```
4. Poussez vos changements :  
   ```bash
   git push origin feature/ma-fonctionnalite
   ```
5. Ouvrez une **Pull Request**.  
