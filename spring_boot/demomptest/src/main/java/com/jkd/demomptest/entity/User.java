package com.jkd.demomptest.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.util.Date;

/**
 * @projectName: demomptest
 * @package: com.jkd.demomptest.entity
 * @className: User
 * @author: JKD
 * @description:
 * @version: 1.0
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    // 自动填充
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;  //create_time

    // 自动填充
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime; //update_time

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;



}
