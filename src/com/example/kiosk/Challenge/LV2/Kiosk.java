package com.example.kiosk.Challenge.LV2;

import java.util.Scanner;

public class Kiosk {
    // 1. 속성(필드)
    private Menu menu; // 메뉴 관리
    private MyCart cart; // 장바구니 관리
    private Discount discount; //할인

    // 2. 생성자
    public Kiosk(Menu menu) {
        this.menu = menu;
        this.cart = new MyCart();
    }

    // 3. 기능

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            printMainMenu();
            char input = sc.next().charAt(0);

            switch (input) {
                case '1':
                    handleCategory("BURGERS");
                    break;
                case '2':
                    System.out.println("DRINKS");
                    break;
                case '3':
                    System.out.println("DESSERT");
                    break;
                case '4':
                    if (!cartIsEmpty()) {
                        handleOrders();
                    } else {
                        System.out.println("장바구니가 비어 있어 주문 메뉴를 선택할 수 없습니다.");
                    }
                    break;
                case '5':
                    if (!cartIsEmpty()) {
                        cancelOrder();
                    } else {
                        System.out.println("취소할 진행 중인 주문이 없습니다.");
                    }
                    break;
                case '0':
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
            }
        }
    }

    private void printMainMenu() {
        System.out.println("[ MAIN MENU ]");
        System.out.println("1. Burgers");
        System.out.println("2. Drinks");
        System.out.println("3. Desserts");
        if (!cartIsEmpty()) {
            System.out.println("[ ORDER MENU ]");
            System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. Cancel       | 진행 중인 주문을 취소합니다.");
        }
        System.out.println("0. 종료      | 종료");
    }

    private boolean cartIsEmpty() {
        return cart.getTotalCount() == 0;
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
                    MenuItem selectedItem = menu.getMenuItem().get(choice - 1);
                    System.out.println("선택한 메뉴: " + selectedItem.getName() + " | W " +
                            selectedItem.getPrice() + " | " + selectedItem.getItemDetails());
                    System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인        2. 취소");

                    char confirm = sc.next().charAt(0);
                    if (confirm == '1') {
                        cart.addCart(selectedItem);
                    } else {
                        System.out.println("메뉴 추가가 취소되었습니다.");
                    }
                    return; // 카테고리 메뉴로 돌아가기
                } else if (choice == 0) {
                    return; // 메인 메뉴로 돌아가기
                } else {
                    System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
                }
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요!");
            }
        }
    }

    private void handleOrders() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("아래와 같이 주문 하시겠습니까?");
            cart.viewCart();
            System.out.println("[ Total ]");
            System.out.printf("W %.2f%n", cart.getTotalPrice());
            System.out.println("\n1. 주문      2. 메뉴판");

            char num = sc.next().charAt(0);

            switch (num) {
                case '1':
                    Discount discount = selectDiscount(); // 할인 선택
                    double totalPrice = cart.getTotalPrice();
                    double discountedPrice = discount.applyDiscount(totalPrice);

                    System.out.printf("주문이 완료되었습니다. 금액은 W%.2f 입니다.%n " , discountedPrice);
                    cart = new MyCart(); // 주문 완료 후 장바구니 초기화
                    return;
                case '2':
                    return; // 메인 메뉴로 돌아가기
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
            }
        }
    }
    private Discount selectDiscount(){
        Scanner sc = new Scanner(System.in);

        while (true){

            System.out.println("할인 정보를 입력해주세요.");
            System.out.println("1. 국가유공자 : 20% ");
            System.out.println("2. 군인     :  10%");
            System.out.println("3. 학생     :  5%");
            System.out.println("4. 일반     :  0%");

            char num = sc.next().charAt(0);

            switch (num){
                case '1':
                    System.out.println("국가유공자 할인이 선택되었습니다.");
                    return Discount.VETERAN;
                case '2':
                    System.out.println("군인 할인이 선택되었습니다.");
                    return Discount.MILITARY;
                case '3':
                    System.out.println("학생 할인이 선택되었습니다.");
                    return Discount.STUDENT;
                case '4':
                    System.out.println("일반이 선택되었습니다.");
                    return Discount.NORMAL;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

    private void cancelOrder() {
        cart = new MyCart(); // 장바구니 초기화
        System.out.println("진행 중인 주문이 취소되었습니다.");
    }
}
