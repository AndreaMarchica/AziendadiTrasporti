package BuildWeek1BETeam3.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
//@NamedQuery(name = "Tessera.isAbbonamentoValidoById", query = "SELECT t.isAbbonamentoValido FROM Tessera t WHERE t.id_tessera = :idTessera")
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

    @ManyToOne
    @JoinColumn(name = "rivenditore_id")
    private RivenditoreAutorizzato rivenditore;



    // aggiungere abbonamento id



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


    //verifica se l'abbonamento è valido
    public boolean isAbbonamentoValido() {
        LocalDate oggi = LocalDate.now();
        for (Abbonamento abbonamento : abbonamenti) {
            if (abbonamento.getScadenza().isAfter(oggi)) {
                return true;
                //almeno 1  abbonamento valido
            }
        }
        return false;
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

}
