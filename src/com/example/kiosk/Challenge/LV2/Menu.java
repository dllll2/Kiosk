package com.example.kiosk.Challenge.LV2;

import java.util.List;

public class Menu {

    // 1.속성(필드)
    private String category;
    private List<MenuItem> menuItem;

    // 2.생성자

    /**
     * Menu 생성자
     *
     * @param category 카테고리 이름
     * @param menuItem 메뉴 리스트
     */
    public Menu(String category, List<MenuItem> menuItem) {
        this.category = category;
        this.menuItem = menuItem;
    }

    // 3.기능

    /**
     * 메뉴 리스트 반환 메서드
     *
     * @return 메뉴 리스트
     */
    public List<MenuItem> getMenuItem() {
        return menuItem;
    }


    /**
     * 메뉴판 출력 메서드
     * 메뉴를 콘솔에 출력한다.
     */
    public void getMenuBoard() {
        for (int i = 0; i < menuItem.size(); i++) {
            MenuItem item = menuItem.get(i);
            System.out.printf("%d. %-15s W | %-2.2f | %s%n",
                    i + 1, item.getName(), item.getPrice(), item.getItemDetails());
        }
    }
}
