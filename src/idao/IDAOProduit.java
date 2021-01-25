package idao;
import java.util.List;

import entities.*;

public interface IDAOProduit {

    List<Produit> listAll();

    Produit get(int id) ;

    int add(Produit product) ;

    boolean delete(int id);

    boolean update(Produit product) ;


}
