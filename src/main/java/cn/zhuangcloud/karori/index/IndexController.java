package cn.zhuangcloud.karori.index;

import cn.zhuangcloud.karori.common.MyController;
import com.jfinal.kit.PropKit;

public class IndexController extends MyController {

    public void index() {
        title("index");
        set("devMode", PropKit.get("devMode"));
        render("index.html");
    }
}
