package com.softtek.ejb;

import com.softtek.model.Vehicle;
import java.util.List;
import javax.ejb.Local;

@Local
public interface VehicleFacadeLocal {

    void create(Vehicle vehicle);

    void edit(Vehicle vehicle);

    void remove(Vehicle vehicle);

    Vehicle find(Object id);

    List<Vehicle> findAll();

    List<Vehicle> findRange(int[] range);

    int count();
    
    List<Vehicle> search(String filter) throws Exception;
    
}
