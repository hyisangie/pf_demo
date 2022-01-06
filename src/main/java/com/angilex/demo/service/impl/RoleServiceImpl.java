package com.angilex.demo.service.impl;

import com.angilex.demo.entity.Menu;
import com.angilex.demo.entity.Role;
import com.angilex.demo.mapper.RoleMapper;
import com.angilex.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public List<Role> getAll() {
        return roleMapper.getAll();
    }

    @Override
    public Role searchById(int id) {
        List<Role> list = roleMapper.searchById(id);
        if (list.size() > 0) {
            Role role = list.get(0);
            List<Menu> menu = roleMapper.getMenu(id);
            role.setMenus(menu);
            return role;
        }
        return null;
    }

    @Override
    public List<Role> searchByName(String name) {
        return roleMapper.searchByName(name);
    }

    @Override
    public List<Role> searchAllEnabled() {
        return roleMapper.searchAllEnabled();
    }

    @Override
    public int addRole(Role role) {
        // 添加角色
        roleMapper.addRole(role);
        // 添加角色关联菜单
        addRoleMenu(role);
        return 1;
    }

    public int addRoleMenu(Role role) {
        // 添加关联，问题：：：roleid是自动生成的，那么在此时role对象里是没有id的，添加的话会变成null，如何解决？
        // 添加到role表后可以返回主键id
        roleMapper.relateToMenu(role);
        return 1;
    }


    @Override
    public List<Menu> getMenu(int roleId) {
        return roleMapper.getMenu(roleId);
    }

    @Override
    public int updateRole(Role role) {
        // 删除role原先的Menu，主要是删除menu_role中的关系
        roleMapper.delRoleMenu(role.getId());
        // 更新role
        roleMapper.updateRole(role);
        // 建立新的Menu
        addRoleMenu(role);
        return 0;
    }

    @Override
    public void delRole(int id) {
        // 查询有无关联账号
        if (roleMapper.relatedAccounts(id) > 0) return;

        // 没有关联账号，进行删除
        // 删除关联菜单，这两条好像有点重复
        roleMapper.delMenu(id);
        roleMapper.delRoleMenu(id);
        // 删除角色
        roleMapper.delRole(id);
    }

    @Override
    public void invalidateRole(int id) {
        roleMapper.invalidateRole(id);
    }

    @Override
    public void validateRole(int id) {
        roleMapper.validateRole(id);
    }
}
