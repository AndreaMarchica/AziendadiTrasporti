package BuildWeek1BETeam3.entities.DAO;

import BuildWeek1BETeam3.entities.PuntoDiEmissione;
import BuildWeek1BETeam3.entities.Stato;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class StatoDao {
    private final EntityManager em;

    public StatoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Stato Stato) {
        try {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.persist(Stato);

            transaction.commit();

            System.out.println("Stato salvato nel database.");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Stato Stato) {
        try {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.merge(Stato);

            transaction.commit();

            System.out.println("Stato aggiornato nel database.");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Stato getById(UUID id) {
        Stato found = em.find(Stato.class, id);
        if (found == null) {
            System.out.println("nessun punto di emissione trovato con quell'id");
        }
        return found;
    }


    public void delete(UUID id) {
        Stato found = this.getById(id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("Stato rimosso dal database");
        } else {
            System.out.println("Stato non trovato, sicuro che l'id sia corretto?");
        }
    }

    public List<Stato> getAll() {
        TypedQuery<Stato> query = em.createQuery("SELECT p from Stato p", Stato.class);
        return query.getResultList();
    }
}

