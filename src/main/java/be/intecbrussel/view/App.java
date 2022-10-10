package be.intecbrussel.view;

import be.intecbrussel.model.MessageEntity;
import be.intecbrussel.model.UserEntity;

import be.intecbrussel.service.MessageRepository;
import be.intecbrussel.service.UserRepository;
import be.intecbrussel.service.UserService;
import be.intecbrussel.util.ValidationUtil;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.lang.System.out;

public class App {
    private static final UserRepository userRepository = new UserRepository();
    private static final UserService userService = new UserService();
    private static final MessageRepository messageRepository = new MessageRepository();


    public static void main(String[] args) {

        UserEntity u1 = new UserEntity();
        ValidationUtil<UserEntity> userValidator = new ValidationUtil<>();

        u1.setfName("Amnina");
        u1.setlName("Bak");
        u1.setEmail("Amnina@jhfl.mail");
        u1.setHashedPassword("A1b23456");
        u1.setValidation("123456");
        u1.setActive(true);

//        final boolean isValid = userValidator.ValidateEntity ( u1 );
//        System.out.println ( "Is the first user valid: " + isValid );
//        userRepository.create ( u1 );

        UserEntity u2 = new UserEntity();
        u2.setfName("Sakina");
        u2.setlName("Bak");
        u2.setEmail("Sakina@gmail.be");
        u2.setHashedPassword("A1b23456");
        u2.setValidation("12345678");
        u2.setActive(true);

        UserEntity u3 = new UserEntity();
        u3.setlName("Kawthar");
        u3.setfName("Bak");
        u3.setEmail("Kawthar@gmail.be");
        u3.setHashedPassword("A1b23456");
        u3.setValidation("12345678");
        u3.setActive(false);

        UserEntity u4 = new UserEntity();
        u3.setfName("Zahra");
        u3.setfName("Bak");
        u3.setEmail("Kawthar@gmail.be");
        u3.setHashedPassword("A1b23456");
        u3.setValidation("12345678");
        u3.setActive(true);

        UserEntity u5 = new UserEntity();
        u3.setfName("Hassan");
        u3.setfName("Bak");
        u3.setEmail("Hassan@gmail.be");
        u3.setHashedPassword("A1b23456");
        u3.setValidation("12345678");
        u3.setActive(true);


        List<UserEntity> userEntityList = new ArrayList<>();
        userEntityList.add(u1);
        userEntityList.add(u2);
        userEntityList.add(u3);
        userEntityList.add(u4);
        userEntityList.add(u5);
        long noOfConstraintViolations = userValidator.validateList(userEntityList);

        out.println("There are " + noOfConstraintViolations + " violations in the list.");

//        userRepository.create ( u2 );
//        userRepository.create ( u3);
//        out.println("##".repeat(30));
//        List<UserEntity> users = userRepository.findAll();
//        for(UserEntity u : users){
//            out.println(u.getEmail());
//        }



        /*Set<ConstraintViolation<UserEntity>> violations = validator.validate(u1);
        for (ConstraintViolation<UserEntity> v : violations) {
            out.println(v.getMessage());
        }*/

        /*MessageEntity m1 = new MessageEntity();
        m1.setSender(u1);
        m1.setSubject("test");
        m1.setContent("intectest");
        m1.setActive(true);
        m1.setLikesCount(3);
        m1.setViewsCount(4);
        messageRepository.create(m1);
        out.println("##".repeat(30));

        //out.println(messageRepository.findById(null));;


        out.println("##".repeat(30));
        out.println("Exist by email : " + userRepository.existsByEmail("Kawthar@gmail.be"));
        out.println("##".repeat(30));
        out.println("Active by email : " + userRepository.isActiveByEmail("Sakina@gmail.be"));
        out.println("##".repeat(30));
        UserService userService = new UserService();
        userService.login("Kawthar@gmail.be", "A1b23456");*/


    }
}
