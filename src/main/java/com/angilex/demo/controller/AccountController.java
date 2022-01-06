package com.angilex.demo.controller;

import com.angilex.demo.entity.Account;
import com.angilex.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 查看所有列表
     * ※ 改造：要能根据条件显示
     * @return
     */
    @GetMapping("/list")
    public List<Account> getAll(){
        return accountService.getAll();
    }

    /**
     * 添加账号信息
     * @param account
     */
    @PostMapping("add")
    public void add(@RequestBody Account account){
        accountService.add(account);
    }


    /**
     * 停用账号
     * @param id
     */
    @PutMapping("/invalidate/{id}")
    public void invalidateRole(@PathVariable int id) {
        accountService.invalidateRole(id);
    }

    /**
     * 停用角色
     * @param id
     */
    @PutMapping("/validate/{id}")
    public void validateRole(@PathVariable int id) {
        accountService.validateRole(id);
    }

    @PutMapping("/resetpwd/{id}")
    public void resetPwd(@PathVariable int id, String oldPwd, String newPwd){
        accountService.resetPwd(id, oldPwd, newPwd);
    }

}
