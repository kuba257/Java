package efs.task.oop;

public class Villager implements Fighter {
    String name;
    int age;
    int health = 100;

    public Villager(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Greetings traveler... I'm " + name + " and I'm " + age + " years old");
    }

    private int getDamage() {
        return (int) ((100 - age * 0.5) / 10);
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    @Override
    public void attack(Fighter victim) {
        victim.takeHit(this.getDamage());
    }

    @Override
    public void takeHit(int damage) {
        health -= damage;
    }
}
