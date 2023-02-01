package immigrants;

import weapons.Bomb;
import weapons.Pistol;
import weapons.Rifle;
import weapons.Weapon;

import java.util.ArrayList;
import java.util.Random;

public abstract class RadicalImmigrant extends Immigrant {
    private final ArrayList<Weapon> weapons = new ArrayList<>();

    public ArrayList<Weapon> showWeapons() {
        return weapons;
    }

    public boolean buyWeaponOrDie(Weapon weapon) {
        if (this.isDead()) {
            return false;
        }

        if (weapon instanceof Bomb && !(this instanceof ExtremeImmigrant)) { //If the weapon is a bomb, only ExtremeImmigrant can buy it
            return false;
        }

        if (this instanceof RadicalImmigrantPass || this instanceof RadicalImmigrantNoPass) { //Radical immigrants can own maximum 5 weapons
            if (weapons.size() > 4) {
                return false;
            }
        }

        if (this.buy(weapon.getPrice())) {   //If the immigrant has enough money, he buys the weapon
            weapons.add(weapon);
            return true;
        } else {
            this.die();
            return false;
        }
    }

    public void terroristAct() {
        if (!this.isDead()) {
            if (this instanceof ExtremeImmigrant) {
                for (Weapon weapon : weapons) {
                    if (weapon instanceof Bomb) {
                        if (this.city != null) {
                            System.out.println("Immigrant Id:" + this.getId() + " explode in " + getCity() + " city.");
                            ArrayList<Immigrant> deadImmigrants = new ArrayList<>(city.getImmigrants());

                            for (Immigrant deadImmigrant : deadImmigrants) {
                                deadImmigrant.die();
                            }
                            this.city.changePopulation(-this.city.getPopulation());
                            this.city.getCountry().removeCity(this.city);
                            this.city.getCountry().addExplodedImmigrant(this);
                            break;
                        }
                    }
                }
            } else {
                Random rand = new Random();
                int bullets = 0;
                int kills;
                for (Weapon weapon : weapons) {
                    if (weapon instanceof Pistol) {
                        bullets += rand.nextInt(5) + 5;
                    } else if (weapon instanceof Rifle) {
                        bullets += rand.nextInt(20) + 10;
                    }
                }

                kills = rand.nextInt((int) (bullets * 0.6) + 1) + (int) (bullets * 0.1);
                if (this.city != null) {
                    if (this.city.getPopulation() > kills) {
                        this.city.changePopulation(-kills);
                        System.out.println("Immigrant Id:" + this.getId() + " kill " + kills + " people in " + city + " city.");
                    } else {
                        this.city.changePopulation(-this.city.getPopulation());
                        System.out.println(this.getId() + "  All citizens are killed in " + city + " city.");
                    }
                }

            }
        }

    }
}
