package util;

import zygh.yfb.wxy.vo.RestultVo;

/**
 * 对ResultVo的封装
 */
public class ResultVoUtil {

    public static RestultVo success(Object object){
        RestultVo restultVo = new RestultVo();
        restultVo.setData(object);
        restultVo.setCode(0);
        restultVo.setMsg("成功");
        return restultVo;
    }

    public static RestultVo shibai(){
        RestultVo restultVo = new RestultVo();
        restultVo.setCode(1);
        restultVo.setMsg("失败");
        return restultVo;
    }

    public static RestultVo success(){
        return success(null);
    }

    public static RestultVo error(Integer code, String msg){
        RestultVo restultVo = new RestultVo();
        restultVo.setCode(code);
        restultVo.setMsg(msg);
        return restultVo;
    }
}
