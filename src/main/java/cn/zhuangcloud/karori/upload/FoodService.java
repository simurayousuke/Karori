package cn.zhuangcloud.karori.upload;

import cn.zhuangcloud.karori.common.model.Composition;
import cn.zhuangcloud.karori.common.model.Food;
import com.jfinal.plugin.activerecord.Db;
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

    public boolean createFood(Food food, Composition cmp) {
        return Db.tx(() -> {
            if (!cmp.save())
                return false;
            food.setComposition(cmp.getCid());
            return food.save();
        });
    }

}
