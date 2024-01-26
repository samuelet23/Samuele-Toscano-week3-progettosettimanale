package it.epicode.week3.progettosettimanale.entities.sottoclassi;

import it.epicode.week3.progettosettimanale.entities.Catalogo;
import it.epicode.week3.progettosettimanale.entities.Prestito;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("libri")
public class Libro extends Catalogo {

    @Column(nullable = false)
    private String autore;
    @Column(nullable = false)

    private String genere;


    public Libro(){}

    public Libro(int isbn, String titolo, int annoPubblicazione, int numeroPagine, Prestito prestito, String autore, String genere) {
        super(isbn, titolo, annoPubblicazione, numeroPagine, prestito);
        this.autore = autore;
        this.genere = genere;
    }

    public Libro(String autore, String genere) {
        this.autore = autore;
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                ", isbn=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
}
