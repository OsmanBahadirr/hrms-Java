package kodlamaio.hrms.entities.concretes;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "job_seekers")
public class JobSeeker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "national_id")
    private String nationalId;
    @Column(name = "birth_year")
    private String birtyYear;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "password_verf")
    private String passwordVerification;
    @Column(name = "staff_verification_id")
    private int staffVerificationId;
    @Column(name = "email_verification_id")
    private int emailVerificationId;
}

