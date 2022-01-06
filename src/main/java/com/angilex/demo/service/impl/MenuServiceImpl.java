package com.angilex.demo.service.impl;

import com.angilex.demo.entity.Menu;
import com.angilex.demo.mapper.MenuMapper;
import com.angilex.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getLevelOne() {
        return menuMapper.getLevelOne();
    }

    @Override
    public List<Menu> getSubLevel(Integer level) {
        return menuMapper.getSubLevel(level);
    }

    @Override
    public int addMenu(Menu menu) {
        return menuMapper.addMenu(menu);
    }

    @Override
    public Menu searchById(int id) {
        return menuMapper.searchById(id);
    }

    @Override
    public int updateMenu(Menu menu) {
        return menuMapper.updateMenu(menu);
    }

    @Override
    public int delMenu(int id) {
        // 查询有无关联账号或角色
        if (menuMapper.relatedAccount(id) > 0 || menuMapper.relatedRole(id) > 0) {
            // System.out.println("有相关账号或角色！");
            return 0;
        }

        // 查询是否有子菜单
        List<Menu> subMenus = menuMapper.getSubLevel(id);
        if (subMenus.size() > 0) {
            for (Menu menu : subMenus) {
                int suc = delMenu(menu.getId());
                if (suc == 0) return 0;
            }
        }
        int suc = menuMapper.delMenu(id);
        if (suc > 0) {  // 成功
            return 1;
        } else {
            return 0;   // 失败
        }
    }
}
