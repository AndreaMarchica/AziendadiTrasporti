package BuildWeek1BETeam3.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "abonamento")
public class Abonamento extends TitoloDiViaggio{
    private Tessera tessera;

    private LocalDate emissione = LocalDate.now();
    @Enumerated(EnumType.STRING)
    private VALIDITA validita;
    private LocalDate scadenza;

    public Abonamento(){}

    public Abonamento(Tessera tessera, VALIDITA validita) {
        this.tessera = tessera;
        this.validita = validita;
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
