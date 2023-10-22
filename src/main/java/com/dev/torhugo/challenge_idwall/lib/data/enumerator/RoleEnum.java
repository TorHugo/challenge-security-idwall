package com.dev.torhugo.challenge_idwall.lib.data.enumerator;

import com.dev.torhugo.challenge_idwall.lib.exception.impl.DataBaseException;
import com.dev.torhugo.challenge_idwall.lib.exception.impl.ResourceNotFoundException;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum RoleEnum {
    ROLE_ADMIN (1L, "ROLE_ADMIN", "Access to ADMIN permission system."),
    ROLE_USER (2L, "ROLE_USER","Access to USER permission system.");

    private final Long roleId;
    private final String name;
    private final String description;

    RoleEnum(final Long roleId, final String name, final String description) {
        this.roleId = roleId;
        this.name = name;
        this.description = description;
    }

    public static RoleEnum parseRole(final String nameRole){
        return Arrays.stream(values()).filter(role -> Objects.equals(nameRole, role.name))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("Role Not Found!"));
    }
}
