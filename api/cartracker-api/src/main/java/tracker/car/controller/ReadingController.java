package tracker.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tracker.car.entity.Alert;
import tracker.car.entity.Reading;
import tracker.car.service.AlertService;
import tracker.car.service.ReadingService;

import java.util.List;

/**
 * Created by Arnab on 5/29/2017.
 */
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@ResponseBody
@RequestMapping(value = "readings")
public class ReadingController {
    @Autowired
    private ReadingService service1;
    @Autowired
    private AlertService service2;
    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Reading create(@RequestBody Reading rd){
        service2.create(rd);
        return service1.create(rd);
    };
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET,value="{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<Reading> findAllReadingsByVin(@PathVariable("id") String vin){
        return service1.findAllReadingsByVin(vin);
    };
}
