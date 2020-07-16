package cn.zhuangcloud.karori.common;

import com.jfinal.core.Controller;

public class MyController extends Controller {

    protected void title(String title) {
        set("title", title);
    }

    protected void building() {
        render("/view/common/building.html");
    }

}
