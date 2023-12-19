package BuildWeek1BETeam3.entities;

import jdk.jfr.Name;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TitoloDiViaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "puntodiemissione_id")
    private PuntoDiEmissione puntodiemissione;

    @ManyToOne
    @JoinColumn(name = "mezzoditrasporto_id")
    private MezzoDiTrasporto mezzoditrasporto;

    public TitoloDiViaggio(){}

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "TitoloDiViaggio{" +
                "uuid=" + uuid +
                '}';
    }


    public PuntoDiEmissione getPuntodiemissione() {
        return puntodiemissione;
    }

    public void setPuntodiemissione(PuntoDiEmissione puntodiemissione) {
        this.puntodiemissione = puntodiemissione;
    }

    public MezzoDiTrasporto getMezzoditrasporto() {
        return mezzoditrasporto;
    }

    public void setMezzoditrasporto(MezzoDiTrasporto mezzoditrasporto) {
        this.mezzoditrasporto = mezzoditrasporto;
    }
}
