package BuildWeek1BETeam3.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "rivenditore_autorizzato"   )
public class RivenditoreAutorizzato extends PuntoDiEmissione  {
    public RivenditoreAutorizzato() {
    }

    public RivenditoreAutorizzato(String luogo) {
        super(luogo);
    }

    @Override
    public String toString() {
        return "RivenditoreAutorizzato{" +
                "luogo='" + luogo + '\'' +
                '}';
    }
}
