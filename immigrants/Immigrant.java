package immigrants;

import country.City;

import java.util.ArrayList;
import java.util.Random;

public abstract class Immigrant {
    private boolean isDead = false;
    private int money;
    City city;
    private final ArrayList<Immigrant> relatives = new ArrayList<>();
    private final int id;
    private static int idNum = 1;

    public Immigrant() {
        Random rand = new Random();
        this.money = rand.nextInt(9000) + 100;
        this.id = idNum;
        idNum++;
    }

    private void setCity(City city) {
        this.city = city;
    }

    public City getCity() {
        if (this.city == null) {
            return null;
        } else {
            return this.city;
        }
    }

    public void immigrate(City city) {
        if (!isDead && city != this.city) {  //Checking if he is alive
            if (city.addImmigrant(this)) {  //Check if city allows immigrant to enter
                setCity(city);
                for (Immigrant immigrant : relatives) { //Tells the relatives to immigrate to the same city
                    immigrant.immigrate(city);
                }
            }
        }
    }

    public ArrayList<Immigrant> getRelatives() {
        return relatives;
    }

    public void setRelatives(Immigrant relative) {
        this.relatives.add(relative);
    }

    public int getMoney() {
        return money;
    }

    boolean buy(int price) {
        if (this.money >= price) {
            this.money -= price;
            return true;
        } else {
            return false;
        }
    }

    void die() {
        if (city != null) {
            this.city.removeImmigrant(this);
        }
        this.isDead = true;
    }

    public boolean isDead() {
        return this.isDead;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Id: " + id;
    }
}
