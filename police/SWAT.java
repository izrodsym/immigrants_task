package police;

import immigrants.Immigrant;
import java.util.Random;

public class SWAT extends PoliceOfficer{
    public SWAT(){
        super();
    }
    @Override
    public boolean checkImmigrant(Immigrant immigrant) {
        Random rand = new Random();
        return rand.nextInt(100) > 90; //90% chance to catch the immigrant
    }
}
