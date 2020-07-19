package cn.com.dhcc.oss.service.impl;

import cn.com.dhcc.oss.service.OssService;
import cn.com.dhcc.oss.utils.ConstantPropertiesUtils;
import cn.com.dhcc.oss.utils.RenameUtils;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * <b></b>
 *
 * @author : WMF
 * @since : 2020/6/29 16:00
 */
@Service
public class OssServiceImpl implements OssService {
    @Override
    public String uploadAvatar(MultipartFile file) {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = ConstantPropertiesUtils.END_POINT;
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = ConstantPropertiesUtils.KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.KEY_SECRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;

        try {
            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            // 上传文件流。
            InputStream inputStream = file.getInputStream();

            //获取文件名
            String fileName = file.getOriginalFilename();

            //重命名文件名
            fileName = RenameUtils.getNewFileName(fileName);

            //第一个参数 Bucket
            //第二个参数 路径/文件名
            ossClient.putObject(bucketName, fileName, inputStream);

            // 关闭OSSClient。
            ossClient.shutdown();

            //把上传的路径返回
            //https://edu-admin-1010.oss-cn-beijing.aliyuncs.com/u%3D1906469856%2C4113625838%26fm%3D26%26gp%3D0.jpg
            String url = "https://" + bucketName + "." + endpoint + "/" + fileName;
            return url;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
