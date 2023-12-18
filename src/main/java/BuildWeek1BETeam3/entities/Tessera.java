package BuildWeek1BETeam3.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

public class Tessera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id_utente;

    @Column( name = "utente_id")
    private Utente  utente;

    @Column(name = "data_emissione")
    private LocalDate data_emissione;

    @Column(name  = "data_scadenza")
    private LocalDate data_scadenza;

    // aggiungere abbonamento id
    // aggiugnere rivenditoreID
    //rinnovo()

}
