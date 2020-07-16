package cn.zhuangcloud.karori.upload;

import cn.zhuangcloud.karori.common.MyController;
import cn.zhuangcloud.karori.common.interceptor.NeedLogin;
import com.jfinal.aop.Before;

public class UploadController extends MyController {

    /*

     */
    @Before(NeedLogin.class)
    public void index() {
        title("uploadFood");
        render("index.html");
    }

    public void mine() {
        building();
    }

}
