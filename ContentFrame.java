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


        HeadlinePanel panel1 = new HeadlinePanel(news.firstItem.getCover(), news.firstItem.getHeadline(), HeadlinePanel.articleNum.ONE);
        HeadlinePanel panel2 = new HeadlinePanel(news.secondItem.getCover(), news.secondItem.getHeadline(), HeadlinePanel.articleNum.TWO);
        HeadlinePanel panel3 = new HeadlinePanel(news.thirdItem.getCover(), news.thirdItem.getHeadline(), HeadlinePanel.articleNum.THREE);

        JFrame gui = new JFrame();
        gui.setSize(720,1080);
        gui.setTitle(newsTopic + " Top Three Bing Results");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.add(panel1);
        gui.add(panel2);
        gui.add(panel3);
        gui.setVisible(true);


       // System.out.println(news.firstItem.getTest());

    }
}
