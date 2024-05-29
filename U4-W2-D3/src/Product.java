import java.text.DecimalFormat;
import java.util.Random;

public class Product {
    private Long id;
    private String name;
    private String category;
    private Double price;

    public Product(String name, String category){
        Random randomID = new Random();
        Random randomPrice = new Random();
        DecimalFormat decimalFormat = new DecimalFormat("###,##");

        this.id = randomID.nextLong();
        this.name = name;
        this.category = category;
        double v = 10 + (randomPrice.nextDouble() * (10 - 100));
        this.price = Double.parseDouble(decimalFormat.format(v));
    }
    public Product (String name, String category, double price) {
        Random randomID = new Random();
        this.id = randomID.nextLong();
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

   @Override
   public String toString() {
       return "Product{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", category='" + category + '\'' +
               ", price=" + price + "€" +
               '}';
   }
}
