package country;

import immigrants.Immigrant;
import immigrants.RegularImmigrant;
import police.PoliceOfficer;
import police.Policeman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class City {
    private final Country country;
    private final static ArrayList<String> namesArray = new ArrayList<>(Arrays.asList("Sofia", "Ruse", "Istanbul", "Vienna", "Athens", "Zagreb", "Paris", "London", "Lisbon", "Rome", "Berlin", "Munich"));
    private final String name;

    private final ArrayList<PoliceOfficer> policeOfficers = new ArrayList<>();
    private final ArrayList<PoliceOfficer> regularPolice = new ArrayList<>();
    private int population;
    private final ArrayList<Immigrant> immigrants = new ArrayList<>();

    public City(Country country) {
        Random rand = new Random();
        this.country = country;
        name = randomName();
        population = rand.nextInt(10000) + 1000;
    }
    // constructor with name
    public City(Country country, String name) {
        this.country = country;
        this.name = name;
        this.population = 0;
    }

    public int getPopulation() {
        return population;
    }

    public ArrayList<Immigrant> getImmigrants() {
        return immigrants;
    }

    public void setPoliceOfficers(PoliceOfficer policeOfficer) {
        this.policeOfficers.add(policeOfficer);
        if (policeOfficer instanceof Policeman) {
            this.regularPolice.add(policeOfficer);
        }
    }

    public void changePopulation(int population) {
        this.population += population;
    }

    public boolean addImmigrant(Immigrant immigrant) {
        Random rand = new Random();
        if (policeOfficers.size() == 0) {
            return false;
        }
        PoliceOfficer police = policeOfficers.get(rand.nextInt(policeOfficers.size()));
        if (immigrant instanceof RegularImmigrant) {
            if (regularPolice.size() == 0) {
                return false;
            }
            police = regularPolice.get(rand.nextInt(regularPolice.size()));
        }
        if (police.checkImmigrant(immigrant)) {
            City oldCity;
            if (immigrant.getCity() != null) {
                oldCity = immigrant.getCity();
                oldCity.removeImmigrant(immigrant);
            }
            immigrants.add(immigrant);
            changePopulation(1);
            return true;
        }


        return false;
    }

    public void removeImmigrant(Immigrant immigrant) {
        immigrants.remove(immigrant);
        changePopulation(-1);
    }
    //choose random name from array of names and remove it from the array
    private String randomName(){
        if (namesArray.size()>0){

            Random rand = new Random();
            int index = rand.nextInt(namesArray.size());
            String toReturn = namesArray.get(index);
            namesArray.remove(index);

            return toReturn;
        }else {
            return "No free names";
        }
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
