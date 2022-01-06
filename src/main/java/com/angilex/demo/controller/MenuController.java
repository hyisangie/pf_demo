package com.angilex.demo.controller;

import com.angilex.demo.entity.Menu;
import com.angilex.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 查询权限列表
     * @return 所有一级菜单
     */
    @GetMapping("/getlevel1")
    public List<Menu> get1stLevel(){
        return menuService.getLevelOne();
    };

    /**
     * 根据 parent_id 查询其子权限
     * @param level 父级id
     * @return 子权限列表
     */
    @GetMapping("/getsublevel/{level}")
    public List<Menu> getSubLevel(@PathVariable("level") int level){
        return menuService.getSubLevel(level);
    }

    /**
     * 添加菜单
     * @param menu
     * @return
     */
    @PostMapping("/add")
    public int addMenu(@RequestBody Menu menu){
        return menuService.addMenu(menu);
    }

    @GetMapping("/get/{id}")
    public Menu searchById(@PathVariable("id") int id){
        return menuService.searchById(id);
    }

    @PostMapping(value = "/update")
    public int updateMenu(@RequestBody Menu menu){
        return menuService.updateMenu(menu);
    }

    @GetMapping("/del/{id}")
    public int delRelatedMenu(@PathVariable int id){
        return menuService.delMenu(id);
    }

}
