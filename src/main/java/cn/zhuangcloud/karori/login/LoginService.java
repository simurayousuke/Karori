package cn.zhuangcloud.karori.login;

import cn.zhuangcloud.karori.common.model.User;
import com.jfinal.kit.HashKit;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.redis.Redis;

public class LoginService {

    private User dao = new User().dao();

    private String hash(String password, String salt) {
        String ret = HashKit.sha256(password + salt);
        for (int i = 0; i < 2; i++) {
            ret = HashKit.sha256(ret + salt);
        }
        return ret;
    }

    private User findByUsername(String username) {
        if (null == username)
            return null;
        return dao.findFirst(dao.getSqlPara("user.findByUsername", username));
    }

    private User findByToken(String token) {
        return null == token ? null : Redis.use("user").get(token);
    }

    public boolean isLogin(String token) {
        return null != findByToken(token);
    }

    public String login(String username, String password) {
        User user = findByUsername(username);
        if (null == user)
            return null;
        if (!user.getPwd().equals(hash(password, user.getSalt())))
            return null;
        String token = StrKit.getRandomUUID();
        Redis.use("user").setex(token, 60 * 60 * 24, user);
        return token;
    }

}
