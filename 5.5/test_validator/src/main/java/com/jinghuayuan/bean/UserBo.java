package com.jinghuayuan.bean;
// Copyright 2021-2101 Pica.

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;

/**
 * @ClassName UserBo
 * @Description TODO
 * @Author 井华源
 * @Date 2021/5/5 20:38
 * @ModifyDate 2021/5/5 20:38
 * @Version 1.0
 */
@Data
public class UserBo {

    @Length(min=6)
    private String name;
    @Length(min=6,max=10)
    private String passWord;

    @Min(18)
    @Min(70)
    private Integer age;
}
