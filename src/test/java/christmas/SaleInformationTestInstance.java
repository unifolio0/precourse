package christmas;

import christmas.Model.SaleInformation;
import christmas.Model.User;

public class SaleInformationTestInstance {
    /*크리스마스 디데이 할인, 주말 할인을 받는 경우: 주말(1일)에 메인 메뉴 1개 포함 120,000원 미만 주문*/
    static String input1 = "양송이수프-2,티본스테이크-1,초코케이크-1";
    static SaleInformation saleInformation1 = new SaleInformation(1, new User(input1));

    /*크리스마스 디데이 할인, 주말 할인, 증정 이벤트를 받는 경우: 주말(16일)에 메인 메뉴 3개 포함 120,000원 이상 주문*/
    static String input2 = "양송이수프-2,티본스테이크-3,아이스크림-1";
    static SaleInformation saleInformation2 = new SaleInformation(16, new User(input2));

    /*주말 할인, 증정 이벤트를 받는 경우: 25일 이후 주말(29일)에 메인 메뉴 3개 포함 120,000원 이상 주문*/
    static String input3 = "양송이수프-2,티본스테이크-1,바비큐립-2,아이스크림-1";
    static SaleInformation saleInformation3 = new SaleInformation(29, new User(input3));

    /*할인 혜택이 없는 경우: 25일 이후 주말(29일)에 메인 메뉴 없이 120,000원 미만 주문*/
    static String input4 = "양송이수프-2,초코케이크-3,아이스크림-1";
    static SaleInformation saleInformation4 = new SaleInformation(29, new User(input4));

    /*크리스마스 디데이 할인, 특별 할인 받는 경우: 별표날(10일)에 디저트 없이 120,000원 미만 주문*/
    static String input5 = "양송이수프-2,티본스테이크-1,샴페인-1";
    static SaleInformation saleInformation5 = new SaleInformation(10, new User(input5));

    /*크리스마스 디데이 할인, 평일 할인, 특별 할인 받는 경우: 별표날(25일)에 디저트 2개 포함 120,000원 미만 주문*/
    static String input6 = "양송이수프-2,티본스테이크-1,초코케이크-2,제로콜라-1";
    static SaleInformation saleInformation6 = new SaleInformation(25, new User(input6));

    /*평일 할인, 특별 할인, 증정 이벤트를 받는 경우: 25일 이후 별표날(31일)에 디저트 5개 포함 120,000원 이상 주문한 경우*/
    static String input7 = "시저샐러드-4,초코케이크-2,레드와인-1,아이스크림-3";
    static SaleInformation saleInformation7 = new SaleInformation(31, new User(input7));

    /*할인 혜택이 없는 경우: 10,000원 미만 주문한 경우*/
    static String input8 = "양송이수프-1";
    static SaleInformation saleInformation8 = new SaleInformation(3, new User(input8));

    /*증명 이벤트 받는 경우: 25일 이후 평일(28일)에 디저트 없이 120,000원 이상 주문한 경우*/
    static String input9 = "양송이수프-1,크리스마스파스타-4,레드와인-1";
    static SaleInformation saleInformation9 = new SaleInformation(28, new User(input9));
}
