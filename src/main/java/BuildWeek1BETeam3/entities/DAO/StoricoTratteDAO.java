package BuildWeek1BETeam3.entities.DAO;


import BuildWeek1BETeam3.entities.StoricoTratte;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class StoricoTratteDAO {

    private EntityManager em;

    public StoricoTratteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(StoricoTratte StoricoTratte) {
        try {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.persist(StoricoTratte);

            transaction.commit();

            System.out.println("Aggiunto allo storico");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public StoricoTratte getById(UUID id) {
        StoricoTratte found = em.find(StoricoTratte.class, id);
        if (found == null) {
            System.out.println("nessun mezzo di trasporto trovato con quell'id");
        }
        return found;
    }


    public void delete(UUID id) {
        StoricoTratte found = this.getById(id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("Lo storico rimosso dal database");
        } else {
            System.out.println("Storico non trovato, sicuro che l'id sia corretto?");
        }
    }

    public List<StoricoTratte> getAll() {
        TypedQuery<StoricoTratte> query = em.createQuery("SELECT m from StoricoTratte m", StoricoTratte.class);
        return query.getResultList();
    }
}


