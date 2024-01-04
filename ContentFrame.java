import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class ContentFrame extends JFrame {

    public ContentFrame() throws IOException {
        setTitle("BING NEWS SCRAPER");
        setSize(new Dimension(1080,1080));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        String newsKeyword = JOptionPane.showInputDialog("Search Bing News");
        setTitle(newsKeyword.toUpperCase() + " TOP 3 BING NEWS RESULTS ");
        NewsScraper ns = new NewsScraper();
        String url = Constants.NEWS_SITE_URL + newsKeyword.replace(" ", "+");
        String html = ns.getHTML(url);
        News news = ns.getHeadlines(html, "<div class=\"news-card newsitem cardcommon\"");

        HeadlinePanel panel1 = new HeadlinePanel(news.firstItem.getCover(), news.firstItem.getHeadline(), news.firstItem.getSummary(), news.firstItem.getPostTime());
        HeadlinePanel panel2 = new HeadlinePanel(news.secondItem.getCover(), news.secondItem.getHeadline(), news.secondItem.getSummary(), news.secondItem.getPostTime());
        HeadlinePanel panel3 = new HeadlinePanel(news.thirdItem.getCover(), news.thirdItem.getHeadline(), news.thirdItem.getSummary(), news.thirdItem.getPostTime());

        JPanel p= (JPanel) getContentPane();
        p.setLayout(new GridLayout(3,3)); //set your own layout
        p.add(panel1);
        p.add(panel2);
        p.add(panel3);
    }

    public static void main(String[] args) throws IOException {

        /*Scanner ear = new Scanner(System.in);
        System.out.println("Enter a topic: ");
        String newsTopic = ear.nextLine();

         */



        /*JFrame gui = new JFrame();
        gui.setSize(720,1080);
        gui.setTitle(newsTopic + " Top Three Bing Results");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.add(panel1);
        gui.add(panel2);
        gui.add(panel3);
        gui.setVisible(true);

         */
        ContentFrame f = new ContentFrame();
       // f.setVisible(true);


       // System.out.println(news.firstItem.getTest());

    }
}
