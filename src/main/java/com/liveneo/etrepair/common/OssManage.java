package com.liveneo.etrepair.common;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import org.springframework.stereotype.Component;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.AppendObjectRequest;
import com.aliyun.oss.model.AppendObjectResult;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

/**
 * OSS文件服务器操作类
 */
@Component
public class OssManage {
    private String accessKeyId      = PropertyConfigurer.getValue("OSS_ACCESS_KEY_ID");
    private String accessKeySecret  = PropertyConfigurer.getValue("OSS_ACCESS_KEY_SECRET");
    private String endPoint         = PropertyConfigurer.getValue("OSS_ENDPOINT");         // 内网上传
    private String endPointInternal = PropertyConfigurer.getValue("OSS_ENDPOINT_INTERNAL"); // 外网读取
    private String bucketName       = PropertyConfigurer.getValue("OSS_BUCKETNAME");
    private String outOfDate        = PropertyConfigurer.getValue("OSS_OUT_OF_DATE");

    /**
     * 上传文件到OSS文件服务器
     * @param content 文件流
     * @param key 上传为OSS文件服务器的唯一标识
     * @param mimeType 文档类型
     * @return
     * @throws Exception
     */
    public String uploadFile(InputStream content, String key, String mimeType) throws Exception {
        /**内网上传(endPoint) ==外网读取(endPointInternal)**/
        // TODO
        // OSSClient client = new OSSClient(endPointInternal, accessKeyId, accessKeySecret);
        OSSClient client = new OSSClient(endPoint, accessKeyId, accessKeySecret);
        ObjectMetadata meta = new ObjectMetadata();
        // 必须设置ContentLength
        meta.setContentType(mimeType);
        // 上传Object.
        PutObjectResult result = client.putObject(bucketName, key, content, meta);
        client.shutdown();
        return result.getETag();
    }

    /**
     * 根据key获取oss服务器上的图片公网地址
     * @param key
     * @return
     */
    public String getURL(String key) {
        /**内网上传(endPoint) ==外网读取(endPointInternal)**/
        // TODO
        OSSClient client = new OSSClient(endPointInternal, accessKeyId, accessKeySecret);
        // OSSClient client = new OSSClient(endPoint, accessKeyId, accessKeySecret);
        URL url = null;
        Date expires = new Date(new Date().getTime() + Integer.parseInt(outOfDate)); // 30
        GeneratePresignedUrlRequest generatePresignedUrlRequest;
        generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, key);
        generatePresignedUrlRequest.setExpiration(expires);
        url = client.generatePresignedUrl(generatePresignedUrlRequest);
        return url.toString();
    }

    /**
     * 根据key获取oss服务器上的ipa文件公网地址
     * @param key
     * @return
     */
    public String getIpaURl(String key) {
        URL url = null;
        /**内网上传(endPoint) ==外网读取(endPointInternal)**/
        // TODO
        OSSClient client = new OSSClient(endPointInternal, accessKeyId, accessKeySecret);
        // OSSClient client = new OSSClient(endPoint, accessKeyId, accessKeySecret);
        Date expires = new Date(new Date().getTime() + 10 * 365 * 24 * 3600 * 1000);
        GeneratePresignedUrlRequest generatePresignedUrlRequest;
        generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, key);
        generatePresignedUrlRequest.setExpiration(expires);
        url = client.generatePresignedUrl(generatePresignedUrlRequest);
        return url.toString();
    }

    /**
     * 根据key获取oss服务器上的图片地址
     * @param key
     * @return
     */
    public InputStream getObject(String key) {
        /**内网上传(endPoint) ==外网读取(endPointInternal)**/
        // TODO
        OSSClient client = new OSSClient(endPointInternal, accessKeyId, accessKeySecret);
        // OSSClient client = new OSSClient(endPoint, accessKeyId, accessKeySecret);
        OSSObject object = client.getObject(bucketName, key);
        ;
        object.getObjectMetadata().getContentType();
        // System.out.println("key:"+object.getKey()+"----------bucket:"+object.getBucketName());
        // 获取Object的输入流
        InputStream objectContent = object.getObjectContent();
        return objectContent;
    }

    /**
     * 删除文件
     * @param key
     */
    public void deleteFile(String key) {
        /**内网上传(endPoint) ==外网读取(endPointInternal)**/
        // TODO
        OSSClient client = new OSSClient(endPointInternal, accessKeyId, accessKeySecret);
        // OSSClient client = new OSSClient(endPoint, accessKeyId, accessKeySecret);
        client.deleteObject(bucketName, key);
    }

    /**
     * 断点上传文件到OSS文件服务器
     * @param content 文件流
     * @param key 上传为OSS文件服务器的唯一标识
     * @param position
     * @param mimeType
     * @return
     * @throws Exception
     */
    public String appendObjectFile(InputStream content, String key, int position, String mimeType) throws Exception {
        // 进行初始化
        /**内网上传(endPoint) ==外网读取(endPointInternal)**/
        // TODO
        // OSSClient client = new OSSClient(endPointInternal, accessKeyId, accessKeySecret);
        OSSClient client = new OSSClient(endPoint, accessKeyId, accessKeySecret);
        ObjectMetadata meta = new ObjectMetadata();
        // 必须设置ContentLength
        meta.setContentLength(position);
        meta.setContentType(mimeType);
        meta.setCacheControl("no-cache");
        meta.setContentEncoding("utf-8");
        // 上传
        AppendObjectRequest appendObjectRequest = new AppendObjectRequest(bucketName, key, content, meta);
        appendObjectRequest.setPosition(Long.valueOf(position));
        AppendObjectResult appendObjectResult = client.appendObject(appendObjectRequest);
        return appendObjectResult.getNextPosition().toString();
    }

    public static void main(String[] args) {
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        // // 文件名称
        // String fileName = UUID.randomUUID().toString().replace("-", "") + ".jpg";
        // // 构建文件保存的目录
        // String savedate = sdf.format(new Date()) + "/";
        // String key = "ltappservicepub-sitoss/taet/dev/img/garagePhoto/" + savedate + fileName;
        // // OssManage ossManage = new OssManage();
        // // System.out.println(ossManage.bucketName);
        // File file = new File("/Users/apple/Desktop/qq.jpg");
        // OSSClient client = new OSSClient("oss-cn-beijing.aliyuncs.com", "LTAIUuVGVITOuhYH",
        // "zw6NmmtbfHOmoonrVm0aPRO1mgzSn7");
        // // 上传Object.
        // PutObjectResult result = client.putObject("dkcloudpublic", key, file);
        // System.err.println("111111====" + result.getETag());
        OSSClient client = new OSSClient("oss-cn-beijing.aliyuncs.com", "LTAIUuVGVITOuhYH", "zw6NmmtbfHOmoonrVm0aPRO1mgzSn7");
        URL url = null;
        Date expires = new Date(new Date().getTime() + Integer.parseInt("1800000")); // 30
        GeneratePresignedUrlRequest generatePresignedUrlRequest;
        generatePresignedUrlRequest = new GeneratePresignedUrlRequest("dkcloudpublic",
                "ltappservicepub-sitoss/taet/dev/img/garagePhoto/20161025/3b3581ccb99b4b3e9d12786b295b52b3.jpg");
        generatePresignedUrlRequest.setExpiration(expires);
        url = client.generatePresignedUrl(generatePresignedUrlRequest);
        // url = client.generatePresignedUrl(bucketName, key, expiration);
        System.err.println(url.toString());
    }
}
