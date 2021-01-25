package entities;

public class Produit {
    private int id;
    private String name;
    private float price;

    public Produit(int id)
    {
        this.id = id;
    }
    public Produit() {
    }
    public Produit(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // getters and setters are not shown for brevity
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produit other = (Produit) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
}
