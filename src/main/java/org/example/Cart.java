package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * 장바구니 클래스
 * @author mxcoogi
 * @version lv challenge
 */
public class Cart {

    private static HashMap<MenuItem, Integer> cartlist = new HashMap<>();


    public static void addMenuItem(MenuItem menuItem){
        if(cartlist.containsKey(menuItem)){
            cartlist.put(menuItem, cartlist.get(menuItem)+1);
        }else{
            cartlist.put(menuItem, 1);
        }
    }

    public static void showCartList(){
        System.out.printf("%-18s | %-4s |  %-5s%n", "상품명", "수량", "가격");
        for(MenuItem menuItem : cartlist.keySet()){
            int countItem = cartlist.get(menuItem);
            String format =String.format("%-20s | %-5d | W %-5.1f", menuItem.getName(), countItem, menuItem.getPrice()*countItem/1000.0);
            System.out.println(format);
        }
    }

    public static void clear(){
        cartlist.clear();
    }
}
