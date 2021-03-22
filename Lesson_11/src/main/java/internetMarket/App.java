package internetMarket;

import internetMarket.dao.OrderDAOImpl;
import internetMarket.dao.ProductDAOImpl;
import internetMarket.dao.UserDAOImpl;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        ProductDAOImpl product = new ProductDAOImpl();
        UserDAOImpl user = new UserDAOImpl();
        OrderDAOImpl order = new OrderDAOImpl();

//        додавання нових продуктів
//        Product newProduct = new Product(7, "Sony", "Music", BigDecimal.valueOf(555.00).setScale(2));
//        product.create(newProduct);
//        Product newProduct2 = new Product(8, "Samsung", "Music", BigDecimal.valueOf(166.00).setScale(2));
//        product.create(newProduct2);
//        Product newProduct3 = new Product(9, "Kivi", "Music", BigDecimal.valueOf(10.00).setScale(2));
//        product.create(newProduct3);

        // оновлення даних продукту по ID
//        Product updatedProduct = new Product(1, "SamSung TV", "TV", BigDecimal.valueOf(10500.00).setScale(2));
//        product.update(updatedProduct);

        System.out.println("Результат пошуку по id продукта: " + "\n" + product.findById(2) + "\n");
        System.out.println("Повний список продуктів в базі: " + "\n" + product.findAll() + "\n");

        // видалення продукту по ID
//        product.deleteById(3);

        // додавання нових клієнтів
//        User user1 = new User(1, "Evgen", "Dnepr", "evgewn@gmail.com", "male", LocalDate.of(1981, 02, 06));
//        user.create(user1);
//        User user2 = new User(2, "Alla", "Kiev", "ewn@gmail.com", "female", LocalDate.of(1977, 11, 15));
//        user.create(user2);
//        User user3 = new User(3, "Kat", "Odessa", "vgewn@gmail.com", "female", LocalDate.of(2004, 02, 03));
//        user.create(user3);
//        User user4 = new User(4, "ererere", "Odessa", "vgewn@gmail.com", "female", LocalDate.of(2004, 02, 03));
//        user.create(user4);

        // оновлення даних клієнта по ID
//        User updatedUserInTable = new User(1, "Evgen", "New York", "evgewn@gmail.com", "male", LocalDate.of(1981, 02, 06));
//        user.update(updatedUserInTable);

        // видалення клієнта по ID
//        user.deleteById(4);

        System.out.println("Результат пошуку по id клієнта: " + "\n" + user.findById(2) + "\n");
        System.out.println("Повний список клієнтів в базі: " + "\n" + user.findAll() + "\n");
        System.out.println("Результат пошуку по email: " + "\n" + user.findByEmail("ewn@gmail.com") + "\n");
        System.out.println("Результат пошуку по даті народження: " + "\n"
                + user.findByDateOfBirth(LocalDate.of(2004, 2, 3)) + "\n");


        // додавання нових клієнтів
//        Order order1 = new Order(1, 4, 2, "в работе", LocalDate.now());
//        order.createOrder(order1);
//        Order order2 = new Order(2, 1, 1, "в работе", LocalDate.now());
//        order.createOrder(order2);
//        Order order3 = new Order(3, 2, 100, "оплачено", LocalDate.now());
//        order.createOrder(order3);
//        Order order4 = new Order(2, 1, 1, "доставка", LocalDate.now());
//        order.createOrder(order4);

        // оновлення даних замовлення по ID
//        Order updatedOrderInTable = new Order(1, 4, 200, "продан", LocalDate.now());
//        order.updateOrder(updatedOrderInTable);

        //пошук замовлень по user_id
        System.out.println("Результат пошуку по id клієнта: " + "\n" + order.findByUserId(1) + "\n");

        //пошук замовлень по user_id та статусу замовлення
        System.out.println("Результат пошуку по id клієнта: " + "\n" + order.findByUserIdAndStatus(1, "продан")+ "\n");
    }
}
