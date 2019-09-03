package util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import net.sf.json.JSONObject;


/**
 * java把要传的数据放入jsonobject，和要发送的服务器接口地址，直接发送给目标服务器上的接口，
 * 让目标服务器上的接口解析jsonobject数据处理成xml数据发送给msdl接口
 * @author 王喜亚
 *
 */
public class SendJson {

	public static final void sendJson(String add_url, JSONObject obj){
		//String add_url = "http://192.168.100.129:8080/zyghOffice/addt_ICItem.action";
        //  String query = " {\"mainUser\":{\"name\":\""+name+"\",\"gender\":\""+gender+"\",\"birthDate\":\""+birthDate+"\",\"birthDateAccurate\":\""+birthDateAccurate+"\",\"addrId\":\""+addrId+"\"},\"productId\":\""+productId+"\"}";
         
          // final static String params = "[{\"FModel\":\"88888\",\"FLowLimit\":99,\"FFullName\":\"Ь��\",\"FItemID\":88,\"t_ICINum\":1}]";  
          
          
          try {
              URL url = new URL(add_url);
              HttpURLConnection connection = (HttpURLConnection)url.openConnection();
              connection.setDoInput(true);
              connection.setDoOutput(true);
              connection.setRequestMethod("POST");
              connection.setUseCaches(false);
              connection.setInstanceFollowRedirects(true);
              connection.setRequestProperty("Content-Type","application/json;charset=UTF-8");
              connection.connect();
              DataOutputStream out = new DataOutputStream(connection.getOutputStream());
              
              
              /*JSONObject obj = new JSONObject();

            //String token = "d5f224c9f83874da5b5025794c773e8e";
              obj.put("FModel", "88888");
              obj.put("FLowLimit", 99);
              obj.put("FFullName", "Ь��");*/
              out.write(obj.toString().getBytes());
              out.flush();
              out.close();
               
              BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
              String lines;
              StringBuffer sbf = new StringBuffer();
              while ((lines = reader.readLine()) != null) {
            	  lines = new String(lines.getBytes());
            	  sbf.append(lines);
               }
              System.out.println(sbf);
              reader.close();
              connection.disconnect();
          } catch (MalformedURLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }

    }  
}
