package cn.zhuangcloud.karori.food;

import cn.zhuangcloud.karori.common.MyController;

public class FoodController extends MyController {

    public void index() {
        title("foodLibrary");
        render("index.html");
    }

}
