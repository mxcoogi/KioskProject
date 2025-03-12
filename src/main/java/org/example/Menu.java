package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * MenuItem 클래스를 관리하는 클래스입니다.<br>
 * 예를 들어, 버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 MenuItem을 포함합니다.
 * @author mxcoogi
 * @version lv4
 */
public class Menu {
    private List<MenuItem> menuItems;
    private String category;

    /**
     * 생성자 생성자를 통해 menuItems를 할당함
     * @param category MenuItem들의 상위 개념인 필드
     */
    public Menu(String category){
        this.menuItems = new ArrayList<>();
        this.category = category;
    }

    /**
     * 이 카테고리에 해당하는 메뉴리스트를 보여줌
     */
    public void showMenuItems(){
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);
            System.out.println(i + 1 + ". " + item.toString());
        }
        System.out.println("0. 종료");
        String input = Kiosk.scanner.nextLine();
        if (input.equals("0")) {
            throw new RuntimeException("종료합니다");
        } else {
            try {
                int idx = Integer.parseInt(input);
                System.out.println(menuItems.get(idx-1).toString());
            } catch (NumberFormatException e) {
                throw new NumberFormatException("잘못된 입력입니다!");
            } catch (IndexOutOfBoundsException e) {
                throw new IndexOutOfBoundsException("없는 메뉴입니다!");
            }
        }
    }

    /**
     * 카테고리 이름을 반환하는 메서드
     * @return String
     */
    public String getCategory() {
        return category;
    }

    /**
     *
     * @param menuItem menuItem을 메뉴에 넣는 메서드
     */
    public void addMenuItem(MenuItem menuItem){
        this.menuItems.add(menuItem);
    }
}
