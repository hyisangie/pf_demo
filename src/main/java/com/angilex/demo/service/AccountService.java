package com.angilex.demo.service;

import com.angilex.demo.entity.Account;
import com.angilex.demo.entity.Role;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AccountService {
    // 获取所有的账号
    List<Account> getAll();

    // 停用账号
    int invalidateRole(int id);

    // 启用账号
    int validateRole(int id);

    // 重设密码
    int resetPwd(int id, String oldPwd, String newPwd);

    // 添加账号
    @Transactional
    int add(Account account);

    // 查询账号及其关联角色或菜单
    Account search(int id);

    // 更新账号
    @Transactional
    int updateAccount(Account account);

    // 删除账号
    @Transactional
    int delAccount(int id);

}
