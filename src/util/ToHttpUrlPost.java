package util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;

public class ToHttpUrlPost {

	public static String toHttpURL(JSONObject data)throws Exception{
		URL url = new URL("http://192.168.100.223:1345/recog_violation/");
		String param=data.toString();
		String result="";
		try {
			String charset="UTF-8";
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(600000);
			conn.setReadTimeout(600000);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			//conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
			conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			conn.connect();
			DataOutputStream out = new DataOutputStream(conn.getOutputStream());
			//String content="jsonStr="+URLEncoder.encode(param, "UTF-8");
//			out.write(content.getBytes(charset));
			out.write(param.getBytes());
			out.flush();
			out.close();
			
			BufferedReader reader =new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			result = buffer.toString();
			//result = result.replaceAll("(null)\\s*,","\"\",");
//			String result1=URLDecoder.decode(result,"UTF-8");
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			return result;
		}
	}
}
