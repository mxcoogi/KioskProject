package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * 장바구니 클래스<br>
 * static 으로 만들어 객체를 생성할 필요 없음<br>
 * @author mxcoogi
 * @version lv challenge
 */
public class Cart {

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
        for(MenuItem menuItem : cartlist.keySet()){
            int countItem = cartlist.get(menuItem);
            String format =String.format("%-20s | %-5d | W %-5.1f", menuItem.getName(), countItem, menuItem.getPrice()*countItem/1000.0);
            System.out.println(format);
        }
    }

    /**
     * 장바구니 비우는 메서드
     */
    public static void clear(){
        cartlist.clear();
    }
}
