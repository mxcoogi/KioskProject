package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * MenuItem 클래스를 관리하는 클래스입니다.<br>
 * 예를 들어, 버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 MenuItem을 포함합니다.
 *
 * @author mxcoogi
 * @version challenge lv1
 */
public class Menu {
    private List<MenuItem> menuItems;
    private String category;

    /**
     * 생성자 생성자를 통해 menuItems를 할당함
     *
     * @param category MenuItem들의 상위 개념인 필드
     */
    public Menu(String category) {
        this.menuItems = new ArrayList<>();
        this.category = category;
    }

    /**
     * 이 카테고리에 해당하는 메뉴리스트를 보여줌
     * 스트림 사용
     */
    public void showMenuItems() {
        System.out.printf("[ %s MENU ]\n", category.toUpperCase());
        IntStream.range(0, menuItems.size())
                .forEach(idx -> System.out.println(idx + 1 + ". " + menuItems.get(idx).toString()));
        System.out.println("0. 뒤로가기");
    }

    /**
     * 카테고리 이름을 반환하는 메서드
     *
     * @return String
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param menuItem menuItem을 메뉴에 넣는 메서드
     */
    public void addMenuItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }

    /**
     * 메뉴가 가지고있는 아이템들을 리턴한다
     *
     * @return List - MenuItem
     */
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
