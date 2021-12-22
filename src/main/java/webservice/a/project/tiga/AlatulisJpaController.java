/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webservice.a.project.tiga;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import webservice.a.project.tiga.exceptions.NonexistentEntityException;
import webservice.a.project.tiga.exceptions.PreexistingEntityException;

/**
 *
 * @author User
 */
public class AlatulisJpaController implements Serializable {

    public AlatulisJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("webservice.a_project.tiga_jar_0.0.1-SNAPSHOTPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public AlatulisJpaController() {
    }
    

    public void create(Alatulis alatulis) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(alatulis);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAlatulis(alatulis.getId()) != null) {
                throw new PreexistingEntityException("Alatulis " + alatulis + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Alatulis alatulis) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            alatulis = em.merge(alatulis);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = alatulis.getId();
                if (findAlatulis(id) == null) {
                    throw new NonexistentEntityException("The alatulis with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alatulis alatulis;
            try {
                alatulis = em.getReference(Alatulis.class, id);
                alatulis.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The alatulis with id " + id + " no longer exists.", enfe);
            }
            em.remove(alatulis);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Alatulis> findAlatulisEntities() {
        return findAlatulisEntities(true, -1, -1);
    }

    public List<Alatulis> findAlatulisEntities(int maxResults, int firstResult) {
        return findAlatulisEntities(false, maxResults, firstResult);
    }

    private List<Alatulis> findAlatulisEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Alatulis.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Alatulis findAlatulis(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Alatulis.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlatulisCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Alatulis> rt = cq.from(Alatulis.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
