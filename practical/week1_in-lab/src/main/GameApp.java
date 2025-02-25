package main;

//Singleton Pattern - GameState.java
class GameState {
 private static GameState instance;
 private int level;
 private String difficulty;

 private GameState() {
     this.level = 1;
     this.difficulty = "Easy";
 }

 public static GameState getInstance() {
     if (instance == null) {
         instance = new GameState();
     }
     return instance;
 }

 public int getLevel() { return level; }
 public String getDifficulty() { return difficulty; }

 public void nextLevel() {
     level++;
     System.out.println("Advancing to level: " + level);
 }

 public void setDifficulty(String difficulty) {
     this.difficulty = difficulty;
     System.out.println("Difficulty set to: " + difficulty);
 }
}

//Factory Method Pattern - Enemy.java
abstract class Enemy {
 public abstract void attack();
}

class EasyEnemy extends Enemy {
 public void attack() { System.out.println("Easy Enemy attacks weakly!"); }
}

class HardEnemy extends Enemy {
 public void attack() { System.out.println("Hard Enemy attacks fiercely!"); }
}

abstract class EnemyFactory {
 public abstract Enemy createEnemy();
}

class EasyEnemyFactory extends EnemyFactory {
 public Enemy createEnemy() { return new EasyEnemy(); }
}

class HardEnemyFactory extends EnemyFactory {
 public Enemy createEnemy() { return new HardEnemy(); }
}

//Abstract Factory Pattern - Weapon and PowerUp
interface Weapon {
 void use();
}

interface PowerUp {
 void activate();
}

class EasyWeapon implements Weapon {
 public void use() { System.out.println("Using a simple sword!"); }
}

class HardWeapon implements Weapon {
 public void use() { System.out.println("Using a powerful laser gun!"); }
}

class EasyPowerUp implements PowerUp {
 public void activate() { System.out.println("Health restored slightly!"); }
}

class HardPowerUp implements PowerUp {
 public void activate() { System.out.println("Double damage activated!"); }
}

interface GameItemFactory {
 Weapon createWeapon();
 PowerUp createPowerUp();
}

class EasyGameItemFactory implements GameItemFactory {
 public Weapon createWeapon() { return new EasyWeapon(); }
 public PowerUp createPowerUp() { return new EasyPowerUp(); }
}

class HardGameItemFactory implements GameItemFactory {
 public Weapon createWeapon() { return new HardWeapon(); }
 public PowerUp createPowerUp() { return new HardPowerUp(); }
}

//Main Game Application
public class GameApp {
 public static void main(String[] args) {
     GameState gameState = GameState.getInstance();
     System.out.println("Game started at level: " + gameState.getLevel());

     // Set difficulty
     gameState.setDifficulty("Hard");

     // Enemy Creation
     EnemyFactory enemyFactory = gameState.getDifficulty().equals("Hard") ?
             new HardEnemyFactory() : new EasyEnemyFactory();
     Enemy enemy = enemyFactory.createEnemy();
     enemy.attack();

     // Weapon and PowerUp Creation
     GameItemFactory itemFactory = gameState.getDifficulty().equals("Hard") ?
             new HardGameItemFactory() : new EasyGameItemFactory();
     Weapon weapon = itemFactory.createWeapon();
     PowerUp powerUp = itemFactory.createPowerUp();

     weapon.use();
     powerUp.activate();

     // Advance Level
     gameState.nextLevel();
 }
}

