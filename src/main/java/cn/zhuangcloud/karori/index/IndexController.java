package cn.zhuangcloud.karori.index;

import cn.zhuangcloud.karori.common.MyController;

public class IndexController extends MyController {

    public void index() {
        title("Karori");
        render("index.html");
    }
}
