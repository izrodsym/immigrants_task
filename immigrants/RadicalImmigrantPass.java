package immigrants;

import country.City;

public class RadicalImmigrantPass extends RadicalImmigrant implements IHavePassport{
    private final Passport passport;

    public RadicalImmigrantPass(){
        super();
        passport = new Passport();
    }

    @Override
    public Passport getPassport() {
        return passport;
    }

}
