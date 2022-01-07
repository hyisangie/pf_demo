package com.angilex.demo.controller;

import com.angilex.demo.entity.Menu;
import com.angilex.demo.entity.Role;
import com.angilex.demo.service.RoleService;
import com.angilex.demo.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    public CommonResult<List<Role>> getAll() {
        return CommonResult.success(roleService.getAll());
    }

    @GetMapping("/searchid/{id}")
    public CommonResult<Role> searchById(@PathVariable("id") int id) {
        Role role = roleService.searchById(id);
        return CommonResult.success(role);
    }

    @GetMapping("/searchname/{name}")
    public CommonResult<List<Role>> searchByName(@PathVariable("name") String name) {
        return CommonResult.success(roleService.searchByName(name));
    }

    @GetMapping("/enabled")
    public CommonResult<List<Role>> searchAllEnabled(){
        return CommonResult.success(roleService.searchAllEnabled());
    }

    @PostMapping("/add")
    public CommonResult add(@RequestBody Role role){
        int count = roleService.addRole(role);
        if (count > 0) return CommonResult.success(count);
        return CommonResult.failed();
    }

    @GetMapping("/getmenu/{id}")
    public CommonResult<List<Menu>> getMenu(@PathVariable int id){
        return CommonResult.success(roleService.getMenu(id));
    }

    @PutMapping("/update")
    public CommonResult updateRole(@RequestBody Role role) {

        int count = roleService.updateRole(role);
        if (count > 0) return CommonResult.success(count);
        return CommonResult.failed();
    }

    @DeleteMapping("del/{id}")
    public CommonResult delRole(@PathVariable int id){
        int count = roleService.delRole(id);
        if (count > 0) return CommonResult.success(count);
        return CommonResult.failed();
    }

    /**
     * 停用角色
     * @param id
     */
    @PutMapping("invalidate/{id}")
    public CommonResult invalidateRole(@PathVariable int id) {
        int count = roleService.invalidateRole(id);
        if (count > 0) return CommonResult.success(count);
        return CommonResult.failed();
    }

    /**
     * 停用角色
     * @param id
     */
    @PutMapping("validate/{id}")
    public CommonResult validateRole(@PathVariable int id) {
        int count = roleService.validateRole(id);
        if (count > 0) return CommonResult.success(count);
        return CommonResult.failed();
    }
}
