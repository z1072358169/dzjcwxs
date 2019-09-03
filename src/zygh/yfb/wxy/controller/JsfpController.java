package zygh.yfb.wxy.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import util.SpecialHp;
import zygh.yfb.wxy.service.IntervalVMService;
import zygh.yfb.wxy.service.JsfpService;
import zygh.yfb.wxy.vo.IntervalVM;
import zygh.yfb.wxy.vo.ScreenTotel;
import zygh.yfb.wxy.vo.Jsfp;
import zygh.yfb.wxy.vo.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class JsfpController {


    private static Logger logger = Logger.getLogger(JsfpController.class);

    private static final String REGEX = "豫A..J.[YW]";

    @Autowired
    private JsfpService jsfpService;

    @Autowired
    private IntervalVMService intervalVMService;

    //查询
    @RequestMapping("/findJsfpfz")
    public void  findJsfpfz(Jsfp jsfp, HttpServletResponse response) throws Exception {
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            List<Jsfp> list = jsfpService.findJsfpfz(jsfp);
            JSONArray jsay = JSONArray.fromObject(list);
            PrintWriter p = null;
            try {
                p = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (jsay != null) {
                p.print(jsay);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg = "失败";
            response.getWriter().print(msg);
        }
    }


    //查询
    @RequestMapping("/findAddressfz")
    public void findAddressfz(Jsfp jsfp,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            List<Jsfp> jsfpList = jsfpService.findAddressfz(jsfp);
            JSONArray jsay= JSONArray.fromObject(jsfpList);
            PrintWriter p=null;
            try {
                p=response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(jsay!=null){
                p.print(jsay);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    //查询违法地址初筛未筛选的
    @RequestMapping("/findAddresscsfz")
    public void findAddresscsfz(Jsfp jsfp,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            List<Jsfp> jsfpList = jsfpService.findAddresscsfz(jsfp);
            JSONArray jsay= JSONArray.fromObject(jsfpList);
            PrintWriter p=null;
            try {
                p=response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(jsay!=null){
                p.print(jsay);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    // 查询这个车牌除了本次违法外的其他违法记录    违法初筛的
    @RequestMapping("/findqtJsfpfz")
    public void findqtJsfpfz(Jsfp jsfp,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            List<Jsfp> jsfpList = jsfpService.findqtJsfpfz(jsfp);
            JSONArray jsay= JSONArray.fromObject(jsfpList);
            PrintWriter p=null;
            try {
                p=response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(jsay!=null){
                p.print(jsay);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    //初筛查询这个车牌有无同时间同地点的重复数据
    @RequestMapping("/findcfcsfz")
    public void findcfcsfz(HttpServletResponse response,Jsfp jsfp)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            long count = jsfpService.findcfcsfz(jsfp);
            if(count > 0){
                String msg = "";
                msg="1";
                response.getWriter().print(msg);
            }else{
                String msg = "";
                msg="0";
                response.getWriter().print(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    //修改号牌号码
    @RequestMapping("/updatehphmzlfz")
    public void updatehphmzlfz(Jsfp jsfp,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            jsfpService.updatehphmzlfz(jsfp);
            String msg = "";
            msg="成功";
            response.getWriter().print(msg);
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    //修改-之 分配数据给个人 --释放数据
    @RequestMapping("/updateghdatafz")
    public void updateghdatafz(String userName,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            jsfpService.updateghdatafz(userName);
            String msg = "";
            msg="成功";
            response.getWriter().print(msg);
            logger.info("释放数据："+userName);
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    //总页数
    @RequestMapping("/getCountfz")
    public void getCountfz(HttpServletResponse response,Jsfp jsfp)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            long count = jsfpService.getCountfz(jsfp);
            response.getWriter().print(count);
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    //查询
    @RequestMapping("/findPageByfz")
    @ResponseBody
    public PageInfo<Jsfp> findPageByfz(@RequestParam(value="pageNo",defaultValue="1")int pageNo,
                             @RequestParam(value="pageSize",defaultValue="10")int pageSize,
                             Jsfp jsfp, HttpServletResponse response)throws Exception{
        PageInfo<Jsfp> pageInfo = new PageInfo<Jsfp>();
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            PageHelper.startPage(pageNo, pageSize);
            List<Jsfp> list = jsfpService.findPageByfz(jsfp);
            pageInfo = new PageInfo<Jsfp>(list);
            return pageInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return pageInfo;
        }
    }

    //修改（筛选正片废片）
    @RequestMapping("/updateStatusfz")
    public void updateStatusfz(Jsfp jsfp,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            //筛选的车牌号
            String hp = jsfp.getHPHM();
            String sfsh = jsfp.getSFSH();

            boolean flag = hp.matches(REGEX);
            if(flag){
                sfsh = "3";
                jsfp.setSFSH(sfsh);
            }

            boolean result = false;
            if (sfsh.equals("0")){
                result = SpecialHp.myGet(hp);
                if (result){
                    jsfp.setSFSH("3");
                }
            }
            String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            //加上筛选日期
            jsfp.setScreenDate(date);
            int aa = jsfpService.updateStatuefz(jsfp);
            if(aa > 0){
                logger.info("违法初筛筛选记录"+jsfp);
                String msg = "";
                msg="成功";
                response.getWriter().print(msg);
            }else if(aa == 0){
                String msg = "";
                msg="此条数据已经被他人审核过了！";
                response.getWriter().print(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    //修改（筛选正片废片） 初筛  误筛
    @RequestMapping("/updateStatuecswsfz")
    public void updateStatuecswsfz(Jsfp jsfp,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            //筛选的车牌号
            String hp = jsfp.getHPHM();
            String sfsh = jsfp.getSFSH();

            boolean flag = hp.matches(REGEX);
            if(flag){
                sfsh = "3";
                jsfp.setSFSH(sfsh);
            }

            boolean result = false;
            if (sfsh.equals("0")){
                result = SpecialHp.myGet(hp);
                if (result){
                    jsfp.setSFSH("3");
                }
            }
            String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            //加上筛选日期
            jsfp.setScreenDate(date);
            int aa = jsfpService.updateStatuecswsfz(jsfp);
            if(aa > 0){
                String msg = "";
                msg="成功";
                response.getWriter().print(msg);
                logger.info("违法初筛筛选记录"+jsfp);
            }else if(aa == 0){
                String msg = "";
                msg="此条数据已经被他人审核过了！";
                response.getWriter().print(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    //筛选统计
    @RequestMapping("/finduserandcountfz")
    public void finduserandcountfz(HttpServletResponse response,Jsfp jsfp)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            List<ScreenTotel> screenTotelList = jsfpService.finduserandcountfz(jsfp);
            JSONArray jsay= JSONArray.fromObject(screenTotelList);
            PrintWriter p=null;
            try {
                p=response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(jsay!=null){
                p.print(jsay);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    //筛选统计
    @RequestMapping("/finduserandcount2fz")
    public void finduserandcount2fz(HttpServletResponse response,Jsfp jsfp)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            ScreenTotel screenTotelList = jsfpService.finduserandcount2fz(jsfp);
            ScreenTotel screenTotelList2 = jsfpService.finduserandcount3fz(jsfp);
            ScreenTotel screenTotelList4 = jsfpService.finduserandcount4fz(jsfp);

            JSONObject jj = new JSONObject();
            jj.put("allTotal", "0");
            jj.put("pass", "0");
            jj.put("tovoid", "0");
            jj.put("userName", jsfp.getUserName());
            JSONObject jsono = new JSONObject();
            JSONObject aa = null;
            if(screenTotelList == null){
                aa = jj;
            }else {
                aa = JSONObject.fromObject(screenTotelList);
            }
            jsono.put("tj1", aa);
            jsono.put("tj2", screenTotelList2);
            long allcs = 0;
            if (screenTotelList4 == null || screenTotelList4.getAllwsx() == 0){
                allcs = 0;
            }else{
                allcs = screenTotelList4.getAllwsx();
            }
            jsono.put("tj3", allcs);
            PrintWriter p=null;
            try {
                p=response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(jsono!=null){
                p.print(jsono);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    //查询未分配或者已分配的数据   用来修改-之 分配数据给个人  总条数
    @RequestMapping("/getCountfpNamefz")
    public void getCountfpNamefz(HttpServletResponse response,Jsfp jsfp)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            long count = jsfpService.getCountfpNamefz(jsfp);
            response.getWriter().print(count);
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    //修改-之 分配数据给个人
    @RequestMapping("/updateStatuefpNamefz")
    public  void updateStatuefpNamefz(Jsfp jsfp,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            jsfpService.updateStatuefpNamefz(jsfp);
            String msg = "";
            msg="成功";
            response.getWriter().print(msg);
            logger.info("违法初筛的提取数据信息"+jsfp);
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

}
