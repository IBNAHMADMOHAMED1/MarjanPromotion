package utils;

public class Sout {

    public static void sout(String color, String message) {
        switch (color) {
            case "red":
                System.out.println("\u001B[31m" + message + "\u001B[0m");
                break;
            case "green":
                System.out.println("\u001B[32m" + message + "\u001B[0m");
                break;
            case "yellow":
                System.out.println("\u001B[33m" + message + "\u001B[0m");
                break;
                case "blue":
                System.out.println("\u001B[34m" + message + "\u001B[0m");
                break;
            default:
                System.out.println(message);
                break;
        }
    }
}
