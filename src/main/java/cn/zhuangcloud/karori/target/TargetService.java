package cn.zhuangcloud.karori.target;

import cn.zhuangcloud.karori.common.model.Target;

public class TargetService {

    private Target dao = new Target().dao();

    public Target getByUid(Integer uid) {
        return dao.findFirst(dao.getSqlPara("target.findByUid", uid));
    }

    public Target getByUidNotNull(Integer uid) {
        Target target = getByUid(uid);
        if (null == target) {
            target = new Target();
            target.setTargetCalorie(0);
            target.setTargetProtein(0);
            target.setTargetFat(0);
            target.setTargetCarbohydrate(0);
        }
        return target;
    }

    public boolean save(Target target) {
        if (null == getByUid(target.getUid()))
            return target.save();
        else
            return target.update();
    }

}
