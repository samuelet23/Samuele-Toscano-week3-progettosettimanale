package it.epicode.week3.progettosettimanale.entities;

import it.epicode.week3.progettosettimanale.entities.sottoclassi.Libro;
import it.epicode.week3.progettosettimanale.entities.sottoclassi.Rivista;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "prestiti")
public class Prestito {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "utente_fk" )
    private Utente utente;

    @Column(name = "elementi_prestati")
    @OneToMany(mappedBy = "prestito")
    private List<Catalogo> elementiPrestati;

    @Column(name = "data_inizio_prestito")
    private LocalDate dataInizioPrestito;

    @Column(name = "data_restituzione_prevista")
    private LocalDate dataRestituzionePrevista;

    @Column(name = "data_restituzione_effettiva")
    private LocalDate dataRestituzioneEffettiva;

    public Prestito(){}

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public Prestito(int id, Set<Utente> utente, List<Catalogo> elementiPrestati, LocalDate dataInizioPrestito, LocalDate getDataRestituzioneEffettiva) {
        this.id = id;
        this.utente = (Utente) utente;
        this.elementiPrestati = elementiPrestati;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzioneEffettiva = getDataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utenti=" + utente +
                ", elementiPrestati=" + elementiPrestati +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }

    public Utente getUtenti() {
        return utente;
    }

    public LocalDate getDataRestituzionePrevista() {
       return dataInizioPrestito.plusDays(30);
    }

    public void setUtenti(Set<Utente> utenti) {
        this.utente = utente;
    }


    public List<Catalogo> getElementiPrestati() {
        return elementiPrestati;
    }

    public void setElementiPrestati(List<Catalogo> elementiPrestati) {
        this.elementiPrestati = elementiPrestati;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }


}
