package BuildWeek1BETeam3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RivenditoreAutomatico extends PuntoDiEmissione{

    @Column(name = "in_servizio")
    public static boolean in_servizio;


    public RivenditoreAutomatico(boolean in_servizio) {
        this.in_servizio = in_servizio;
    }
    public RivenditoreAutomatico() {
    }
    public RivenditoreAutomatico(String luogo, boolean in_servizio) {
        super(luogo);
        this.in_servizio = in_servizio;
    }

    public static boolean isIn_servizio() {
        return in_servizio;
    }

    public void setIn_servizio(boolean in_servizio) {
        this.in_servizio = in_servizio;
    }

    public Biglietto stampaBiglietto() {
        if(!RivenditoreAutomatico.isIn_servizio()){
            System.out.println("Rivenditore automatico fuori servizio!");
        } else {
            Biglietto b = new Biglietto();
            List<TitoloDiViaggio> listaBiglietti = getTitoliDiViaggio();
            if(listaBiglietti == null){
                listaBiglietti = new ArrayList<>();
            }
            listaBiglietti.add(b);
            setTitoliDiViaggio(listaBiglietti);
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
