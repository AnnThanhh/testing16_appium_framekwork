package drivers;

public class DriverManagerFactory {
    public static DriverManager getDriverManager(String platform){
        if(platform.equalsIgnoreCase("android")){
            return new AndroidDriverManager();
        } else if (platform.equalsIgnoreCase("ios")) {
            return new IOSDriverManager();
        } else {
            throw new IllegalArgumentException("Platform not supported: " + platform);
        }
    }
}
