package com.ohgiraffers.section02.javaconfig.controller;

import com.ohgiraffers.common.PrintResult;
import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section02.javaconfig.service.MenuService;

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

        List<MenuDTO> menuList = menuService.selectAllMenu();
         printResult.printMenuList(menuList);

    }

    public void selectMenuByCode(Map<String,String> parameter ) {

        int code = Integer.parseInt(parameter.get("code")); // int 자료형을 받아줌

        MenuDTO menu = menuService.selectMenuByCode(code);

        printResult.printMenu(menu); // 프론트 출력을 담당하는 메소드로 보내줌

    }

    public void registMenu(Map<String, String> parameter) {

        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);

        if (menuService.registMenu(menu)){
            printResult.printSuccessMessage("insert");
        }else {
            printResult.printErrorMessage("insert");
        }



    }

    public void modifyMenu(Map<String, String> parameter) {
           int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));


        MenuDTO menu = new MenuDTO();
        menu.setCode(code);
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);


        if(menuService.modifyMenu(menu)){
            printResult.printSuccessMessage("update");
        }else {
            printResult.printErrorMessage("update");
        }


    }

    public void deleteMenu(Map<String, String> stringStringMap) {
        int code = Integer.parseInt(stringStringMap.get("code"));


        if (menuService.deleteMenu(code)){
            printResult.printSuccessMessage("delete");
        }else{
            printResult.printErrorMessage("delete");
        }
    }
}
