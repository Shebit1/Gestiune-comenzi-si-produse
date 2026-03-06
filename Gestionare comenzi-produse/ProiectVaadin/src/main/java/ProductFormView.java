import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.

public class ProductFormView extends VerticalLayout {
    @PersistenceContext
    private EntityManager entityManager;

    public ProductFormView() {
        FormLayout formLayout = new FormLayout();

        TextField nameField = new TextField("Product Name");
        NumberField priceField = new NumberField("Price");
        Button saveButton = new Button("Save");
        Button deleteButton = new Button("Delete");

        formLayout.add(nameField, priceField, saveButton, deleteButton);
        add(formLayout);

        // Save Product
        saveButton.addClickListener(click -> {
            String name = nameField.getValue();
            Double price = priceField.getValue();

            if (name == null || price == null) {
                Notification.show("Please fill out all fields!");
                return;
            }

            saveProduct(name, price);
            Notification.show("Product saved successfully!");
        });

        // Delete Product
        deleteButton.addClickListener(click -> {
            String name = nameField.getValue();
            if (name == null) {
                Notification.show("Enter a product name to delete!");
                return;
            }

            deleteProduct(name);
            Notification.show("Product deleted successfully!");
        });
    }

    @Transactional
    private void saveProduct(String name, Double price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);

        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    @Transactional
    private void deleteProduct(String name) {
        entityManager.getTransaction().begin();
        Product product = entityManager.createQuery("SELECT p FROM Product p WHERE p.name = :name", Product.class)
                .setParameter("name", name)
                .getSingleResult();

        if (product != null) {
            entityManager.remove(product);
        }

        entityManager.getTransaction().commit();
    }
}