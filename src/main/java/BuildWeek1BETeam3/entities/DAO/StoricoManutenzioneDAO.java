package BuildWeek1BETeam3.entities.DAO;

import BuildWeek1BETeam3.entities.MezzoDiTrasporto;
import BuildWeek1BETeam3.entities.StoricoManutenzione;
import BuildWeek1BETeam3.entities.TitoloDiViaggio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class StoricoManutenzioneDAO {
    private  EntityManager em;

    public StoricoManutenzioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(StoricoManutenzione storicoManutenzione) {
        try {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.persist(storicoManutenzione);

            transaction.commit();

            System.out.println("storico salvato nel database.");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public StoricoManutenzione getById(UUID id){
        StoricoManutenzione found = em.find(StoricoManutenzione.class, id);
        if(found == null){
            System.out.println("nessuno storico trovato con quell'id");
        }
        return found;
    }


    public void delete(UUID id){
        StoricoManutenzione found = this.getById(id);

        if(found != null){
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("storico rimosso dal database");
        }else{
            System.out.println("storico non trovato, sicuro che l'id sia corretto?");
        }
    }

    public void update(StoricoManutenzione storicoManutenzione) {
        try {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.merge(storicoManutenzione);

            transaction.commit();

            System.out.println("storico aggiornato nel database.");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

/*    public List<MezzoDiTrasporto> getAll(){
        TypedQuery<MezzoDiTrasporto> query = em.createQuery("SELECT m from MezzoDiTrasporto m", MezzoDiTrasporto.class);
        return query.getResultList();
    }

    public List<MezzoDiTrasporto> getAllOutOfService(){
        TypedQuery<MezzoDiTrasporto> query = em.createNamedQuery("getAllOutOfService", MezzoDiTrasporto.class);
        return query.getResultList();
    }*/
}
