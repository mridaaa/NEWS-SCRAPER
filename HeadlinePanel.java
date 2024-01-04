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
        //image
        g.setColor(Color.BLACK);
        g.drawImage(image, 500, 100,300,200,null);
        g.drawRect(500, 100, 300, 200);

        //heading
        Font font  = new Font("Verdana", Font.BOLD, 14);
        g.setFont(font);
        char[] title = new char[headline.length()];
        for(int i = 0; i<headline.length(); i++) {
            title[i] = headline.charAt(i);
        }
        g.drawChars(title,0,headline.length(),100,50);

        //subheading
        font = new Font("Verdana", Font.PLAIN, 11);
        g.setFont(font);
        char[] subtitle = new char[subheadline.length()+3];
        for(int i = 0; i<subheadline.length(); i++) {
            subtitle[i] = subheadline.charAt(i);
        }
        subtitle[subheadline.length()] = '.';
        subtitle[subheadline.length()+1] = '.';
        subtitle[subheadline.length()+2] = '.';
        g.drawChars(subtitle, 0,subheadline.length()+3, 125,75);


        //date posted
        font = new Font("Verdana", Font.PLAIN, 9);
        g.setFont(font);
        g.drawString(datePosted,150,100);

    }
}