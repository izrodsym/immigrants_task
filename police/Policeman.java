package police;

import immigrants.IHavePassport;
import immigrants.Immigrant;
import immigrants.RadicalImmigrant;
import weapons.Bomb;
import weapons.Weapon;

import java.util.ArrayList;
import java.util.Random;

public class Policeman extends PoliceOfficer {
    public Policeman() {
        super();
    }

    @Override
    public boolean checkImmigrant(Immigrant immigrant) {
        if (immigrant instanceof IHavePassport) {
            return true;    //every regular immigrant can enter the city
        } else {
            ArrayList<Weapon> immigrantWeapons = ((RadicalImmigrant) immigrant).showWeapons();
            for (Weapon weapon : immigrantWeapons) {
                if (weapon instanceof Bomb) {
                    return true;    //every extreme immigrant with a bomb can enter the city
                }
            }
        }

        Random rand = new Random();
        return rand.nextInt(100) > 50;   //50% chance to catch the immigrant
    }
}
