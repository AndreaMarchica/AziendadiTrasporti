package BuildWeek1BETeam3.entities;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="mezzi_di_trasporto")
public abstract class MezzoDiTrasporto {

    /*ATTRIBUTI*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private UUID id;
    private int capienza;
    private LocalDate dataPrimoImpiego;
    @Enumerated
    private StatoManutenzione manutenzione;
    private LocalDate dataInizioManutenzione;
    private LocalDate dataFineManutenzione;

    @ManyToMany
    @JoinTable(
            name = "mezzoditrasporto_tratta",
            joinColumns = @JoinColumn(name = "mezzoditrasporto_id"),
            inverseJoinColumns = @JoinColumn(name = "tratta_id")
    )
    private List<Tratta> tratte = new ArrayList<>();


    /*COSTRUTTORI*/

    public MezzoDiTrasporto() {
    }

    public MezzoDiTrasporto(int capienza, LocalDate dataPrimoImpiego) {
        this.capienza = capienza;
        this.dataPrimoImpiego = dataPrimoImpiego;
        this.manutenzione = StatoManutenzione.IN_SERVIZIO;
    }

    /*METODI*/

    public void setMaunutenzione(StatoManutenzione manutenzione) {
        this.manutenzione = manutenzione;
        if (manutenzione.equals(StatoManutenzione.IN_MANUTENZIONE)) {
            this.dataInizioManutenzione = LocalDate.now();
        } else { this.dataFineManutenzione = LocalDate.now();
    }}

    public UUID getId() {
        return id;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    public LocalDate getDataPrimoImpiego() {
        return dataPrimoImpiego;
    }

    public void setDataPrimoImpiego(LocalDate dataPrimoImpiego) {
        this.dataPrimoImpiego = dataPrimoImpiego;
    }

    @Override
    public String toString() {
        return "MezzoDiTrasporto{" +
                "id=" + id +
                ", capienza=" + capienza +
                ", dataPrimoImpiego=" + dataPrimoImpiego +
                '}';
    }
}
