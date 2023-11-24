package kodlamaio.hrms.business.concretes;


import kodlamaio.hrms.business.abstracts.PositionAdvertisementService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PositionAdvertisementDao;
import kodlamaio.hrms.entities.concretes.PositionAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionAdvertisementManager implements PositionAdvertisementService {

    private PositionAdvertisementDao positionAdvertisementDao;

    @Autowired
    public PositionAdvertisementManager(PositionAdvertisementDao positionAdvertisementDao) {
        this.positionAdvertisementDao = positionAdvertisementDao;
    }

    @Override
    public DataResult<List<PositionAdvertisement>> ListAll() {
        return new SuccessDataResult<>(positionAdvertisementDao.findAll());
    }

    @Override
    public Result create(PositionAdvertisement positionAdvertisement) {
        positionAdvertisementDao.save(positionAdvertisement);
        return new SuccessResult();
    }
}
