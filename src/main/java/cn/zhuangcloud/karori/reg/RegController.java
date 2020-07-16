package cn.zhuangcloud.karori.reg;

import cn.zhuangcloud.karori.common.MyController;
import cn.zhuangcloud.karori.login.LoginService;
import com.jfinal.aop.Inject;

public class RegController extends MyController {

    @Inject
    LoginService loginService;

    public void index() {
        if (loginService.isLogin(getCookie("token"))) {
            redirect("/");
            return;
        }
        title("reg");
        render("index.html");
    }

}
