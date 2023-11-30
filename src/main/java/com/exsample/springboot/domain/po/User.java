package com.exsample.springboot.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("mybatis_plus.user")
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;
//    private String sex;
}
