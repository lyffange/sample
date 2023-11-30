package com.exsample;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exsample.springboot.domain.po.User;
import com.exsample.springboot.mapper.UserMapper;
import com.exsample.utils.initLogRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class ApplicationTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        System.out.println("Spring Boot Test!");
    }

    @Test
    public void testSelectList() {
//        initLogRecord.initLog();
        System.out.println(("----- selectAll method test ------"));
        //UserMapper 中的 selectList() 方法的参数为 MP 内置的条件封装器 Wrapper
        //所以不填写就是无任何条件
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testInsert(){

        User user = new User();
        user.setName("Helen");
        user.setAge(18);
        user.setEmail("55317332@qq.com");

        int result = userMapper.insert(user);
        System.out.println(result); //影响的行数
        System.out.println(user); //id自动回填
    }
    @Test
    public void testSelectById(){

        User user = userMapper.selectById(1L);
        System.out.println(user);
    }
    @Test
    public void testSelectBatchIds(){

        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }
    @Test
    public void testSelectByMap(){

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Helen");
        map.put("age", 18);
        List<User> users = userMapper.selectByMap(map);

        users.forEach(System.out::println);
    }
    //测试selectPage分页
    @Test
    public void testSelectPage() {

        Page<User> page = new Page<>(1,5);
        userMapper.selectPage(page, null);

        page.getRecords().forEach(System.out::println);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }
    //测试selectMapsPage分页：结果集是Map
    @Test
    public void testSelectMapsPage() {

        Page<Map<String, Object>> page = new Page<>(1, 5);
        //查询对象：可以组装select、where、order by语句
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name");
        userMapper.selectMapsPage(page, queryWrapper);

        page.getRecords().forEach(System.out::println);
    }
}
