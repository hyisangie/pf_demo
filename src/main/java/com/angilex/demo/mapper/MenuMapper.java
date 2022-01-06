package com.angilex.demo.mapper;

import com.angilex.demo.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {

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

    // 删除子菜单
    int deleteSubMenu(int id);

    // 判断菜单是否有关联账户
    int relatedAccount(int id);

    // 判断菜单是否有关联角色
    int relatedRole(int id);
}
