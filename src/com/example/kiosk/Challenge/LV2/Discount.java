package com.example.kiosk.Challenge.LV2;

public enum Discount {
    VETERAN(0.2),
    MILITARY(0.1),
    STUDENT(0.05),
    NORMAL(0.0);

    private double discountRate;

    // 2.생성자

    /**
     * Discount 생성자
     * @param discountRate 할인율
     */
    Discount(double discountRate) {
        this.discountRate = discountRate;
    }

    // 3. 기능

    // 할인율 반환 메서드
    public double getDiscountRate() {
        return discountRate;
    }

    // 할인 적용 금액 반환 메서드
    public double applyDiscount(double price){
        return price * (1 - discountRate);
    }
}
