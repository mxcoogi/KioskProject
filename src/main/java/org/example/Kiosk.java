package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author mxcoogi
 * @version lv3
 * 키오스크 클래스로 사용자의 입력을 처리하고<br>
 * List에 MenuItem을 저장하고 있습니다.
 */
public class Kiosk {
    private List<MenuItem> menuItems;
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 생성자<br>
     * 생성시 menuItem ArrayList 할당<br>
     * init 함수 실행
     */
    public Kiosk() {
        menuItems = new ArrayList<>();
        init();
    }

    /**
     * 초기 세팅 키오스크 List에 menuItem 넣어줌
     */
    private void init() {
        menuItems.add(new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    /**
     * 키오스크 프로그램을 시작하는 메서드
     */
    public void start() {
        while (true) {
            showMenuItems();
            showMenuItemDescription();
        }
    }

    /**
     * 키오스크의 전체 메뉴를 보여주는 메서드
     */
    private void showMenuItems() {
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);
            System.out.println(i + 1 + ". " + item.toString());
        }
        System.out.println("0. 종료");
    }

    /**
     * 키오스크 메뉴를 선택하면 정보를  출력해주는 메소드
     * @throws RuntimeException 0입력시 종료시킴
     * @throws NumberFormatException 잘못된 숫자 입력
     * @throws IndexOutOfBoundsException 범위를 넘어가는 숫자 입력
     */
    private void showMenuItemDescription() {
        String input = scanner.nextLine();
        if (input.equals("0")) {
            throw new RuntimeException("종료합니다");
        } else {
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
