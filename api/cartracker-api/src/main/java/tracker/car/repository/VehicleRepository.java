package tracker.car.repository;

import tracker.car.entity.Vehicle;

import java.util.List;

/**
 * Created by Arnab on 5/29/2017.
 */
public interface VehicleRepository {
    List<Vehicle> findAll();
    Vehicle findOne(String vin);
    Vehicle findByVin(String vin);
    Vehicle create(Vehicle vc);
    Vehicle update(Vehicle vc);
//    void delete(Vehicle vc);

}
