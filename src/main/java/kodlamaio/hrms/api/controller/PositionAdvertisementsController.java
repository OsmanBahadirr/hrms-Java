package kodlamaio.hrms.api.controller;


import kodlamaio.hrms.business.abstracts.PositionAdvertisementService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.PositionAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/positionAdvertisements")
public class PositionAdvertisementsController {
    private PositionAdvertisementService positionAdvertisementService;

    @Autowired
    public PositionAdvertisementsController(PositionAdvertisementService positionAdvertisementService) {
        this.positionAdvertisementService = positionAdvertisementService;
    }

    @GetMapping("/getall")
    public DataResult<List<PositionAdvertisement>> listAll(){
        return positionAdvertisementService.ListAll();
    }

    @PostMapping("/create")
    public Result create(@RequestBody PositionAdvertisement positionAdvertisement){
        return positionAdvertisementService.create(positionAdvertisement);
    }
}
