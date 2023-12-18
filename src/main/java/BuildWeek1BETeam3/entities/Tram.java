package BuildWeek1BETeam3.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tram")
public class Tram extends MezzoDiTrasporto {

    /*COSTRUTTORI*/

    public Tram() {
    }

    public Tram(int capienza, LocalDate dataPrimoImpiego) {
        super(capienza, dataPrimoImpiego);
    }

    /*METODI*/

    @Override
    public UUID getId() {
        return super.getId();
    }

    @Override
    public int getCapienza() {
        return super.getCapienza();
    }

    @Override
    public void setCapienza(int capienza) {
        super.setCapienza(capienza);
    }

    @Override
    public LocalDate getDataPrimoImpiego() {
        return super.getDataPrimoImpiego();
    }

    @Override
    public void setDataPrimoImpiego(LocalDate dataPrimoImpiego) {
        super.setDataPrimoImpiego(dataPrimoImpiego);
    }

    @Override
    public void setMaunutenzione(StatoManutenzione manutenzione) {
        super.setMaunutenzione(manutenzione);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
