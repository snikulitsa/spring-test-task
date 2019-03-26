package com.nikulitsa.springsandbox.services.ldap;

import com.nikulitsa.springsandbox.entities.ldap.LdapObjectClass;
import com.nikulitsa.springsandbox.entities.ldap.tree.AbstractLdapTreeEntity;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.ContextMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author Sergey Nikulitsa
 */
public interface LdapMapperFactory {
    AttributesMapper<AbstractLdapTreeEntity> ldapTreeEntityMapper(LdapObjectClass ldapObjectClass);

    AttributesMapper<String> dnMapper();

    AttributesMapper<String> debugMapper();

    AttributesMapper<? extends GrantedAuthority> groupCnMapper();

    /**
     * Маппер, использующий Spring ODM для резолвинга полей.
     *
     * @param ldapTemplate {@link LdapTemplate}
     * @param clazz        класс сущности, которую достаем из LDAP
     * @param <T>          тип сущности
     * @return {@link ContextMapper}
     */
    <T> ContextMapper<T> objectDirectoryContextMapper(LdapTemplate ldapTemplate, Class<T> clazz);
}
