package com.example.kiosk.LV2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List <MenuItem> menuItem = new ArrayList<>();
        menuItem.add(new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItem.add(new MenuItem("SmokeShack",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItem.add(new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItem.add(new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거"));

        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("[ SHAKESHACK MENU]");

            for(int i = 0; i < menuItem.size(); i++){
                System.out.printf("%d. %-15s W | %-2.2f | %s%n", i + 1 , menuItem.get(i).name, menuItem.get(i).price, menuItem.get(i).itemDetails);
            }
            char num = sc.next().charAt(0);

            switch(num){
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
                    break;
                default:
                    System.out.println("잘못 선택하셨습니다.");
                    break;
            }

        }while(!sc.next().equals('0'));

        sc.close();
    }
}
