package top.mitday.shiro_combat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mitday.shiro_combat.utils.JsonData;

@RestController
@RequestMapping("video")
public class VideoController {

    @RequestMapping("update")
    public JsonData updateVideo(){
        return JsonData.buildSuccess("video更新成功");
    }
}
