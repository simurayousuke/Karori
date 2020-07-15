package cn.zhuangcloud.karori.login;

import cn.zhuangcloud.karori.common.MyController;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.ext.interceptor.POST;

public class LoginController extends MyController {

    @Inject
    LoginService loginService;

    public void index() {
        if (loginService.isLogin(getCookie("token")))
            redirect("/");
        title("login");
        render("index.html");
    }

    public void error() {
        renderText("Wrong password.");
    }

    @Before({POST.class})
    public void v1(String username, String password) {
        String token = loginService.login(username, password);
        if (null == token)
            redirect("/login/error");
        setCookie("token", token, 60 * 60 * 24);
        redirect("/");
    }

}
