package it.epicode.week3.progettosettimanale.entities;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "tipo")
public abstract class Catalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogo_id")
    @SequenceGenerator(name = "catalogo_id", initialValue = 0, allocationSize = 1)
    protected int isbn;
    @Column(nullable = false)
    protected String titolo;

    @Column(name = "anno_pubblicazione")
    protected int annoPubblicazione;

    @Column(name = "numero_pagine", nullable = false)
    protected int numeroPagine;

    @ManyToOne
    @JoinColumn(name = "prestito_fk")
    protected Prestito prestito;


    public Catalogo(int isbn, String titolo, int annoPubblicazione, int numeroPagine, Prestito prestito) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;

    }

    public Catalogo() {}



    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(LocalDate annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione.getYear();

    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
}
