package BuildWeek1BETeam3.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@DiscriminatorValue("autobus")
public class Autobus extends MezzoDiTrasporto {

    /*COSTRUTTORI*/

    public Autobus() {
    }

    public Autobus(int capienza, LocalDate dataPrimoImpiego, Stato statoDiManutenzione) {
        super(capienza, dataPrimoImpiego, statoDiManutenzione);
    }

    @Override
    public List<Tratta> getTratte() {
        return super.getTratte();
    }

    @Override
    public void aggiungiTratta(Tratta tratta) {
        super.aggiungiTratta(tratta);
    }

    @Override
    public void rimuoviTratta(Tratta tratta) {
        super.rimuoviTratta(tratta);
    }

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
    public void setStato(Stato stato) {
        super.setStato(stato);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
