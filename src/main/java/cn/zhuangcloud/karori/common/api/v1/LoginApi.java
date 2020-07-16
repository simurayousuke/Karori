package cn.zhuangcloud.karori.common.api.v1;

import cn.zhuangcloud.karori.login.LoginService;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;

public class LoginApi extends ApiV1 {

    @Inject
    LoginService loginService;

    @Clear
    public void index(String username, String password) {
        String token = loginService.login(username, password);
        if (null == token) {
            fail(getRes().get("wrongPassword"));
            return;
        }
        setCookie("token", token, 60 * 60 * 24);
        success(Ret.by("token", token));
    }

}
