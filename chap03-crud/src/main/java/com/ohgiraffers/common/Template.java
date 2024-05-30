package com.ohgiraffers.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {
    //통신해주는 곳

 private static SqlSessionFactory sqlSessionFactory;

 public static SqlSession getSqlSession() {

     if(sqlSessionFactory == null) {

         try {
             InputStream inputStream = Resources.getResourceAsStream("Xmlconfig/mybatis-config.xml");
             sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }

     }
     return sqlSessionFactory.openSession(false);
 }


}
