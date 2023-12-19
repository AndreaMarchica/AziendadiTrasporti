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

    @Enumerated
    private StatoMezzo stato;
    private LocalDate inizioManutenzione;
    private LocalDate fineManutenzione;
    @Enumerated
    private TipoManutenzione tipoManutenzione;

    @OneToMany(mappedBy = "stato")
    private List<MezzoDiTrasporto> listaMezzi = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="storicoManutenzioni")
private StoricoManutenzione storicoManutenzioni;

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
    public void setId(int id) {
        this.id = id;
    }

    public Stato(List<MezzoDiTrasporto> listaMezzi) {
        this.listaMezzi=listaMezzi;
    }
    public void setState(StatoMezzo stato){
        this.stato=stato;
        if (stato.equals(StatoMezzo.IN_MANUTENZIONE)){this.inizioManutenzione=LocalDate.now();}}


}
