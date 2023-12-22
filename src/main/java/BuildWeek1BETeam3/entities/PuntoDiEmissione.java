package BuildWeek1BETeam3.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_prodotto")
public abstract class PuntoDiEmissione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codice_ID;

    @Column(name = "Luogo")
    public String luogo;

    @OneToMany(mappedBy = "puntodiemissione")
    private List<TitoloDiViaggio> titoliDiViaggio;


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

    public List<TitoloDiViaggio> getTitoliDiViaggio() {
        return titoliDiViaggio;
    }

    public void setTitoliDiViaggio(List<TitoloDiViaggio> titoliDiViaggio) {
        this.titoliDiViaggio = titoliDiViaggio;
    }

    public Biglietto stampaBiglietto(RivenditoreAutomatico rivenditoreAutomatico) {
        if(!rivenditoreAutomatico.isIn_servizio()){
            System.out.println("Rivenditore automatico fuori servizio!");
        } else {
            //crea un biglietto
            Biglietto b = new Biglietto();
            //crea una lista di biglietti partendo dalla lista dei titoli di viaggio presenti (se presenti)
            List<TitoloDiViaggio> listaBiglietti = getTitoliDiViaggio();
            if(listaBiglietti == null){
                //se non erano presenti titoli di viaggio creo una lista vuota
                listaBiglietti = new ArrayList<>();
            }
            //aggiungo alla lista il biglietto appena creato
            listaBiglietti.add(b);
            //imposto la lista "titoli di viaggio" nella classe padre PuntoDiEmissione con la lista alla quale abbiamo aggiunto il nuovo biglietto
            setTitoliDiViaggio(listaBiglietti);
            //imposto il punto di emissione del biglietto con "this",
            //in questo modo sto passando un riferimento alla classe corrente
            b.setPuntodiemissione(this);
            return b;
        }
        return null;
    }

    public Biglietto stampaBiglietto(RivenditoreAutorizzato rivenditoreAutorizzato) {

            Biglietto b = new Biglietto();
            titoliDiViaggio.add(b);
            return b;
    }

    public Abbonamento stampaAbbonamento(RivenditoreAutomatico rivenditoreAutomatico) {
        if(!rivenditoreAutomatico.isIn_servizio()){
            System.out.println("Rivenditore fuori servizio!");
        } else {
            //crea un abbonamento
            Abbonamento a = new Abbonamento();
            //crea una lista di biglietti partendo dalla lista dei titoli di viaggio presenti (se presenti)
            List<TitoloDiViaggio> listaAbbonamenti = getTitoliDiViaggio();
            if(listaAbbonamenti == null){
                //se non erano presenti titoli di viaggio creo una lista vuota
                listaAbbonamenti = new ArrayList<>();
            }
            //aggiungo alla lista il biglietto appena creato
            listaAbbonamenti.add(a);
            //imposto la lista "titoli di viaggio" nella classe padre PuntoDiEmissione con la lista alla quale abbiamo aggiunto il nuovo biglietto
            setTitoliDiViaggio(listaAbbonamenti);
            //imposto il punto di emissione del biglietto con "this",
            //in questo modo sto passando un riferimento alla classe corrente
            a.setPuntodiemissione(rivenditoreAutomatico);
            return a;
        }
        return null;
    }

    public Abbonamento stampaAbbonamento(RivenditoreAutorizzato rivenditoreAutorizzato) {

        Abbonamento a = new Abbonamento();
        titoliDiViaggio.add(a);
        return a;
    }

    public Abbonamento stampaAbbonamento(Tessera tessera, VALIDITA validita) {
        return new Abbonamento();
    }
}
