package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /**
         * @author : mxcoogi
         * @version : lv1
         *
         */
        Scanner scanner = new Scanner(System.in);
        String burger1 = "ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거";
        String burger2 = "SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거";
        String burger3 = "Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거";
        String burger4 = "Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거";
        while(true){
            System.out.println("[ SHAKESHACK MENU ]");
            System.out.println("1. " + burger1);
            System.out.println("2. " +burger2);
            System.out.println("3. " +burger3);
            System.out.println("4. " +burger4);
            System.out.println("0. 종료");
            String input = scanner.nextLine();
            switch (input){
                case "0":
                    return;
                case "1":
                    System.out.println(burger1);break;
                case "2":
                    System.out.println(burger2);break;
                case "3":
                    System.out.println(burger3);break;
                case "4":
                    System.out.println(burger4);break;
                default:
                    System.out.println("메뉴에 없는 입력 입니다");
                    break;
            }
        }
    }
}