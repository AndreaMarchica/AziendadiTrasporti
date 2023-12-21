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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private int capienza;
    private LocalDate dataPrimoImpiego;

    @ManyToMany
    @JoinTable(
            name = "mezzoditrasporto_tratta",
            joinColumns = @JoinColumn(name = "mezzoditrasporto_id"),
            inverseJoinColumns = @JoinColumn(name = "tratta_id")
    )
    private List<Tratta> tratte = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "stato_id")
    private Stato stato;

    /*COSTRUTTORI*/

    public MezzoDiTrasporto() {
    }

    public MezzoDiTrasporto(int capienza, LocalDate dataPrimoImpiego, Stato stato) {
        this.capienza = capienza;
        this.dataPrimoImpiego = dataPrimoImpiego;
        this.stato = stato;
        this.tratte = new ArrayList<>();
    }

    /*METODI*/

    public List<Tratta> getTratte() {
        return tratte;
    }

    public void aggiungiTratta(Tratta tratta) {
        this.tratte.add(tratta);
    }

    public void rimuoviTratta(Tratta tratta) {
        this.tratte.remove(tratta);
    }

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
                ", tratte=" + tratte +
                ", stato=" + stato +
                '}';
    }
}
