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

    @OneToMany(mappedBy = "storicoManutenzione")
    private List<MezzoDiTrasporto> listaMezziInManutenzione = new ArrayList<>();
    @OneToMany(mappedBy = "storicoManutenzioni")
    private List<Stato> storicoManutenzioni = new ArrayList<>();

    public StoricoManutenzione(){}

    public StoricoManutenzione(MezzoDiTrasporto mezzoDiTrasporto){
        listaMezziInManutenzione.add(mezzoDiTrasporto);
    }

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

    public void aggiungiStato(Stato stato) {
        this.storicoManutenzioni.add(stato);
    }
    public void rimuoviStato(Stato stato) {
        this.storicoManutenzioni.remove(stato);
    }

    public List<MezzoDiTrasporto> getListaMezziInManutenzione() {
        return listaMezziInManutenzione;
    }

    public void setListaMezziInManutenzione(List<MezzoDiTrasporto> listaMezziInManutenzione) {
        this.listaMezziInManutenzione = listaMezziInManutenzione;
    }

    @Override
    public String toString() {
        return "StoricoManutenzione{" +
                "id_StoricoManutenzioni=" + id_StoricoManutenzioni +
                ", storicoManutenzioni=" + storicoManutenzioni +
                '}';
    }
}
