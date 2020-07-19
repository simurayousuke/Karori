package cn.zhuangcloud.karori.share;

import cn.zhuangcloud.karori.common.base.MyController;
import cn.zhuangcloud.karori.common.interceptor.NeedLogin;
import com.jfinal.aop.Before;

public class ShareController extends MyController {

    @Before(NeedToken.class)
    public void index() {
        title("statistic");
        render("index.html");
    }

    @Before(NeedLogin.class)
    public void create(){
        title("share");
        render("create.html");
    }

}
