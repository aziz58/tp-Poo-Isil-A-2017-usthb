# tp-Poo-Isil-A-2017-usthb
Dans ce projet, on s’intéresse aux villes algériennes. Une ville est caractérisée par un nom, une wilaya, une superficie, le nombre de ses habitants, son type (agricole, touristique, industrielle, ordinaire) supposé unique, un paramètre définissant son classement par rapport aux nombres de fleurs 4 fleurs (très fleurie, 3 fleurs (bien fleurie), 2 fleurs (assez fleurie), 1 fleurs (peu fleurie), 0 fleur (pas du tout fleurie).
Une route peut lier une ville A à une ville B. Cette liaison n’est pas symétrique, on parle de liaison orientée. Chaque ville comporte la liste des villes (tableau statique) qui lui sont directement liées.  On suppose, dans la première partie du projet, qu’une telle liste est figée et connue à la création de la ville. Dans la première partie du projet, on suppose que les liaisons entre les villes forment un graphe acyclique (sans boucle). 
1. Implémenter la classe ville. Rajouter  un constructeur.  On suppose que les villes sont numérotées de manière automatique. 
2. Rajouter les setteurs et guetteurs nécessaires.
3. Rajouter  une méthode  couleur affiche  qui affiche les informations de la ville en lui attribuant une couleur selon les règles suivantes 
- La couleur rouge est attribuée à une ville si son  type est ordinaire et  peu ou n’est pas fleurie,
- La couleur orange est attribuée à une ville si son type est ordinaire et fleurie ou  n’est pas ordinaire  mais  peu ou pas fleurie ,
     - La couleur verte  est attribuée aux cas restants .
4. Ecrire une méthode booléenne qui vérifie si la  ville courante ne mène directement à aucune autre ville. 
5. Ecrire une méthode booléenne qui vérifie si   la  ville courante mène à exactement 3 villes d’une manière directe.
6.  Ecrire une méthode qui vérifie  si toutes les villes voisines directes sont de types différents. 
7.   Ecrire une méthode qui vérifie  si la ville courante est plus fleurie que ses villes voisines (directes). 

8.  Ecrire une méthode qui vérifie  si la  ville courante est :   verte, a un type non ordinaire et  n’est entourée que par des villes rouges. 
9. (*)  Etant donné un  ensemble de villes v1…vn,  écrire une méthode  qui vérifie si le chemin partant de la ville v1 passant directement  par les villes v2, …, vn-1,,et se terminant par la ville   vn     est réalisable.  
10.  (**) Ecrire une méthode qui vérifie  s’il existe un chemin entre  la  ville courante  et une autre ville donnée. 
11. Ecrire une classe Application qui comporte une méthode main. Ecrire une  méthode qui cherche une ville donnée par son nom (le nom est unique). Une autre méthode qui modifie les informations d’une ville, une dernière qui supprime une ville. 
12. (**)Ecrire une méthode qui permet d’afficher le réseau routier des villes. 
13.  Une méthode qui affiche la liste  des villes vertes, celle des oranges et celle des rouges. 
14. (***) Reprendre les questions de 11 à 14 en supposant que les voisins d’une ville peuvent  changer ( tableau dynamique : ArrayList) et le graphe des liaisons peut comporter des cycles. 
15. (****) Partitionner  les villes de telle sorte que chaque partition  contienne des villes fortement liées (composantes fortement connexes).  
 

Remarque :
1. Le concept d’encapsulation doit être respecté.
2. Le code doit être lisible et bien commenté.
3. Le degré de difficulté des questions est donné par le nombre d’étoiles.
4. Il est souhaitable de traiter le projet en binôme 
5. Le projet doit remis au plus tard le 14 mars 2017
6. Les projets de chaque groupe doivent être regroupés dans un seul CD 
