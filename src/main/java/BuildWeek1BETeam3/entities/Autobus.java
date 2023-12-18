package BuildWeek1BETeam3.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "autobus")
public class Autobus extends MezzoDiTrasporto {

    /*COSTRUTTORI*/

    public Autobus() {
    }

    public Autobus(UUID id, int capienza, LocalDate dataPrimoImpiego) {
        super(id, capienza, dataPrimoImpiego);
    }

    /*METODI*/

    @Override
    public UUID getId() {
        return super.getId();
    }

    @Override
    public void setId(UUID id) {
        super.setId(id);
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
    public void manutenzione() {
        super.manutenzione();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
