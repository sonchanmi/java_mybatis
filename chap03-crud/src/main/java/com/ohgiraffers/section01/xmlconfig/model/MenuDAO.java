package com.ohgiraffers.section01.xmlconfig.model;

import com.ohgiraffers.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;
import java.util.List;


public class MenuDAO {

   public List<MenuDTO> selectAllMenu(SqlSession sqlSession){ //dto 의 모든 정보를 가져오기 위해 list쓰임
        return sqlSession.selectList("MenuMapper.selectAllMenu");
   }


    public MenuDTO selectMenuByCode(SqlSession sqlSession, int code) {

       return sqlSession.selectOne("MenuMapper.selectMenuByCode", code);

    }

    public int insertMenu(SqlSession sqlSession, MenuDTO menu) {

       return sqlSession.insert("MenuMapper.insertMenu", menu);

    }

    public int updateMenu(SqlSession sqlSession, MenuDTO menu) {

        return sqlSession.update("MenuMapper.updateMenu", menu);
    }

    public int deleteCode(SqlSession sqlSession, int code) {

        return sqlSession.delete("MenuMapper.deleteMenu", code);
    }
}
