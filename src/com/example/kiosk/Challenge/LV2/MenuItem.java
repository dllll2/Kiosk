package com.example.kiosk.Challenge.LV2;

public class MenuItem {
    // 1. 속성(필드)
    private String name;
    private double price;
    private String itemDetails;

    // 2. 생성자

    /**
     * MenuItem 생성자 선언
     *
     * @param name 음식 이름
     * @param price 음식 가격
     * @param itemDetails 음식 설명
     */
    public MenuItem(String name, double price, String itemDetails) {
        this.name = name;
        this.price = price;
        this.itemDetails = itemDetails;
    }


    // 3. 기능 (메소드)

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getItemDetails() {
        return itemDetails;
    }

}
