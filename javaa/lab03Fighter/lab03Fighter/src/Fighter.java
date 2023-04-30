public class Fighter {
    private String name;
    private int health;
    private int damage;

    public Fighter(String name) {
        this.name=name;
        this.setHealth(100);
        this.setDamage(10);
    }

    public Fighter(String name, int damage) {
        this.setHealth(100);
        this.name=name;
        this.damage=damage;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
        }
        this.health = health;
    }


    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (damage < 0) {
            this.damage = 0;
        }
        this.damage = damage;
    }

    int attack(Fighter enemy) {
         enemy.setHealth(enemy.getHealth()-this.getDamage());
         return enemy.getHealth();

    }
    public String toString(){
        return " \nName:" + this.name
                + "\n Health: " +this.health
                + "\n Damage: " +this.damage;
    }
}

