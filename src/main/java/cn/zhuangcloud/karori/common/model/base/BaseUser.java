package cn.zhuangcloud.karori.common.model.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseUser<M extends BaseUser<M>> extends Model<M> implements IBean {

    public java.lang.Integer getUid() {
        return getInt("uid");
    }

    public void setUid(java.lang.Integer uid) {
        set("uid", uid);
    }

    public java.lang.String getUsername() {
        return getStr("username");
    }

    public void setUsername(java.lang.String username) {
        set("username", username);
    }

    public java.lang.String getSalt() {
        return getStr("salt");
    }

    public void setSalt(java.lang.String salt) {
        set("salt", salt);
    }

    public java.lang.String getPwd() {
        return getStr("pwd");
    }

    public void setPwd(java.lang.String pwd) {
        set("pwd", pwd);
    }

}
