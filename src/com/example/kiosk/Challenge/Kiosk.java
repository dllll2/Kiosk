package com.example.kiosk.Challenge;

import java.util.Scanner;

public class Kiosk {
    // 1. 속성(필드)
    private Menu menu;

    // 2. 생성자

    /**
     * Kiosk 생성자
     *
     * @param menu
     */
    public Kiosk(Menu menu) {
        this.menu = menu;
    }

    // 3.기능
    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("[ MAIN MENU ]");
            System.out.println("1. Burgers");
            System.out.println("2. Drinks");
            System.out.println("3. Desserts");
            System.out.println("0. 종료");

            char num = sc.next().charAt(0);

            switch (num) {
                case '1':
                    handleCategory("BURGERS");
                    break;
                case '2':
                    System.out.println("아직 준비된 음료가 없습니다.");
                    System.out.println("다시 선택해 주세요.");
                    break;
                case '3':
                    System.out.println("아직 준비된 디저트가 없습니다.");
                    System.out.println("다시 선택해 주세요.");
                    break;
                case '0':
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도해주세요");
            }
        }
    }

    private void handleCategory(String category) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("[" + category + " MENU]");
            menu.getMenuBoard(); // 메뉴 출력
            System.out.println("0. 뒤로가기");

            char num = sc.next().charAt(0);

            try {
                int choice = Character.getNumericValue(num);
                if (choice > 0 && choice <= menu.getMenuItem().size()) {
                    // 선택한 메뉴 출력
                    MenuItem selectedItem = menu.getMenuItem().get(choice - 1);
                    System.out.println("선택한 메뉴: " + selectedItem.getName() + " | W " + selectedItem.getPrice()
                            + " | " + selectedItem.getItemDetails());
                    System.out.println();
                    return;
                } else if (choice == 0) {
                    // 뒤로가기
                    return;
                } else {
                    System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
                }
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요!");
            }
        }
    }
}

