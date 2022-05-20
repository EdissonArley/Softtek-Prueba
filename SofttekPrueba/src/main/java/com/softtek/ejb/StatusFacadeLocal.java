package com.softtek.ejb;

import com.softtek.model.Status;
import java.util.List;
import javax.ejb.Local;

@Local
public interface StatusFacadeLocal {

    void create(Status status);

    void edit(Status status);

    void remove(Status status);

    Status find(Object id);

    List<Status> findAll();

    List<Status> findRange(int[] range);

    int count();
    
}
