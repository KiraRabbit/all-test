package utils;


import exception.TipException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

public class UploadUtil {

    public static String getUpLoadFileName(String extName) {
        if (extName == null || extName.length() < 1) {
            return UUID.randomUUID().toString();
        }
        return UUID.randomUUID().toString() + extName;
    }

    /**
     * 下载APK文件
     *
     * @param fileUrl
     * @param fileLocal
     * @return
     * @throws Exception
     */
    public static String[] downloadFile(String fileUrl, String fileLocal) throws Exception {

        URL url = new URL(fileUrl);
        HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
        urlCon.setConnectTimeout(6000);
        urlCon.setReadTimeout(6000);
        urlCon.setRequestProperty("Accept", "*/*");//模拟ie浏览器
        urlCon.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; CIBA)"); //模拟ie浏览器
        urlCon.setRequestProperty("Accept-Language", "zh-cn");//模拟ie浏览器
        if (urlCon.getResponseCode() != HttpURLConnection.HTTP_OK) {
            if (urlCon.getResponseCode() == HttpURLConnection.HTTP_MOVED_TEMP) {
                String location = urlCon.getHeaderField("Location");
                return downloadFile(location, fileLocal);
            } else {
                throw new TipException(400, "文件读取失败,错误代码:" + urlCon.getResponseCode());
            }
        }
        String extName = ".apk";
        String[] array = new String[2];
        String fileName = getUpLoadFileName(extName);
        array[0] = fileLocal + fileName;
        array[1] = fileName;
        File file = new File(fileLocal);
        if (!file.exists()) {
            file.mkdirs();
        }
        DataInputStream in = null;
        DataOutputStream out = null;
        try {
            in = new DataInputStream(urlCon.getInputStream());
            out = new DataOutputStream(new FileOutputStream(fileLocal + fileName));
            byte[] buffer = new byte[2048];
            int count = 0;
            while ((count = in.read(buffer)) > 0) {
                out.write(buffer, 0, count);
            }
        } finally {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
        }
        return array;
    }


    /**
     * 将文件拷贝到目标文件夹
     *
     * @param filePath
     * @param targetDir
     */
    public static void copyFile(String filePath, String targetDir) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new TipException(204, "文件不存在！");
        }
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(file), 16 * 1024);
            FileOutputStream f = new FileOutputStream(
                    targetDir + filePath.substring(filePath.lastIndexOf(File.separator), filePath.length()));
            out = new BufferedOutputStream(f, 16 * 1024);
            byte[] buffer = new byte[16 * 1024];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new TipException(500, "拷贝文件失败");
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 替换文件内容/移动文件
     *
     * @param filePath
     * @param targetDir
     * @throws Exception
     */
    public static void coverFile(String filePath, String targetDir) throws Exception {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new Exception("文件不存在！");
        }
        InputStream in = null;
        OutputStream out = null;
        int i = 2;
        try {
            in = new BufferedInputStream(new FileInputStream(file), 16 * 1024);
            FileOutputStream f = new FileOutputStream(targetDir);
            out = new BufferedOutputStream(f, 16 * 1024);
            byte[] buffer = new byte[16 * 1024];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                if (i>6){
                out.write(buffer, 0, len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("拷贝文件失败");
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
