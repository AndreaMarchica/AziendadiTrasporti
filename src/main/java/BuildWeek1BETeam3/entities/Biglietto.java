package BuildWeek1BETeam3.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("biglietto")
@NamedQueries(
        @NamedQuery(name = "Biglietto.findVidimatiByPeriodo",
        query = "SELECT x FROM Biglietto x WHERE x.vidimazione BETWEEN :startPeriod AND :endPeriod"
))


public class Biglietto extends TitoloDiViaggio{
    private LocalDate emissione;
    private LocalDate vidimazione;

    public Biglietto (){
        this.emissione = LocalDate.now();
    }

    public LocalDate getEmissione() {
        return emissione;
    }

    public LocalDate getVidimazione() {
        return vidimazione;
    }
    public void setVidimazione(LocalDate vidimazione) {
        this.vidimazione = vidimazione;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "emissione=" + emissione +
                '}';
    }
}
