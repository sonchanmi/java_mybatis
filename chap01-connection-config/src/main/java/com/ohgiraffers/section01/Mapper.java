package com.ohgiraffers.section01;

import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface Mapper {
    // ibatis 사용할 수 있는 Select
    @Select("SELECT CURDATE() FROM DUAL") // 날짜 출력하는것 curdate
    Date selctSysDate();

}
