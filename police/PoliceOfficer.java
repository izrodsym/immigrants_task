package police;

import country.City;
import immigrants.Immigrant;

import java.util.Random;

public abstract class PoliceOfficer {
//    enum Type{POLICEMAN, SWAT}

    private City city;
    private final String name;

    public PoliceOfficer() {
        Random rand = new Random();
        String[] names = {"Abdul", "Ivan", "Jon", "Brittney", "Chris", "Alli", "Pavel", "Muller", "Johan", "Dave", "Samanta", "Robert"};
        this.name = names[rand.nextInt(names.length)];
    }

    //check if immigrant can enter the city
    public abstract boolean checkImmigrant(Immigrant immigrant);

    public void setCity(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public String getName() {
        return name;
    }
}
