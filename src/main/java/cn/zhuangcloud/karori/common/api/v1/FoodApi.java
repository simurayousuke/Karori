package cn.zhuangcloud.karori.common.api.v1;

import cn.zhuangcloud.karori.common.model.Composition;
import cn.zhuangcloud.karori.common.model.Food;
import cn.zhuangcloud.karori.common.model.User;
import cn.zhuangcloud.karori.upload.FoodService;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.i18n.Res;
import com.jfinal.kit.Ret;

public class FoodApi extends ApiV1 {

    @Inject
    FoodService foodService;

    public void upload() {
        Res res = getRes();
        Composition composition = bean(Composition.class);
        Long unit = getLong("unit");
        if (100 != unit) {
            try {
                composition.calculate(unit);
            } catch (Exception e) {
                fail(Ret.by("code", 500).set("msg", res.get("uploadFail")));
            }
        }
        Food food = bean(Food.class);
        food.setUploader(((User) getAttr("user")).getUid());
        if (foodService.createFood(food, composition))
            success(res.get("uploadSuccess"));
        else
            fail(Ret.by("code", 500).set("msg", res.get("uploadFail")));
    }

    @Clear(POST.class)
    public void fetch() {
        //todo remake
        renderJson(foodService.unionByFid(getParaToInt()));
    }

}
