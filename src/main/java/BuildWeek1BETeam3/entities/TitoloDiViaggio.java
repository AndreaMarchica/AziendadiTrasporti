package BuildWeek1BETeam3.entities;

import jdk.jfr.Name;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TitoloDiViaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    public TitoloDiViaggio(){}

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "TitoloDiViaggio{" +
                "uuid=" + uuid +
                '}';
    }
}
