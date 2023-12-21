package BuildWeek1BETeam3.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
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
