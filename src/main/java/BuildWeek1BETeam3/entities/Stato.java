package BuildWeek1BETeam3.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Stato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Enumerated(EnumType.STRING)
    private StatoMezzo stato;
    private LocalDate inizioManutenzione;
    private LocalDate fineManutenzione;
    @Enumerated(EnumType.STRING)
    private TipoManutenzione tipoManutenzione;

    @OneToMany(mappedBy = "stato")
    private List<MezzoDiTrasporto> listaMezzi = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="storicoManutenzioni")
    private StoricoManutenzione storicoManutenzioni;


    public Stato() {}
    public Stato(StatoMezzo stato, LocalDate inizioManutenzione, TipoManutenzione tipoManutenzione, MezzoDiTrasporto mezzo) {
        this.stato = stato;
        this.inizioManutenzione = inizioManutenzione;
        this.tipoManutenzione = tipoManutenzione;
        listaMezzi.add(mezzo);
    }

    public StatoMezzo getStato() {
        return stato;
    }

    public void setStato(StatoMezzo stato) {
        this.stato = stato;
    }

    public LocalDate getFineManutenzione() {
        return fineManutenzione;
    }
    public void setFineManutenzione(LocalDate fineManutenzione) {
        this.fineManutenzione = fineManutenzione;
    }

    public LocalDate getInizioManutenzione() {
        return inizioManutenzione;
    }
    public void setInizioManutenzione(LocalDate inizioManutenzione) {
        this.inizioManutenzione = inizioManutenzione;
    }

    public TipoManutenzione getTipoManutenzione() {
        return tipoManutenzione;
    }
    public void setTipoManutenzione(TipoManutenzione tipoManutenzione) {
        this.tipoManutenzione = tipoManutenzione;
    }

    public int getId() {
        return id;
    }
    public void aggiungiMezzo(MezzoDiTrasporto mezzo) {
        this.listaMezzi.add(mezzo);
    }

    public void rimuoviMezzo(MezzoDiTrasporto mezzo) {
        this.listaMezzi.remove(mezzo);
    }

    public Stato(StatoMezzo statoMezzo) {
        this.stato = statoMezzo;
    }
    public void setState(StatoMezzo stato) {
        this.stato = stato;
        if (stato.equals(StatoMezzo.IN_MANUTENZIONE)) {
            this.inizioManutenzione = LocalDate.now();
        } else {
            this.inizioManutenzione = null;
            this.fineManutenzione = null;
        }
    }

    @Override
    public String toString() {
        return "Stato{" +
                "id=" + id +
                ", stato=" + stato +
                ", inizioManutenzione=" + inizioManutenzione +
                ", fineManutenzione=" + fineManutenzione +
                ", tipoManutenzione=" + tipoManutenzione +
                ", listaMezzi=" + listaMezzi +
                ", storicoManutenzioni=" + storicoManutenzioni +
                '}';
    }
}
