package cn.zhuangcloud.karori.version;

import cn.zhuangcloud.karori.common.base.MyController;

public class VersionController extends MyController {

    public void index() {
        title("version");
        render("index.html");
    }

}
