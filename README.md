# LemmingsLight
_Version light du jeux Lemmings implémenté avec l'architecture MVC_ 
## Instruction pour compiler et excuter le jeux
- Se placer dans le repertoire du projet juste avant le dossier src puis copier la commande suivante: 

```sh 
javac -d bin /lemmingsLight/*.java /lemmingsLight/model/*.java /lemmingsLight/model/element/*.java /lemmingsLight/view/*.java /lemmingsLight/controller/MyMouse.java /lemmingsLight/state/*.java 
```

pour executer:

```sh
java -cp bin lemmingsLight.App
```

## Fonctionnement du jeux, pour affecter un état à un Lemmings

- Le but du jeux est de faire sortir un maximum de Lemmings pour gagner des points, la mort d'un lemmings n'entraine pas de perte de point, la partie se termine une fois qu'il ne reste plus aucun lemmings sur le plateau
- On sélectionne un état avec les boutons du panneau de contrôle ensuite on sélectionne un Lemmings et on lui affecte son état.
- Attention pour que certain état fonctionne il faut que le lemmings soit en dessous d'un bloc qu'il peut creuser ou devant un bloc qu'il peut miner.

## Description du plateau
- les blocs indestructible sont de couleur noir
- les blocs destructible sont de couleur marron (un peu comme la terre qu'on peut creuser et miner)
- le bloc special faisant apparaitre d'autre bloc à sa creation est de couleur rose pale
- les entrées sont de couleur bleu
- les sorties sont de couleur magenta
- les téléporteurs sont de couleur cyan
