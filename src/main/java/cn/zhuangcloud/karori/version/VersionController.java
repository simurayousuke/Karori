package cn.zhuangcloud.karori.version;

import cn.zhuangcloud.karori.common.MyController;
import cn.zhuangcloud.karori.common.interceptor.NeedLogin;
import com.jfinal.aop.Before;
import com.jfinal.i18n.I18n;
import com.jfinal.i18n.Res;
import com.jfinal.kit.StrKit;

public class VersionController extends MyController {

    @Before(NeedLogin.class)
    public void index() {
        String locale = getCookie("_locale");
        Res res = StrKit.notBlank(locale) ? I18n.use(locale) : I18n.use();
        title(res.get("version"));
        render("index.html");
    }

}
