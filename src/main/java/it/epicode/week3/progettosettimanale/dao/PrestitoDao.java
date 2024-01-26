package it.epicode.week3.progettosettimanale.dao;

import it.epicode.week3.progettosettimanale.entities.Catalogo;
import it.epicode.week3.progettosettimanale.entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PrestitoDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();




    public void addElement(Prestito p){
        try{
            et.begin();
            em.persist(p);
            et.commit();
        }catch (Exception e){
            e.getMessage();
        } finally {
//            em.close();
        }
    }

}
