package com.jiang.minimybatis.session;

/**
 * @author jiangyunkai <jiangyunkai@kuaishou.com>
 * Created on 2024-01-24
 */
public interface SqlSessionFactory {

    /**
     * 打开一个 session
     * @return SqlSession
     */
    SqlSession openSession();

}
