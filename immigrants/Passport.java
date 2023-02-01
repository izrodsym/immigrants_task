package immigrants;

import java.util.Random;

public class Passport {
    private final String name;
    private final int age;
    private final String countryOfOrigin;

    public Passport(){
        Random rand = new Random();
        String []names = {"Mohamed", "Hasan", "Mehmed", "Aishe", "Erdogan", "Farida", "Fatima", "Habib", "Jasim", "Kalila"};
        String []countriesOfOrigin = {"Afghanistan","Pakistan","Syria","Iran","Iraq"};

        this.name = names[rand.nextInt(names.length)];
        age = rand.nextInt(100);
        countryOfOrigin = countriesOfOrigin[rand.nextInt(countriesOfOrigin.length)];
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
