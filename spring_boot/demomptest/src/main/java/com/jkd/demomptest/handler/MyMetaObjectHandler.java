package com.jkd.demomptest.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @projectName: demomptest
 * @package: com.jkd.demomptest.handler
 * @className: MyMetaObjectHandler
 * @author: JKD
 * @description: mp自动填充处理类
 * @date: 2021/5/8 16:50
 * @version: 1.0
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    // mp 执行添加操作，这个方法执行
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
    // mp 执行修改操作，这个方法执行
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
