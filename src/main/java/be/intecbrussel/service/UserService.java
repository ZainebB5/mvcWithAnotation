package be.intecbrussel.service;

import be.intecbrussel.model.UserEntity;
import be.intecbrussel.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import javax.swing.*;
import java.util.IllegalFormatCodePointException;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public boolean login(final String email, final String hashedPassword) {


        // TODO: controleer of de gebruikersnaam en het wachtwoord klopt zijn
        final EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
        final EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("SELECT u FROM UserEntity u WHERE u.email LIKE :email AND u.hashedPassword LIKE :hashedPassword");
        query.setParameter("email", email);
        query.setParameter("hashedPassword", hashedPassword);


        // TODO: als alles klopt, geef true terug
        return true;
    }

    public boolean register(UserEntity user) {
        userRepository.create(user);
        System.out.println("User whit email : " + user.getEmail() + " already registred !");
        return true;
    }
}