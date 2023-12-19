package BuildWeek1BETeam3.entities.DAO;

import BuildWeek1BETeam3.entities.PuntoDiEmissione;
import BuildWeek1BETeam3.entities.TitoloDiViaggio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class PuntoDiEmissioneDAO {
    private final EntityManager em;

    public PuntoDiEmissioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(PuntoDiEmissione puntoDiEmissione) {
        try {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.persist(puntoDiEmissione);

            transaction.commit();

            System.out.println("punto di emissione salvato nel database.");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public PuntoDiEmissione getById(UUID id){
        PuntoDiEmissione found = em.find(PuntoDiEmissione.class, id);
        if(found == null){
            System.out.println("nessun punto di emissione trovato con quell'id");
        }
        return found;
    }


    public void delete(UUID id){
        PuntoDiEmissione found = this.getById(id);

        if(found != null){
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("punto di emissione rimosso dal database");
        }else{
            System.out.println("punto di emissione non trovato, sicuro che l'id sia corretto?");
        }
    }

    public List<PuntoDiEmissione> getAll(){
        TypedQuery<PuntoDiEmissione> query = em.createQuery("SELECT p from PuntoDiEmissione p", PuntoDiEmissione.class);
        return query.getResultList();
    }
}
