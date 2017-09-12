package tracker.car.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tracker.car.entity.Reading;
import tracker.car.repository.ReadingRepository;

import java.util.List;


/**
 * Created by Arnab on 5/29/2017.
 */
@Service
public class ReadingServiceImpl implements ReadingService {
    @Autowired
    private ReadingRepository repository;
    @Override
    @Transactional
    public Reading create(Reading rd) {
        return repository.create(rd);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reading> findAllReadingsByVin(String vin) {
        return repository.findAllReadingsByVin(vin);
    }
}
