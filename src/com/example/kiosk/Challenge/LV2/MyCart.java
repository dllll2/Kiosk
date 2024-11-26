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
            System.out.println(item.getName() + "은(는) 이미 장바구니에 있습니다. 추가할 수 없습니다.");
        } else {
            cartItems.put(item, 1); // 메뉴당 하나만 추가
            totalCount++;
            System.out.println(item.getName() + "이(가) 장바구니에 추가되었습니다.");
        }
    }

    /**
     * 장바구니 메뉴 제거 메서드
     *
     * @param item 제거할 메뉴
     */
    public void removeCart(MenuItem item) {
        if (cartItems.containsKey(item)) {
            cartItems.remove(item); // 메뉴 항목을 삭제
            totalCount--;
            System.out.println(item.getName() + "이(가) 장바구니에서 제거되었습니다.");
        } else {
            System.out.println("장바구니에 해당 메뉴가 없습니다.");
        }
    }

    /**
     * 장바구니 보여주는 메서드
     */
    public void viewCart() {
        if (cartItems.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
        } else {
            System.out.println("[ Orders ]");
            for (Map.Entry<MenuItem, Integer> entry : cartItems.entrySet()) {
                MenuItem item = entry.getKey();
                System.out.printf("%-15s | 가격: W %.2f%n", item.getName(), item.getPrice());
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
