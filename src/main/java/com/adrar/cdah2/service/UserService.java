package com.adrar.cdah2.service;

import com.adrar.cdah2.exception.NoUserFoundException;
import com.adrar.cdah2.exception.SaveUserExistException;
import com.adrar.cdah2.exception.UserNotFoundException;
import com.adrar.cdah2.model.User;
import com.adrar.cdah2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Récupére tous les comptes utilisateurs
    public Iterable<User> findAllUsers() {
        if (userRepository.count() == 0) {
            throw new NoUserFoundException();
        }
        return userRepository.findAll();
    }

    //récupére un compte utilisateur par son id
    public User findUserById(Integer id) {
        if(!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        return userRepository.findById(id).get();
    }

    //Ajouter un compte utilisateur
    public User saveUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new SaveUserExistException(user);
        }
        return userRepository.save(user);
    }


}
