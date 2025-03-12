package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /**
         * @author : mxcoogi
         * @version : lv2
         *
         */
        Scanner scanner = new Scanner(System.in);
        /**
         * MenuItem을 담는 List 생성
         */
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));


        /**
         * 반복문을 활용해 메뉴에 접근<br>
         * 메뉴아이템의 toString 메소드로 메뉴의 정보 출력
         * @throws NumberFormatException 문자열을 숫자로 변환하지 못할 때 발생
         * @throws IndexOutOfBoundsException 메뉴에 없는 숫자를 입력할 때 발생
         */
        while (true) {
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuItems.size(); i++) {
                MenuItem item = menuItems.get(i);
                System.out.println(i+1 +". "+ item.toString());
            }
            System.out.println("0. 종료");
            String input = scanner.nextLine();
            if (input.equals("0")) return;
            else {
                try {
                    int idx = Integer.parseInt(input);
                    System.out.println(menuItems.get(idx - 1).toString());
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("잘못된 입력입니다!");
                } catch (IndexOutOfBoundsException e) {
                    throw new IndexOutOfBoundsException("없는 메뉴입니다!");
                }
            }
        }

    }
}