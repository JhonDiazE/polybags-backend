package com.model.sistem.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.model.sistem.entities.Usuario;
import com.model.sistem.service.UsuarioService;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    
    @Autowired
    private UsuarioService usuarioService;
       
   
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
    	if (username == null || username.trim().isEmpty()) {
    		throw new UsernameNotFoundException("Username vacio");
    	}
    	
    	Usuario user = usuarioService.findByNick(username);
        if (user == null) {
            throw new UsernameNotFoundException("Credenciales no válidas");
        } 
          
        String[] roles = {"ROLE_ADMIN", "ROLE_USER"}; //user.getRoleNames()  

        Collection<GrantedAuthority> grantedAuthorities = toGrantedAuthorities(Arrays.asList(roles));
        String password = user.getClave();
        boolean enabled = "A".equals(user.getEstado())?true:false;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        return new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
    }     

    private Collection<GrantedAuthority> toGrantedAuthorities(List<String> roles) {
          List<GrantedAuthority> result = new ArrayList();
          for (String role : roles) {
              result.add(new SimpleGrantedAuthority(role));
          }
  
          return result;
  }
    
}
