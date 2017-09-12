package tracker.car.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tracker.car.entity.Alert;
import tracker.car.entity.Reading;
import tracker.car.entity.Vehicle;
import tracker.car.repository.AlertRepository;
import tracker.car.repository.VehicleRepository;

import java.util.List;
import java.util.UUID;


/**
 * Created by Arnab on 5/30/2017.
 */
@Service
public class AlertServiceImpl implements AlertService {
    @Autowired
    private AlertRepository repository1;
    @Autowired
    private VehicleRepository repository2;

    @Override
    @Transactional
    public Alert create(Reading rd) {
        Alert alert=new Alert();
        String vin = rd.getVin();
        alert.setTimestamp(rd.getTimestamp());
        alert.setVin(vin);
        if (rd.getEngineRpm()>repository2.findByVin(vin).getRedlineRpm()) {
            alert.setPriority("HIGH");
            alert.setReason("Engine Rpm is greater than Readline Rpm.");
            alert.setId(UUID.randomUUID().toString());
            return repository1.create(alert);
        }

        else if (rd.getFuelVolume()<repository2.findByVin(vin).getMaxFuelVolume()*0.1){
            alert.setPriority("MEDIUM");
            alert.setReason("Fuel Volume is lesser than 10% of Max Fuel Volume.");
            alert.setId(UUID.randomUUID().toString());
            return repository1.create(alert);

        }

        else if (rd.getTires().getFrontLeft()<32||rd.getTires().getFrontLeft()>36)
        {
            alert.setPriority("LOW");
            alert.setReason("Tire pressure of Front left tire is lesser than 32 psi or greater than 36 psi.");
            alert.setId(UUID.randomUUID().toString());
            return repository1.create(alert);

        }

        else if (rd.getTires().getFrontRight()<32||rd.getTires().getFrontRight()>36)
        {
            alert.setPriority("LOW");
            alert.setReason("Tire pressure of Front right tire is lesser than 32 psi or greater than 36 psi.");
            alert.setId(UUID.randomUUID().toString());
            return repository1.create(alert);

        }

        else if (rd.getTires().getRearLeft()<32||rd.getTires().getRearLeft()>36)
        {
            alert.setPriority("LOW");
            alert.setReason("Tire pressure of Rear left tire is lesser than 32 psi or greater than 36 psi.");
            alert.setId(UUID.randomUUID().toString());
            return repository1.create(alert);

        }

        else if (rd.getTires().getRearRight()<32||rd.getTires().getRearRight()>36)
        {
            alert.setPriority("LOW");
            alert.setReason("Tire pressure of Rear right tire is lesser than 32 psi or greater than 36 psi.");
            alert.setId(UUID.randomUUID().toString());
            return repository1.create(alert);

        }

        else if(rd.isEngineCoolantLow()||rd.isCheckEngineLightOn()){
            alert.setPriority("LOW");
            alert.setReason("Engine coolant is low or Engine light is on.");
            alert.setId(UUID.randomUUID().toString());
            return repository1.create(alert);

        }

        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Alert> findAllHighAlert() {
        return repository1.findAllHighAlert();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Alert> findAllAlertsByVin(String vin) {

        return repository1.findAllAlertsByVin(vin);
    }
}
