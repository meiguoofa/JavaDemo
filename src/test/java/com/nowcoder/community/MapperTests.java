package com.nowcoder.community;


import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder12@sina.com");
        System.out.println(user);

        user = userMapper.selectByName("ddd");
        System.out.println(user);
    }
     @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("666");
        user.setType(0);
        user.setStatus(0);
        user.setPassword("111111");
        user.setSalt("666");
        user.setEmail("666@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println("rows  " + rows);
        System.out.println("userId   " + user.getId());



    }

      @Test
    public void testUpdateUser(){
        int rows = userMapper.updateHeader(1,"http://www.nowcoder.com/666.png");
        rows = userMapper.updatePassword(1,"666");
        rows = userMapper.updateStatus(1,1);


    }

    @Test
    public void testSelectDiscussPost(){
        List<DiscussPost> discussPostList = discussPostMapper.selectDiscussPosts(101,1,10);
        for(int i = 0 ;i < discussPostList.size() ; i++){
            System.out.println(discussPostList.get(i));

        }
    }

    @Test
    public void testSelectDiscussPostRows(){
        int rows = discussPostMapper.selectDiscussPostRows(101);
        System.out.println("rows  " + rows);
    }


}
