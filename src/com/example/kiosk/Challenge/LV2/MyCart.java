package com.example.kiosk.Challenge.LV2;

import java.util.HashMap;
import java.util.Map;

public class MyCart {

    // 1. 속성(필드)
    //메뉴명, 수량, 가격 정보
    private Map<MenuItem, Integer> cartItems; // 메뉴 항목과 수량을 저장
    private int totalCount; // 총 수량

    // 2. 생성자

    public MyCart() {
        this.cartItems = new HashMap<>();
        this.totalCount = 0;
    }


    // 3.

    /**
     * 장바구니에 메뉴 추가 메서드
     *
     * @param item 추가할 메뉴
     */
    public void addCart(MenuItem item) {
        if (cartItems.containsKey(item)) {
            int currentCount = cartItems.get(item);
            cartItems.put(item, currentCount +1);
            System.out.println(item.getName() + "이(가) 장바구니에 추가되었습니다.");
        } else {
            cartItems.put(item, 1); // 메뉴당 하나만 추가
            System.out.println(item.getName() + "이(가) 장바구니에 추가되었습니다.");
        }
        totalCount++;
    }

    /**
     * 장바구니 메뉴 삭제 메서드
     * 
     * @param index 삭제할 메뉴 번호
     */
    public void removeCart(int index) {
        if(index < 0 || index >= cartItems.size()){
            System.out.println("잘못된번호입니다. 다시 시도해주세요.");
            return;
        }

        // index 에 해당하는 메뉴 가져오기
        MenuItem targetItem = cartItems.keySet().stream()
                .skip(index)
                .findFirst()
                .orElse(null);

        if (targetItem != null){
            int currentCount = cartItems.get(targetItem);
            if (currentCount > 1){
                cartItems.put(targetItem, currentCount - 1); //수량 감소
            }else {
                cartItems.remove(targetItem); // 마지막 한개남았을 경우에는 삭제
            }
            totalCount --;
            System.out.println(targetItem.getName() + "이(가) 장바구니에서 삭제되었습니다.");
        }
    }


    /**
     * 장바구니 출력 메서드
     */
    public void viewCart() {
        if (cartItems.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
        } else {
            System.out.println("[ Orders ]");
            int index = 1; // 번호 초기화
            for (Map.Entry<MenuItem, Integer> entry : cartItems.entrySet()) {
                MenuItem item = entry.getKey();
                Integer count = entry.getValue();
                System.out.printf("%d. %-15s | 가격: W %.2f | 수량: %d 개%n",
                        index++, item.getName(), item.getPrice(), count);
            }
        }
    }

    /**
     * 장바구니 총 금액을 반환하는 메서드
     *
     * @return 총 금액
     */
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Map.Entry<MenuItem, Integer> entry : cartItems.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        return totalPrice;
    }

    /**
     * 장바구니의 총 메뉴 개수를 반환
     *
     * @return 총 메뉴 개수
     */
    public int getTotalCount() {
        return totalCount;
    }

}
