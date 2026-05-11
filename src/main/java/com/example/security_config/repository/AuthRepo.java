package com.example.security_config.repository;

import com.example.security_config.model.entity.Auth;
import com.example.security_config.model.request.RegisterRequest;
import org.apache.ibatis.annotations.*;
import org.springframework.core.convert.ConversionService;

@Mapper
public interface AuthRepo {

    @Select("""
select * from users where email = #{email}
""")
    @Results(id = "AuthMapper",value = {
            @Result(property = "userId",column = "user_id"),
            @Result(property = "userName",column ="user_name" ),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "tokenVersion",column = "token_version"),
            @Result(property = "createdAt",column = "created_at"),

    })
    Auth findByEmail(String email);


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
