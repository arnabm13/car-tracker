package tracker.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tracker.car.entity.Vehicle;
import tracker.car.exception.BadRequestException;
import tracker.car.exception.NotFoundException;
import tracker.car.repository.VehicleRepository;

import java.util.List;

/**
 * Created by Arnab on 5/29/2017.
 */
@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository repository;
    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {

        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Vehicle findOne(String vin) {
        Vehicle vehicle=repository.findOne(vin);
        if(vehicle==null){
            throw new NotFoundException("Vehicle with vin="+vin+"not found");
        }
        return vehicle;
    }

    @Override
    @Transactional
    public Vehicle load(Vehicle vc) {
        Vehicle existing=repository.findByVin(vc.getVin());
        if(existing!=null){
            return repository.update(vc);
        }
        return repository.create(vc);
    }

//    @Override
//    @Transactional
//    public Vehicle update(String vin, Vehicle vc) {
//        Vehicle existing =repository.findOne(vin);
//        if(existing==null){
//            throw new NotFoundException("Vehicle with vin="+vin+"not found");
//        }
//        return repository.update(vc);
//    }
//
//    @Override
//    @Transactional
//    public void delete(String vin) {
//        Vehicle existing =repository.findOne(vin);
//        if(existing==null) {
//            throw new NotFoundException("Vehicle with vin="+vin+"not found");
//        }
//        repository.delete(existing);
//
//    }
}
