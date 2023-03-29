package de.allianz.training.roles;

import de.allianz.training.permissions.Permissions;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static de.allianz.training.permissions.Permissions.*;


public enum Role {


        USER(Set.of(TODO_READ, TODO_WRITE, TODO_CREATE, TODO_UPDATE, TODO_DELETE)),
        ADMIN(Set.of(TODO_READ, TODO_WRITE,  TODO_CREATE, TODO_UPDATE, TODO_DELETE, USER_READ, USER_WRITE)),
        ANALYST(Set.of(TODO_READ, TODO_WRITE,  TODO_CREATE, TODO_UPDATE, TODO_DELETE, USER_READ));


    private final Set<Permissions> permissions;

    Role(Set<Permissions> permissions) {this.permissions = permissions;}

    public Set<Permissions> getPermissions() {return permissions;}

    public Set<SimpleGrantedAuthority> getGrantedAuthority() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority(("ROLE_" + this.name())));

        return permissions;
    }
}
