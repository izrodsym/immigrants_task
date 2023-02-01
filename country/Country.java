package country;

import immigrants.Immigrant;

import java.util.ArrayList;
import java.util.Random;

public class Country {
    private final String name;
    ArrayList<City> cities = new ArrayList<>();
    ArrayList<Immigrant> explodedImmigrants = new ArrayList<>();

    public Country() {
        Random rand = new Random();
        String[] names = {"Bulgaria", "France", "Albania", "Turkey", "Italy", "Germany", "Portugal"};
        name = names[rand.nextInt(names.length)];
    }

    public ArrayList<City> getCities() {
        return cities;
    }
    public void addCity(City city){
        this.cities.add(city);
    }
    public void removeCity(City city){
        this.cities.remove(city);
    }

    public void addExplodedImmigrant(Immigrant immigrant){
        explodedImmigrants.add(immigrant);
    }

    public ArrayList<Immigrant> getExplodedImmigrants() {
        return explodedImmigrants;
    }

    @Override
    public String toString() {
        return name;
    }
}
