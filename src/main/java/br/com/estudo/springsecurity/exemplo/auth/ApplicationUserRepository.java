package br.com.estudo.springsecurity.exemplo.auth;

import java.util.Optional;

public interface ApplicationUserRepository {

	Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
