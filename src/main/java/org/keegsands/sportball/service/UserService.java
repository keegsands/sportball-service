package org.keegsands.sportball.service;

import org.keegsands.sportball.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends SimpleService<User>, UserDetailsService {

}
