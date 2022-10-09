package be.intecbrussel.service;

import be.intecbrussel.model.RoleEntity;
import be.intecbrussel.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.Optional;

public class RoleRepository {


    public void create(RoleEntity role){
        final EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
        final EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(role);
        em.getTransaction().commit();
        em.close();
    }
    public void updateTitleAndDescriptionById ( Long id ,String title, String description ) {

        final EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
        final EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        final RoleEntity foundRole = em.find(RoleEntity.class, id);
        foundRole.setTitle(title);
        foundRole.setDescription(description);
        em.getTransaction().commit();
        em.close();

    }

    public void delete ( Long id) {

        final EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
        final EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        final RoleEntity foundRole = em.find(RoleEntity.class, id);
        em.remove(foundRole);
        em.getTransaction().commit();
        em.close();
    }

    public Optional<RoleEntity> findById (Long id ) {
        final EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
        final EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        final RoleEntity foundRole = em.find(RoleEntity.class, id);
        em.getTransaction().commit();
        return Optional.ofNullable(foundRole);

    }

}