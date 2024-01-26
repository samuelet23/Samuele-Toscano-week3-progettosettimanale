package it.epicode.week3.progettosettimanale;

import it.epicode.week3.progettosettimanale.dao.CatalogoDao;
import it.epicode.week3.progettosettimanale.dao.PrestitoDao;
import it.epicode.week3.progettosettimanale.dao.UtenteDao;
import it.epicode.week3.progettosettimanale.entities.Prestito;
import it.epicode.week3.progettosettimanale.entities.Utente;
import it.epicode.week3.progettosettimanale.entities.sottoclassi.Libro;
import it.epicode.week3.progettosettimanale.entities.sottoclassi.Rivista;
import it.epicode.week3.progettosettimanale.entities.type.Periodicita;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Set;

public class UsaArchivio {

    public static void main(String[] args) {
        CatalogoDao catalogoDao = new CatalogoDao();
        PrestitoDao prestitoDao =new PrestitoDao();
        UtenteDao utenteDao = new UtenteDao();

        Libro libro1 = new Libro();
        Libro libro2 = new Libro();

        Rivista rivista1 = new Rivista();
        Rivista rivista2 = new Rivista();

        Utente utente1 = new Utente();
        Utente utente2 = new Utente();
        Utente utente3 = new Utente();

        Prestito prestito = new Prestito();


        libro1.setAutore("Marco");
        libro1.setGenere("Horror");
        libro1.setAnnoPubblicazione(LocalDate.of(2022, 10, 20));
        libro1.setNumeroPagine(390);
        libro1.setTitolo("Bel libro");

        libro2.setTitolo("Bel libro2");
        libro2.setAutore("Filippo");
        libro2.setGenere("Comico");
        libro2.setAnnoPubblicazione(LocalDate.of(2020, 10, 14));
        libro2.setNumeroPagine(390);

        catalogoDao.addElement(libro1);
        catalogoDao.addElement(libro2);

        rivista1.setTitolo("Il quotidiano");
        rivista1.setNumeroPagine(40);
        rivista1.setAnnoPubblicazione(LocalDate.of(2022, Month.APRIL, 25));
        rivista1.setPeriodicita(Periodicita.SETTIMANALE);

        rivista2.setTitolo("Il sole");
        rivista2.setNumeroPagine(20);
        rivista2.setAnnoPubblicazione(LocalDate.of(2024, Month.JANUARY, 10));
        rivista2.setPeriodicita(Periodicita.MENSILE);

        catalogoDao.addElement(rivista1);
        catalogoDao.addElement(rivista2);

        utente1.setNome("Francesco");
        utente1.setCognome("Tripolio");
        utente1.setDataDiNascita(LocalDate.of(2000, 11, 23));

        utente2.setNome("Marco");
        utente2.setCognome("Bene");
        utente2.setDataDiNascita(LocalDate.of(1999, 1, 14));

        utente3.setNome("Filippo");
        utente3.setCognome("Male");
        utente3.setDataDiNascita(LocalDate.of(2003, 12, 7));

        utenteDao.addElement(utente1);
        utenteDao.addElement(utente2);
        utenteDao.addElement(utente3);


        prestito.setElementiPrestati(List.of(rivista1, libro2, libro1));
        prestito.setDataInizioPrestito(LocalDate.of(2024, 10, 1));
        prestito.getDataRestituzionePrevista();
        prestito.setDataRestituzioneEffettiva(LocalDate.of(2024, 11, 10));
        prestito.setUtenti(Set.of(utente1,utente2));

        prestitoDao.addElement(prestito);

//        catalogoDao.removeFromIsbn(3);
//        System.out.println(catalogoDao.findByIsbn(3));
//        System.out.println(catalogoDao.findByAutore("Marco"));
//        System.out.println(catalogoDao.findByYear(2022));
//        catalogoDao.findByTitle("quotidi")
//                .stream()
//                .forEach(catalogo -> System.out.println(catalogo));
//        System.out.println(catalogoDao.findExpiredPrestito());

    }
}
