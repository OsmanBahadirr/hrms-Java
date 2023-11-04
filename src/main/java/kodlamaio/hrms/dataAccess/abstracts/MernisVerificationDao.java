package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.EmailVerification;
import kodlamaio.hrms.entities.concretes.MernisVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MernisVerificationDao extends JpaRepository<MernisVerification,Integer> {
}
