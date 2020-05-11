package top.mitday.shiro_combat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mitday.shiro_combat.utils.JsonData;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/asd")
    public String sdf(){
        return " 我是睡";
    }
}
