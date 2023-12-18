package BuildWeek1BETeam3.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tratte")
public class Tratta {

    /*ATTRIBUTI*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String zonaDiPartenza;
    private String capolinea;
    private int tempoMedioPercorrenza;
    private MezzoDiTrasporto mezzoDiTrasporto;

    /*COSTRUTTORI*/

    public Tratta() {
    }

    public Tratta(UUID uuid, String zonaDiPartenza, String capolinea, int tempoMedioPercorrenza, MezzoDiTrasporto mezzoDiTrasporto) {
        this.id = uuid;
        this.zonaDiPartenza = zonaDiPartenza;
        this.capolinea = capolinea;
        this.tempoMedioPercorrenza = tempoMedioPercorrenza;
        this.mezzoDiTrasporto = mezzoDiTrasporto;
    }

    /*METODI*/

    public UUID getUuid() {
        return id;
    }

    public void setUuid(UUID uuid) {
        this.id = uuid;
    }

    public String getZonaDiPartenza() {
        return zonaDiPartenza;
    }

    public void setZonaDiPartenza(String zonaDiPartenza) {
        this.zonaDiPartenza = zonaDiPartenza;
    }

    public String getCapolinea() {
        return capolinea;
    }

    public void setCapolinea(String capolinea) {
        this.capolinea = capolinea;
    }

    public int getTempoMedioPercorrenza() {
        return tempoMedioPercorrenza;
    }

    public void setTempoMedioPercorrenza(int tempoMedioPercorrenza) {
        this.tempoMedioPercorrenza = tempoMedioPercorrenza;
    }

    public MezzoDiTrasporto getMezzoDiTrasporto() {
        return mezzoDiTrasporto;
    }

    public void setMezzoDiTrasporto(MezzoDiTrasporto mezzoDiTrasporto) {
        this.mezzoDiTrasporto = mezzoDiTrasporto;
    }

    @Override
    public String toString() {
        return "Tratta{" +
                "uuid=" + id +
                ", zonaDiPartenza='" + zonaDiPartenza + '\'' +
                ", capolinea='" + capolinea + '\'' +
                ", tempoMedioPercorrenza=" + tempoMedioPercorrenza +
                ", mezzoDiTrasporto=" + mezzoDiTrasporto +
                '}';
    }
}
