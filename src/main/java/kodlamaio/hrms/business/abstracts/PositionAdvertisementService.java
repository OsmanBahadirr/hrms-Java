package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.PositionAdvertisement;

import java.util.List;

public interface PositionAdvertisementService {
    DataResult<List<PositionAdvertisement>> ListAll();
    Result create(PositionAdvertisement positionAdvertisement);

}