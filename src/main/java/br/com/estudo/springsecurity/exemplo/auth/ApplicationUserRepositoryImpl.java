package br.com.estudo.springsecurity.exemplo.auth;

import static br.com.estudo.springsecurity.exemplo.security.ApplicationUserRole.ADMIN;
import static br.com.estudo.springsecurity.exemplo.security.ApplicationUserRole.ADMINTRAINEE;
import static br.com.estudo.springsecurity.exemplo.security.ApplicationUserRole.STUDENT;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository("fake")
public class ApplicationUserRepositoryImpl implements ApplicationUserRepository {

	private static final String PASSWORD = "password";

	private final PasswordEncoder passwordEncoder;

	@Autowired
	public ApplicationUserRepositoryImpl(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
		return getApplicationUsers().stream().filter(applicationUser -> username.equals(applicationUser.getUsername()))
				.findFirst();
	}

	private List<ApplicationUser> getApplicationUsers() {
		return List.of(
				new ApplicationUser("thiago", passwordEncoder.encode(PASSWORD), STUDENT.grantedAuthorities(), true,
						true, true, true),
				new ApplicationUser("marcela", passwordEncoder.encode(PASSWORD), ADMIN.grantedAuthorities(), true, true,
						true, true),
				new ApplicationUser("heitor", passwordEncoder.encode(PASSWORD), ADMINTRAINEE.grantedAuthorities(), true,
						true, true, true));

	}
}
