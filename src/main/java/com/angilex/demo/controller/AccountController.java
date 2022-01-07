package com.angilex.demo.controller;

import com.angilex.demo.entity.Account;
import com.angilex.demo.service.AccountService;
import com.angilex.demo.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
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
     */
    @GetMapping("/list")
    public CommonResult<List<Account>> getAll(){

        List<Account> accounts = accountService.getAll();
        return CommonResult.success(accounts);
    }

    /**
     * 添加账号信息
     * @param account   账户信息
     */
    @PostMapping("add")
    public CommonResult add(@RequestBody Account account){

        int count = accountService.add(account);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    /**
     * 查询账号
     * @param id
     */
    @GetMapping("search/{id}")
    public CommonResult<Account> search(@PathVariable int id) {
        Account account = accountService.search(id);
        if (account != null) return CommonResult.success(account);
        return CommonResult.failed();
    }

    /**
     * 更新账户
     * @param account
     */
    @PutMapping("/update")
    public CommonResult updateAccount(@RequestBody Account account) {
        int count = accountService.updateAccount(account);
        if (count > 0) return CommonResult.success(count);
        return CommonResult.failed();
    }

    /**
     * 删除账户
     * @param id
     */
    @DeleteMapping("del/{id}")
    public CommonResult delAccount(@PathVariable int id){
        int count = accountService.delAccount(id);
        if (count > 0) return CommonResult.success(count);
        return CommonResult.failed();
    }

    /**
     * 停用账号
     * @param id
     */
    @PutMapping("/invalidate/{id}")
    public CommonResult invalidateRole(@PathVariable int id) {

        int count = accountService.invalidateRole(id);
        if (count > 0) return CommonResult.success(count);
        return CommonResult.failed();
    }

    /**
     * 停用角色
     * @param id
     */
    @PutMapping("/validate/{id}")
    public CommonResult validateRole(@PathVariable int id) {
        int count = accountService.validateRole(id);
        if (count > 0) return CommonResult.success(count);
        return CommonResult.failed();
    }

    @PutMapping("/resetpwd/{id}")
    public CommonResult resetPwd(@PathVariable int id, String oldPwd, String newPwd){
        int count = accountService.resetPwd(id, oldPwd, newPwd);
        if (count > 0) return CommonResult.success(count);
        return CommonResult.failed();
    }

}
