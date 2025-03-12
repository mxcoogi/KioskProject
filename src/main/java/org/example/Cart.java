package org.example;

import java.util.HashMap;
/**
 * 장바구니 클래스<br>
 * static 으로 만들어 객체를 생성할 필요 없음<br>
 * @author mxcoogi
 * @version lv challenge
 */
public class Cart {

    private final static double DIVPRICE = 1000;
    private static HashMap<MenuItem, Integer> cartlist = new HashMap<>();


    /**
     * 장바구니에 아이템이 담겨있는지 확인하고 저장
     * @param menuItem 을 인수로 받아 장바구니에 저장
     */
    public static void addMenuItem(MenuItem menuItem){
        if(cartlist.containsKey(menuItem)){
            cartlist.put(menuItem, cartlist.get(menuItem)+1);
        }else{
            cartlist.put(menuItem, 1);
        }
    }

    /**
     * 장바구니의 목록을 출력하는 메소드
     */
    public static void showCartList(){
        System.out.printf("%-18s | %-4s |  %-5s%n", "상품명", "수량", "가격");
        int resultPrice = 0;
        for(MenuItem menuItem : cartlist.keySet()){
            resultPrice += menuItem.getPrice() * cartlist.get(menuItem);
            int countItem = cartlist.get(menuItem);
            String format =String.format("%-20s | %-5d | W %-5.1f", menuItem.getName(), countItem, menuItem.getPrice()*countItem/DIVPRICE);
            System.out.println(format);
        }
        System.out.println("[ Total ]");
        System.out.printf("W %-5.1f\n", resultPrice / DIVPRICE);

    }

    /**
     * 장바구니 비우는 메서드
     */
    private static void clear(){
        cartlist.clear();
    }


    /**
     * 결제 진행 메서드
     */
    public static void payOrder(){
        int resultPrice = 0;
        for(MenuItem menuItem : cartlist.keySet()){
            resultPrice += menuItem.getPrice() * cartlist.get(menuItem);
        }
        showCartList();
        System.out.println("[ Total ]");
        System.out.printf("W %-5.1f\n", resultPrice / DIVPRICE);
        System.out.println("주문이 완료되었습니다. 금액은 W " + resultPrice / DIVPRICE + " 입니다.");
        clear();
    }

    /**
     * 상수 반환
     * @return double
     */
    public static double getDIVPRICE() {
        return DIVPRICE;
    }
}
