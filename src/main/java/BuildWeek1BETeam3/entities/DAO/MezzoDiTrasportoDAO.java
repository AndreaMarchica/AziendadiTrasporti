package BuildWeek1BETeam3.entities.DAO;

import BuildWeek1BETeam3.entities.MezzoDiTrasporto;
import BuildWeek1BETeam3.entities.TitoloDiViaggio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class MezzoDiTrasportoDAO {
    private final EntityManager em;

    public MezzoDiTrasportoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(MezzoDiTrasporto mezzoDiTrasporto) {
        try {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.persist(mezzoDiTrasporto);

            transaction.commit();

            System.out.println("mezzo di trasporto salvato nel database.");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public MezzoDiTrasporto getById(UUID id){
        MezzoDiTrasporto found = em.find(MezzoDiTrasporto.class, id);
        if(found == null){
            System.out.println("nessun mezzo di trasporto trovato con quell'id");
        }
        return found;
    }


    public void delete(UUID id){
        MezzoDiTrasporto found = this.getById(id);

        if(found != null){
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("mezzo di trasporto rimosso dal database");
        }else{
            System.out.println("mezzo di trasporto non trovato, sicuro che l'id sia corretto?");
        }
    }

    public List<MezzoDiTrasporto> getAll(){
        TypedQuery<MezzoDiTrasporto> query = em.createQuery("SELECT m from MezzoDiTrasporto m", MezzoDiTrasporto.class);
        return query.getResultList();
    }
}
