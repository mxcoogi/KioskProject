package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 키오스크 클래스로 사용자의 입력을 처리하고<br>
 * List에 MenuItem을 저장하고 있습니다.
 *
 * @author mxcoogi
 * @version lv3
 */
public class Kiosk{
    private List<Menu> menuList;
    private static Scanner scanner = new Scanner(System.in);
    private static Stack<Runnable> stack= new Stack<>();
    private static String input;

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
     */
    private void init() {
        Menu burger = new Menu("burger");
        burger.addMenuItem(new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burger.addMenuItem(new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burger.addMenuItem(new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burger.addMenuItem(new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));
        menuList.add(burger);

        Menu drink = new Menu("drink");
        drink.addMenuItem(new MenuItem("Fresh Lemonade", 3500, "신선한 레몬과 설탕으로 만든 상큼한 레모네이드"));
        drink.addMenuItem(new MenuItem("Iced Tea", 2900, "시원한 아이스티, 달콤한 맛!!"));
        drink.addMenuItem(new MenuItem("Milkshake", 4900, "부드럽고 크리미한 초코, 바닐라, 딸기 밀크쉐이크"));
        drink.addMenuItem(new MenuItem("Coke", 2000, "클래식 콜라, 다이어트 콜라, 제로 콜라 선택 가능"));
        menuList.add(drink);

        Menu dessert = new Menu("dessert");
        dessert.addMenuItem(new MenuItem("Chocolate Brownie", 3000, "촉촉한 초콜릿 브라우니와 바닐라 아이스크림"));
        dessert.addMenuItem(new MenuItem("Apple Pie", 3200, "따뜻한 애플 파이와 달콤한 시나몬 향!!"));
        dessert.addMenuItem(new MenuItem("Vanilla Custard", 2500, "부드러운 바닐라 커스터드와 과일 토핑"));
        dessert.addMenuItem(new MenuItem("Cheesecake", 4000, "고소하고 부드러운 뉴욕 스타일 치즈케이크"));
        menuList.add(dessert);
    }


    /**
     * 키오스크 프로그램을 시작하는 메서드
     */
    public void start() {
        stack.push(showMenuList());
        try {
            while(true){
                Runnable function = stack.pop();
                function.run();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    /**
     * 키오스크의 전체 메뉴 카테고리를 보여주는 메서드<br>
     * 메뉴 카테고리를 번호를 선택한다
     *
     * @return 선택한 메뉴 카테고리의 번호를 리턴
     * @throws NumberFormatException
     * @throws IndexOutOfBoundsException
     */
    private Runnable showMenuList() {
        Runnable showMenuList = new Runnable() {
            @Override
            public void run() {
                System.out.println("[ MAIN MENU ]");
                for (int i = 0; i < menuList.size(); i++) {
                    System.out.println(i + 1 + ". " + menuList.get(i).getCategory());
                }
                System.out.println("0. 종료");
                input = scanner.nextLine();
                if (input.equals("0")) {
                    throw new RuntimeException("종료합니다");
                } else {
                    try {
                        int idx = Integer.parseInt(input);
                        stack.push(showMenuList());
                        stack.push(showMenuItems());
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException("잘못된 입력입니다!");
                    } catch (IndexOutOfBoundsException e) {
                        throw new IndexOutOfBoundsException("없는 메뉴입니다!");
                    }
                }
            }
        };
        return showMenuList;
    }


    /**
     * 선택한 메뉴 카테고리의 리스트를 보여주는 메서드
     *
     */
    private Runnable showMenuItems() {

        Runnable showMenuItems = new Runnable() {
            @Override
            public void run() {
                Menu menu = menuList.get(Integer.parseInt(input)-1);
                menu.showMenuItems();
                String temp = scanner.nextLine();
                if (input.equals("0")) {

                } else {
                    try {
                        int idx = Integer.parseInt(temp);
                        System.out.println(menu.getMenuItems().get(idx - 1).toString());

                    } catch (NumberFormatException e) {
                        throw new NumberFormatException("잘못된 입력입니다!");
                    } catch (IndexOutOfBoundsException e) {
                        throw new IndexOutOfBoundsException("없는 메뉴입니다!");
                    }
                }
            }
        };
    return showMenuItems;
    }


}