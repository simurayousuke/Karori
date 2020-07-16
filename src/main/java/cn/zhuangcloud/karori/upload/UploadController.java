package cn.zhuangcloud.karori.upload;

import cn.zhuangcloud.karori.common.MyController;

public class UploadController extends MyController {

    /*

     */
    public void index() {
        title("uploadFood");
        render("index.html");
    }

    public void mine() {
        building();
    }

}
