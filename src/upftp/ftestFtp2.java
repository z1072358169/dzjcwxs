package upftp;

import java.io.File;  
import java.io.FileInputStream;  
  
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;
  
//测试FTP的类  
public class ftestFtp2 {  
    @Test  
    public void testFtpClient() throws Exception{
        //创建一个FTPClient对象  
        FTPClient ftpClient = new FTPClient();  
          
        //创建FTP连接,端口号可以设定，我的是22，默认是21  
        ftpClient.connect("192.168.100.35",21);  
          
        //登录FTP服务器，使用用户名和密码  
        ftpClient.login("zygh-yfb", "123456");  
          
        //上传文件,读取本地文件  
        String path = "G:\\image\\aaa.jpg";  
        FileInputStream inputStream = new FileInputStream(new File(path));  
          
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);//************此处是重点要不就服务器的图像就被损坏  
          
        //设置上传的路径  
        String pathname = "/wenjian";//这个路径就是FTP服务端存储的路径，可以从FileZilla中获取  
        ftpClient.changeWorkingDirectory(pathname);  
          
        //参数一：服务器端文档名；参数二：上传文档的inputStream  
        String remote = "aaa.jpg";  
        ftpClient.storeFile(remote, inputStream);  
          
        //关闭连接  
        ftpClient.logout();  
          
    }  
}  