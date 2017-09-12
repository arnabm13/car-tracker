package tracker.car.service;

import tracker.car.entity.Vehicle;

import java.util.List;

/**
 * Created by Arnab on 5/29/2017.
 */
public interface VehicleService {
    List<Vehicle> findAll();
    Vehicle findOne(String vin);
    Vehicle load(Vehicle vc);
//    Vehicle update(String vin,Vehicle vc);
//    void delete(String vin);
}
