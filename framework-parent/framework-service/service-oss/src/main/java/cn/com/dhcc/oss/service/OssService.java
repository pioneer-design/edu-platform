package cn.com.dhcc.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * <b>oss 服务层</b>
 *
 * @author : WMF
 * @since : 2020/6/29 16:00
 */
public interface OssService {
    /**
     * 上传头像
     * @param file
     * @return
     */
    String uploadAvatar(MultipartFile file);
}
