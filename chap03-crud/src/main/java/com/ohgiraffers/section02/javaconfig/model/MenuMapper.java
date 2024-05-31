package com.ohgiraffers.section02.javaconfig.model;

import com.ohgiraffers.dto.MenuDTO;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MenuMapper {


    @Results(id = "menuResultMap", value ={
            @Result(id = true, property = "code", column = "MENU_CODE"),//이 result 에 들어가는 id키는 프로마퍼티 키다 라는걸 설정
            @Result(property = "name", column = "MENU_NAME"),
            @Result(property = "price", column = "MENU_PRICE"),
            @Result(property = "categoryCode" , column = "CATEGORY_CODE"),
            @Result(property = "orderableStatus", column = "ORDERABLE_STATUS")
    })
    @Select("SELECT MENU_CODE" +
             ", MENU_NAME" +
    ",MENU_PRICE" +
    ", CATEGORY_CODE" +
    ", ORDERABLE_STATUS" +
    " FROM TBL_MENU"+
    " WHERE ORDERABLE_STATUS = 'Y'")

    List<MenuDTO> selectAllMenu();

    @Select("SELECT MENU_CODE" +
    ", MENU_NAME"+
    ", CATEGORY_CODE"+
    ", ORDERABLE_STATUS" +
    " FROM TBL_MENU"+
    " WHERE ORDERABLE_STATUS = 'Y'" +
    " AND MENU_CODE = #{ code }")

    @ResultMap("menuResultMap") //select를 어디다 담아줄지 모르기 때문에 resultmap에 menuResultMap을 담아줌
    MenuDTO selectMenuByCode(int code);


    @Insert("INSERT INTO TBL_MENU(" +
    " MENU_NAME"+
    ",MENU_PRICE"+
    " ,CATEGORY_CODE"+
    " ,ORDERABLE_STATUS"+
    " )VALUES(" +
    " #{ name }" +
    " ,#{ price } " +
            ",#{categoryCode}"+
    ",'Y'" +
    ")")

    int registMenu(MenuDTO menu);
    @Update("UPDATE TBL_MENU" +
            "   SET MENU_NAME = #{ name }" +
            "       ,MENU_PRICE = #{ price }" +
            "       ,CATEGORY_CODE = #{ categoryCode }" +
            " WHERE MENU_CODE = #{ code }")
    int modifyMenu(MenuDTO menu);

    @Delete("DELETE" +
            "  FROM TBL_MENU" +
            " WHERE MENU_CODE = #{ code }")
    int deleteMenu(int code);
}
