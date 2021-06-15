/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Logic.AppointmentInfo;
import Persistence.exceptions.NonexistentEntityException;
import Persistence.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author joch_
 */
public class AppointmentInfoJpaController implements Serializable {
    
    public AppointmentInfoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    private EntityManagerFactory emf = null;
    
    public AppointmentInfoJpaController() {
        emf = Persistence.createEntityManagerFactory("Mejia_Jose_tpo2_PU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void create(AppointmentInfo appointmentInfo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(appointmentInfo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAppointmentInfo(appointmentInfo.getClient_num()) != null) {
                throw new PreexistingEntityException("AppointmentInfo " + appointmentInfo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void edit(AppointmentInfo appointmentInfo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            appointmentInfo = em.merge(appointmentInfo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = appointmentInfo.getClient_num();
                if (findAppointmentInfo(id) == null) {
                    throw new NonexistentEntityException("The appointmentInfo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AppointmentInfo appointmentInfo;
            try {
                appointmentInfo = em.getReference(AppointmentInfo.class, id);
                appointmentInfo.getClient_num();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The appointmentInfo with id " + id + " no longer exists.", enfe);
            }
            em.remove(appointmentInfo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<AppointmentInfo> findAppointmentInfoEntities() {
        return findAppointmentInfoEntities(true, -1, -1);
    }
    
    public List<AppointmentInfo> findAppointmentInfoEntities(int maxResults, int firstResult) {
        return findAppointmentInfoEntities(false, maxResults, firstResult);
    }
    
    private List<AppointmentInfo> findAppointmentInfoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AppointmentInfo.class));
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
    
    public AppointmentInfo findAppointmentInfo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AppointmentInfo.class, id);
        } finally {
            em.close();
        }
    }
    
    public int getAppointmentInfoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AppointmentInfo> rt = cq.from(AppointmentInfo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
