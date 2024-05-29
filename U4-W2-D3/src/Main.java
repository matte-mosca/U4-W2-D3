import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("One hundred years of solitude", "book");
        Product product2 = new Product("Soccer ball", "boys");
        Product product3 = new Product("T-shirt", "baby");
        Product product4 = new Product("Notes from the underground", "book");
        Product product5 = new Product("Baby bottle", "baby");
        Product product6 = new Product("Shorts", "boys");
        Product product7 = new Product("Doors of perception", "book");
        Product product8 = new Product("Sunglasses", "boys");
        Product product9 = new Product("Carrillon", "baby");

        List<Product> ProductsList = new ArrayList<>();
        ProductsList.add(product1);
        ProductsList.add(product2);
        ProductsList.add(product3);
        ProductsList.add(product4);
        ProductsList.add(product5);
        ProductsList.add(product6);
        ProductsList.add(product7);
        ProductsList.add(product8);
        ProductsList.add(product9);

        // Esercizio 1

        List<Product> BooksList = ProductsList.stream().filter(product -> product.getCategory().equals("book") && product.getPrice() >100).toList();
        if (!BooksList.isEmpty()){
            System.out.println("Books that cost more than 100: " +BooksList);
        } else System.out.println("There are no books");

        System.out.println(ProductsList);

        // Esercizio 2

        Customer customer1 = new Customer("Paolo", 1);
        Customer customer2 = new Customer("Simone", 2);
        Customer customer3 = new Customer("Giorgia", 1);
        Customer customer4 = new Customer("Michela", 3);
        Customer customer5 = new Customer("Ettore", 4);

        Order order1 = new Order("Delay",customer1);
        Order order2 = new Order("Failed",customer1);
        Order order3 = new Order("Delay",customer2);
        Order order4 = new Order("Success",customer3);
        Order order5 = new Order("Delay",customer4);
        Order order6 = new Order("Success",customer5);
        Order order7 = new Order("Failed",customer3);
        Order order8 = new Order("Failed",customer5);

        order1.getProducts().add(product4);
        order1.getProducts().add(product1);
        order1.getProducts().add(product3);
        order2.getProducts().add(product2);
        order3.getProducts().add(product2);
        order4.getProducts().add(product6);
        order5.getProducts().add(product9);
        order6.getProducts().add(product8);
        order6.getProducts().add(product9);
        order7.getProducts().add(product6);
        order8.getProducts().add(product1);
        order8.getProducts().add(product3);
        order7.getProducts().add(product4);

        List<Order> OrderList = new ArrayList<>();
        OrderList.add(order1);
        OrderList.add(order2);
        OrderList.add(order3);
        OrderList.add(order4);
        OrderList.add(order5);
        OrderList.add(order6);
        OrderList.add(order7);
        OrderList.add(order8);

        OrderList.stream().filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory().equals("baby"))).toList();

        List<Order> babyList = OrderList.stream().filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory().equals("baby"))).toList();

        System.out.println("Baby's category orders: " +babyList);
        System.out.println("There are "+babyList.size()+ " orders");


        // Esercizio 3

        List <Product> boysList = ProductsList.stream().filter(product -> product.getCategory().equals("boys")).map(product -> new Product(product.getName(), product.getCategory(), product.getPrice() * 0.9)).collect(Collectors.toList());
        System.out.println("Boys' products are on 10% sale. Here's the list: " +boysList);

        //Esercizio 4

        LocalDate startDate = LocalDate.of(2021, 2, 1);
        LocalDate endDate = LocalDate.of(2021, 4,1);

        List<Product> Tier2Orders = OrderList.stream()
                .filter(order -> Objects.equals(order.getCustomer().getTier(), 2))
                .filter(order -> order.getOrderDate().isAfter(startDate)&& order.getOrderDate().isBefore(endDate))
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toList());

        System.out.println("Orders from Tier 2: " +Tier2Orders);
    }




}