package org.example;

/**
 * 개별 음식 항목을 관리하는 클래스<br>
 *
 *
 * @author mxcoogi
 * @version lv2
 */
public class MenuItem {
    /**
     * 클래스는 이름, 가격, 설명 필드를 갖는다
     */
    private String name;
    private int price;
    private String description;

    /**
     * @param name        메뉴 아이템의 이름
     * @param price       메뉴 아이템의 가격
     * @param description 메뉴 아이템의 설명
     */
    public MenuItem(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    /**
     * MenuItem의 정보를 보여주는 함수
     *
     * @return 형식에 맞게 만들어진 문자열
     */
    @Override
    public String toString() {
        return String.format("%-20s | W %-5.1f | %s", name, price / Cart.getDIVPRICE(), description);
    }


    /**
     * 아이템 이름
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * 아이템 가격
     * @return int
     */
    public int getPrice() {
        return price;
    }

    /**
     * 아이템 설명
     * @return String
     */
    public String getDescription() {
        return description;
    }
}
