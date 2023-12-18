package BuildWeek1BETeam3.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "biglietto")
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
