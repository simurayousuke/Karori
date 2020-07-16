package cn.zhuangcloud.karori.common.model.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseFood<M extends BaseFood<M>> extends Model<M> implements IBean {

    public java.lang.Integer getFid() {
        return getInt("fid");
    }

    public void setFid(java.lang.Integer fid) {
        set("fid", fid);
    }

    public java.lang.String getEan() {
        return getStr("ean");
    }

    public void setEan(java.lang.String ean) {
        set("ean", ean);
    }

    public java.lang.String getFoodname() {
        return getStr("foodname");
    }

    public void setFoodname(java.lang.String foodname) {
        set("foodname", foodname);
    }

    public java.lang.Integer getUploader() {
        return getInt("uploader");
    }

    public void setUploader(java.lang.Integer uploader) {
        set("uploader", uploader);
    }

    public java.util.Date getCreateTime() {
        return get("create_time");
    }

    public void setCreateTime(java.util.Date createTime) {
        set("create_time", createTime);
    }

    public java.util.Date getUpdateTime() {
        return get("update_time");
    }

    public void setUpdateTime(java.util.Date updateTime) {
        set("update_time", updateTime);
    }

    public java.lang.Integer getComposition() {
        return getInt("composition");
    }

    public void setComposition(java.lang.Integer composition) {
        set("composition", composition);
    }

}