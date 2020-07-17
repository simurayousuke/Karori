package cn.zhuangcloud.karori.statistic;

import cn.zhuangcloud.karori.common.MyController;
import cn.zhuangcloud.karori.common.kit.ConvertKit;
import com.jfinal.aop.Inject;

import java.util.Date;

public class StatisticController extends MyController {

    @Inject
    StatisticService statisticService;

    public void index() {
        title("statistic");
        Date date = getParaToDate();
        if (null == date)
            date = new Date();
        Integer uid = getUid();
        set("_breakfast", ConvertKit.getSumForDouble(statisticService.unionByUidAndDateAndType(uid, date, 1)));
        set("_lunch", ConvertKit.getSumForDouble(statisticService.unionByUidAndDateAndType(uid, date, 2)));
        set("_dinner", ConvertKit.getSumForDouble(statisticService.unionByUidAndDateAndType(uid, date, 3)));
        render("index.html");
    }

}
