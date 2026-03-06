import jakarta.persistence.*;
import java.util.*;
import lombok.*;

public class RepositoryProduct implements IRepositoryProduct {

    private EntityManager entityManager;

    public RepositoryProduct(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void addProduct(Product product) {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }
    public Product getProductById(Integer id) {
        return entityManager.find(Product.class, id);
    }
    public List<Product> getAllProducts() {
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }
    public void deleteProduct(Product product) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(product) ? product : entityManager.merge(product));
        entityManager.getTransaction().commit();
    }
}