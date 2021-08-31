package br.com.estudo.springsecurity.exemplo.security;

import static br.com.estudo.springsecurity.exemplo.security.ApplicationUserPermission.COURSE_READ;
import static br.com.estudo.springsecurity.exemplo.security.ApplicationUserPermission.COURSE_WRITE;
import static br.com.estudo.springsecurity.exemplo.security.ApplicationUserPermission.STUDENT_READ;
import static br.com.estudo.springsecurity.exemplo.security.ApplicationUserPermission.STUDENT_WRITE;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum ApplicationUserRole {
	STUDENT(Set.of()), ADMIN(Set.of(STUDENT_READ, STUDENT_WRITE, COURSE_READ, COURSE_WRITE)),
	ADMINTRAINEE(Set.of(STUDENT_READ, COURSE_READ));

	private final Set<ApplicationUserPermission> permissions;

	ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
		this.permissions = permissions;
	}

	public Set<ApplicationUserPermission> getPermissions() {
		return permissions;
	}

	public Set<SimpleGrantedAuthority> grantedAuthorities() {
		Set<SimpleGrantedAuthority> permission = getPermissions().stream()
				.map(p -> new SimpleGrantedAuthority(p.getPermission())).collect(Collectors.toSet());

		permission.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

		return permission;
	}
}
