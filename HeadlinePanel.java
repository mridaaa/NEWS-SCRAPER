import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class HeadlinePanel extends JPanel{
    Image image;
    String headline;
    String subheadline;
    String datePosted;

    public HeadlinePanel(Image image, String headline, String subHeadline, String datePosted) {
        this.image = image;
        this.headline = headline;
        this.subheadline = subHeadline;
        this.datePosted = datePosted;
    }

    public void paintComponent(Graphics g) {
        g.drawImage(image, 500, 75,300,200,null);
        char[] title = new char[headline.length()];
        for(int i = 0; i<headline.length(); i++) {
            title[i] = headline.charAt(i);
        }

        char[] subtitle = new char[subheadline.length()];
        for(int i = 0; i<subheadline.length(); i++) {
            subtitle[i] = subheadline.charAt(i);
        }
        g.drawChars(subtitle, 0,subheadline.length(), 550,50);

        char[] postDate = new char[datePosted.length()];
        for(int i = 0; i<datePosted.length(); i++) {
            subtitle[i] = datePosted.charAt(i);
        }
        g.drawChars(postDate, 0,datePosted.length(), 600,50);
    }
}