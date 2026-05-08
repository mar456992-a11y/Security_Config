package com.example.security_config.repository;


import com.example.security_config.model.entity.Auth;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AuthRepo {

    @Select("""

select * from user wher email = {#email}
""")
@Results(id = "AuthMapper" , value = {
        @Result(property = "UserId",column = "user_id"),
        @Result(property = "fullName" , column = "fullName"),
        @Result(property = "email", column = "email"),
        @Result(property = "password", column = "password"),
        @Result(property = "createAt", column = "creat_at")


})
    static Auth findByEmail(String email) {
        return null;
    }

    @Select("""
insert into users(user_name,email,password,token_version,created_at) 
values(#{userName},#{email},#{password},0,now()) returning *
""")
    @ResultMap("AuthMapper")
    Auth register(Auth auth);

    @Update("UPDATE users SET token_version = token_version + 1 WHERE user_id = #{userId}")
    @ResultMap("AuthMapper")
    Object incrementTokenVersion(long userId);
}
