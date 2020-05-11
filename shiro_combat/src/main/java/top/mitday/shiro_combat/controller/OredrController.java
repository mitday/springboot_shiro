package top.mitday.shiro_combat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mitday.shiro_combat.utils.JsonData;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/authc")
public class OredrController {

    @RequestMapping("/video/play_record")
    public JsonData findMyPlayRecord(){
        Map<String, String> recodMap = new HashMap<>();

        recodMap.put("SpringBoot入门到高级实战","第8章第1集");
        recodMap.put("Cloud微服务入门到高级实战","第4章第10集");
        recodMap.put("分布式缓存Redis","第10章第3集");

        return JsonData.buildSuccess(recodMap);
    }
}
