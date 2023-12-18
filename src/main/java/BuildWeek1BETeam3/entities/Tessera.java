package BuildWeek1BETeam3.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
public class Tessera {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_tessera;

    @OneToOne
    private Utente  utente;

    @Column(name = "data_emissione")
    private LocalDate data_emissione;

    @Column(name  = "data_scadenza")
    private LocalDate data_scadenza;

    @OneToMany(mappedBy = "tessera")
    private List<Abbonamento> abbonamenti = new ArrayList<>();



    // aggiungere abbonamento id
    // aggiugnere rivenditoreID
    //rinnovo()

    public Tessera(){}
    public Tessera(Utente utente) {
        this.utente = utente;
    }

    public UUID getId_tessera() {
        return id_tessera;
    }

    public Utente getUtente() {
        return utente;
    }

    public LocalDate getData_emissione() {
        return data_emissione;
    }

    public LocalDate getData_scadenza() {
        return data_scadenza;
    }

    @Override
    public String toString() {
        return "Tessera{" +
                "id_tessera=" + id_tessera +
                ", utente=" + utente +
                ", data_emissione=" + data_emissione +
                ", data_scadenza=" + data_scadenza +
                '}';
    }
}
