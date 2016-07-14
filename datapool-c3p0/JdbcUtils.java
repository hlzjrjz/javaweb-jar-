package com.cx.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;

/**
 * Created by cxspace on 16-7-13.
 */
public class JdbcUtils {

     /*
        初始化c3p0连接池
      */

    private static DataSource dataSource;

    static {
        dataSource = new ComboPooledDataSource();
    }

    /*
      创建DbUtils核心工具类对象
     */

    public static QueryRunner getQueryRunner(){
        //创建QueryRunner对象
        //在传入了QueryRunner对象的时候,如果传入了数据源对象
        //那么在使用QueryRunner对象方法的时候,就不要传入连接对象
        //会自动从数据源中获取连接（不用关闭连接）
        return new QueryRunner(dataSource);

    }

}
