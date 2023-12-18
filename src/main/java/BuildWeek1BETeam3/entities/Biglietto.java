package BuildWeek1BETeam3.entities;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity

public class Biglietto extends TitoloDiViaggio{
    private LocalDate emissione = LocalDate.now();

    public Biglietto (){}

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
