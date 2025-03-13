package org.example;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 키오스크 클래스로 사용자의 입력을 처리하고<br>
 * List에 MenuItem을 저장하고 있습니다.
 *
 * @author mxcoogi
 * @version challenge lv1
 */
public class Kiosk {
    /**
     * 메뉴를 저장하는 MenuList
     * 입력받는 Scanner
     * 이전 함수(콘솔에 보여지는 화면을 담당하는)를 기록하는 stack
     * 명령어를 저장하는 input
     */
    private List<Menu> menuList;
    private Cart cart;
    private static Scanner scanner = new Scanner(System.in);
    private static Stack<Runnable> stack = new Stack<>();
    private static String input;


    /**
     * 생성자<br>
     * 생성시 menuItem, ArrayList 할당<br>
     * init 함수 실행
     */
    public Kiosk() {
        menuList = new ArrayList<>();
        cart = new Cart();
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

    public static Scanner getScanner() {
        return scanner;
    }

    /**
     * 키오스크 프로그램을 시작하는 메서드
     * 함수스택에 쌓여있는 걸 제거하고 실행시킨다
     */
    public void start() {
        stack.push(showFirst());
        try {
            while (true) {
                Runnable function = stack.pop();
                function.run();
            }
        } catch (EmptyStackException e) {
            System.out.println("종료합니다~");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 메뉴보기 장바구니 주문하기 선택지를 보여줍니다<br>
     * 함수가 실행되면 현재 함수와 다음함수 스택에 저장<br>
     * 메서드명 작문이 애매합니다
     *
     * @return Runnable 구현한 함수 반환
     */
    public Runnable showFirst() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("========== Restaurant ==========");
                System.out.println("1. 메뉴   2. 장바구니   3. 주문하기   0. 종료");
                try {
                    input = scanner.nextLine();
                    switch (input) {
                        case "1" -> {
                            stack.push(showFirst());
                            stack.push(showMenuList());
                        }
                        case "2" -> {
                            stack.push(showFirst());
                            stack.push(showCartList());
                        }
                        case "3" -> {
                            stack.push(showFirst());
                            stack.push(payOrder());
                        }
                        case "0" -> {

                        }
                        default -> throw new NumberFormatException();
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        };
    }


    /**
     * 키오스크의 전체 메뉴 카테고리를 보여주는 메서드<br>
     * 메뉴 카테고리를 번호를 선택한다
     *
     * @return 선택한 메뉴 카테고리의 번호를 리턴
     */
    private Runnable showMenuList() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("[ MAIN MENU ]");
                IntStream.range(0, menuList.size())
                        .forEach(idx -> System.out.println(idx + 1 + ". " + menuList.get(idx).getCategory()));
                System.out.println("0. 뒤로가기");
                input = scanner.nextLine();
                if (input.equals("0")) {
                } else {
                    try {
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
    }


    /**
     * 선택한 메뉴 카테고리의 리스트를 보여주는 메서드
     */
    private Runnable showMenuItems() {

        return new Runnable() {
            @Override
            public void run() {
                Menu menu = menuList.get(Integer.parseInt(input) - 1);
                menu.showMenuItems();
                String temp = scanner.nextLine();
                if (temp.equals("0")) {

                } else {
                    try {
                        int idx = Integer.parseInt(temp) - 1;
                        MenuItem menuItem = menu.getMenuItems().get(idx);
                        System.out.println(menuItem.toString());
                        addCartList(menuItem);
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException("잘못된 입력입니다!");
                    } catch (IndexOutOfBoundsException e) {
                        throw new IndexOutOfBoundsException("없는 메뉴입니다!");
                    }
                }
            }
        };
    }

    /**
     * showMenuItems 의해서만 작동하는 함수
     *
     * @param menuItem 선택한 메뉴아이템을 받아 장바구니에 저장
     */
    private void addCartList(MenuItem menuItem) {
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
        String temp = scanner.nextLine();
        switch (temp) {
            case "1" -> cart.addMenuItem(menuItem);
            case "2" -> System.out.println("취소합니다.");
            default -> throw new NumberFormatException();
        }
    }


    /**
     * 장바구니에 담긴 목록을 보여줌
     *
     * @return Runnable
     */
    private Runnable showCartList() {
        return new Runnable() {
            @Override
            public void run() {
                cart.showCartList();
            }
        };
    }


    /**
     * 주문하는 메서드
     *
     * @return Runnable
     */
    private Runnable payOrder() {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    cart.showCartList();
                    System.out.println("1. 주문하기   0. 뒤로가기");
                    String temp = scanner.nextLine();
                    switch (temp) {
                        case "1" -> cart.payOrder();
                        case "0" -> {}
                        default -> throw new Exception();
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        };
    }


}