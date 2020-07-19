package cn.zhuangcloud.karori.food;

import cn.zhuangcloud.karori.common.base.MyController;

public class FoodController extends MyController {

    public void index() {
        title("foodLibrary");
        render("index.html");
    }

}
