package cn.zhuangcloud.karori.index;

import cn.zhuangcloud.karori.common.MyController;

public class IndexController extends MyController {

    public void index() {
        title("index");
        render("index.html");
    }
}
