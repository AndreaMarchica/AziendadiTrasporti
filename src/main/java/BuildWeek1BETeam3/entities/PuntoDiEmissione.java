package BuildWeek1BETeam3.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "punti_di_emissione")

@DiscriminatorColumn(name = "tipo_prodotto")
public abstract class PuntoDiEmissione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
