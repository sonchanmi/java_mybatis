package com.ohgiraffers.section02;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class Application {
    public static void main(String[] args) {
// 설정정보를 xml로 작성함

        String resource= "mybatis-config.xml";
        SqlSession session =null;

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource); // "mybatis-config.xml"문자열형태의 파일을 읽어서 리소스 해줌
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); // inputStream 객체사용해줌

            session = sqlSessionFactory.openSession(false); //오토커밋을 false로 설정함

            Date date = session.selectOne("mapper.selectSysDate");  // 데이터 하나만 받아올꺼라 selectOne 씀
            System.out.println(date + "section02 Application");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            session.close();
        }

    }
}
