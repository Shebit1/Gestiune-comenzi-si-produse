import jakarta.persistence.*;

public class TestGenerareSchemaSql {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProduseJPA");
        EntityManager em = emf.createEntityManager();
    }
}
