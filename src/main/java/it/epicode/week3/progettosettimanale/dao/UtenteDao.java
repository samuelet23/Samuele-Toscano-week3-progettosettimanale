package it.epicode.week3.progettosettimanale.dao;

import it.epicode.week3.progettosettimanale.entities.Prestito;
import it.epicode.week3.progettosettimanale.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UtenteDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();




    public void addElement(Utente u){
        try{
            et.begin();
            em.persist(u);
            et.commit();
        }catch (Exception e){
            e.getMessage();
        } finally {
//            em.close();
        }
    }
}
