package BuildWeek1BETeam3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RivenditoreAutomatico extends PuntoDiEmissione{

    @Column(name = "in_servizio", nullable = false)
    private static boolean in_servizio;


    public RivenditoreAutomatico(Boolean _in_servizio) {
        in_servizio = _in_servizio;
    }
    public RivenditoreAutomatico() {
    }
    public RivenditoreAutomatico(String luogo, boolean _in_servizio) {
        super(luogo);
        in_servizio = _in_servizio;
    }

    public static boolean isIn_servizio() {
        return in_servizio;
    }

    public void setIn_servizio(boolean _in_servizio) {
        in_servizio = _in_servizio;
    }

    public Biglietto stampaBiglietto() {
        if(!in_servizio){
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

    @Override
    public String toString() {
        return "RivenditoreAutomatico{" +
                "in_servizio=" + in_servizio +
                ", luogo='" + luogo + '\'' +
                '}';
    }
}
