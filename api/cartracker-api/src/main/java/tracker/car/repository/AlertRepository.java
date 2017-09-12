package tracker.car.repository;

import tracker.car.entity.Alert;
import java.util.List;

/**
 * Created by Arnab on 5/30/2017.
 */
public interface AlertRepository {
    Alert create(Alert alert);
    List<Alert> findAllHighAlert();
    List<Alert> findAllAlertsByVin(String vin);

}
