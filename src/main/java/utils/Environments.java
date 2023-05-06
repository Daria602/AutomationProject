package utils;

public class Environments {

    public static String getEnv() {
        if (System.getProperty("environment").equals("qa"))
            return "qa";
        else return "dev";
    }
}
