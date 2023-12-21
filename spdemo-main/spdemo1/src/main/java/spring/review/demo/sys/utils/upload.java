package spring.review.demo.sys.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**

 * 阿里云 OSS 工具类
 */
@Component
public class upload {

    @Autowired
    private static AliOSSProperties aliOSSProperties;

    /**

     * 实现上传图片到OSS
     */
    public static String uploadLocalFile(String localFilePath) throws IOException {
        String endpoint= "https://oss-cn-guangzhou.aliyuncs.com";
        String accessKeyId= "LTAI5tFuAcUcZFsbWnpLjcWA";
        String accessKeySecret= "nWhzxHgc2Yc8kPvK6JONbJioWmOuCn";
        String bucketName= "lnu-liang-web-tlias";


        // 本地文件路径
        File localFile = new File(localFilePath);

        // 获取上传文件的输入流
        try (InputStream inputStream = new FileInputStream(localFile)) {
            // 避免文件覆盖
            String fileName = UUID.randomUUID().toString() + "_" + localFile.getName();

            // 上传文件到 OSS
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            ossClient.putObject(bucketName, fileName, inputStream);

            // 文件访问路径
            String url = endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + fileName;

            // 关闭 ossClient
            ossClient.shutdown();

            return url; // 返回上传到 OSS 的路径
        }
    }

}

