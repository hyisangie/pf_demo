package com.angilex.demo.service.impl;

import com.angilex.demo.entity.Account;
import com.angilex.demo.entity.Role;
import com.angilex.demo.mapper.AccountMapper;
import com.angilex.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> getAll() {
        return accountMapper.getAll();
    }

    @Override
    public int invalidateRole(int id) {

        return accountMapper.invalidate(id);
    }

    @Override
    public int validateRole(int id) {
        return accountMapper.validate(id);
    }

    @Override
    public int resetPwd(int id, String oldPwd, String newPwd) {
        // 判断原密码是否输入正确
        if (accountMapper.checkPwd(id, oldPwd).size() == 0) return 0;
        // 正确后才能修改密码
        return accountMapper.resetPwd(id, newPwd);
    }

    @Override
    public int add(Account account) {

        // 添加账户信息
        int count = accountMapper.add(account);
        // 添加账户和角色的关联信息
        if (account.getRoles().size() > 0) {
            addAccountRole(account);
        }
        // 添加账户和菜单的关联信息
        if (account.getMenus().size() > 0) {
            addAccountMenu(account);
        }

        return count;
    }

    @Override
    public Account search(int id) {
        // 查询账号
        List<Account> accounts = accountMapper.search(id);
        Account account = null;
        if (accounts.size() > 0) {
            account = accounts.get(0);
            // 查询关联角色
            account.setRoles(accountMapper.getRelatedRole(id));
            // 查询关联菜单
            account.setMenus(accountMapper.getRelatedMenu(id));
        }
        return account;
    }

    private void addAccountMenu(Account account) {
        // 添加账户和菜单的关系
        accountMapper.addAccountMenu(account);
    }

    private void addAccountRole(Account account) {
        // 添加账户和角色的关系
        accountMapper.addAccountRole(account);
        // 获得roleid
        List<Role> roles = account.getRoles();
        if (roles.size() > 0) {
            for (Role role : roles) {
                // 通过roleid获得他的菜单列表
                List<Integer> menuList = accountMapper.getMenuList(role.getId());
                if (menuList.size() > 0) {
                    for (Integer menuid : menuList) {
                     // 绑定账户和角色下菜单的关系
                        accountMapper.bindRoleMenu(account, menuid);
                    }
                }
            }
        }
    }

    @Override
    public int delAccount(int id) {
        // 删除关联角色
        accountMapper.delRole(id);
        accountMapper.delAccountRole(id);
        // 删除关联菜单
        accountMapper.delMenu(id);
        accountMapper.delAccountMenu(id);
        // 删除账户
        return accountMapper.delAccount(id);
    }


    @Override
    public int updateAccount(Account account) {
        accountMapper.delAccountMenu(account.getId());
        accountMapper.delAccountRole(account.getId());
        int count = accountMapper.updateAccount(account);
        addAccountMenu(account);
        addAccountRole(account);
        return count;
    }

}
