package com.metaway.mybatis.controllers;

import com.metaway.mybatis.entitites.Role;
import com.metaway.mybatis.mappers.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    @Autowired
    private RoleMapper roleMapper;

    @GetMapping
    public ResponseEntity<List<Role>> findAll(){
        List<Role> list = roleMapper.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Role> findById(@PathVariable Integer id){
        Role entity = roleMapper.findById(id);
        return ResponseEntity.ok().body(entity);
    }

    @PostMapping
    public ResponseEntity<Role> insert(@RequestBody Role role){
        roleMapper.insert(role);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(role.getId()).toUri();
        return ResponseEntity.created(uri).body(role);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Role> update(@RequestBody Role role, @PathVariable Integer id){
        roleMapper.update(role, id);
        return ResponseEntity.ok().body(role);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id){
        roleMapper.delete(id);
    }
}
