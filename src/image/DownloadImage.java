package image;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import upftp.UpFTP;

public class DownloadImage {

	public static void main(String[] args) throws Exception {
		//download("http://ui.51bi.com/opt/siteimg/images/fanbei0923/Mid_07.jpg", "51bi.gif", "c:\\image\\");
		//download("http://41.5.253.152:8090/Pics//vhipict/2018/06/09/14/410100000000999000107660404021/0320180609143557-880-1.jpg", "wxy.jpg", "F:\\image\\");
	}

	public static void download(String urlString, /*String filename,*/ String savePath, String csName, String M) throws Exception {
		// TODO Auto-generated method stub
		// 构造URL
		URL url = new URL(urlString);
		//打开链接
		URLConnection con = url.openConnection();
		//设置请求超时为5s
		con.setConnectTimeout(5*1000);
		// 输入流
		InputStream is = con.getInputStream();
		// 1K的数据缓冲
		byte[] bs = new byte[1024];
		// 读取到的数据长度
		int len;
		// 输出的文件流
		File sf=new File(savePath);
		if(!sf.exists()){
			sf.mkdirs();
		}
		
		String filename = urlString.substring(urlString.lastIndexOf("/")+1, urlString.length());
		System.out.println("filename!!"+filename);
		OutputStream os = new FileOutputStream(sf.getPath() +"\\"+ filename);
		
		//文件真实路径+名字
		String aaa = "D://"+"image/"+ filename;
		System.out.println("111"+sf.getPath());
		System.out.println("aaa"+aaa);
		//String aaa1 = "F://image/" + filename;
		//System.out.println("aaa"+aaa1);
		//String aaa = "F://image/wxy1.jpg";
		
		// 开始读取  
		while((len = is.read(bs)) != -1) {
			os.write(bs, 0, len);
		}
		// 完毕，关闭所有链接  
		os.close();
		is.close();
		
//		UpFTP up1 = new UpFTP();
//		up1.testFtpClient(aaa, csName, M, urlString);
//		UpFTP up2 = new UpFTP();
//		up2.testFtpClient(aaa, csName, M, urlString);
//		UpFTP up3 = new UpFTP();
//		up3.testFtpClient(aaa, csName, M, urlString);
	}
}
