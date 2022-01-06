package com.angilex.demo;

import com.angilex.demo.entity.Menu;
import com.angilex.demo.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private RoleService roleService;

    @Test
    public void test111(){
        List<Menu> menu = roleService.getMenu(1);
        System.out.println(menu);
    }

}
