package com.jiang.minimybatis.transaction.jdbc;

import java.sql.Connection;

import javax.sql.DataSource;

import com.jiang.minimybatis.session.TransactionIsolationLevel;
import com.jiang.minimybatis.transaction.Transaction;
import com.jiang.minimybatis.transaction.TransactionFactory;

/**
 * @author jiangyunkai <jiangyunkai@kuaishou.com>
 * Created on 2024-01-26
 */
public class JdbcTransactionFactory implements TransactionFactory {

    @Override
    public Transaction newTransaction(Connection conn) {
        return new JdbcTransaction(conn);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }

}
