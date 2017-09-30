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
	//post����ķ���
   public static String sendPost(String path,String request){
        String response = null;
        try {
        	// ����url��Դ
            URL url = new URL(path);
            // ����http����
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            // conn.setConnectTimeout(10000);//���ӳ�ʱ ��λ����
            // conn.setReadTimeout(2000);//��ȡ��ʱ ��λ����
            // ����POST������������������� // ���������������
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);         
            httpURLConnection.setConnectTimeout(50000); //�������ӳ�ʱ 
            httpURLConnection.setReadTimeout(50000);//���ö�ȡ��ʱ 
            //���ö�Ӧ������ʽ
            httpURLConnection.setRequestMethod("POST");
            // ����ά�ֳ�����
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            // �����ļ�����:
            httpURLConnection.setRequestProperty("Content-Type","application/json");
            // �����ļ��ַ���:
            httpURLConnection.setRequestProperty("Charset", "UTF-8");          
            // ��ʼ��������
            httpURLConnection.connect();
            OutputStream  out = httpURLConnection.getOutputStream();  
            // д��������ַ���
            out.write(request.getBytes());
            out.flush();
            out.close();
         // ���󷵻ص�״̬
            if (httpURLConnection.getResponseCode() == 200) {
//                System.out.println("���ӳɹ�");
                // ���󷵻ص�����
                BufferedInputStream in  = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    byte[] data1 = new byte[in.available()]; 
                    in.read(data1);
                    // ת���ַ���
                    response = new String(data1,"UTF-8");
                    return response;
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            } else {
                System.out.println("�����������״ֵ̬Ϊ��" + httpURLConnection.getResponseCode());
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return response;
    }
       
    //get����ķ���
    public static String sendGet(String path,String request){
    	String response = null;
    	
    	return response;
    }
    
    //��ȡ���������󣬲�д����
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