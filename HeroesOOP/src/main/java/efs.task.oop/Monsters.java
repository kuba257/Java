package efs.task.oop;

public class Monsters {
    static final Monster andariel = new Monster(10,70) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }

        @Override
        public void takeHit(int damage) {
            andariel.setHealth(getHealth() - damage);
            monstersHealth -= damage;
        }
    };

    static final Monster blacksmith = new Monster(100,25) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }

        @Override
        public void takeHit(int damage) {
            blacksmith.setHealth(getHealth() - (5 + damage));
            monstersHealth -= (5 + damage);
        }
    };

    static int monstersHealth = andariel.getHealth() + blacksmith.getHealth();
}




