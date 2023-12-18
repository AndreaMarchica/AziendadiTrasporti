package BuildWeek1BETeam3.entities;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity

public class Biglietto extends TitoloDiViaggio{
    private LocalDate emissione = LocalDate.now();
}
