package BuildWeek1BETeam3.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NamedQueries(
        @NamedQuery(
                name = "Tratta.countPercorsiPerMezzo",
                query = "SELECT COUNT(x) FROM Tratta x WHERE t.MezzoDiTrasporto.id = :mezzoId AND t.id = :trattaId"
        )
)
public class Tratta {

    /*ATTRIBUTI*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String zonaDiPartenza;
    private String capolinea;
    private int tempoMedioPercorrenza;

    @ManyToMany
    @JoinTable(
            name = "mezzoditrasporto_tratta",
            joinColumns = @JoinColumn(name = "tratta_id"),
            inverseJoinColumns = @JoinColumn(name = "mezzoditrasporto_id")
    )
    private List<MezzoDiTrasporto> mezzi = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="storico_tratte")
    private StoricoTratte storicoTratte;



    /*COSTRUTTORI*/

    public Tratta() {
    }

    public Tratta(UUID uuid, String zonaDiPartenza, String capolinea, int tempoMedioPercorrenza, MezzoDiTrasporto mezzoDiTrasporto) {
        this.id = uuid;
        this.zonaDiPartenza = zonaDiPartenza;
        this.capolinea = capolinea;
        this.tempoMedioPercorrenza = tempoMedioPercorrenza;
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


    @Override
    public String toString() {
        return "Tratta{" +
                "uuid=" + id +
                ", zonaDiPartenza='" + zonaDiPartenza + '\'' +
                ", capolinea='" + capolinea + '\'' +
                ", tempoMedioPercorrenza=" + tempoMedioPercorrenza +
                ", mezzoDiTrasporto="  +
                '}';
    }
}
