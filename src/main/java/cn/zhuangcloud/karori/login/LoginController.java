package cn.zhuangcloud.karori.login;

import cn.zhuangcloud.karori.common.MyController;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.i18n.I18n;
import com.jfinal.i18n.Res;
import com.jfinal.kit.StrKit;

public class LoginController extends MyController {

    @Inject
    LoginService loginService;

    public void index() {
        if (loginService.isLogin(getCookie("token"))) {
            redirect("/");
            return;
        }
        String locale = getCookie("_locale");
        Res res = StrKit.notBlank(locale) ? I18n.use(locale) : I18n.use();
        title(res.get("login"));
        render("index.html");
    }

    public void error() {
        //todo page remake
        renderText("Wrong password.");
    }

    @Before({POST.class})
    public void v1(String username, String password) {
        String token = loginService.login(username, password);
        if (null == token) {
            redirect("/login/error");
            return;
        }
        setCookie("token", token, 60 * 60 * 24);
        redirect("/");
    }

    @ActionKey("/logout")
    public void logout() {
        loginService.logout(getCookie("token"));
        removeCookie("token");
        redirect("/login");
    }

}
