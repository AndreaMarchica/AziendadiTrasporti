package BuildWeek1BETeam3.entities.DAO;

import BuildWeek1BETeam3.entities.TitoloDiViaggio;
import BuildWeek1BETeam3.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente) {
        try {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.persist(utente);

            transaction.commit();

            System.out.println("utente salvato nel database.");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Utente getById(UUID id){
        Utente found = em.find(Utente.class, id);
        if(found == null){
            System.out.println("nessun utente trovato con quell'id");
        }
        return found;
    }


    public void delete(UUID id){
        Utente found = this.getById(id);

        if(found != null){
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("utente rimosso dal database");
        }else{
            System.out.println("utente non trovato, sicuro che l'id sia corretto?");
        }
    }

    public List<Utente> getAll(){
        TypedQuery<Utente> query = em.createQuery("SELECT u from Utente u", Utente.class);
        return query.getResultList();
    }
}
