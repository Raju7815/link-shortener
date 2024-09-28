import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QuickLinkShortener {
    private static final String BASE_URL = "http://short.url/";
    private static final Map<String, String> urlMap = new HashMap<>();
    private static int id = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nURL Shortener Menu:");
            System.out.println("1. Shorten URL");
            System.out.println("2. Retrieve Original URL");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the long URL: ");
                    String longUrl = scanner.nextLine();
                    String shortUrl = shortenURL(longUrl);
                    System.out.println("Shortened URL: " + shortUrl);
                    break;
                case 2:
                    System.out.print("Enter the shortened URL: ");
                    String shortUrlInput = scanner.nextLine();
                    String originalUrl = retrieveOriginalURL(shortUrlInput);
                    if (originalUrl != null) {
                        System.out.println("Original URL: " + originalUrl);
                    } else {
                        System.out.println("Shortened URL not found.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static String shortenURL(String longUrl) {
        String shortUrl = BASE_URL + id++;
        urlMap.put(shortUrl, longUrl);
        return shortUrl;
    }

    private static String retrieveOriginalURL(String shortUrl) {
        return urlMap.get(shortUrl);
    }
}
