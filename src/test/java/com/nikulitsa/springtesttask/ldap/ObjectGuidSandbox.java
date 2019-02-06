package com.nikulitsa.springtesttask.ldap;

import com.nikulitsa.springtesttask.entities.ldap.AbstractLdapEntity;
import com.nikulitsa.springtesttask.entities.ldap.LdapObjectClass;
import com.nikulitsa.springtesttask.services.ldap.LdapMapperFabric;
import com.nikulitsa.springtesttask.services.ldap.LdapQueryFabric;
import com.nikulitsa.springtesttask.services.ldap.LdapSearchUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.HardcodedFilter;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectGuidSandbox {

    @Qualifier("ldapTemplate_1")
    @Autowired
    private LdapTemplate ldapTemplate;

    @Autowired
    private LdapQueryFabric ldapQueryFabric;

    @Autowired
    private LdapMapperFabric ldapMapperFabric;

    @Test
    public void test() {
        Optional<AbstractLdapEntity> group = ldapTemplate.search(
            ldapQueryFabric.ldapEntityQuery("CN=Builtin", LdapObjectClass.GROUP),
            ldapMapperFabric.ldapEntityMapper(LdapObjectClass.GROUP)
        ).stream().findFirst();

        if (group.isPresent()) {
            AbstractLdapEntity abstractLdapEntity = group.get();

            System.out.println(abstractLdapEntity.getDn());

            String rfcObjectGUID = LdapSearchUtils.rfcObjectGUID(abstractLdapEntity.getObjectGuid());

            List<String> search = ldapTemplate.search(
                "", new HardcodedFilter("(objectGUID=" + rfcObjectGUID + ")").encode(),
                ldapMapperFabric.dnMapper()
            );

            System.out.println(search);
        }
    }
}