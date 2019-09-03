package zygh.yfb.wxy.mapper;

import java.util.List;
import zygh.yfb.wxy.vo.PlateColor;

/**
 * 号牌颜色
 * @author 王喜亚
 *
 */
public interface PlateColorMapper {
	
    //查询信息
    public List<PlateColor> findPlateColor(PlateColor plateColor)throws Exception;
    
	//添加
	public void addPlateColor(PlateColor plateColor)throws Exception;
	
	//删除
	public void deletePlateColor(Integer[] sysIds) throws Exception;
	
	//修改信息
	public void updatePlateColor(PlateColor plateColor)throws Exception;
	
	
}
