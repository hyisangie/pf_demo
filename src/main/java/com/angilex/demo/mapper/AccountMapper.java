package com.angilex.demo.mapper;

import com.angilex.demo.entity.Account;
import com.angilex.demo.entity.Menu;
import com.angilex.demo.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {

    // 获取所有
    List<Account> getAll();

    // 停用账号
    void invalidate(int id);

    // 启用账号
    void validate(int id);

    // 查询密码是否符合
    List<Account> checkPwd(int id, String oldPwd);

    // 更新密码
    int resetPwd(int id, String newPwd);

    // 添加用户
    void add(Account account);

    // 添加账户和角色的关系
    void addAccountRole(Account account);

    // 自动绑定账户和角色下菜单的关系
    void bindRoleMenu(Account account, Integer menuId);

    // 添加账户和菜单的关系
    void addAccountMenu(Account account);

    // 通过角色id获取它对应的角色菜单id
    List<Integer> getMenuList(Integer roleId);

    // 查询账户
    List<Account> search(int id);

    // 查询关联角色
    List<Role> getRelatedRole(int id);

    // 查询关联菜单
    List<Menu> getRelatedMenu(int id);

    // 删除角色
    void delRole(int id);

    // 删除账户角色对应关系
    void delAccountRole(int id);

    // 删除菜单
    void delMenu(int id);

    // 删除账户菜单关系
    void delAccountMenu(int id);

    // 删除账号
    void delAccount(int id);

    // 更新账号
    void updateAccount(Account account);
}
