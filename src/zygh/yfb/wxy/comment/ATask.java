package zygh.yfb.wxy.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zygh.yfb.wxy.service.IntervalVMService;
import zygh.yfb.wxy.service.WffhService;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Component
public class ATask {


    //private IntervalVMService intervalVMService;
    @Autowired
    private WffhService wffhService;

    public void test(){
        try {
            wffhService.shifangallnew();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
