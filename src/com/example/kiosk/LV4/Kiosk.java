package com.example.kiosk.LV4;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    // 1. 속성(필드)
    private List<MenuItem> menuItem;

    // 2. 생성자

    public Kiosk(List<MenuItem> menuItem) {
        this.menuItem = menuItem;
    }


    // 3.기능
    public void start() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("[ SHAKESHACK MENU]");
            for (int i = 0; i < menuItem.size(); i++) {
                System.out.printf("%d. %-15s W | %-2.2f | %s%n", i + 1, menuItem.get(i).name, menuItem.get(i).price, menuItem.get(i).itemDetails);
            }
            System.out.println("0. 종료      | 종료");
            char num = sc.next().charAt(0);

            try {
                switch (num) {
                    case '1':
                        System.out.println("ShackBurger 를 선택하셨습니다.");
                        break;
                    case '2':
                        System.out.println("SmokeShack 를 선택하셨습니다.");
                        break;
                    case '3':
                        System.out.println("Cheeseburger 를 선택하셨습니다.");
                        break;
                    case '4':
                        System.out.println("Hamburger 를 선택하셨습니다.");
                        break;
                    case '0':
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    default:
                        System.out.println("잘못 선택하셨습니다.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요!!!");
            }
        } while (!sc.nextLine().equals('0'));
    }

}
