package it.epicode.week3.progettosettimanale.entities.sottoclassi;

import it.epicode.week3.progettosettimanale.entities.Catalogo;
import it.epicode.week3.progettosettimanale.entities.Prestito;
import it.epicode.week3.progettosettimanale.entities.type.Periodicita;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("rivista")
public class Rivista extends Catalogo {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Periodicita periodicita;


    public Rivista(int isbn, String titolo, int annoPubblicazione, int numeroPagine, Prestito prestito, Periodicita periodicita) {
        super(isbn, titolo, annoPubblicazione, numeroPagine, prestito);
        this.periodicita = periodicita;
    }

    public Rivista(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    public Rivista(){}

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicita=" + periodicita +
                ", isbn=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }
}
