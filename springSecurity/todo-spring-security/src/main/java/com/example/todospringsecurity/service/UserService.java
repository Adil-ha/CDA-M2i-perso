package com.example.todospringsecurity.service;

import com.example.todospringsecurity.config.jwt.JwtTokenProvider;
import com.example.todospringsecurity.entity.User;
import com.example.todospringsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // Injection du gestionnaire d'authentification pour authentifier les utilisateurs.
    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;

    // Injection du fournisseur de token JWT pour générer des tokens JWT.
    @Autowired
    private JwtTokenProvider tokenProvider;

    // Injection du encodeur de mot de passe pour chiffrer les mots de passe des utilisateurs.
    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Méthode pour vérifier si un utilisateur est valide en comparant le mot de passe donné avec celui enregistré.
    public boolean verifyUser(String email, String password) {
        return userRepository.findByEmail(email)
                .map(user -> passwordEncoder.matches(password, user.getPassword()))
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }

    // Méthode pour vérifier si un nom d'utilisateur (email) existe déjà dans la base de données.
    public boolean checkUserNameExists(String email){
        return userRepository.findByEmail(email).isPresent();
    }

    // Méthode pour générer un token JWT après avoir authentifié un utilisateur.
    public String generateToken(String email, String password){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenProvider.generateToken(authentication);
        return token;
    }

    // Méthode pour créer un nouvel utilisateur, avec le mot de passe chiffré, et le sauvegarder dans la base de données.
    public boolean createUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    // Méthode pour charger les détails de l'utilisateur par son email. Utilisée par Spring Security pour l'authentification.
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }


}
