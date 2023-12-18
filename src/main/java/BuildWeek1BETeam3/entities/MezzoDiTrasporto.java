package BuildWeek1BETeam3.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "mezzi_di_trasporto")
public abstract class MezzoDiTrasporto {

    /*ATTRIBUTI*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private int capienza;
    private LocalDate dataPrimoImpiego;

    /*COSTRUTTORI*/

    public MezzoDiTrasporto() {
    }

    public MezzoDiTrasporto(UUID id, int capienza, LocalDate dataPrimoImpiego) {
        this.id = id;
        this.capienza = capienza;
        this.dataPrimoImpiego = dataPrimoImpiego;
    }

    /*METODI*/

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
    public void manutenzione(){
    };

    @Override
    public String toString() {
        return "MezzoDiTrasporto{" +
                "id=" + id +
                ", capienza=" + capienza +
                ", dataPrimoImpiego=" + dataPrimoImpiego +
                '}';
    }
}
