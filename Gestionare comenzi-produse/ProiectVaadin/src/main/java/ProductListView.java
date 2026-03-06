
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import com.vaadin.pro.licensechecker.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;


public class ProductListView extends VerticalLayout {
    @PersistenceContext
    private EntityManager entityManager;

    public ProductListView() {
        setSizeFull();
        Grid<Product> productGrid = new Grid<>(Product.class);
        productGrid.setColumns("id", "name", "price");

        // Load products from database
        List<Product> products = entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        productGrid.setItems(products);

        add(productGrid);
    }
}