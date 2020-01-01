package com.hebeu.resale.demo1.utils;


import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;


public class Qiniu {
//    public static String uploadToken(String bucket, String accessKey, String secretKey){
//        PutPolicy upPolicy = new PutPolicy(bucket);
//        upPolicy.endUser = user;
//        upPolicy.callbackUrl = callbackUrl;
//        upPolicy.callbackBody = "key=$(key)&hash=$(etag)&width=$(imageInfo.width)&height=$(imageInfo.height)&user=$(endUser)&size=$(fsize)&mime=$(mimeType)";
//        String token = null;
//        Mac mac = new Mac(accessKey, secretKey);
//        try{
//            token = upPolicy.token(mac);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return token;
//    }

    public static void main(String[] args) {

        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.huanan());
//...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传
        String accessKey = "Nx0xrItkiX29wy0yi4OoP_2QrjlQl6yqDG-AJRTK";
        String secretKey = "KxxxjJE6CsuyuQSgomOFCQilEs6zhCc4HxrY414C";
        String bucket = "resaleresource";
//如果是Windows情况下，格式是 D:\\qiniu\\test.png
        String localFilePath = "D:\\uploadFiles\\3d980f4da113467ba0c0713e85a64fafIMG_0038.JPG";
//默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
    }
}
