package com.angilex.demo.service;

import com.angilex.demo.entity.Menu;

import java.util.List;

public interface MenuService {

    // 查询权限列表
    List<Menu> getLevelOne();

    // 查询子权限列表
    List<Menu> getSubLevel(Integer level);

    // 添加菜单信息
    int addMenu(Menu menu);

    // 根据id查询菜单信息
    Menu searchById(int id);

    // 更新菜品
    int updateMenu(Menu menu);

    // 删除菜单
    int delMenu(int id);

}
