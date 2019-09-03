package util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

public class restTemplate {

	public static void main(String[] args) {
		//String url = "http://41.5.253.170:8080/LHY/Getsjh?cph=豫A11111&hpzl=02";
		String url = "http://41.5.253.170:8080/LHY/Getsjh?cph={cph}&hpzl={hpzl}";
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> params = new HashMap<String, String>();
	    params.put("cph", "豫A88888");
	    params.put("hpzl", "02");
		String result = restTemplate.getForObject(url, String.class, params);
		System.out.println(result);
		//User result=restTemplate.getForObject(uri,User.class);
	}
}
