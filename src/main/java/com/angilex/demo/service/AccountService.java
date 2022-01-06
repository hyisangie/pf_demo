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
}