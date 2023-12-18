package BuildWeek1BETeam3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class RivenditoreAutomatico extends PuntoDiEmissione{

    @Column(name = "in_servizio")
    private boolean in_servizio;


    public RivenditoreAutomatico(boolean in_servizio) {
        this.in_servizio = in_servizio;
    }
    public RivenditoreAutomatico( ) {
    }
    public RivenditoreAutomatico(String luogo, boolean in_servizio) {
        super(luogo);
        this.in_servizio = in_servizio;
    }

    public boolean isIn_servizio() {
        return in_servizio;
    }

    public void setIn_servizio(boolean in_servizio) {
        this.in_servizio = in_servizio;
    }

    @Override
    public String toString() {
        return "RivenditoreAutomatico{" +
                "in_servizio=" + in_servizio +
                ", luogo='" + luogo + '\'' +
                '}';
    }
}
