package BuildWeek1BETeam3.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("abbonamento")
public class Abbonamento extends TitoloDiViaggio{

    @ManyToOne
    private Tessera tessera;

    private LocalDate emissione;
    @Enumerated(EnumType.STRING)
    private VALIDITA validita;
    private LocalDate scadenza;

    public Abbonamento(){}

    public Abbonamento(Tessera tessera, VALIDITA validita) {
        this.tessera = tessera;
        this.validita = validita;
        this.emissione = LocalDate.now();
        if(validita.equals(VALIDITA.SETTIMANALE)){
            this.scadenza = LocalDate.now().plusDays(7);
        }else {
            this.scadenza = LocalDate.now().plusDays(28);
        }
    }

    public Tessera getTessera() {
        return tessera;
    }

    public LocalDate getEmissione() {
        return emissione;
    }

    public VALIDITA getValidita() {
        return validita;
    }

    public LocalDate getScadenza() {
        return scadenza;
    }

    @Override
    public String toString() {
        return "Abonamento{" +
                "tessera=" + tessera +
                ", emissione=" + emissione +
                ", validita=" + validita +
                ", scadenza=" + scadenza +
                '}';
    }
}
