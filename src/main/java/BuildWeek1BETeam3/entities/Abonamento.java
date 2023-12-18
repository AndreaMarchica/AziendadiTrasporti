package BuildWeek1BETeam3.entities;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Abonamento extends TitoloDiViaggio{
    private Tessera tessera;

    private LocalDate emissione = LocalDate.now();

}
