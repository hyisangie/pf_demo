package com.angilex.demo.service;

import com.angilex.demo.entity.Menu;
import com.angilex.demo.entity.Role;

import java.util.List;

public interface RoleService {

    // 获取列表
    List<Role> getAll();
    // 根据id查询
    Role searchById(int id);
    // 根据id查询
    List<Role> searchByName(String name);
    // 根据isEnabled查询
    List<Role> searchAllEnabled();
    // 添加角色
    int addRole(Role role);
    // 查找角色下的菜单信息
    List<Menu> getMenu(int roleId);
    // 更新角色
    int updateRole(Role role);
    // 删除角色
    int delRole(int id);
    // 停用角色
    int invalidateRole(int id);
    // 启用角色
    int validateRole(int id);
}
