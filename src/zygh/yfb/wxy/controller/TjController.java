package zygh.yfb.wxy.controller;

import enums.DynamicDataSource;
import jxl.Workbook;
import jxl.format.*;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zygh.yfb.wxy.service.IntervalVMService;
import zygh.yfb.wxy.vo.TjVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class TjController {

    @Autowired
    private IntervalVMService intervalVMService;


   //查询--路口数据统计
/*     @RequestMapping("/findByAllLukou")
    public void findByAllLukou(TjVO tjVO, HttpServletResponse response)throws Exception{
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");

            //切换到临时库数据源
            DynamicDataSource.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
            DynamicDataSource.setCustomerType(DynamicDataSource.DataSourceTwo);//切换数据源，设置后 就OK了。可以随时切换过来（在controller层切换）
            List<TjVO> tjVOTempList = intervalVMService.findlukouBytemp(tjVO);

            //切换到默认数据库
            DynamicDataSource.clearCustomerType();
            DynamicDataSource.setCustomerType(DynamicDataSource.DataSource0ne);//切换回主数据源
            List<TjVO> tjVOillcount = intervalVMService.findByCJDZ1(tjVO);

            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject;
            for (int i = 0; i < tjVOTempList.size(); i++){
                jsonObject = new JSONObject();
                jsonObject.put("cjdz", tjVOTempList.get(i).getCJDZ());
                jsonObject.put("zpcount", tjVOTempList.get(i).getZqcount());
                long sfsh = 0;
                long mjsczt = 0;
                for (int j = 0; j < tjVOillcount.size(); j++){
                    if (tjVOTempList.get(i).getCJDZ().equals(tjVOillcount.get(j).getCJDZ())){
                        sfsh = tjVOillcount.get(j).getSfsfcount();
                        mjsczt = tjVOillcount.get(j).getMjscztcount();
                    }
                    jsonObject.put("sfshcount", sfsh);
                    jsonObject.put("mjscztcount", mjsczt);
                }
                jsonArray.add(jsonObject);
                jsonObject.clear();
            }
            response.getWriter().print(jsonArray);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            String msg = "";
            msg="失败";
            response.getWriter().print(msg);
        }
    }*/

    //查询--路口数据统计
//    @RequestMapping("/findByAllLukou")
//    public void findByAllLukou(TjVO tjVO, HttpServletResponse response)throws Exception{
//        try {
//            response.setHeader("Access-Control-Allow-Origin", "*");
//            response.setContentType("text/html;charset=utf-8");
//
//            //切换到临时库数据源
//            DynamicDataSource.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
//            DynamicDataSource.setCustomerType(DynamicDataSource.DataSourceTwo);//切换数据源，设置后 就OK了。可以随时切换过来（在controller层切换）
//            List<TjVO> tjVOTempList = intervalVMService.findlukouBytemp(tjVO);
//
//            //切换到默认数据库
//            DynamicDataSource.clearCustomerType();
//            DynamicDataSource.setCustomerType(DynamicDataSource.DataSource0ne);//切换回主数据源
//            List<TjVO> tjVOillcount = intervalVMService.findByCJDZ1(tjVO);
//
//            //查询所有的路口名
//            List<String> alllukou = intervalVMService.findAlllukou();
//            System.out.println("所有路口长度："+alllukou.size());
//
//            //取出临时库的路口名
//            List<String> templukouname = new  ArrayList<String>();
//            for (int k = 0; k < tjVOTempList.size(); k++) {
//                templukouname.add(tjVOTempList.get(k).getCJDZ());
//            }
//
//            /*templukouname.removeAll(alllukou);
//            System.out.println("多出来六个路口："+templukouname);*/
//
//            System.out.println("有数据路口长度："+templukouname.size());
//            alllukou.removeAll(templukouname);
//
//            System.out.println("差集："+alllukou.size());
//
//            JSONArray jsonArray = new JSONArray();
//            JSONObject jsonObject;
//            for (int g = 0; g < alllukou.size(); g++) {
//                jsonObject = new JSONObject();
//                jsonObject.put("cjdz", alllukou.get(g));
//                jsonObject.put("zpcount", 0);
//                jsonObject.put("sfshcount", 0);
//                jsonObject.put("mjscztcount", 0);
//
//                jsonArray.add(jsonObject);
//                jsonObject.clear();
//            }
//
//            for (int i = 0; i < tjVOTempList.size(); i++){
//                jsonObject = new JSONObject();
//                jsonObject.put("cjdz", tjVOTempList.get(i).getCJDZ());
//                jsonObject.put("zpcount", tjVOTempList.get(i).getZqcount());
//                long sfsh = 0;
//                long mjsczt = 0;
//                for (int j = 0; j < tjVOillcount.size(); j++){
//                    if (tjVOTempList.get(i).getCJDZ().equals(tjVOillcount.get(j).getCJDZ())){
//                        sfsh = tjVOillcount.get(j).getSfsfcount();
//                        mjsczt = tjVOillcount.get(j).getMjscztcount();
//                    }
//                    jsonObject.put("sfshcount", sfsh);
//                    jsonObject.put("mjscztcount", mjsczt);
//                }
//                templukouname.add(tjVOTempList.get(i).getCJDZ());
//
//                jsonArray.add(jsonObject);
//                jsonObject.clear();
//            }
//
//
//            response.getWriter().print(jsonArray);
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//            String msg = "";
//            msg="失败";
//            response.getWriter().print(msg);
//        }
//    }


}
