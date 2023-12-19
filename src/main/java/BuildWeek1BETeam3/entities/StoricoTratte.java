package BuildWeek1BETeam3.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class StoricoTratte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_StoricoTratte;

    @OneToMany(mappedBy = "storicoTratte")
    private List<Tratta> storicoTratte = new ArrayList<>();

    public UUID getId_StoricoTratte() {
        return id_StoricoTratte;
    }

    public List<Tratta> getStoricoTratte() {
        return storicoTratte;
    }

    public StoricoTratte() {
    }
}
