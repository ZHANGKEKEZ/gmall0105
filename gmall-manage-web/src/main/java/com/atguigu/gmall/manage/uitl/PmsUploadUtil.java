package com.atguigu.gmall.manage.uitl;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class PmsUploadUtil {
    public static String uploadImg(MultipartFile multipartFile)  {
        //获取dfds全局连接地址
        String tracker=PmsUploadUtil.class.getResource("/tracker.conf").getPath();
        try {
            ClientGlobal.init(tracker);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TrackerClient trackerClient = new TrackerClient();
        //获取trackerService的实例
        TrackerServer trackerServer= null;
        try {
            trackerServer = trackerClient.getTrackerServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //创建storage连接客户端
        StorageClient storageClient = new StorageClient(trackerServer, null);
        String url= "http://192.168.84.129";
        try {
            byte[] bytes = multipartFile.getBytes();
            String originalFilename = multipartFile.getOriginalFilename();
            String[] strings = originalFilename.split("\\.");
            String s=strings[strings.length-1];
            String[] uploadInfos = storageClient.upload_file(bytes,s,null);
            for (String uploadInfo : uploadInfos) {
                url+="/"+uploadInfo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }
}
