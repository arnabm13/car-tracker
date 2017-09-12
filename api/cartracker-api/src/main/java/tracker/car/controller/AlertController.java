package tracker.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tracker.car.entity.Alert;
import tracker.car.service.AlertService;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping(value = "alerts")
public class AlertController {
    @Autowired
    private AlertService service2;

    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<Alert> findAllHighAlert(){
        return service2.findAllHighAlert();
    };
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET,value="{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<Alert> findAllAlertsByVin(@PathVariable("id") String vin){
        return service2.findAllAlertsByVin(vin);
    };

}
