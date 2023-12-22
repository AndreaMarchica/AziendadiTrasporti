package BuildWeek1BETeam3.entities.DAO;

import BuildWeek1BETeam3.entities.Biglietto;
import BuildWeek1BETeam3.entities.TitoloDiViaggio;
import BuildWeek1BETeam3.entities.Tratta;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class TrattaDAO {
    private final EntityManager em;

    public TrattaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Tratta tratta) {
        try {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.persist(tratta);

            transaction.commit();

            System.out.println("tratta salvata nel database.");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Tratta getById(UUID id){
        Tratta found = em.find(Tratta.class, id);
        if(found == null){
            System.out.println("nessuna tratta trovato con quell'id");
        }
        return found;
    }


    public void delete(UUID id){
        Tratta found = this.getById(id);

        if(found != null){
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("tratta rimossa dal database");
        }else{
            System.out.println("tratta non trovata, sicuro che l'id sia corretto?");
        }
    }

/*    public Long contaPercorsi(UUID idMezzo){
        TypedQuery<Long> query = em.createNamedQuery("quanteVolteUnMezzoPercorreUnaTratta", Long.class );
        query.setParameter("mezzoId", idMezzo);
        return  query.getSingleResult();
    }*/

    public List<Tratta> getAll(){
        TypedQuery<Tratta> query = em.createQuery("SELECT t from Tratta t", Tratta.class);
        return query.getResultList();
    }
}
