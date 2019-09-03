package util;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;

import net.sf.json.JSONObject;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.springframework.web.bind.annotation.RequestBody;


public class sendjsonstr {

	public static String sendXMLstr(String json)throws Exception{
        try {
            String endpoint = "http://10.57.99.245:9080/rminf/services/RmOutAccess?wsdl";
            //String endpoint = "http://localhost:8080/ca3/services/caSynrochnized?wsdl";
            //直接引用远程的wsdl文件
            //以下都是套路
            
            JSONObject jsonObject = JSONObject.fromObject(json); 

            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(endpoint);
            //ttp://localhost:8080/rmweb/services/RmOutAccess
            call.setOperationName("writeObjectOut");
//               call.addParameter("userName", org.apache.axis.encoding.XMLType.XSD_DATE,
//                             javax.xml.rpc.ParameterMode.IN);//接口的参数
            call.addParameter("xtlb", XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter("jkxlh", XMLType.XSD_STRING,ParameterMode.IN);
            call.addParameter("jkid", XMLType.XSD_STRING,ParameterMode.IN);
            call.addParameter("UTF8XmlDoc", XMLType.XSD_STRING,ParameterMode.IN);
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置返回类型
            call.setUseSOAPAction(true);
            call.setSOAPActionURI("http://www.wj.com/Rpc");

   			String UTF8XmlDoc = "<root><surscreen>";
			UTF8XmlDoc += "<sbbh>" + StringUtil.encodeUTF8(jsonObject.getString("sbbh")) + "</sbbh>";
			UTF8XmlDoc += "<clfl>" + StringUtil.encodeUTF8("3") + "</clfl>";
			UTF8XmlDoc += "<hpzl>" + StringUtil.encodeUTF8(jsonObject.getString("hpzl")) + "</hpzl>";
			UTF8XmlDoc += "<hphm>" + StringUtil.encodeUTF8(jsonObject.getString("hphm")) + "</hphm>";
			UTF8XmlDoc += "<wfxw>" + StringUtil.encodeUTF8(jsonObject.getString("wfxw")) + "</wfxw>";
			UTF8XmlDoc += "<zqmj>" + StringUtil.encodeUTF8("") + "</zqmj>";
			UTF8XmlDoc += "<zpsl>" + StringUtil.encodeUTF8("1") + "</zpsl>";
			UTF8XmlDoc += "<zpstr1>" + StringUtil.encodeUTF8(readFile(jsonObject.getString("zpstr1"))) + "</zpstr1>";
			UTF8XmlDoc += "</surscreen></root>";

            //String postdata = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><surscreen><sbbh>410195010000016277</sbbh><zqmj>123456</zqmj><clfl>6</clfl><hpzl>02</hpzl><hphm>豫A2TL76</hphm><xzqh>123456</xzqh><wfdd>12345</wfdd><lddm>1234</lddm><ddms>123</ddms><wfdz>J</wfdz><wfsj>2018-08-01 15:32:24</wfsj><wfsj1>2018-08-01 15:32:24</wfsj1><wfxw></wfxw><scz></scz><bzz></bzz><zpsl>StringUtil.encodeUTF8(\"1\")</zpsl><zpwjm></zpwjm><zpstr1></zpstr1><zpstr2></zpstr2><zpstr3></zpstr3><wfspdz></wfspdz></surscreen>";
            Object[] paramValues = new Object[] {"60","7A1E1D0D020703070A1502010002090200060904070C178CE5356D72692E636E","60W01",UTF8XmlDoc};
            //String ret = (String)call.invoke(new Object[] {paramValues});
            String ret = (String)call.invoke(paramValues);

            //String temp = "测试人员";
            //String result = (String)call.invoke(new Object[]{temp});
            //给方法传递参数，并且调用方法
            System.out.println("result is "+ret);
            return ret;
        }
        catch (Exception e) {
            System.err.println(e.toString());
            return "shibai";
        }
	}
	
	private static String readFile(String name) {
        try {
            File file = new File(name);
            FileInputStream is = new FileInputStream(file);
            byte[] b = StringUtil.getByte(is);
            return StringUtil.base64ToStr(b);
        } catch (Exception e) {
            return "";
        }
    }
}
