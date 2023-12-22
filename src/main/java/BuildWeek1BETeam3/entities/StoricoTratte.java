package BuildWeek1BETeam3.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Entity
public class StoricoTratte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_StoricoTratte;

    private LocalDate dataPercorrenza;

    private int numeroVoltePercorse;

    private int tempoEffettivoDiPercorrenza;

    @ManyToOne
    @JoinColumn(name = "tratta_id")
    private Tratta tratta;

    @ManyToOne
    @JoinColumn(name="mezzo_id")
    private MezzoDiTrasporto mezzo;

    public StoricoTratte() {
    }

    public StoricoTratte(LocalDate dataPercorrenza, int numeroVoltePercorse, Tratta tratta, MezzoDiTrasporto mezzo) {
        this.dataPercorrenza = dataPercorrenza;
        this.numeroVoltePercorse = numeroVoltePercorse;
        this.tratta = tratta;
        this.mezzo = mezzo;
        Random rndm = new Random();
        int traffico = rndm.nextInt(-7, 40);
        this.tempoEffettivoDiPercorrenza = tratta.getTempoMedioPercorrenza() + traffico;
    }

    public UUID getId_StoricoTratte() {
        return id_StoricoTratte;
    }

    public LocalDate getDataPercorrenza() {
        return dataPercorrenza;
    }

    public int getNumeroVoltePercorse() {
        return numeroVoltePercorse;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public MezzoDiTrasporto getMezzo() {
        return mezzo;
    }

    public void setNumeroVoltePercorse(int numeroVoltePercorse) {
        this.numeroVoltePercorse = numeroVoltePercorse;
    }

    @Override
    public String toString() {
        return "StoricoTratte{" +
                "id_StoricoTratte=" + id_StoricoTratte +
                ", dataPercorrenza=" + dataPercorrenza +
                ", numeroVoltePercorse=" + numeroVoltePercorse +
                ", tratta=" + tratta +
                ", mezzo=" + mezzo +
                '}';
    }
}
