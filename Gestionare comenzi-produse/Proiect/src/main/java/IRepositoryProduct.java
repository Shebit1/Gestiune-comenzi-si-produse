import java.util.List;

public interface IRepositoryProduct {
    void addProduct(Product product);
    Product getProductById(Integer id);
    List<Product> getAllProducts();
    void deleteProduct(Product product);
}
