package com.angilex.demo.mapper;

import com.angilex.demo.entity.Menu;
import com.angilex.demo.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {

    // 获取全部角色信息
    List<Role> getAll();

    // 根据id查询
    List<Role> searchById(int id);

    // 根据名字模糊查询
    List<Role> searchByName(String name);

    // 根据isEnabled查询
    List<Role> searchAllEnabled();

    // 添加角色
    int addRole(Role role);

    // 建立角色和菜单的关系
    int relateToMenu(Role role);

    // 查找角色下的菜单信息
    List<Menu> getMenu(int roleId);

    // 根据roleId删除menu_role中与该角色有关的关联关系
    int delRoleMenu(Integer roleId);

    // 更新数据库中角色
    int updateRole(Role role);

    // 查询有无关联账号
    int relatedAccounts(int id);

    // 删除角色
    int delRole(int id);

    // 删除菜单
    int delMenu(int id);

    // 停用角色
    int invalidateRole(int id);

    // 启用角色
    int validateRole(int id);
}
