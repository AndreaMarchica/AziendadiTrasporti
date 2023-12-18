package BuildWeek1BETeam3.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_prodotto")
public abstract class PuntoDiEmissione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codice_ID;

    @Column(name = "Luogo")
    public String luogo;

    public PuntoDiEmissione() {
    }

    public PuntoDiEmissione(String luogo) {
        this.luogo = luogo;
    }

    public UUID getCodice_ID() {
        return codice_ID;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }
}
