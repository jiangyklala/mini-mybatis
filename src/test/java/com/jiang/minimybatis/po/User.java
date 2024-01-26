package com.jiang.minimybatis.po;

import java.util.Date;

import lombok.Data;

/**
 * @author jiangyunkai <jiangyunkai@kuaishou.com>
 * Created on 2024-01-25
 */
@Data
public class User {

    private Long id;

    private String userId;          // 用户ID

    private String userHead;        // 头像

    private Date createTime;        // 创建时间

    private Date updateTime;        // 更新时间
}