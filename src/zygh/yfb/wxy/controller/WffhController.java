package zygh.yfb.wxy.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zygh.yfb.wxy.service.WffhService;
import zygh.yfb.wxy.vo.ScreenTotel;
import zygh.yfb.wxy.vo.Wffh;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
public class WffhController {

    private static Logger logger = Logger.getLogger(WffhController.class);

    @Autowired
    private WffhService wffhService;

    //查询
    @RequestMapping("/queryWffh")
    public void queryWffh(Wffh wffh, HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            List<Wffh> WffhList = wffhService.findWffh(wffh);
            JSONArray jsay=JSONArray.fromObject(WffhList);
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

    // 查询这个车牌除了本次违法外的其他违法记录   民警初筛的
    @RequestMapping("/findqtwfnew")
    public void findqtwfnew(Wffh wffh,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            List<Wffh> wffhList = wffhService.findqtwfnew(wffh);
            JSONArray jsay=JSONArray.fromObject(wffhList);
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

    //查询违法地址民警未筛选的
    @RequestMapping("/findAddressmjnew")
    public void findAddressmjnew(Wffh wffh,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            List<Wffh> wffhList = wffhService.findAddressmjnew(wffh);
            JSONArray jsay=JSONArray.fromObject(wffhList);
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

    //修改号牌号码
    @RequestMapping("/updatehphmzlnew")
    public void updatehphmzlnew(Wffh wffh,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            wffhService.updatehphmzlnew(wffh);
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

    //查询
    @RequestMapping("/findPageBynew")
    public void findPageBynew(Wffh wffh, HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            int start = (wffh.getPageNow()-1)*(wffh.getPageSize());
            wffh.setStart(start);
            List<Wffh> wffhList = wffhService.findPageBynew(wffh);
            JSONArray jsay=JSONArray.fromObject(wffhList);
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

    //总页数
    @RequestMapping("/getCountnew")
    public void getCountnew(HttpServletResponse response,Wffh wffh)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            long count = wffhService.getCountnew(wffh);
            response.getWriter().print(count);
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    //民警筛选--修改（筛选正片废片）
    @RequestMapping("/updateStatusmjnew")
    public void updateStatusmjnew(Wffh wffh,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            //筛选的车牌号
            //String hp = wffh.getHPHM();
            String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            //加上筛选日期
            wffh.setScreenDatemj(date);
            int aa = wffhService.updateStatuemjnew(wffh);
            if(aa > 0){
                String msg = "";
                msg="成功";
                response.getWriter().print(msg);
                logger.info("初筛复合筛选记录"+wffh);
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

    //民警筛选--修改误筛（筛选正片废片）
    @RequestMapping("/updatewsnew")
    public void updatewsnew(Wffh wffh,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            //加上筛选日期
            wffh.setScreenDatemj(date);
            int aa = wffhService.updatewsnew(wffh);
            if(aa > 0){
                String msg = "";
                msg="成功";
                response.getWriter().print(msg);
                logger.info("修改误筛记录"+wffh);
            }else if(aa == 0){
                String msg = "";
                msg="此条数据已上传不允许修改！";
                response.getWriter().print(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    //查询未分配或者已分配的数据  修改-之 分配数据给个人  总条数 ----民警 ----新
    @RequestMapping("/getCountfpNamemjnew")
    public void getCountfpNamemjnew(HttpServletResponse response,Wffh wffh)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            long count = wffhService.getCountfpNamemjnew(wffh);
            response.getWriter().print(count);
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }


    //修改-之 分配数据给个人 ---民警------新
    @RequestMapping("/updateStatuefpNamemjnew")
    public  void updateStatuefpNamemjnew(Wffh wffh,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            wffhService.updateStatuefpNamemjnew(wffh);
            String msg = "";
            msg="成功";
            response.getWriter().print(msg);
            logger.info("民警初筛复合的提取数据信息"+wffh);
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    //修改-之 分配数据给个人 --释放数据 --民警 ---新
    @RequestMapping("/updateghdatamjnew")
    public void updateghdatamjnew(String mjuserName,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            wffhService.updateghdatamjnew(mjuserName);
            String msg = "";
            msg="成功";
            response.getWriter().print(msg);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    //民警筛选统计
    @RequestMapping("/finduserandcountmjnew")
    public void finduserandcountmjnew(HttpServletResponse response,Wffh wffh)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            ScreenTotel screenTotelList = wffhService.finduserandcountmjnew(wffh);
            ScreenTotel screenTotelList2 = wffhService.finduserandcountmj2new(wffh);
            ScreenTotel screenTotelList4 = wffhService.finduserandcountmj4new(null);

            JSONObject jj = new JSONObject();
            jj.put("allTotal", "0");
            jj.put("pass", "0");
            jj.put("tovoid", "0");
            jj.put("mjuserName", wffh.getMjuserName());
            JSONObject jsono = new JSONObject();
            JSONObject aa = null;
            if(screenTotelList == null){
                aa = jj;
            }else {
                aa = JSONObject.fromObject(screenTotelList);
            }
            if(screenTotelList4 == null){
                aa.put("allwsx", 0);
            }else {
                aa.put("allwsx", screenTotelList4.getAllwsx());
            }
            jsono.put("tj1", aa);
            jsono.put("tj2", screenTotelList2);
            //JSONArray jsay=JSONArray.fromObject(jsono);
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

    /*//民警复核统计  复核统计页面
    @RequestMapping("/finduserandcountmj4new")
    public void finduserandcountmj4new(HttpServletResponse response,Wffh wffh)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");

            List<String> mjuserNames = wffhService.findmjuserNamenew();
            JSONArray jsona = new JSONArray();
            for (int i = 0; i < mjuserNames.size(); i++) {
                wffh.setMjuserName(mjuserNames.get(i));
                ScreenTotel screenTotelList = wffhService.finduserandcountmjnew(wffh);
                ScreenTotel screenTotelList2 = wffhService.finduserandcountmj2new(wffh);
                JSONObject jj = new JSONObject();
                if(screenTotelList == null){
                    jj.put("allTotal", 0);

                    jj.put("pass", 0);
                    jj.put("tovoid", 0);
                    jj.put("mjuserName", wffh.getMjuserName());
                }else{
                    jj.put("allTotal", screenTotelList.getAllTotal());
                    jj.put("pass", screenTotelList.getPass());
                    jj.put("tovoid", screenTotelList.getTovoid());
                    jj.put("mjuserName", wffh.getMjuserName());
                }
                if(screenTotelList2 == null){
                    jj.put("screening", 0);
                }else{
                    jj.put("screening", screenTotelList2.getScreening());
                }
                jsona.add(jj);
            }
            //JSONArray jsay=JSONArray.fromObject(jsono);
            PrintWriter p=null;
            try {
                p=response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(jsona!=null){
                p.print(jsona);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }*/

    //民警复核统计  复核统计页面
    @RequestMapping("/finduserandcountmj4new")
    public void finduserandcountmj4new(HttpServletResponse response,Wffh wffh)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            List<ScreenTotel> screenTotelList = wffhService.finduserandcountmj5new(wffh);

            if (screenTotelList != null) {
                Iterator<ScreenTotel> it = screenTotelList.iterator();
                while (it.hasNext()) {
                    ScreenTotel screenTotel = it.next();
                    if (screenTotel.getAllTotal() == 0 && screenTotel.getScreening() == 0)
                        it.remove();
                }
            }
            JSONArray jsay=JSONArray.fromObject(screenTotelList);
            System.out.println(jsay);
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

    //民警筛选统计
    @RequestMapping("/finduserandcountmj3new")
    public void finduserandcountmj3new(HttpServletResponse response,Wffh wffh)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            List<ScreenTotel> screenTotelList = wffhService.finduserandcountmj3new(wffh);
            JSONArray jsay=JSONArray.fromObject(screenTotelList);
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

    //民警查询这个车牌有无同时间同地点的重复数据
    @RequestMapping("/findcfmjnew")
    public void findcfmjnew(HttpServletResponse response,Wffh wffh)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            long count = wffhService.findcfmjnew(wffh);
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


}
