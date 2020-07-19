package cn.zhuangcloud.karori.index;

import cn.zhuangcloud.karori.common.base.MyController;

public class IndexController extends MyController {

    public void index() {
        //todo remake home page
        title("Karori");
//        render("index.html");
        redirect("/food");
    }
}
