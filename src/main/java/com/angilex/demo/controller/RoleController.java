package com.angilex.demo.controller;

import com.angilex.demo.entity.Menu;
import com.angilex.demo.entity.Role;
import com.angilex.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    public List<Role> getAll() {
        return roleService.getAll();
    }

    @GetMapping("/searchid/{id}")
    public Role searchById(@PathVariable("id") int id) {
        return roleService.searchById(id);
    }

    @GetMapping("/searchname/{name}")
    public List<Role> searchByName(@PathVariable("name") String name) {
        return roleService.searchByName(name);
    }

    @GetMapping("/enabled")
    public List<Role> searchAllEnabled(){
        return roleService.searchAllEnabled();
    }

    @PostMapping("/add")
    public int add(@RequestBody Role role){
        return roleService.addRole(role);
    }

    @GetMapping("/getmenu/{id}")
    public List<Menu> getMenu(@PathVariable int id){
        return roleService.getMenu(id);
    }

    @PutMapping("/update")
    public int updateRole(@RequestBody Role role) {
        return roleService.updateRole(role);
    }

    @PutMapping("del/{id}")
    public void delRole(@PathVariable int id){
        roleService.delRole(id);
    }

    /**
     * 停用角色
     * @param id
     */
    @PutMapping("invalidate/{id}")
    public void invalidateRole(@PathVariable int id) {
        roleService.invalidateRole(id);
    }

    /**
     * 停用角色
     * @param id
     */
    @PutMapping("validate/{id}")
    public void validateRole(@PathVariable int id) {
        roleService.validateRole(id);
    }
}
