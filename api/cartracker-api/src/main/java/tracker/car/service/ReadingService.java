package tracker.car.service;
import tracker.car.entity.Reading;

import java.util.List;

/**
 * Created by Arnab on 5/29/2017.
 */
public interface ReadingService {
    Reading create(Reading rd);
    List<Reading> findAllReadingsByVin(String vin);
}
