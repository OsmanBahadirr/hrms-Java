package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.StaffVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffVerificationDao extends JpaRepository<StaffVerification,Integer> {
}
