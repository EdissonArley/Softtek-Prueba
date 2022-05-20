package com.softtek.ejb;

import com.softtek.model.Provider;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ProviderFacadeLocal {

    void create(Provider provider);

    void edit(Provider provider);

    void remove(Provider provider);

    Provider find(Object id);

    List<Provider> findAll();

    List<Provider> findRange(int[] range);

    int count();
    
}
