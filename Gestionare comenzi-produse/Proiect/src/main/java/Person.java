import jakarta.persistence.*;
import java.util.List;
import lombok.*;


// Superclasă pentru moștenire



@Entity
@Data @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor @RequiredArgsConstructor
public abstract class Person {
    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @NonNull private String name;
    @NonNull private String email;
}