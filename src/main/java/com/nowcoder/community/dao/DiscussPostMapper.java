package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface DiscussPostMapper {
        List<DiscussPost> selectDiscussPosts(int userId , int offset , int limit);
        //offset 在数据库中起始行的行号    limit每页限制的行数

    //@Param注解用于给参数取别名
    //如果只有一个参数,并且在<if>里使用,则必须加别名
       int selectDiscussPostRows(@Param("userId") int userId);




}
