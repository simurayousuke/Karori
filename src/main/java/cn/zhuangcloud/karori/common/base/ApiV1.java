package cn.zhuangcloud.karori.common.base;

import cn.zhuangcloud.karori.common.model.User;
import com.jfinal.core.Controller;
import com.jfinal.i18n.I18n;
import com.jfinal.i18n.Res;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ApiV1 extends Controller {

    protected Res getRes() {
        String locale = getCookie("_locale");
        return StrKit.notBlank(locale) ? I18n.use(locale) : I18n.use();
    }

    protected void fail() {
        renderJson(Ret.fail());
    }

    protected void fail(String msg) {
        renderJson(Ret.fail("msg", msg));
    }

    protected void fail(Ret ret) {
        renderJson(ret.setFail());
    }

    protected void success() {
        renderJson(Ret.ok());
    }

    protected void success(String msg) {
        renderJson(Ret.ok("msg", msg));
    }

    protected void success(Ret ret) {
        renderJson(ret.setOk());
    }

    protected <T> T bean(Class<T> beanClass) {
        return getBean(beanClass, "");
    }

    protected Integer getUid() {
        return ((User) getAttr("user")).getUid();
    }

    protected User getUser() {
        return ((User) getAttr("user"));
    }

    protected boolean isSameDay(Date date1,Date date2){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        return fmt.format(date1).equals(fmt.format(date2));
    }

}
