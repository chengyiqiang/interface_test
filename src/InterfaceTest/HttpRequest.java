package InterfaceTest;

import getexcel.ReadExcel;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;



public class HttpRequest {
	//post请求的发送
   public static String sendPost(String path,String request){
        String response = null;
        try {
        	// 创建url资源
            URL url = new URL(path);
            // 建立http连接
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            // conn.setConnectTimeout(10000);//连接超时 单位毫秒
            // conn.setReadTimeout(2000);//读取超时 单位毫秒
            // 发送POST请求必须设置如下两行 // 设置允许输出输入
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);         
            httpURLConnection.setConnectTimeout(50000); //设置连接超时 
            httpURLConnection.setReadTimeout(50000);//设置读取超时 
            //设置对应的请求方式
            httpURLConnection.setRequestMethod("POST");
            // 设置维持长连接
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            // 设置文件类型:
            httpURLConnection.setRequestProperty("Content-Type","application/json");
            // 设置文件字符集:
            httpURLConnection.setRequestProperty("Charset", "UTF-8");          
            // 开始连接请求
            httpURLConnection.connect();
            OutputStream  out = httpURLConnection.getOutputStream();  
            // 写入请求的字符串
            out.write(request.getBytes());
            out.flush();
            out.close();
         // 请求返回的状态
            if (httpURLConnection.getResponseCode() == 200) {
//                System.out.println("连接成功");
                // 请求返回的数据
                BufferedInputStream in  = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    byte[] data1 = new byte[in.available()]; 
                    in.read(data1);
                    // 转成字符串
                    response = new String(data1,"UTF-8");
                    return response;
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            } else {
                System.out.println("请求出错，返回状态值为：" + httpURLConnection.getResponseCode());
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return response;
    }
       
    //get请求的发送
    public static String sendGet(String path,String request){
    	String response = null;
    	
    	return response;
    }
    
    //读取用例并请求，并写入结果
    public static void requestAndWriteResult (int row){
    	try {
			String request = ReadExcel.getRequest(row);
			String url= ReadExcel.getUrl(row);
			String affirm= ReadExcel.getAffirm(row);
			String respone = sendPost(url, request);
			if (respone.contains(affirm)) {
				ReadExcel.writeResult(row, respone, true);
			}else{
				ReadExcel.writeResult(row, respone, false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}