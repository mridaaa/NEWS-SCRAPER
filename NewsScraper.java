/*
 * December 28, 2023
 * Author: Mrida Yawale
 * Purpose: Finds and stores headlines of the three news items
 */

import java.io.IOException;
import java.util.Scanner;

public class NewsScraper {
    public String getHTML(String url) {
        URLReader ur = new URLReader(url);
        String html = ur.readURL();
        return html;
    }

    public News getHeadlines(String html, String pattern) throws IOException {
        int beginIndex = html.indexOf(pattern);

        // Default to 0, assigned in the while loop
        int endIndex = 0;

        String newsItemHTML = " ";

        News news = new News();
        int count = 1;

        while (beginIndex >= 0 && endIndex >= 0) {

            // end index for the current look up is the begin index for the next lookup
            // Next look up
            endIndex = html.indexOf(pattern, beginIndex + 1);
            if (endIndex < 0) {
                break;
            }

            newsItemHTML = html.substring(beginIndex, endIndex);
            NewsItem newsItem = new NewsItem(newsItemHTML);

            if (count == 1) {
                news.setFirstItem(newsItem);
            } else if (count == 2) {
                news.setSecondItem(newsItem);
            } else if (count == 3) {
                news.setThirdItem(newsItem);
            }
            count ++;

            // Begin index for next look up is the end index of the last look up
            beginIndex = endIndex;

        }
        return news;
    }

}
