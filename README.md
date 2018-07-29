# final-proxibanque
___________________
Final-proxibanque est un logiciel destiné à la création et au suivi de sondage effectués aupès des clients de Proxibanque. Une partie back permet d'administrer les sondages, la partie front est l'interface destinée aux clients.

## Auteurs
__________
* Kamir Elsisi
* Steven Roman
* Antoine Volatron

## Etat du projet
_________________
Le projet est à la version 1. Le back et le front sont stabilisés.

## Installation rapide
______________________
### La presistence 
1. Lancer votre système de gestion de BDD
2. Installer la base de donnée proxibanque_v4
Pour installer la structure de la base de donnée, importez le fichier : script/proxibanque_v4_structure_only.sql
Pour installer la structure et un jeu de donnée test, importez le fichier : script/proxibanque_v4_testdataAndStructure.sql

### Le back
1. Dézipper le dossier proxinbanque_ERV
2. Copier le back/proxinbanque_ERV.web dans le dossier webapps de votre serveur web
3. Lancer votre serveur web

### Le front
1. Ouvrir une console dans le dossier front
2. Lancer un serveur web (ng serve) pour atteindre l'application en local

