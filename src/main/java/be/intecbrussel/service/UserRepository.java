package be.intecbrussel.service;

import be.intecbrussel.model.UserEntity;
import be.intecbrussel.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

public class UserRepository {
    public void create ( UserEntity user ){

        final EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
        final EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        em.close();
    }

    public void createAll(List<UserEntity> users){

        final EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
        final EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        for (UserEntity u : users){
            em.persist(u);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void updateFullNameById(final Long id,
                                   final String firstName,
                                   final String middelName,
                                   final String lastName){

        final EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
        final EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        final UserEntity foundUser = em.find(UserEntity.class, id);

        foundUser.setFName(firstName);
        foundUser.setMName(middelName);
        foundUser.setLName(lastName);

        em.getTransaction().commit();
        em.close();

    }

    public void updateEmailById(Long id , String email){

        final EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
        final EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        UserEntity foundUser = em.find(UserEntity.class, id);
        foundUser.setEmail(email);
        em.getTransaction().commit();
        em.close();
    }


    public void deleteById(Long id){

        final EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
        final EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        UserEntity foundUser = em.find(UserEntity.class, id);
        if (foundUser != null){
            em.remove(foundUser);
        }
        transaction.commit();
        em.close();

    }

    public Optional<UserEntity> findById(Long id){
        final EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
        final EntityManager em = factory.createEntityManager();
        UserEntity foundUser = em.find(UserEntity.class, id);
        em.close();
        return Optional.ofNullable(foundUser);
    }

    public List<UserEntity> findAll(){
        final EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
        final EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("SELECT u FROM UserEntity u");
        List<UserEntity> users = query.getResultList();
        // Alternative CRITERIA API
       /* CriteriaQuery<UserEntity> criteria = em.getCriteriaBuilder().createQuery(UserEntity.class);
        Query query = em.createQuery(criteria);
        List<UserEntity> users = query.getResultList();*/
        em.close();
        return users;
    }

    public Boolean existsByEmail(String email){

        final EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
        final EntityManager em = factory.createEntityManager();
        Query query = em.createQuery ( "SELECT u FROM UserEntity u WHERE u.email LIKE :email " );
        query.setParameter("email", email);
        if (query.getResultList().size() == 0){
            //if (! query.getResultList().equals(email)){
            throw new RuntimeException("the email doesn't exist");
        }

        return true;
    }

    public Boolean isActiveByEmail(String email){
        final EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
        final EntityManager em = factory.createEntityManager();
        Query query = em.createQuery ( "SELECT u FROM UserEntity u WHERE u.email LIKE :email AND u.active = true " );
        query.setParameter("email", email);
        if (query.getResultList().size() == 0){
            throw new RuntimeException("the email isn't actif");
        }

        return true;

    }
}
