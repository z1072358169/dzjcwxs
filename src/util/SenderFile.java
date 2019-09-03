package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.BlobMessage;


public class SenderFile {

	 private static final String URL="tcp://10.57.99.120:61616";
	 private static final String USERNAME="hiatmp";
	 private static final String PASSWORD="hiatmp";
	 private static final String topicName="HIATMP.HISENSE.ILLEGAL";
	 
	 public static void sender(String result) throws JMSException, Exception {
		 
		 	InputStream is=null;
		 	
		 	//ActiveMQSession session;
	        //创建工厂类
	        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(USERNAME,PASSWORD,URL);
	        //创建连接
	        Connection conn=connectionFactory.createConnection();
	        //启动连接
	        conn.start();
	        //创建会话
	        ActiveMQSession session=(ActiveMQSession) conn.createSession(false,Session.AUTO_ACKNOWLEDGE);
	        //创建目的地(消息发送的目标)
	        Destination destination=session.createTopic(topicName);
	        //创建消息发布者
	        MessageProducer producer= session.createProducer(destination);
	        
	        /*for(int i=0;i<10;i++) {
	            //创建消息
	            TextMessage message=session.createTextMessage("中裕广恒"+i);
	            producer.send(message);
	            System.out.println("发送消息"+i+" "+message.getText());
	        }*/
	        
	        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        BlobMessage blobMessage = session.createBlobMessage(new File("F:/dzjc.xml"));
	        // 设置该消息的超时时间(有效期)
	        producer.setTimeToLive(60000);
	        // 发送
	        producer.send(blobMessage);
	        producer.close();
	        System.out.println("发送成功有文件4");
	        
	        /*BlobMessage blob = session.createBlobMessage(new File(文件路径));
	        blob.setStringProperty("fileName", file.getName());//设置文件名
	        producer = session.createProducer( session.createQueue(queueName));
	        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
	        producer.send(blob);
	        producer.close();
	        producer=null;*/
	        
	        
	        /*TextMessage message=session.createTextMessage(result);
            producer.send(message);*/
	        
	        //关闭连接
	            conn.close();
	            System.out.println("成功发送");
	    }
}
