package cn.zhuangcloud.karori.login;

import cn.zhuangcloud.karori.common.base.MyController;
import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;

public class LoginController extends MyController {

    @Inject
    LoginService loginService;

    public void index() {
        if (loginService.isLogin(getCookie("token"))) {
            redirect("/");
            return;
        }
        title("login");
        render("index.html");
    }

    @ActionKey("/logout")
    public void logout() {
        loginService.logout(getCookie("token"));
        removeCookie("token");
        redirect("/login");
    }

}
