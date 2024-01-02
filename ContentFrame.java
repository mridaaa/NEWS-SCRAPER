import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class ContentFrame {

    public static void main(String[] args) throws IOException {

        Scanner ear = new Scanner(System.in);
        System.out.println("Enter a topic: ");
        String newsTopic = ear.nextLine();

        NewsScraper ns = new NewsScraper();
        String url = Constants.NEWS_SITE_URL + newsTopic.replace(" ", "+");
        String html = ns.getHTML(url);
        News news = ns.getHeadlines(html, "<div class=\"news-card newsitem cardcommon\"");

        JFrame gui = new JFrame();
        gui.setTitle(newsTopic + " Top Three Bing Results");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
