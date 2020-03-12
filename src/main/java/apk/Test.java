package apk;

import exception.TipException;
import lombok.extern.java.Log;
import utils.UploadUtil;

import java.io.File;
@Log
public class Test {
    public static void main(String[] args) {
        String apkLocation = "/Users/kira/Desktop/aaaaa/";
        String ApkDir = "/Users/kira/Desktop/bbbbb/";
        String fileName = "83d59897-72f8-4de1-a8eb-82c953c4b8c6.apk";

        if (fileName != null && !new File(apkLocation + fileName).exists()) {
            try {
                File file = new File(apkLocation);
                if (!file.exists()) {
                    file.mkdirs();
                }
                UploadUtil.coverFile(ApkDir + fileName, apkLocation + fileName);
                System.out.println("拷贝成功拷贝成功拷贝成功！！！！！！");
            } catch (Exception e) {
                log.info("APK拷贝失败"+ e);
                throw new TipException(400, "APK拷贝失败");
            }
        }
    }
}
