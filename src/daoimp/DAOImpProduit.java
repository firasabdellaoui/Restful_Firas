package daoimp;
import java.util.ArrayList;
import java.util.List;
import connexion.Factory;
import entities.Produit;
import idao.IDAOProduit;
public class DAOImpProduit implements IDAOProduit {
    List<Produit> data;
    public DAOImpProduit()
    {
        data=Factory.getInstance();
    }
    @Override
    public List<Produit> listAll() {
        return new ArrayList<Produit>(data); }
    @Override
    public Produit get(int id) {
        Produit productToFind = new Produit(id);
        int index = data.indexOf(productToFind);
        if (index >= 0) {
            return data.get(index);
        }
        return null;	}
    @Override
    public int add(Produit product) {
        int newId = data.size() + 1;
        product.setId(newId);
        data.add(product);
        return newId;
    }
    @Override
    public boolean delete(int id) {
        Produit productToFind = new Produit(id);
        int index = data.indexOf(productToFind);
        if (index >= 0) {
            data.remove(index);
            return true;
        }
        return false;	}
    @Override
    public boolean update(Produit product) {
        int index = data.indexOf(product);
        if (index >= 0) {
            data.set(index, product);
            return true;
        }
        return false;
    }}
