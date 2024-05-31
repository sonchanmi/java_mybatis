package com.ohgiraffers.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {

    public static SqlSessionFactory SqlSessionFactory;

    public static SqlSession getSession(){

        if(SqlSessionFactory == null){
            String resource = "config/mybatis-config.xml";

            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                SqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);



            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

           return SqlSessionFactory.openSession(false);

    }


}

