package cn.zhuangcloud.karori.target;

import cn.zhuangcloud.karori.common.base.MyController;
import cn.zhuangcloud.karori.common.interceptor.NeedLogin;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;

public class TargetController extends MyController {

    @Inject
    TargetService targetService;

    @Before(NeedLogin.class)
    public void index() {
        title("targetValue");
        set("_target", targetService.getByUidNotNull(getUid()));
        render("index.html");
    }

}
