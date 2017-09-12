package tracker.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tracker.car.entity.Vehicle;
import tracker.car.service.VehicleService;

import java.util.List;

/**
 * Created by Arnab on 5/29/2017.
 */
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@ResponseBody
@RequestMapping(value = "vehicles")
public class VehicleController {
    @Autowired
    private VehicleService service;
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<Vehicle> findAll(){
        return service.findAll();
    };
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET,value="{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Vehicle findOne(@PathVariable("id") String vin){
        return service.findOne(vin);
    };
    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Vehicle load(@RequestBody List<Vehicle> vList){
        Vehicle vehicle=null;
        for (Vehicle vc:vList) {
            vehicle = service.load(vc);
        }
        return vehicle;
    };
//    @RequestMapping(method = RequestMethod.POST,value = "{id}",
//            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
//            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    Vehicle update(@PathVariable("id") String vin,@RequestBody List<Vehicle> vList){
//        Vehicle vehicle=null;
//        for (Vehicle vc: vList) {
//            vehicle = service.update(vin,vc);
//        }
//        return vehicle;
//    };
//    @RequestMapping(method = RequestMethod.DELETE,value = "{id}")
//    void delete(@PathVariable("id") String vin){
//        service.delete(vin);
//    };

}
