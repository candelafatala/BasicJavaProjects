package com.candela.auth.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.candela.auth.models.User;
import com.candela.auth.repos.UserRepo;

@Service
public class UserService {
	
	private final UserRepo userRepository;
	public UserService(UserRepo userRepository) {
		this.userRepository = userRepository;
	}
	
	
	 // registrar el usuario y hacer Hash a su password
    public User registerUser(User user, BindingResult result) {
    	
    	User registeredUser = userRepository.findByEmail(user.getEmail());
    	
    	//verificar si el correo que ingresamos en el registro ya existe en la base de datos
    	if(registeredUser != null) { 
    		result.rejectValue("email", "Matches", "e-mail already exists");
    	}
    	
    	//ahora verificamos si la pw es igual a la confirmacion
    	if(!user.getPassword().equals(user.getPasswordConfirmation())) {
    		result.rejectValue("password", "Matches", "password must match");
    	}
    	
    	//devolvemos null si tienen un error definido en los atributos, luego de haber validado los errores anteriores
    	if(result.hasErrors()) {
    		return null;
    	}
    	
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
    
    // encontrar un usuario por su email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    // encontrar un usuario por su id
    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // autenticar usuario
    public boolean authenticateUser(String email, String password, BindingResult result) {
        
    	// primero encontrar el usuario por su email
        User registeredUser = userRepository.findByEmail(email);
        
        // si no lo podemos encontrar por su email, retornamos false
        if(registeredUser == null) {
        	result.rejectValue("email", "matches", "Invalid e-mail");
            return false;
        } else {
            
        	// si el password coincide devolvemos true, sino, devolvemos false
            if(BCrypt.checkpw(password, registeredUser.getPassword())) {
                return true;
            } else {
            	result.rejectValue("password", "matches", "Invalid password");
                return false;
            }
        }
    }
}
