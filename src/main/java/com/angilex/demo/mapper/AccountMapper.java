package com.angilex.demo.mapper;

import com.angilex.demo.entity.Account;
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
}
