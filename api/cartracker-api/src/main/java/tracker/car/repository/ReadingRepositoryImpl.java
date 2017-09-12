package tracker.car.repository;

import org.springframework.stereotype.Repository;
import tracker.car.entity.Reading;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Created by Arnab on 5/30/2017.
 */
@Repository
public class ReadingRepositoryImpl implements ReadingRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Reading create(Reading rd) {
        em.persist(rd);
        return rd;
    }

    @Override
    public List<Reading> findAllReadingsByVin(String vin) {
        TypedQuery<Reading> query=em.createNamedQuery("Reading.findByVin",Reading.class);
        Instant instant = Instant.now ();
        Instant instantHourEarlier = instant.minus ( 30 , ChronoUnit.MINUTES );
        Timestamp ts = Timestamp.from(instantHourEarlier);
        query.setParameter("pTS",ts);
        query.setParameter("pVin",vin);
        List<Reading> resultList = query.getResultList();
        if(resultList!= null){
            return resultList;
        }else {
            return null;
        }

    }
}
