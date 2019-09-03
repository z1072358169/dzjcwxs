package upftp;

import java.io.File;  
import java.io.FileInputStream;  
  
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;
  
//测试FTP的类  
public class UpFTP {  
	
    public void testFtpClient(String path, String csName, String L/*, String yName*/) throws Exception{
    	
        //创建一个FTPClient对象  
        FTPClient ftpClient = new FTPClient();
          
        //创建FTP连接,端口号可以设定，我的是22，默认是21
        ftpClient.connect("10.57.99.125",21);
        //ftpClient.connect("192.168.100.220",21);
          
        //登录FTP服务器，使用用户名和密码  
        //ftpClient.login("ftpadmin", "Zygh001");
        ftpClient.login("j3", "j3");
          
        //上传文件,读取本地文件  F:\image\wxy1.jpg
        //String path = "F://image/wxy1.jpg";
        //String path = "http://41.5.253.152:8090/Pics//vhipict/2018/06/09/14/410100000000999000107660404021/0320180609143557-880-1.jpg";
        String PATH1 = path.replace("http://41.5.253.152:8090", "E:/");
        String PATH2 = PATH1.replace("Pics1//", "Pics1/");
        
        FileInputStream inputStream = new FileInputStream(new File(PATH2)); 
          
        ftpClient.enterLocalPassiveMode();
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);//************此处是重点要不就服务器的图像就被损坏  
          
        //设置上传的路径  
        String[] path1 = path.split("//");
        String path1_2 = path1[2];
        String[] path2 = path1_2.split("/");
        
        //String pathname = "/qjcs/2018/06/09/14";//这个路径就是FTP服务端存储的路径，可以从FileZilla中获取  
        //String pathname = "/images/image/image1/";
        //ftp://j3:j3@10.57.99.125:21/
        
        String pathname = "/weifa/";
        if(pathname != null) {
        	ftpClient.makeDirectory(pathname);// 创建文件目录 
        	ftpClient.changeWorkingDirectory(pathname);// 切换至文件目录准备上传 
        }
        String pathname1 = "/weifa/"+path2[1]+path2[2]+"/";
        if(pathname != null) {
        	ftpClient.makeDirectory(pathname1);// 创建文件目录 
        	//ftpClient.changeWorkingDirectory(pathname);// 切换至文件目录准备上传 
        }
        String pathname2 = "/weifa/"+path2[1]+path2[2]+"/"+csName+"/";
        if(pathname != null) {
        	ftpClient.makeDirectory(pathname2);// 创建文件目录 
        	//ftpClient.changeWorkingDirectory(pathname);// 切换至文件目录准备上传 
        }
        String pathname3 = "/weifa/"+path2[1]+path2[2]+"/"+csName+"/"+L+"/";
        if(pathname != null) {
        	ftpClient.makeDirectory(pathname3);// 创建文件目录 
        	//ftpClient.changeWorkingDirectory(pathname);// 切换至文件目录准备上传 
        }
        String pathname4 = "/weifa/"+path2[1]+path2[2]+"/"+csName+"/"+L+"/"+path2[3]+"/";
        if(pathname != null) {
        	ftpClient.makeDirectory(pathname4);// 创建文件目录 
        	//ftpClient.changeWorkingDirectory(pathname);// 切换至文件目录准备上传 
        }
        String pathname5 = "/weifa/"+path2[1]+path2[2]+"/"+csName+"/"+L+"/"+path2[3]+"/"+path2[4]+"/";
        if(pathname != null) {
        	ftpClient.makeDirectory(pathname5);// 创建文件目录
        	ftpClient.changeWorkingDirectory(pathname5);// 切换至文件目录准备上传 
        }
        /*String pathname = "/qujiancesu/";
        ftpClient.changeWorkingDirectory(pathname);*/

        //参数一：服务器端文档名；参数二：上传文档的inputStream  
        String remote = path2[6]; 
        //String remote = "613.jpg";
        ftpClient.storeFile(remote, inputStream);  
          
        //关闭连接  
        ftpClient.logout();  
          
    }  
}  