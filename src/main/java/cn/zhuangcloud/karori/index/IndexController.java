package cn.zhuangcloud.karori.index;

import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;

public class IndexController extends Controller {

    public void index() {
        set("title", "index");
        set("devMode", PropKit.get("devMode"));
        render("index.html");
    }
}
