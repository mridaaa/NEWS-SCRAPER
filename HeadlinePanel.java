import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class HeadlinePanel extends JPanel{
    Image image;
    String headline;
    public enum articleNum {
        ONE,
        TWO,
        THREE
    }
    private articleNum num;

    public HeadlinePanel(Image image, String headline, articleNum num) {
        this.image = image;
        this.headline = headline;
        this.num = num;
    }

    public void paintComponent(Graphics g) {
        int xOffset = 0;
        int yOffset = 200;

        switch(num) {
            case ONE:
                break;
            case TWO:
                xOffset = 350;
                break;
            case THREE:
                xOffset = 700;
        }

        g.drawImage(image, xOffset, yOffset,300,200,null);
        char[] title = new char[headline.length()];
        for(int i = 0; i<headline.length(); i++) {
            title[i] = headline.charAt(i);
        }
        g.drawChars(title, 0,headline.length(), 0,yOffset - 10);
    }
}