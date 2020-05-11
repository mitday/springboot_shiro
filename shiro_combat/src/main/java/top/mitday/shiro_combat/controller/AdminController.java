package top.mitday.shiro_combat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mitday.shiro_combat.utils.JsonData;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("admin")
public class AdminController {

    @RequestMapping("/video/order")
    public JsonData findMyVideoOrder(){
        Map<String, String> recodMap = new HashMap<>();

        recodMap.put("SpringBoot入门到高级实战","463元");
        recodMap.put("Cloud微服务入门到高级实战","443元");
        recodMap.put("分布式缓存Redis","999元");

        return JsonData.buildSuccess(recodMap);
    }
}
