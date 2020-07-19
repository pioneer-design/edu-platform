package cn.com.dhcc.oss.controller;

import cn.com.dhcc.common.core.R;
import cn.com.dhcc.oss.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <b>阿里云 OSS 上传控制器</b>
 *
 * @author : WMF
 * @since : 2020/6/29 15:59
 */
@Api(tags = "头像上传")
@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {

    @Autowired
    private OssService ossService;

    @ApiOperation(value = "上传头像的方法")
    @PostMapping("upload")
    public R uploadOssFile(MultipartFile file) {
        //获取上传对象
        String url = ossService.uploadAvatar(file);
        return R.ok().data("url", url);
    }
}
