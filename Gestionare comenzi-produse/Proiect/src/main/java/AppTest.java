import jakarta.persistence.*;
import java.util.*;
import lombok.*;

public class AppTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProduseJPA");
        EntityManager em = emf.createEntityManager();

        RepositoryProduct rp = new RepositoryProduct(em);

        Category category = new Category();
        category.setName("Electronics");
        em.persist(category);

        // Crearea și persistarea unui produs
        Product product1 = new Product();
        product1.setName("Laptop");
        product1.setPrice(1200.0);
        product1.setCategory(category);
        em.persist(product1);

        Product product2 = new Product();
        product2.setName("Smartphone");
        product2.setPrice(800.0);
        product2.setCategory(category);
        em.persist(product2);

        // Crearea și persistarea unui client
        Customer customer = new Customer();
        customer.setName("John Doe");
        customer.setEmail("johndoe@example.com");
        customer.setAddress("123 Main Street");
        customer.setPhoneNumber("123-456-7890");
        em.persist(customer);

        // Crearea și persistarea unei comenzi
        Order order = new Order();
        order.setStatus("Pending");
        order.setCustomer(customer);
        order.setProducts(Arrays.asList(product1, product2));
        em.persist(order);

        // Crearea și persistarea unei facturi
        Invoice invoice = new Invoice();
        invoice.setTotalAmount(2000.0);
        invoice.setOrder(order);
        em.persist(invoice);

        // Crearea și persistarea unei plăți
        Payment payment = new Payment();
        payment.setMethod("Credit Card");
        payment.setAmount(2000.0);
        payment.setInvoice(invoice);
        em.persist(payment);

        // Persistarea unui angajat
        Employee employee = new Employee();
        employee.setName("Jane Smith");
        employee.setEmail("janesmith@example.com");
        employee.setPosition("Manager");
        employee.setSalary(5000.0);
        em.persist(employee);

        System.out.println("Datele au fost inserate cu succes în baza de date!");

    }
}
