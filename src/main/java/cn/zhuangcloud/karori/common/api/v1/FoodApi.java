package cn.zhuangcloud.karori.common.api.v1;

import cn.zhuangcloud.karori.common.kit.ConvertKit;
import cn.zhuangcloud.karori.common.model.Composition;
import cn.zhuangcloud.karori.common.model.Food;
import cn.zhuangcloud.karori.common.model.User;
import cn.zhuangcloud.karori.upload.FoodService;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.i18n.Res;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

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
            success(Ret.by("msg", res.get("uploadSuccess")).set("fid", food.getFid()));
        else
            fail(Ret.by("code", 500).set("msg", res.get("uploadFail")));
    }

    @Clear(POST.class)
    public void fetch() {
        //todo remake
        renderJson(foodService.unionByFid(getParaToInt()));
    }


    @ActionKey("/api/v1/food/paginate/barcode/datatables")
    public void paginateByBarcodeForDatatables() {
        String ean = get("search[value]");
        int start = getInt("start");
        int length = getInt("length");
        int index = start / length + 1;

        Page<Record> page = foodService.paginateByBarcode(index, length, ean);
        renderJson(ConvertKit.convertPageToDatatablesJsonResult(page));
    }

    @ActionKey("/api/v1/food/paginate/barcode/zui")
    public void paginateByBarcodeForZuiDatagrid2() {
        String ean = get("search");
        int index = getInt("page") + 1;
        Integer size = getInt("recPerPage");

        Page<Record> page = foodService.paginateByBarcode(index, size, ean);
        renderJson(ConvertKit.convertPageToZuiDatagridJsonResult(page));
    }

}
