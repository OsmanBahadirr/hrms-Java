package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.PositionAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionAdvertisementDao extends JpaRepository<PositionAdvertisement,Integer> {
}
