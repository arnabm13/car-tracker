package tracker.car.repository;

import org.springframework.stereotype.Repository;
import tracker.car.entity.Alert;

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
public class AlertRepositoryImpl implements AlertRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    public Alert create(Alert alert) {
        em.persist(alert);
        return alert;
    }

    @Override
    public List<Alert> findAllHighAlert() {
        TypedQuery<Alert> query=em.createNamedQuery("Alert.findAllHighAlert",Alert.class);
        Instant instant = Instant.now ();
        Instant instantHourEarlier = instant.minus ( 2 , ChronoUnit.HOURS );
        Timestamp ts = Timestamp.from(instantHourEarlier);
        query.setParameter("pTS",ts);
        List<Alert> resultList = query.getResultList();
        if(resultList!= null){
            return resultList;
        }else {
            return null;
        }
    }

    @Override
    public List<Alert> findAllAlertsByVin(String vin) {
        TypedQuery<Alert> query=em.createNamedQuery("Alert.findByVin",Alert.class);
        query.setParameter("pVin",vin);
        List<Alert> resultList = query.getResultList();
        if(resultList!= null){
            return resultList;
        }else {
            return null;
        }

    }
}
