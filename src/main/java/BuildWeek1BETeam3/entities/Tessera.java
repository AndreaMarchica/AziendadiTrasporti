package BuildWeek1BETeam3.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NamedQuery(
        name = "abbonamentiValidi",
        query = "SELECT a FROM Tessera t JOIN t.abbonamenti a " +
                "WHERE t.id = :tesseraId AND a.scadenza > CURRENT_DATE"
)
public class Tessera {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_tessera;

    @OneToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @Column(name = "data_emissione")
    private LocalDate data_emissione;

    @Column(name  = "data_scadenza")
    private LocalDate data_scadenza;

    @OneToMany(mappedBy = "tessera")
    private List<Abbonamento> abbonamenti = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "rivenditore_id")
    private RivenditoreAutorizzato rivenditore;


    public Tessera(){}
    public Tessera(Utente utente) {
        this.utente = utente;
        this.data_emissione = LocalDate.now();
        this.data_scadenza = LocalDate.now().plusYears(1);
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
        return data_scadenza.plusYears(1);
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


    //rinnovo() tessera
    public boolean isTesseraValida() {
        LocalDate oggi = LocalDate.now();
            if (getData_scadenza().isAfter(oggi)) {
                return true;
                //tessera valida
            }else { return false;
            }
        }
    public void rinnovo() {
        if (!isTesseraValida()) {
              LocalDate nuovaScadenza = LocalDate.now().plusYears(1);
            this.data_scadenza = nuovaScadenza;
            System.out.println("Tessera rinnovata, nuova scadenza: " + nuovaScadenza);
        } else {
            System.out.println("Tessera è ancora valida, data di scadenza: " + getData_scadenza() );
        }
    }


    // aggiugnere rivenditoreID
    public Tessera(Utente utente, RivenditoreAutorizzato rivenditore) {
        this.utente = utente;
        this.rivenditore = rivenditore;
    }

    public RivenditoreAutorizzato getRivenditore() {
        return rivenditore;
    }

    public void setId_tessera(UUID id_tessera) {
        this.id_tessera = id_tessera;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public void setData_emissione(LocalDate data_emissione) {
        this.data_emissione = data_emissione;
    }

    public void setData_scadenza(LocalDate data_scadenza) {
        this.data_scadenza = data_scadenza;
    }

    public List<Abbonamento> getAbbonamenti() {
        return abbonamenti;
    }

    public void setAbbonamenti(List<Abbonamento> abbonamenti) {
        this.abbonamenti = abbonamenti;
    }

    public void setRivenditore(RivenditoreAutorizzato rivenditore) {
        this.rivenditore = rivenditore;
    }
}
