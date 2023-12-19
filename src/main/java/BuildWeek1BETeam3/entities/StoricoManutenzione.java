package BuildWeek1BETeam3.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class StoricoManutenzione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_StoricoManutenzioni;

    @OneToMany(mappedBy = "storicoManutenzioni")
    private List<Stato> storicoManutenzioni = new ArrayList<>();

    public UUID getId_StoricoManutenzioni() {
        return id_StoricoManutenzioni;
    }
    public void setId_StoricoManutenzioni(UUID id_StoricoManutenzioni) {
        this.id_StoricoManutenzioni = id_StoricoManutenzioni;
    }

    public List<Stato> getStoricoManutenzioni() {
        return storicoManutenzioni;
    }
    public void setStoricoManutenzioni(List<Stato> storicoManutenzioni) {
        this.storicoManutenzioni = storicoManutenzioni;
    }

    public StoricoManutenzione(){
    }
}
