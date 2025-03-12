package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 키오스크 클래스로 사용자의 입력을 처리하고<br>
 * List에 MenuItem을 저장하고 있습니다.
 * @author mxcoogi
 * @version lv3
 */
public class Kiosk {
    private List<Menu> menuList;
    static Scanner scanner = new Scanner(System.in);

    /**
     * 생성자<br>
     * 생성시 menuItem, ArrayList 할당<br>
     * init 함수 실행
     */
    public Kiosk() {
        menuList = new ArrayList<>();
        init();
    }


    /**
     * 초기 세팅 키오스크 List에 menuItem 넣어줌
     *
     */
    private void init() {
        Menu burger = new Menu("burger");
        burger.addMenuItem(new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burger.addMenuItem(new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burger.addMenuItem(new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burger.addMenuItem(new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));
        menuList.add(burger);
    }


    /**
     * 키오스크 프로그램을 시작하는 메서드
     */
    public void start() {
        try {
            while (true) {
                showMenuList();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    /**
     * 키오스크의 전체 메뉴 카테고리를 보여주는 메서드<br>
     * @throws NumberFormatException
     * @throws IndexOutOfBoundsException
     */
    private void showMenuList() {
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println(i+1 + ". " + menuList.get(i).getCategory());
        }
        System.out.println("0. 종료");
        String input = scanner.nextLine();
        if (input.equals("0")) {
            throw new RuntimeException("종료합니다");
        } else {
            try {
                int idx = Integer.parseInt(input);
                menuList.get(idx-1).showMenuItems();
            } catch (NumberFormatException e) {
                throw new NumberFormatException("잘못된 입력입니다!");
            } catch (IndexOutOfBoundsException e) {
                throw new IndexOutOfBoundsException("없는 메뉴입니다!");
            }
        }
    }



}
