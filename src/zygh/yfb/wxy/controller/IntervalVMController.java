package zygh.yfb.wxy.controller;

import image.DownImage;
import image.DownloadImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.net.util.Base64;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import upftp.UpFTP;
import util.*;
import zygh.yfb.wxy.mapper.ManufacturerNumberMapper;
import zygh.yfb.wxy.service.IntervalVMService;
import zygh.yfb.wxy.service.ManufacturerNumberService;
import zygh.yfb.wxy.service.PlateTypeService;
import zygh.yfb.wxy.service.SpecialhpService;
import zygh.yfb.wxy.vo.DownImageVo;
import zygh.yfb.wxy.vo.IntervalVM;
import zygh.yfb.wxy.vo.IntervalVMExample;
import zygh.yfb.wxy.vo.ManufacturerNumber;
import zygh.yfb.wxy.vo.ScreenTotel;
import zygh.yfb.wxy.vo.Specialhp;


/**
 * 高速公路
 * 区间测速
 * @author 王喜亚
 *
 */

@Controller
public class IntervalVMController {

    private static Logger logger = Logger.getLogger(IntervalVMController.class);

    private final Base64 base64 = new Base64();

    @Autowired
    private IntervalVMService intervalVMService;

    //厂商
    @Autowired
    private ManufacturerNumberService manufacturerNumberService;

    //号牌种类
    @Autowired
    private PlateTypeService plateTypeService;

    @Autowired
    private SpecialhpService specialhpService;


    //查询
    @RequestMapping("/queryIntervalVM")
    public void queryIntervalVM(IntervalVM intervalVM,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            List<IntervalVMExample> intervalVMList = intervalVMService.findIntervalVM(intervalVM);
            JSONArray jsay=JSONArray.fromObject(intervalVMList);
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
    @RequestMapping("/findqtwf")
    public void findqtwf(IntervalVM intervalVM,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            List<IntervalVM> intervalVMList = intervalVMService.findqtwf(intervalVM);
            JSONArray jsay=JSONArray.fromObject(intervalVMList);
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
    @RequestMapping("/findqtwfcs")
    public void findqtwfcs(IntervalVM intervalVM,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            List<IntervalVM> intervalVMList = intervalVMService.findqtwfcs(intervalVM);
            JSONArray jsay=JSONArray.fromObject(intervalVMList);
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
    @RequestMapping("/findAddress")
    public void findAddress(IntervalVM intervalVM,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            List<IntervalVM> intervalVMList = intervalVMService.findAddress(intervalVM);
            JSONArray jsay=JSONArray.fromObject(intervalVMList);
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
    @RequestMapping("/findAddressmj")
    public void findAddressmj(IntervalVM intervalVM,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            List<IntervalVM> intervalVMList = intervalVMService.findAddressmj(intervalVM);
            JSONArray jsay=JSONArray.fromObject(intervalVMList);
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
    @RequestMapping("/findAddresscs")
    public void findAddresscs(IntervalVM intervalVM,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            List<IntervalVM> intervalVMList = intervalVMService.findAddresscs(intervalVM);
            JSONArray jsay=JSONArray.fromObject(intervalVMList);
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

    //添加
    @RequestMapping("/addIntervalVM")
    public void addIntervalVM(IntervalVM intervalVM,HttpServletResponse response) throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            intervalVMService.addIntervalVM(intervalVM);
            String msg = "";
            msg="1";
            response.getWriter().print(msg);
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    //删除
    @RequestMapping("/deleteIntervalVM")
    public void deleteIntervalVM(Integer[] sysids,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            intervalVMService.deleteIntervalVM(sysids);
            String msg = "";
            msg="1";
            response.getWriter().print(msg);
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    //修改
    @RequestMapping("/updateIntervalVM")
    public void updateIntervalVM(IntervalVM intervalVM,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            intervalVMService.updateIntervalVM(intervalVM);
            String msg = "";
            msg="1";
            response.getWriter().print(msg);
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }

    }

    //修改号牌号码
    @RequestMapping("/updatehphm")
    public void updatehphm(IntervalVM intervalVM,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            intervalVMService.updatehphm(intervalVM);
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

    //修改号牌号码
    @RequestMapping("/updatehpzl")
    public void updatehpzl(IntervalVM intervalVM,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            intervalVMService.updatehpzl(intervalVM);
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
    @RequestMapping("/findPage")
    public void findPage(Page page, HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
			/*page.setPageNow(2);
			page.setPageSize(10);*/
            int start = (page.getPageNow()-1)*(page.getPageSize());;
            page.setStart(start);
            List<IntervalVM> intervalVMList = intervalVMService.findPage(page);
            JSONArray jsay=JSONArray.fromObject(intervalVMList);
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
    @RequestMapping("/findPageBy")
    public void findPageBy(IntervalVMExample intervalVMExample, HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
			/*intervalVMExample.setPageNow(1);
			intervalVMExample.setPageSize(2);
			intervalVMExample.setLicensePlateType("1");*/
            int start = (intervalVMExample.getPageNow()-1)*(intervalVMExample.getPageSize());
            intervalVMExample.setStart(start);
            List<IntervalVMExample> intervalVMList = intervalVMService.findPageBy(intervalVMExample);
            JSONArray jsay=JSONArray.fromObject(intervalVMList);
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
    @RequestMapping("/getCount")
    public void getCount(HttpServletResponse response,IntervalVM intervalVM)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            long count = intervalVMService.getCount(intervalVM);
            response.getWriter().print(count);
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    //查询--上一条
    @RequestMapping("/findUpOne")
    public void findUpOne(IntervalVM intervalVM,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            IntervalVMExample intervalVMExample = intervalVMService.findUpOne(intervalVM);
            JSONArray jsay=JSONArray.fromObject(intervalVMExample);
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


    //查询--上一条  违法数据查询用的
    @RequestMapping("/findUpOnewhb")
    public void findUpOnewhb(IntervalVM intervalVM,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            IntervalVMExample intervalVMExample = intervalVMService.findUpOnewhb(intervalVM);
            JSONArray jsay=JSONArray.fromObject(intervalVMExample);
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

    //民警查询--上一条
    @RequestMapping("/findUpOnemj")
    public void findUpOnemj(IntervalVM intervalVM,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            IntervalVMExample intervalVMExample = intervalVMService.findUpOnemj(intervalVM);
            JSONArray jsay=JSONArray.fromObject(intervalVMExample);
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

    //民警查询误筛的--上一条
    @RequestMapping("/findmjws")
    public void findmjws(IntervalVM intervalVM,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            IntervalVMExample intervalVMExample = intervalVMService.findmjws(intervalVM);
            JSONArray jsay=JSONArray.fromObject(intervalVMExample);
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

    //查询--下一条
    @RequestMapping("/findDownOne")
    public void findDownOne(IntervalVM intervalVM,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            IntervalVMExample intervalVMExample = intervalVMService.findDownOne(intervalVM);
            JSONArray jsay=JSONArray.fromObject(intervalVMExample);
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

    //查询--违法数据查询   下一条
    @RequestMapping("/findDownOnewhb")
    public void findDownOnewhb(IntervalVM intervalVM,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            IntervalVMExample intervalVMExample = intervalVMService.findDownOnewhb(intervalVM);
            JSONArray jsay=JSONArray.fromObject(intervalVMExample);
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

    //民警查询--下一条
    @RequestMapping("/findDownOnemj")
    public void findDownOnemj(IntervalVM intervalVM,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            IntervalVMExample intervalVMExample = intervalVMService.findDownOnemj(intervalVM);
            JSONArray jsay=JSONArray.fromObject(intervalVMExample);
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
    @RequestMapping("/updateStatus")
    public void updateStatus(IntervalVM intervalVM,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            //筛选的车牌号
            String hp = intervalVM.getHPHM();
            String sfsh = intervalVM.getSFSH();

            boolean result = false;
            if (sfsh.equals("0")){
                result = SpecialHp.myGet(hp);
            }
            if (result){
                intervalVMService.deletebyid(intervalVM.getSysid());
                logger.info("删除白名单的信息"+intervalVM);
                String msg = "";
                msg="成功";
                response.getWriter().print(msg);
            }else{
                String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                //加上筛选日期
                intervalVM.setScreenDate(date);
                int aa = intervalVMService.updateStatue(intervalVM);
                if(aa > 0){
                    logger.info("违法初筛筛选记录"+intervalVM);
                    String msg = "";
                    msg="成功";
                    response.getWriter().print(msg);
                }else if(aa == 0){
                    String msg = "";
                    msg="此条数据已经被他人审核过了！";
                    response.getWriter().print(msg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    //修改（筛选正片废片）
	/*@RequestMapping("/updateStatus")
	public void updateStatus(IntervalVM intervalVM,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");

			//筛选的车牌号
			String hp = intervalVM.getHPHM();
			//String hp = "豫ARD726";
			int youwu =  specialhpService.findSpecialhpByHp(hp);
			System.out.println("youwu: "+ youwu);
			if(youwu > 0){
				intervalVM.setSFSH("3");
			}
			System.out.println("aaaa: "+intervalVM);
			String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			//加上筛选日期
			intervalVM.setScreenDate(date);
			//intervalVMService.updateStatue(intervalVM);
			int aa = intervalVMService.updateStatue(intervalVM);
			if(aa > 0){
				String msg = "";
				msg="成功";
				response.getWriter().print(msg);
				logger.info("违法初筛筛选记录"+intervalVM);
			}else if(aa == 0){
				String msg = "";
				msg="此条数据已经被他人审核过了！";
				response.getWriter().print(msg);
			}
			System.out.println("aa: "+aa);
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "";
			msg="失败";
			response.getWriter().print(msg);
		}
	}*/


    //修改（筛选正片废片） 初筛  误筛
    @RequestMapping("/updateStatuecsws")
    public void updateStatuecsws(IntervalVM intervalVM,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            //筛选的车牌号
            String hp = intervalVM.getHPHM();
            String sfsh = intervalVM.getSFSH();

            boolean result = false;
            if (sfsh.equals("0")){
                result = SpecialHp.myGet(hp);
            }
            if (result){
                intervalVMService.deletebyid(intervalVM.getSysid());
                String msg = "";
                msg="成功";
                response.getWriter().print(msg);
                logger.info("删除白名单的信息"+intervalVM);
            }else{
                String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                //加上筛选日期
                intervalVM.setScreenDate(date);
                int aa = intervalVMService.updateStatuecsws(intervalVM);
                if(aa > 0){
                    String msg = "";
                    msg="成功";
                    response.getWriter().print(msg);
                    logger.info("违法初筛筛选记录"+intervalVM);
                }else if(aa == 0){
                    String msg = "";
                    msg="此条数据已经被他人审核过了！";
                    response.getWriter().print(msg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }


    //修改（筛选正片废片） 初筛  误筛
    /*@RequestMapping("/updateStatuecsws")
    public void updateStatuecsws(IntervalVM intervalVM,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            //筛选的车牌号
            String hp = intervalVM.getHPHM();
            int youwu =  specialhpService.findSpecialhpByHp(hp);
            if(youwu > 0){
                intervalVM.setSFSH("3");
            }
            String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            //加上筛选日期
            intervalVM.setScreenDate(date);
            //intervalVMService.updateStatue(intervalVM);
            int aa = intervalVMService.updateStatuecsws(intervalVM);
            if(aa > 0){
                String msg = "";
                msg="成功";
                response.getWriter().print(msg);
                logger.info("修改误筛记录"+intervalVM);
            }else if(aa == 0){
                String msg = "";
                msg="此条数据已上传复核不允许修改！";
                response.getWriter().print(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }*/


    //民警筛选--修改（筛选正片废片）
    @RequestMapping("/updateStatusmj")
    public void updateStatusmj(IntervalVM intervalVM,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            //筛选的车牌号
            String hp = intervalVM.getHPHM();
            //String hp = "豫ARD726";
            //int youwu =  specialhpService.findSpecialhpByHp(hp);
            //System.out.println("youwu: "+ youwu);
			/*boolean result = SpecialHp.myGet(hp);
			if(result){
				intervalVM.setMJSCZT(3);
			}*/
            String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            //加上筛选日期
            intervalVM.setScreenDatemj(date);
            //intervalVMService.updateStatue(intervalVM);
            int aa = intervalVMService.updateStatuemj(intervalVM);
            if(aa > 0){
                String msg = "";
                msg="成功";
                response.getWriter().print(msg);
                logger.info("初筛复合筛选记录"+intervalVM);
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
    @RequestMapping("/updatews")
    public void updatews(IntervalVM intervalVM,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            //筛选的车牌号
			/*String hp = intervalVM.getHPHM();
			boolean result = SpecialHp.myGet(hp);
			if(result){
				intervalVM.setMJSCZT(3);
			}*/
            String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            //加上筛选日期
            intervalVM.setScreenDatemj(date);
            //intervalVMService.updateStatue(intervalVM);
            int aa = intervalVMService.updatews(intervalVM);
            if(aa > 0){
                String msg = "";
                msg="成功";
                response.getWriter().print(msg);
                logger.info("修改误筛记录"+intervalVM);
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


    //@RequestMapping("/wxyy")
	/*public static void main(String args[])throws Exception{
		//response.setHeader("Access-Control-Allow-Origin", "*");
		//response.setContentType("text/html;charset=utf-8");
		boolean result = SpecialHp.myGet("豫AZK696");
		if (result){
			System.out.println("白名单");
			//response.getWriter().print("这个车牌在白名单里有");
		}else{
			System.out.println("黑名单");
			//response.getWriter().print("没有");
		}
	}*/



    //查询未分配或者已分配的数据   用来修改-之 分配数据给个人  总条数
    @RequestMapping("/getCountfpName")
    public void getCountfpName(HttpServletResponse response,IntervalVM intervalVM)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            long count = intervalVMService.getCountfpName(intervalVM);
            response.getWriter().print(count);
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    //查询未分配或者已分配的数据  修改-之 分配数据给个人  总条数 ----民警 ----新
    @RequestMapping("/getCountfpNamemj")
    public void getCountfpNamemj(HttpServletResponse response,IntervalVM intervalVM)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            long count = intervalVMService.getCountfpNamemj(intervalVM);
            response.getWriter().print(count);
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    //修改-之 分配数据给个人
    @RequestMapping("/updateStatuefpName")
    public  void updateStatuefpName(IntervalVMExample intervalVMExample,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            intervalVMService.updateStatuefpName(intervalVMExample);
            String msg = "";
            msg="成功";
            response.getWriter().print(msg);
            logger.info("违法初筛的提取数据信息"+intervalVMExample);
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }

    //修改-之 分配数据给个人 ---民警------新
    @RequestMapping("/updateStatuefpNamemj")
    public  void updateStatuefpNamemj(IntervalVMExample intervalVMExample,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            intervalVMService.updateStatuefpNamemj(intervalVMExample);
            String msg = "";
            msg="成功";
            response.getWriter().print(msg);
            logger.info("民警初筛复合的提取数据信息"+intervalVMExample);
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }



    //-之 分配数据给个人 查询未被分配的数据
    @RequestMapping("/findPageByfpName")
    public void findPageByfpName(IntervalVMExample intervalVMExample, HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
			/*intervalVMExample.setPageNow(1);
			intervalVMExample.setPageSize(2);
			intervalVMExample.setLicensePlateType("1");*/
            int start = (intervalVMExample.getPageNow()-1)*(intervalVMExample.getPageSize());
            intervalVMExample.setStart(start);
            List<IntervalVMExample> intervalVMList = intervalVMService.findPageByfpName(intervalVMExample);
            JSONArray jsay=JSONArray.fromObject(intervalVMList);
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

    //-之 分配数据给个人 查询未被分配的数据 ---民警----------新
    @RequestMapping("/findPageByfpNamemj")
    public void findPageByfpNamemj(IntervalVMExample intervalVMExample, HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
			/*intervalVMExample.setPageNow(1);
			intervalVMExample.setPageSize(2);
			intervalVMExample.setLicensePlateType("1");*/
            int start = (intervalVMExample.getPageNow()-1)*(intervalVMExample.getPageSize());
            intervalVMExample.setStart(start);
            List<IntervalVMExample> intervalVMList = intervalVMService.findPageByfpNamemj(intervalVMExample);
            JSONArray jsay=JSONArray.fromObject(intervalVMList);
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

    //修改-之 分配数据给个人 --释放数据
    @RequestMapping("/updateghdata")
    public void updateghdata(String userName,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            intervalVMService.updateghdata(userName);
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

    //修改-之 分配数据给个人 --释放数据 --民警 ---新
    @RequestMapping("/updateghdatamj")
    public void updateghdatamj(String mjuserName,HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            intervalVMService.updateghdatamj(mjuserName);
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

    //筛选统计
    @RequestMapping("/finduserandcount")
    public void finduserandcount(HttpServletResponse response,IntervalVM intervalVM)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            List<ScreenTotel> screenTotelList = intervalVMService.finduserandcount(intervalVM);
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


    //筛选统计
    @RequestMapping("/finduserandcount2")
    public void finduserandcount2(HttpServletResponse response,IntervalVM intervalVM)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            ScreenTotel screenTotelList = intervalVMService.finduserandcount2(intervalVM);
            ScreenTotel screenTotelList2 = intervalVMService.finduserandcount3(intervalVM);
            ScreenTotel screenTotelList4 = intervalVMService.finduserandcount4(intervalVM);

            JSONObject jj = new JSONObject();
            jj.put("allTotal", "0");
            jj.put("pass", "0");
            jj.put("tovoid", "0");
            jj.put("userName", intervalVM.getUserName());
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

    //民警筛选统计
    @RequestMapping("/finduserandcountmj")
    public void finduserandcountmj(HttpServletResponse response,IntervalVM intervalVM)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            ScreenTotel screenTotelList = intervalVMService.finduserandcountmj(intervalVM);
            ScreenTotel screenTotelList2 = intervalVMService.finduserandcountmj2(intervalVM);
            ScreenTotel screenTotelList4 = intervalVMService.finduserandcountmj4(null);

            JSONObject jj = new JSONObject();
            jj.put("allTotal", "0");
            jj.put("pass", "0");
            jj.put("tovoid", "0");
            jj.put("mjuserName", intervalVM.getMjuserName());
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

    //民警复核统计  复核统计页面
    @RequestMapping("/finduserandcountmj4")
    public void finduserandcountmj4(HttpServletResponse response,IntervalVM intervalVM)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");

            List<String> mjuserNames = intervalVMService.findmjuserName();
            JSONArray jsona = new JSONArray();
            for (int i = 0; i < mjuserNames.size(); i++) {
                intervalVM.setMjuserName(mjuserNames.get(i));
                ScreenTotel screenTotelList = intervalVMService.finduserandcountmj(intervalVM);
                ScreenTotel screenTotelList2 = intervalVMService.finduserandcountmj2(intervalVM);
                JSONObject jj = new JSONObject();
                if(screenTotelList == null){
                    jj.put("allTotal", 0);
                    jj.put("pass", 0);
                    jj.put("tovoid", 0);
                    jj.put("mjuserName", intervalVM.getMjuserName());
                }else{
                    jj.put("allTotal", screenTotelList.getAllTotal());
                    jj.put("pass", screenTotelList.getPass());
                    jj.put("tovoid", screenTotelList.getTovoid());
                    jj.put("mjuserName", intervalVM.getMjuserName());
                }
                if(screenTotelList2 == null){
                    jj.put("screening", 0);
                }else{
                    jj.put("screening", screenTotelList2.getScreening());
                }
                jsona.add(jj);
				/*JSONObject jj = new JSONObject();
				jj.put("allTotal", "0");
				jj.put("pass", "0");
				jj.put("tovoid", "0");
				jj.put("screening", "0");
				jj.put("mjuserName", intervalVM.getMjuserName());

				JSONObject jj2 = new JSONObject();
				jj.put("screening", "0");
				JSONObject jsono = new JSONObject();
				JSONObject aa = null;
				if(screenTotelList == null){
					aa = jj;
				}else {
					aa = JSONObject.fromObject(screenTotelList);
				}
				jsono.put("tj1", aa);
				jsono.put("tj2", screenTotelList2);
				jsona.add(jsono);*/
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
    }

    //民警筛选统计
    @RequestMapping("/finduserandcountmj3")
    public void finduserandcountmj3(HttpServletResponse response,IntervalVM intervalVM)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            List<ScreenTotel> screenTotelList = intervalVMService.finduserandcountmj3(intervalVM);
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


    @RequestMapping("/daochulukou")//导出考勤
    public void exporby(IntervalVM intervalVM,HttpServletRequest request, HttpServletResponse response) throws Exception{
        //页面传的查询条件
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");
        String path = request.getRealPath( "/Excel" );
        File file1 = new File(path);//获取文件夹路径
        if(!file1.exists()){//判断文件夹是否创建，没有创建则创建新文件夹
            file1.mkdirs();
        }
        int radom = new Random().nextInt(999999);
        String filename ="路口数量表"+radom+".xls";
        File file=new File(path+"/路口数量表"+radom+".xls");
        try {
            file.createNewFile();
            WritableWorkbook wwb=Workbook.createWorkbook(file);
            WritableSheet ws =wwb.createSheet("sheet1", 0);

            //设置每列的宽度
            ws.setColumnView(0, 8);
            ws.setColumnView(1, 60);
            ws.setColumnView(2, 12);

            //设置字体;
            WritableFont font1 = new WritableFont(WritableFont.createFont("楷体"),20);
            WritableCellFormat diyihang = new WritableCellFormat(font1);
            diyihang.setAlignment(Alignment.CENTRE);
            diyihang.setVerticalAlignment(VerticalAlignment.CENTRE);
            diyihang.setWrap(true);
            diyihang.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,jxl.format.Colour.BLACK); //BorderLineStyle边框

            WritableFont font2 = new WritableFont(WritableFont.createFont("楷体"),16);
            //创建格式化对象实例
            WritableCellFormat headerfor = new WritableCellFormat(font2);
            //水平居中对齐
            headerfor.setAlignment(Alignment.CENTRE);
            //竖直方向居中对齐
            headerfor.setVerticalAlignment(VerticalAlignment.CENTRE);
            //设置自动换行
            headerfor.setWrap(true);
            //设置边框线
            headerfor.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,jxl.format.Colour.BLACK); //BorderLineStyle边框
            //headerfor.setBorder(Border.ALL, BorderLineStyle.THIN);

            //jxl.write.WritableFont wfcNav =new jxl.write.WritableFont(WritableFont.ARIAL,12, WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.BLACK);
            //WritableCellFormat wcfN=new WritableCellFormat(wfcNav);
            //Color color = Color.decode("#0099cc"); // 自定义的颜色
            //workbook.setColourRGB(Colour.ORANGE, color.getRed(),color.getGreen(), color.getBlue());
            //wcfN.setBackground(Colour.ORANGE);
            //wcfN.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,jxl.format.Colour.BLACK); //BorderLineStyle边框
            //wcfN.setAlignment(Alignment.CENTRE); //设置水平对齐
            //wcfN.setWrap(false); //设置自动换行


			/*List<Sign> signlist = signService.findexcelll(sign);*/
			/*List<Sign> signlist = signService.findSign(sign);*/
            //List<Sign> signlist = signService.findprintSign(sign);
            List<IntervalVM> intervalVMList = intervalVMService.findAddress(intervalVM);


            //合并单元格（左上列，左上行，右下列，右下行）
            //ws.mergeCells(0, 0, 7, 0);

            //设置Sheet表的标题，使用刚才合并的单元格，并将格式绑定
			/*String ti1 = "";
			if(sign.getTime1() != null){
				ti1 = sign.getTime1();
			}
			String ti2 = "";
			if(sign.getTime2() != null){
				ti2 = sign.getTime2();
			}
			String ti3 = "所有数据";
			if(ti1 != "" && ti2 != ""){
				ti3 = ti1 + "——"+ ti2;
			}
			Label sheetTitle = new Label(0, 0, "中裕广恒OA—外出签到表"+"   "+ti3, diyihang);
			ws.addCell(sheetTitle); */

            Label labelsecName = new Label(0, 0, "序号", headerfor);
            ws.addCell(labelsecName);

            Label labeluserName = new Label(1, 0, "路口", headerfor);
            ws.addCell(labeluserName);

            Label labelsignDate = new Label(2, 0, "数量", headerfor);
            ws.addCell(labelsignDate);

            for (int i = 0; i < intervalVMList.size(); i++) {

                Label labelsecName_i = new Label(0, i + 1, i + 1+"", headerfor);
                Label labeluserName_i = new Label(1, i + 1, intervalVMList.get(i).getCJDZ(), headerfor);
                Label labelsignDate_i = new Label(2, i + 1, intervalVMList.get(i).getAddcount() +"", headerfor);

                ws.addCell(labelsecName_i);
                ws.addCell(labeluserName_i);
                ws.addCell(labelsignDate_i);

            }
            wwb.write();
            wwb.close();

            String msg = "";
            msg= filename;
            response.getWriter().print(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //下载图片
	/*@RequestMapping("/downimage")
	public void downimage(HttpServletResponse response,IntervalVM intervalVM)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			List<IntervalVM> intervalVMList = intervalVMService.downimage(intervalVM);
			DownImageVo dvo = null;
			for (int i = 0; i < intervalVMList.size(); i++) {
				dvo = new DownImageVo();
				dvo.setSysid(intervalVMList.get(i).getSysid());
				dvo.setWFDM(intervalVMList.get(i).getWFDM());
				dvo.setSBBH(intervalVMList.get(i).getSBBH());
				dvo.setFXBH(intervalVMList.get(i).getFXBH());
				dvo.setCDBH(intervalVMList.get(i).getCDBH());
				dvo.setHPHM(intervalVMList.get(i).getHPHM());
				dvo.setSysid(intervalVMList.get(i).getSysid());
				dvo.setURL1(intervalVMList.get(i).getURL1());
				try {
					DownImage.download(dvo);
				} catch (Exception e) {
					e.printStackTrace();
					String msg = "";
					msg="此条失败，继续下一条";
					response.getWriter().print(msg);
				}
			}
			String msg = "";
			msg="完成";
			response.getWriter().print(msg);
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "";
			msg="失败";
			response.getWriter().print(msg);
		}
	}*/

    //初筛查询这个车牌有无同时间同地点的重复数据
    @RequestMapping("/findcfcs")
    public void findcfcs(HttpServletResponse response,IntervalVM intervalVM)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            long count = intervalVMService.findcfcs(intervalVM);
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


    //民警查询这个车牌有无同时间同地点的重复数据
    @RequestMapping("/findcfmj")
    public void findcfmj(HttpServletResponse response,IntervalVM intervalVM)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            long count = intervalVMService.findcfmj(intervalVM);
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


    //查询
	/*@RequestMapping("/sss")
	public void sss(HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			//查出重复的车牌号
			List<String> list = intervalVMService.findhp();
			System.out.println("qq: "+list.size());
			for (int i = 0; i < list.size(); i++) {
				List<IntervalVM> list1 = intervalVMService.findhp1(list.get(i));
				for (int j = 0; j < list1.size(); j++) {
					//if(!list1.get(j).getSFSH().equals("0")){
						intervalVMService.deletebyid(list1.get(j).getSysid());
					//}
				}
			}
			JSONArray jsay=JSONArray.fromObject(list);
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
	}*/

}
