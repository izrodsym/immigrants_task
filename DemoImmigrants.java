import country.*;
import immigrants.*;
import police.*;
import weapons.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

public class DemoImmigrants {
    public static void main(String[] args) {
        Country country = new Country();
        for (int i = 0; i < 5; i++) {
            country.addCity(new City(country));
        }

        for (City city : country.getCities()) {
            for (int i = 0; i < 10; i++) {
                city.setPoliceOfficers(new Policeman());
                city.setPoliceOfficers(new SWAT());
            }
        }

        Random rand = new Random();
        //create 100 immigrants
        ArrayList<Immigrant> immigrants = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int rand1 = rand.nextInt(100);
            if (rand1 < 25) {
                if (rand.nextInt(100) > 50) {
                    immigrants.add(new RadicalImmigrantNoPass());
                } else {
                    immigrants.add(new RadicalImmigrantPass());
                }
            } else if (rand1 < 60) {
                immigrants.add(new ExtremeImmigrant());
            } else {
                immigrants.add(new RegularImmigrant());
            }
        }

        //Set 2 relatives for every immigrant
        int relativesNumber = 2;
        for (Immigrant immigrant : immigrants) {
            for (int i = 0; i < relativesNumber; i++) {
                if (immigrant.getRelatives().size() < relativesNumber) {
                    Immigrant relative = immigrants.get(rand.nextInt(immigrants.size()));
                    immigrant.setRelatives(relative);
                    if (relative.getRelatives().size() < relativesNumber) {
                        relative.setRelatives(immigrant);
                    }
                }
            }
        }

        //Create 200 weapons
        ArrayList<Weapon> weapons = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            int rand1 = rand.nextInt(100);
            if (rand1 < 33) {
                weapons.add(new Pistol());
            } else if (rand1 < 66) {
                weapons.add(new Rifle());
            } else {
                weapons.add(new Bomb());
            }
        }

        //every RadicalImmigrant try to buy 5 weapons
        for (Immigrant immigrant : immigrants) {
            if (immigrant instanceof RadicalImmigrant) {  //only RadicalImmigrants can buy weapons
                for (int i = 0; i < 5; i++) {
                    //buy random weapon from weapon array
                    if (weapons.size() > 0) {     //check if there is weapons for sale
                        Weapon weaponToBuy = weapons.get(rand.nextInt(weapons.size()));
                        if (((RadicalImmigrant) immigrant).buyWeaponOrDie(weaponToBuy)) {    //If immigrant is able to buy weapon, remove weapon from array
                            weapons.remove(weaponToBuy);
                        }
                    }
                }
            }
        }

        //immigrate every immigrant
        for (Immigrant immigrant : immigrants) {
            immigrant.immigrate(country.getCities().get(rand.nextInt(country.getCities().size()))); //immigrant immigrate in random city in country
        }

        //report status of every immigrant
        for (Immigrant immigrant : immigrants) {
            String passport;
            if (immigrant instanceof IHavePassport) {
                passport = "have a passport";
            } else {
                passport = "don't have a passport";
            }
            if (immigrant.isDead()) {
                System.out.println("Immigrant " + immigrant.getId() + " is dead.");
            } else {
                System.out.print("Immigrant " + immigrant.getId() + " in city: " + immigrant.getCity() + " " + passport + " with " + immigrant.getMoney() + " euro. Have relatives:");
                for (Immigrant relative : immigrant.getRelatives()) {
                    System.out.print(" " + relative.getId());
                }
                System.out.println();
            }
        }
        System.out.println();

        //Get 20 immigrants to commit terrorist act
        int shootingImmigrants = 0;
        while (shootingImmigrants < 20) {
            Immigrant shooter = immigrants.get(rand.nextInt(immigrants.size()));
            if (shooter instanceof RadicalImmigrant) {
                ((RadicalImmigrant) shooter).terroristAct();
                shootingImmigrants++;
            }
        }

        //print rest cities
        TreeMap<Integer, City> restCities = new TreeMap<>();
        for (City city : country.getCities()) {
            restCities.put(city.getPopulation(), city);
        }
        System.out.println();
        System.out.println("Cities survived the attacks:");
        System.out.println(restCities);

        //print rest immigrants
        TreeMap<Integer, Immigrant> restImmigrants = new TreeMap<>();
        for (Immigrant immigrant : immigrants) {
            if (!immigrant.isDead()) {
                restImmigrants.put(immigrant.getMoney(), immigrant);
            }
        }
        System.out.println();
        System.out.println("Survived immigrants:");
        System.out.println(restImmigrants);
        System.out.println();
        System.out.println("Exploded immigrants:");
        System.out.println(country.getExplodedImmigrants());


    }
}
