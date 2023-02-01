package immigrants;

import country.City;

import java.util.ArrayList;

public class RegularImmigrant extends Immigrant implements IHavePassport{
    private final Passport passport;

    public RegularImmigrant(){
        super();
        passport = new Passport();
    }

    @Override
    public Passport getPassport() {
        return passport;
    }

    @Override
    public void setRelatives(Immigrant relative) {
        ArrayList<Immigrant> relatives = this.getRelatives();
        if (relatives.size() < 10){
            super.setRelatives(relative);
        }
    }
}
