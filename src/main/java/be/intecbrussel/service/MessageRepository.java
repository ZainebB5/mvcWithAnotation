package be.intecbrussel.service;

import be.intecbrussel.model.MessageEntity;
import be.intecbrussel.model.UserEntity;
import be.intecbrussel.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

public class MessageRepository {

    public void create(MessageEntity message){
        final EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
        final EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(message);
        em.getTransaction().commit();
        em.close();
    }

    public void updateSubjectAndContentById ( Long id, String subject, String content ) {

        final EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
        final EntityManager em = factory.createEntityManager();
        MessageEntity foundMessage = em.find(MessageEntity.class, id);
        foundMessage.setSubject(subject);
        foundMessage.setContent(content);
        em.getTransaction().commit();
        em.close();

    }

    public void delete ( Long id) {
        final EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
        final EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        MessageEntity foundMessage = em.find(MessageEntity.class, id);
        em.remove(foundMessage);
        em.getTransaction().commit();
        em.close();

    }

    public Optional<MessageEntity> findById (Long id ) {

        final EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
        final EntityManager em = factory.createEntityManager();
        MessageEntity foundMessage = em.find(MessageEntity.class, id);

        em.close();
        return Optional.ofNullable(foundMessage);
    }

    /*public List<MessageEntity> findMessageBySender (Long senderId) {
        if (senderId == null){
            throw new MessageException("Id is required ! ");
        }
        final EntityManager em = super.getFactory().createEntityManager();
        Query query = em.createQuery("SELECT u FROM MessageEntity m join UserEntity u where m.sender.id = senderId ");//, UserEntity.class);
        query.setParameter("senderId", senderId);
        List < MessageEntity > messages = query.getResultList ( );
        return messages;
    }*/

}