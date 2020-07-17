package cn.zhuangcloud.karori.upload;

import cn.zhuangcloud.karori.common.model.Composition;
import cn.zhuangcloud.karori.common.model.Food;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

public class FoodService {

    private Food foodDao = new Food().dao();
    private Composition cmpDao = new Composition().dao();

    private Composition findCompositionByCid(Integer cid) {
        return cmpDao.findFirst(cmpDao.getSqlPara("cmp.findByCid", cid));
    }

    public Record unionByFid(Integer fid) {
        return Db.findFirst(Db.getSqlPara("food.unionByFid", fid));
    }

    /*
    SELECT F.fid, F.foodname, F.uploader upid, C.calorie,C.protein,C.fat,C.carbohydrate, U.username uploader
FROM t_food F
         LEFT JOIN t_composition C ON F.composition = C.cid
         left join t_user U on F.uploader = U.uid
WHERE F.ean =
#para(0)
ORDER BY #para(1) asc;
     */

    public Page<Record> paginateByBarcode(int index, int size, String ean) {
        if (StrKit.notBlank(ean))
            return Db.paginate(index, size, Db.getSqlPara("food.paginateByBarcode", ean));
        else
            return Db.paginate(index, size, Db.getSqlPara("food.paginateAll"));
    }

    public Page<Record> paginateByUid(int index, int size, Integer uid) {
        return Db.paginate(index, size, Db.getSqlPara("food.paginateByUid", uid));
    }

    public Page<Record> paginateAll(int index, int size) {
        return Db.paginate(index, size, Db.getSqlPara("food.paginateAll"));
    }

    public boolean createFood(Food food, Composition cmp) {
        return Db.tx(() -> {
            if (!cmp.save())
                return false;
            food.setComposition(cmp.getCid());
            return food.save();
        });
    }

}
