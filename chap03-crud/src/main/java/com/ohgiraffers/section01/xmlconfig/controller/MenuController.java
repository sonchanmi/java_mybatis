package com.ohgiraffers.section01.xmlconfig.controller;

import com.ohgiraffers.common.PrintResult;
import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section01.xmlconfig.service.MenuService;

import java.util.List;
import java.util.Map;

public class MenuController {

    private final PrintResult printResult;

    private final MenuService menuService;

    public MenuController(){
        printResult = new PrintResult();
        menuService = new MenuService();
    }




    public void selectAllMenu() {

        List<MenuDTO> menuList= menuService.selectAllMenu();

          printResult.printMenuList(menuList);
    }

    public void selectMenuByCode(Map<String, String> parameter) {

        int code= Integer.parseInt(parameter.get("code"));

        MenuDTO menu = menuService.selectMenuByCode(code);

        printResult.printMenu(menu);

    }


    public void registMenu(Map<String, String> parameter) {

        MenuDTO menu = new MenuDTO();
        menu.setName(parameter.get("name"));
        menu.setPrice(Integer.parseInt(parameter.get("price")));
        menu.setCategoryCode(Integer.parseInt(parameter.get("categoryCode")));

        if(menuService.registMenu(menu)){
            // 메뉴등록이 성공했을 때 동작
            printResult.printSuccessMessage("insert");
        }else{
            //메뉴 동작이 실패했을 때 동작
            printResult.printErrorMessage("insert");
        }

    }
}
