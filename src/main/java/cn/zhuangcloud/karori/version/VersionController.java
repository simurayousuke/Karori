package cn.zhuangcloud.karori.version;

import cn.zhuangcloud.karori.common.MyController;
import cn.zhuangcloud.karori.common.interceptor.NeedLogin;
import com.jfinal.aop.Before;

public class VersionController extends MyController {

    @Before(NeedLogin.class)
    public void index() {
        title("version");
        render("index.html");
    }

}
