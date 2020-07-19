package cn.zhuangcloud.karori.common.base;

import cn.zhuangcloud.karori.common.model.User;
import com.jfinal.core.Controller;
import com.jfinal.i18n.I18n;
import com.jfinal.i18n.Res;
import com.jfinal.kit.StrKit;

public class MyController extends Controller {

    protected void title(String title) {
        set("title", title);
    }

    protected void building() {
        render("/view/common/building.html");
    }

    protected Integer getUid() {
        return ((User) getAttr("user")).getUid();
    }

    protected Res getRes() {
        String locale = getCookie("_locale");
        return StrKit.notBlank(locale) ? I18n.use(locale) : I18n.use();
    }

}
