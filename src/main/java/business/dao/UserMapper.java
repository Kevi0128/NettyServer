package business.dao;

import business.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    public User findByLoginName(@Param("Login")String loginName);

}
