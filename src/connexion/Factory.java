package connexion;

import java.util.ArrayList;
import java.util.List;

import entities.Produit;

public class Factory {

    public static List<Produit> data = new ArrayList<>();

    static {
        data.add(new Produit(1, "iPhone X", 999.99f));
        data.add(new Produit(2, "XBOX 360", 329.50f));
    }



    public static List<Produit> getInstance() {

        return data;
    }

}
