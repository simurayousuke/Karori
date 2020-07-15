package cn.zhuangcloud.karori.reg;

import cn.zhuangcloud.karori.common.MyController;
import cn.zhuangcloud.karori.login.LoginService;
import com.jfinal.aop.Inject;

public class RegController extends MyController {

    @Inject
    LoginService loginService;

    public void index() {
        renderError(404);
    }

    public void error() {
        renderError(500);
    }

    public void v1(String username, String password) {
        String token = loginService.reg(username, password);
        if (null == token) {
            redirect("/reg/error");
            return;
        }
        setCookie("token", token, 60 * 60 * 24);
        redirect("/");
    }

}
