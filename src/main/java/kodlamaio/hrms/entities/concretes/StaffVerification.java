package kodlamaio.hrms.entities.concretes;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "staff_verification")
public class StaffVerification{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "is_success")
    private boolean isSuccess;
}
