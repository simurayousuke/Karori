package cn.zhuangcloud.karori.common.api.v1;

import cn.zhuangcloud.karori.common.base.ApiV1;
import cn.zhuangcloud.karori.statistic.StatisticService;
import com.jfinal.aop.Inject;

public class StatisticApi extends ApiV1 {

    @Inject
    StatisticService statisticService;

    @Deprecated
    public void date() {
        renderJson(statisticService.unionByUidAndDate(getUid(), getDate("date")));
    }

    public void dateAndType() {
        renderJson(statisticService.unionByUidAndDateAndType(getUid(), getDate("date"), getInt("type")));
    }

}
