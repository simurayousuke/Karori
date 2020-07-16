package cn.zhuangcloud.karori.common.api.v1;

import cn.zhuangcloud.karori.common.bo.FoodBO;
import cn.zhuangcloud.karori.common.model.Composition;
import com.jfinal.kit.Ret;

public class FoodApi extends ApiV1 {

    public void upload() {
        Composition composition = getBean(Composition.class);
        FoodBO food = getBean(FoodBO.class);
        renderJson(Ret.ok().set("food", food).set("composition", composition));
    }

}
