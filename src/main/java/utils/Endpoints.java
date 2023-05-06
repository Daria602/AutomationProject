package utils;

import static utils.Environments.getEnv;

public class Endpoints {

    public static String CREATE_ACCOUNT_URI;
    public static String HOMEPAGE;
    public static String MY_ACCOUNT;
    public static String LOGIN_PAGE;

    public static String PANTS_PAGE;

    static {
        if (getEnv().equals("dev")) {
            CREATE_ACCOUNT_URI = "https://magento.softwaretestingboard.com/customer/account/create/";
            HOMEPAGE = "https://magento.softwaretestingboard.com";
            MY_ACCOUNT = "https://magento.softwaretestingboard.com/customer/account/";
            LOGIN_PAGE = "https://magento.softwaretestingboard.com/customer/account/login/";
            PANTS_PAGE = "https://magento.softwaretestingboard.com/women/bottoms-women/pants-women.html";
        }
    }
}
