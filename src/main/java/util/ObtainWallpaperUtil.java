package util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author: 汉高鼠刘邦
 * @Date: 2020/8/7 18:36
 */
public class ObtainWallpaperUtil {

    public static JsonObject getXpath(String requestUrl){

        String res="";
        JsonObject object = null;
        StringBuffer buffer = new StringBuffer();

        try {

            URL url = new URL(requestUrl);
            HttpURLConnection urlCon= (HttpURLConnection)url.openConnection();

            if(200==urlCon.getResponseCode()){
                InputStream is = urlCon.getInputStream();
                InputStreamReader isr = new InputStreamReader(is,"utf-8");
                BufferedReader br = new BufferedReader(isr);

                String str = null;
                while((str = br.readLine())!=null){
                    buffer.append(str);
                }
                br.close();
                isr.close();
                is.close();
                res = buffer.toString();
               /* JsonParser parse =new JsonParser();
                object = (JsonObject) parse.parse(res);*/
                object = (JsonObject) JsonParser.parseString(res);

            }

        }catch (IOException e){
            e.printStackTrace();
        }

        return object;
    }


    public static JsonObject postDownloadJson(String path,String post){
        URL url = null;
        try {
            url = new URL(path);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");// 提交模式
            // conn.setConnectTimeout(10000);//连接超时 单位毫秒
            // conn.setReadTimeout(2000);//读取超时 单位毫秒
            // 发送POST请求必须设置如下两行
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            // 发送请求参数
            printWriter.write(post);//post的参数 xx=xx&yy=yy
            // flush输出流的缓冲
            printWriter.flush();
            //开始获取数据
            BufferedInputStream bis = new            BufferedInputStream(httpURLConnection.getInputStream());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            byte[] arr = new byte[1024];
            while((len=bis.read(arr))!= -1){
                bos.write(arr,0,len);
                bos.flush();
            }
            bos.close();
            JsonParser parse = new JsonParser();
            return (JsonObject)parse.parse(bos.toString("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getWallpaperPath(){
        JsonObject res;

        String tou = "https://www.bing.com";

        String path = "https://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1&mkt=zh-CN";
        //https://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1&mkt=zh-CN

        res = getXpath(path);

        /*System.out.println(res);
        System.out.println(res.get("images").getAsJsonArray().get(0).getAsJsonObject().get("url"));*/

        String image = res.get("images").getAsJsonArray().get(0).getAsJsonObject().get("url").getAsString();
        String str= image.replace("\"", "");

        /*System.out.println(tou + str);*/
        return (tou + str);
    }


    public static void main(String[] args) {


    }
}
