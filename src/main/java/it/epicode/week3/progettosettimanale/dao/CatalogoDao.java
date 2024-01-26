package it.epicode.week3.progettosettimanale.dao;

import it.epicode.week3.progettosettimanale.CustomException;
import it.epicode.week3.progettosettimanale.entities.Catalogo;
import it.epicode.week3.progettosettimanale.entities.Prestito;
import it.epicode.week3.progettosettimanale.entities.Utente;
import it.epicode.week3.progettosettimanale.entities.sottoclassi.Libro;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class CatalogoDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();





    public void addElement(Catalogo c){
        try{
        et.begin();
        em.persist(c);
        et.commit();
        }catch (Exception e){
           e.getMessage();
        } finally {
//            em.close();
        }
    }
    public void removeFromIsbn(int isbn){
        try{
        et.begin();
        Query query = em.createQuery("delete c from Catalogo c where c.isbn = :isbn");
        query.setParameter("isbn", isbn);
        query.executeUpdate();
            System.out.println("L'elemento:" + findByIsbn(isbn) + "è stato eliminato");
        et.commit();

        }catch (Exception e){
            e.getMessage();
        }finally {
            em.close();
        }
    }
    public Catalogo findByIsbn(int isbn){
        Catalogo c = null;
        try{
        et.begin();
        Query query = em.createQuery("select c from Catalogo c where c.isbn = :isbn");
        query.setParameter("isbn", isbn);
             c = (Catalogo) query.getSingleResult();
            et.commit();
        }catch (Exception e){
            e.getMessage();
        }finally {
            em.close();
        }
        return c;
    }
    public List<Catalogo> findByYear(int anno){
        List<Catalogo> c = null;
        try{
        et.begin();

        Query query = em.createQuery("select c from Catalogo c where c.annoPubblicazione = :anno");
        query.setParameter("anno", anno);
             c = (List<Catalogo>) query.getResultList();
            et.commit();
        }catch (Exception e){
            e.getMessage();
        }finally {
            em.close();
        }
        return c;
    }





    public List<Catalogo> findByAutore(String autore){
        List<Catalogo> c = null;
        try{
        et.begin();
        Query query = em.createQuery("select c from Catalogo c where c.autore = :autore");
        query.setParameter("autore", autore);
             c = (List<Catalogo>) query.getResultList();
            et.commit();
        }catch (Exception e){
            e.getMessage();
        }finally {
            em.close();
        }
        return c;
    }

    public List<Catalogo> findByTitle(String parola){
       List<Catalogo> c = null;
        try{
            et.begin();
            Query query = em.createQuery("select c from Catalogo c where titolo like: parola");
            query.setParameter("parola", "%" +parola+ "%");
            c = (List<Catalogo>) query.getResultList();
        }catch (Exception e){
            e.getMessage();
        }finally {
            em.close();
        }
        return c;
    }



    public Utente findByTessera(int tessera) {
        Utente u = null;
        try {
            et.begin();
            LocalDate oggi = LocalDate.now();
            String queryString = "select c from Catalogo left join c.prestito p left join p.utenti u where (:oggi between p.dataInizioPrestito and p.getDataRestituzioneEffettiva) and (u.numeroTessera = :tessera)  ";
            Query query = em.createQuery(queryString);
            query.setParameter("tessera", tessera);
            query.setParameter("oggi", oggi);
            u = (Utente) query.getResultList();
            et.commit();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            em.close();
        }
        return u;
    }

    public List<Prestito> findExpiredPrestito(){
        List<Prestito> p = null;
        try{
        et.begin();
            LocalDate oggi = LocalDate.now();
            String stringaQuery ="select p from Prestito p where p.getDataRestituzioneEffettiva isnull and p.dataRestituzionePrevista < :oggi";
            Query query = em.createQuery(stringaQuery);
            query.setParameter("oggi", oggi);
            p = (List<Prestito>)query.getResultList();
        et.commit();
        }catch (Exception e){
            e.getMessage();
        }finally{
            em.close();
        }
        return p;

    }
}

