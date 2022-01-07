package com.angilex.demo.controller;

import com.angilex.demo.entity.Menu;
import com.angilex.demo.service.MenuService;
import com.angilex.demo.utils.CommonResult;
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
    public CommonResult<List<Menu>> get1stLevel(){
        List<Menu> menu = menuService.getLevelOne();
        if (menu.size() > 0) return CommonResult.success(menu);
        return CommonResult.failed("没有相关数据！");
    }

    /**
     * 根据 parent_id 查询其子权限
     * @param level 父级id
     * @return 子权限列表
     */
    @GetMapping("/getsublevel/{level}")
    public CommonResult<List<Menu>> getSubLevel(@PathVariable("level") int level){
        List<Menu> menu = menuService.getSubLevel(level);
        if (menu.size() > 0) return CommonResult.success(menu);
        return CommonResult.failed("没有相关数据！");
    }

    /**
     * 添加菜单
     * @param menu 菜单信息
     * @return
     */
    @PostMapping("/add")
    public CommonResult addMenu(@RequestBody Menu menu){
        int count = menuService.addMenu(menu);
        if (count > 0) return CommonResult.success(count);
        return CommonResult.failed();
    }

    @GetMapping("/get/{id}")
    public CommonResult<Menu> searchById(@PathVariable("id") int id){
        Menu menu = menuService.searchById(id);
        if (menu != null) return CommonResult.success(menu);
        return CommonResult.failed();
    }

    @PutMapping("/update")
    public CommonResult updateMenu(@RequestBody Menu menu){
        int count = menuService.updateMenu(menu);
        if (count > 0) return CommonResult.success(count);
        return CommonResult.failed();
    }

    @DeleteMapping("/del/{id}")
    public CommonResult delRelatedMenu(@PathVariable int id){
        int count = menuService.delMenu(id);
        if (count > 0) return CommonResult.success(count);
        return CommonResult.failed();
    }

}
