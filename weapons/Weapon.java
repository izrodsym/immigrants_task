package weapons;

import java.util.Random;

public abstract class Weapon {
    private final int price;
    public Weapon(){
        Random rand = new Random();
        price = rand.nextInt(1000)+200;
    }
    public int getPrice() {
        return price;
    }
}
