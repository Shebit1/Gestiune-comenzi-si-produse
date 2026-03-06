import jakarta.persistence.*;
import java.util.List;
// Subclasă: Angajat
@Entity
public class Employee extends Person {
    private String position;
    private Double salary;

    // Getteri și setteri
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}