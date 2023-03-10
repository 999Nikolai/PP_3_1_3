package ru.kata.spring.boot_security.demo.dao;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImp implements RoleDao, Converter<String, Role> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> findAllRoles() {
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }
    @Override
    public Role getRoleById(long id) {
        return entityManager.find(Role.class, id);
    }
    public Role convert(String id) {
        Role role = new Role();
        role.setId(Long.valueOf(id));
        return role;
    }
}
