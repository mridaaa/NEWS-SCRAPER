/*
Author: Anushka Dole
Purpose: Displays GUI for webscraper
Date: 1/4/23
 */

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

        String newsKeyword =  customDialogBox();
        setTitle(newsKeyword.toUpperCase() + " TOP 3 BING NEWS RESULTS ");
        NewsScraper ns = new NewsScraper();
        String url = Constants.NEWS_SITE_URL + newsKeyword.replace(" ", "+");
        String html = ns.getHTML(url);
        News news = ns.getHeadlines(html, "<div class=\"news-card newsitem cardcommon\"");

        JPanel p= (JPanel) getContentPane();
        Color bgColor = new Color(255,252,235);
        p.setBackground(bgColor);
        p.setLayout(new GridLayout(3,3)); //set your own layout

        if (news.getFirstItem() == null || news.getSecondItem() == null || news.getThirdItem() == null) {
            HeadlinePanel panel = new HeadlinePanel(null,"No results", "","");
            p.add(panel);
        } else {
            HeadlinePanel panel1 = new HeadlinePanel(news.firstItem.getCover(), news.firstItem.getHeadline(), news.firstItem.getSummary(), news.firstItem.getPostTime());
            HeadlinePanel panel2 = new HeadlinePanel(news.secondItem.getCover(), news.secondItem.getHeadline(), news.secondItem.getSummary(), news.secondItem.getPostTime());
            HeadlinePanel panel3 = new HeadlinePanel(news.thirdItem.getCover(), news.thirdItem.getHeadline(), news.thirdItem.getSummary(), news.thirdItem.getPostTime());

            p.add(panel1);
            p.add(panel2);
            p.add(panel3);
        }
    }

    private String customDialogBox() {
        UIManager.put("OptionPane.messageFont" , new Font("Verdana", Font.BOLD, 14));
        Icon icon = new ImageIcon("tempicon.jpeg");
        UIManager.put("OptionPane.messageIcon", icon);

        String userInput = (String)JOptionPane.showInputDialog(
                null, "Search Bing News", "Bing News Scraper", JOptionPane.QUESTION_MESSAGE, icon, null, null
        );
        return userInput;
    }

    public static void main(String[] args) throws IOException {
        ContentFrame f = new ContentFrame();
    }
}