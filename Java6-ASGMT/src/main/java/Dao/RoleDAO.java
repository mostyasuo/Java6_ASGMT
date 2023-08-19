package Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Role;



public interface RoleDAO extends JpaRepository<Role, String> { }
