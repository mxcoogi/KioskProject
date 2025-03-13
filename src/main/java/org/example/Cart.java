package org.example;

import java.util.HashMap;
/**
 * 장바구니 클래스<br>
 * @author mxcoogi
 * @version challenge lv1
 */
public class Cart {

    private final static double DIVPRICE = 1000;
    private HashMap<MenuItem, Integer> cartList;

    /**
     * 생성자
     * cartList 값 할당
     */
    public Cart(){
        cartList = new HashMap<>();
    }

    /**
     * 장바구니에 아이템이 담겨있는지 확인하고 저장
     * @param menuItem 을 인수로 받아 장바구니에 저장
     */
    public void addMenuItem(MenuItem menuItem){
        cartList.put(menuItem, cartList.getOrDefault(menuItem, 0)+1);
    }

    /**
     * @deprecated
     * @param menuItem 을 인수로 받아 장바구니에 있는지 확인하고 수량 제거
     */
    public void removeMenuItem(MenuItem menuItem){
        Integer cnt = cartList.get(menuItem);
        if(cnt == null) {
            System.out.println("장바구니에 메뉴가 없습니다.");
            return;
        }
        if(cnt==1){
            cartList.remove(menuItem);
            System.out.println(menuItem.getName() + " 제거 완료");
        }
        else{
            cartList.put(menuItem, cnt-1);
            System.out.println(menuItem.getName() + "1개 제거 완료");
        }

    }

    /**
     * 장바구니의 목록을 출력하는 메소드
     * 스트림보다는  for문을 사용하는게 편할거 같아서 for문으로 유지
     * -> 스트림 변경
     */
    public void showCartList(){
        System.out.printf("%-18s | %-4s |  %-5s%n", "상품명", "수량", "가격");
        /*int resultPrice = 0;
        for(MenuItem menuItem : this.cartList.keySet()){
            resultPrice += menuItem.getPrice() * cartList.get(menuItem);
            int countItem = cartList.get(menuItem);
            String format =String.format("%-20s | %-5d | W %-5.1f", menuItem.getName(), countItem, menuItem.getPrice()*countItem/DIVPRICE);
            System.out.println(format);
        }*/
        int resultPrice = cartList.keySet().stream()
                .mapToInt(menuItem -> {
                    int countItem = cartList.get(menuItem);
                    String format =String.format("%-20s | %-5d | W %-5.1f", menuItem.getName(), countItem, menuItem.getPrice()*countItem/DIVPRICE);
                    System.out.println(format);
                    return menuItem.getPrice() * cartList.get(menuItem);
                })
                .sum();
        System.out.println();
        System.out.println("[ Total ]");
        System.out.printf("W %-5.1f\n", resultPrice / DIVPRICE);
    }

    /**
     * 장바구니 비우는 메서드
     */
    private void clear(){
        cartList.clear();
    }


    /**
     * 결제 진행 메서드
     */
    public void payOrder(){
        if(cartList.isEmpty()){
            System.out.println("장바구니가 비어있습니다.");
            return ;
        }
        int resultPrice = cartList.keySet().stream()
                .mapToInt(menuItem -> menuItem.getPrice() * cartList.get(menuItem))
                .sum();
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
