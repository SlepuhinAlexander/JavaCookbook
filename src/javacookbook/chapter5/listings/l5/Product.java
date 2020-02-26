package javacookbook.chapter5.listings.l5;

public class Product implements Comparable<Product> {
    private String name;
    private int ID;

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public Product(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    @Override
    public int compareTo(Product product) {
        return name.compareToIgnoreCase(product.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        return name.compareToIgnoreCase(((Product) obj).name) == 0;
    }
}
