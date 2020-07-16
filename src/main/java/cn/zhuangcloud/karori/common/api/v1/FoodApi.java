package cn.zhuangcloud.karori.common.api.v1;

import cn.zhuangcloud.karori.common.model.Composition;
import cn.zhuangcloud.karori.common.model.Food;
import com.jfinal.kit.Ret;

public class FoodApi extends ApiV1 {

    public void upload() {
        Composition composition = bean(Composition.class);
        Food food = bean(Food.class);
        renderJson(Ret.ok().set("food", food).set("composition", composition));
    }

}
