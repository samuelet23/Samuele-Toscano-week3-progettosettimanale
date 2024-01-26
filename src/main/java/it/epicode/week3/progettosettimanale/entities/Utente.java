package it.epicode.week3.progettosettimanale.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numero_tessera")
    private int numeroTessera;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)

    private String cognome;
    @Column(name = "data_di_nasccita")
    private LocalDate dataDiNascita;
    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    private Set<Prestito> prestiti;


    public Utente(){}

    public Utente(int numeroTessera, String nome, String cognome, LocalDate dataDiNascita, Set<Prestito> prestiti) {
        this.numeroTessera = numeroTessera;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.prestiti = prestiti;
    }
    @Override
    public String toString() {
        return "Utente{" +
                "numeroTessera=" + numeroTessera +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                '}';
    }

    public int getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(int numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Set<Prestito> getPrestiti() {
        return prestiti;
    }

    public void setPrestiti(Set<Prestito> prestiti) {
        this.prestiti = prestiti;
    }
}
