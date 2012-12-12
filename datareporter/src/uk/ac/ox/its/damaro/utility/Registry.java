package uk.ac.ox.its.damaro.utility;

import javax.inject.Named;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Named
public class Registry {

    public static Registry INST = new Registry();
    
    private EntityManagerFactory emf;
    
    public Registry() {
        this.emf = Persistence.createEntityManagerFactory("damaroReporterPU");
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

}
