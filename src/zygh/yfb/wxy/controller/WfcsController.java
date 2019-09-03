package zygh.yfb.wxy.controller;

import com.alibaba.fastjson.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import util.SpecialHp;
import zygh.yfb.wxy.service.IntervalVMService;
import zygh.yfb.wxy.service.WfcsService;
import zygh.yfb.wxy.vo.IntervalVM;
import zygh.yfb.wxy.vo.ScreenTotel;
import zygh.yfb.wxy.vo.Wfcs;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class WfcsController {


    private static Logger logger = Logger.getLogger(WfcsController.class);

    private static final String REGEX = "豫A..J.[YW]";

    @Autowired
    private WfcsService wfcsService;

    @Autowired
    private IntervalVMService intervalVMService;

    //查询
    @RequestMapping("/findWfcsold")
    public void findWfcsold(Wfcs wfcs, HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            List<Wfcs> wfcsList = wfcsService.findWfcsold(wfcs);
            JSONArray jsay= JSONArray.fromObject(wfcsList);
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

    //查询
    @RequestMapping("/findAddressold")
    public void findAddressold(Wfcs wfcs,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            List<Wfcs> wfcsList = wfcsService.findAddressold(wfcs);
            JSONArray jsay= JSONArray.fromObject(wfcsList);
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
    @RequestMapping("/findAddresscsold")
    public void findAddresscsold(Wfcs wfcs,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            List<Wfcs> wfcsList = wfcsService.findAddresscsold(wfcs);
            JSONArray jsay= JSONArray.fromObject(wfcsList);
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
    @RequestMapping("/findqtwfcsold")
    public void findqtwfcsold(Wfcs wfcs,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            List<Wfcs> wfcsList = wfcsService.findqtwfcsold(wfcs);
            JSONArray jsay= JSONArray.fromObject(wfcsList);
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
    @RequestMapping("/findcfcsold")
    public void findcfcsold(HttpServletResponse response,Wfcs wfcs)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            long count = wfcsService.findcfcsold(wfcs);
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
    @RequestMapping("/updatehphmzlold")
    public void updatehphmzlold(Wfcs wfcs,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            wfcsService.updatehphmzlold(wfcs);
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
    @RequestMapping("/updateghdataold")
    public void updateghdataold(String userName,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            wfcsService.updateghdataold(userName);
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
    @RequestMapping("/getCountold")
    public void getCountold(HttpServletResponse response,Wfcs wfcs)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            long count = wfcsService.getCountold(wfcs);
            response.getWriter().print(count);
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    //查询
    @RequestMapping("/findPageByold")
    public void findPageByold(Wfcs wfcs, HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            int start = (wfcs.getPageNow()-1)*(wfcs.getPageSize());
            wfcs.setStart(start);
            List<Wfcs> wfcsList = wfcsService.findPageByold(wfcs);
            JSONArray jsay= JSONArray.fromObject(wfcsList);
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

    //修改（筛选正片废片）
    @RequestMapping("/updateStatusold")
    public void updateStatusold(Wfcs wfcs,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            //筛选的车牌号
            String hp = wfcs.getHPHM();
            String sfsh = wfcs.getSFSH();

            boolean flag = hp.matches(REGEX);
            if(flag){
                wfcs.setSFSH("3");
            }

            boolean result = false;
            if (sfsh.equals("0")){
                result = SpecialHp.myGet(hp);
                if(result){

                }
            }
            String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            //加上筛选日期
            wfcs.setScreenDate(date);
            int aa = wfcsService.updateStatueold(wfcs);
            if(aa > 0){
                logger.info("违法初筛筛选记录"+wfcs);
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
    @RequestMapping("/updateStatuecswsold")
    public void updateStatuecswsold(Wfcs wfcs,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            //筛选的车牌号
            String hp = wfcs.getHPHM();
            String sfsh = wfcs.getSFSH();

            boolean flag = hp.matches(REGEX);
            if(flag){
                sfsh = "3";
                wfcs.setSFSH(sfsh);
            }

            boolean result = false;
            if (sfsh.equals("0")){
                result = SpecialHp.myGet(hp);
                if (result){
                    wfcs.setSFSH("3");
                }
            }
            String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            //加上筛选日期
            wfcs.setScreenDate(date);
            int aa = wfcsService.updateStatuecswsold(wfcs);
            if(aa > 0){
                String msg = "";
                msg="成功";
                response.getWriter().print(msg);
                logger.info("违法初筛筛选记录"+wfcs);
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
    @RequestMapping("/finduserandcountold")
    public void finduserandcountold(HttpServletResponse response,Wfcs wfcs)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            List<ScreenTotel> screenTotelList = wfcsService.finduserandcountold(wfcs);
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
    @RequestMapping("/finduserandcount2old")
    public void finduserandcount2old(HttpServletResponse response,Wfcs wfcs)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            ScreenTotel screenTotelList = wfcsService.finduserandcount2old(wfcs);
            ScreenTotel screenTotelList2 = wfcsService.finduserandcount3old(wfcs);
            ScreenTotel screenTotelList4 = wfcsService.finduserandcount4old(wfcs);

            JSONObject jj = new JSONObject();
            jj.put("allTotal", "0");
            jj.put("pass", "0");
            jj.put("tovoid", "0");
            jj.put("userName", wfcs.getUserName());
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
    @RequestMapping("/getCountfpNameold")
    public void getCountfpNameold(HttpServletResponse response,Wfcs wfcs)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            long count = wfcsService.getCountfpNameold(wfcs);
            response.getWriter().print(count);
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    //修改-之 分配数据给个人
    @RequestMapping("/updateStatuefpNameold")
    public  void updateStatuefpNameold(Wfcs wfcs,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            wfcsService.updateStatuefpNameold(wfcs);
            String msg = "";
            msg="成功";
            response.getWriter().print(msg);
            logger.info("违法初筛的提取数据信息"+wfcs);
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }


    //查询五百个路口的名字
    @RequestMapping("/findAlllukou")
    public void findAlllukou(HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            List<String> wfcsList = intervalVMService.findAlllukou();
            String jsay = JSON.toJSONString(wfcsList);
            //JSONArray jsay= JSONArray.fromObject(wfcsList);
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

}
