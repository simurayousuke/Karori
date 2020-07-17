package cn.zhuangcloud.karori.statistic;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.Date;
import java.util.List;

public class StatisticService {

    public List<Record> unionByUidAndDate(Integer uid, Date date) {
        return Db.find(Db.getSqlPara("statistic.unionByUidAndDate", uid, date));
    }

    public List<Record> unionByUidAndDateAndType(Integer uid, Date date, Integer type) {
        return Db.find(Db.getSqlPara("statistic.unionByUidAndDateAndType", uid, date, type));
    }

}
