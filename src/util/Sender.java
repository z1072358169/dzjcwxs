package util;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;


public class Sender {

	 private static final String URL="tcp://10.57.99.120:61616";
	 private static final String USERNAME="hiatmp";
	 private static final String PASSWORD="hiatmp";
	 private static final String topicName="HIATMP.HISENSE.ILLEGAL";
	 
	 public static void sender(String result) throws JMSException {
	        //创建工厂类
	        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(USERNAME,PASSWORD,URL);
	        //创建连接
	        Connection conn=connectionFactory.createConnection();
	        //启动连接
	        conn.start();
	        //创建会话
	        Session session=conn.createSession(false,Session.AUTO_ACKNOWLEDGE);
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
	        TextMessage message=session.createTextMessage(result);
            producer.send(message);
	        
	        //关闭连接
	            conn.close();
	            System.out.println("成功发送");
	    }
}
