package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.section01.xmlconfig.controller.MenuController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    static Scanner scr = new Scanner(System.in);
    public static void main(String[] args) {

      /*
      * 1. xml방식
      * 2. java 방식
      * 3. 혼합방식
      *
      * */



        MenuController menuController = new MenuController();



        do{
            System.out.println("=========메뉴 관리 시스템========");
            System.out.println("1. 메뉴 전체 조회");
            System.out.println("2. 메뉴 코드로 메뉴 조회");
            System.out.println("3. 신규 메뉴 추가");
            System.out.println("4. 메뉴 수정");
            System.out.println("5. 메뉴 삭제");
            System.out.println("메뉴 번호를 입력 해주세요");
            int no = scr.nextInt();
            scr.nextLine();

            switch (no){
                case 1: menuController.selectAllMenu(); break;
                case 2: menuController.selectMenuByCode(inputMenuCode()); break;
                case 3: menuController.registMenu(inputMenu()); break;
            }


        }while(true);


    }
    // 특정 메뉴 코드를 입력 받아 해당 메누 조회 혹은 삭제 메소드
    private static Map<String,String> inputMenuCode(){
        System.out.println("메뉴 코드를 입력하세요: ");
        String code = scr.nextLine();

        Map<String,String> parameter = new HashMap<>();
        parameter.put("code",code);

        return parameter;
    }

    public static Map<String,String> inputMenu(){

        System.out.println("메뉴 이름을 입력 해주세요 : ");
        String name = scr.nextLine();
        System.out.println("메뉴 가격을 입력 해주세요 : ");
        String price = scr.nextLine();
        System.out.println("카테고리 코드를 입력 해주세요 : ");
        String categoryCode = scr.nextLine();

        Map<String,String> parameter = new HashMap<>();
        parameter.put("name",name);
        parameter.put("price",price);
        parameter.put("categoryCode",categoryCode);
        return parameter;

    }




}
