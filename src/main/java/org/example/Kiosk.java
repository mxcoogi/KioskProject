package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<MenuItem> menuItems;
    private static Scanner scanner = new Scanner(System.in);

    public Kiosk() {
        menuItems = new ArrayList<>();
        init();
    }

    private void init() {
        menuItems.add(new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    public void start() {
        while (true) {
            showMenuItems();
            showMenuItemDescription();
        }
    }

    private void showMenuItems() {
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);
            System.out.println(i + 1 + ". " + item.toString());
        }
        System.out.println("0. 종료");
    }

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
