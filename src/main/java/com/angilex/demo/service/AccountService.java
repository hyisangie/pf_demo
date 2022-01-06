package com.angilex.demo.service;

import com.angilex.demo.entity.Account;

import java.util.List;

public interface AccountService {
    // 获取所有的账号
    List<Account> getAll();

    // 停用账号
    void invalidateRole(int id);

    // 启用账号
    void validateRole(int id);

    // 重设密码
    void resetPwd(int id, String oldPwd, String newPwd);

    // 添加账号
    void add(Account account);

    // 查询账号及其关联角色或菜单
    Account search(int id);

}
