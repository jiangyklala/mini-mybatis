package com.jiang.minimybatis.datasource;

import java.util.Properties;

import javax.sql.DataSource;

/**
 * @author jiangyunkai <jiangyunkai@kuaishou.com>
 * Created on 2024-01-26
 */
public interface DataSourceFactory {

    void setProperties(Properties props);

    DataSource getDataSource();

}
