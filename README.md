# final-proxibanque
Final-proxibanque est un logiciel destiné à la création et au suivi de sondages effectués auprès des clients de Proxibanque. 
La partie back permet d'administrer les sondages, la partie front est l'interface destinée aux clients.

## Auteurs
* Kamir Elsisi
* Steven Roman
* Antoine Volatron

## Etat du projet
Le projet est à la version 1. Le back et le front sont stabilisés.

## Installation rapide
### La presistence 
Installer la base de donnée "proxibanque_v4"
* Pour installer la structure de la base de donnée, importez le fichier : script/proxibanque_v4_structure_only.sql
* Pour installer la structure et un jeu de donnée test, importez le fichier : script/proxibanque_v4_testdataAndStructure.sql

### Le back
1. Dézipper le dossier proxibanque_ERV
2. Copier le back/proxibanque_ERV.war dans votre serveur web
3. Lancer votre serveur web
4. Lancer un navigateur et entrez l'url: 'http://localhost:8080/proxibanque_ERV/'

### Le front
1. Ouvrir une console dans le dossier front
2. Entrer dans la console 'npm install'
3. Entrer dans la console 'npm install -g @angular/cli'
4. Lancer un serveur web (ng serve --open) pour atteindre l'application en local
3. Cas d'utilisation a utiliser pour le test : Numéro d'identification: 16589354


## Documentation

La documentation de la partie JEE (back) se trouve dans le dossier doc/. Pour la parcourir, ouvrir le document index.html dans votre navigateur web
