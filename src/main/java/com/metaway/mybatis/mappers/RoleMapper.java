package com.metaway.mybatis.mappers;

import com.metaway.mybatis.entitites.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMapper { // equivalente ao repository, para consultas

    @Select("SELECT * FROM tb_role")
    List<Role> findAll();

    @Select("SELECT * FROM tb_role WHERE id = #{id}")
    Role findById(Integer id);

    @Insert("INSERT INTO tb_role (authority) VALUES (#{authority})")
    void insert(Role role);

    @Update("UPDATE tb_role SET authority = #{role.authority} WHERE id = #{id}")
    void update(Role role, Integer id);

    @Delete("DELETE FROM tb_role WHERE id = #{id}")
    void delete(Integer id);
}
