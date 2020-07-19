package cn.com.dhcc.edu.controller;

import cn.com.dhcc.common.core.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <b></b>
 *
 * @author : WMF
 * @since : 2020/7/15 10:57
 */
@RestController
@RequestMapping("edu/sys")
@CrossOrigin
public class EduSysResourceController {

    @GetMapping("getData")
    public R getSysResourceController() {
        Map<String, Object> map = new HashMap<>();
        map.put("value", 89);
        map.put("value2", 23);
        map.put("value3", 56);

        return R.ok().data("map", map);
    }
}
