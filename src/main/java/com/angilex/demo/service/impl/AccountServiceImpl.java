package com.angilex.demo.service.impl;

import com.angilex.demo.entity.Account;
import com.angilex.demo.mapper.AccountMapper;
import com.angilex.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void invalidateRole(int id) {
        accountMapper.invalidate(id);
    }

    @Override
    public void validateRole(int id) {
        accountMapper.validate(id);
    }

    @Override
    public void resetPwd(int id, String oldPwd, String newPwd) {
        // 判断原密码是否输入正确
        if (accountMapper.checkPwd(id, oldPwd).size() == 0) return;
        // 正确后才能修改密码
        accountMapper.resetPwd(id, newPwd);

    }

    public static void main(String[] args) {
        System.out.println("sdsa".charAt(0));
    }
}
