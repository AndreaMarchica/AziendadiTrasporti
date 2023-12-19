package BuildWeek1BETeam3.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
public class Biglietto extends TitoloDiViaggio{
    private LocalDate emissione;

    public Biglietto (){
        this.emissione = LocalDate.now();
    }

    public LocalDate getEmissione() {
        return emissione;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "emissione=" + emissione +
                '}';
    }
}
