/*
 * December 28, 2023
 * Author: Mrida Yawale
 * 
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class NewsItem {
    private String headline;
    private String channelLogo;
    private String postTime;
    private String summary;
    private String itemHTML;
    private String site = "https://www.bing.com/";
    private Image cover;

    public NewsItem(String itemHTML) throws IOException {
        this.itemHTML = itemHTML;
        createNewsItem();
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getChannelLogo() {
        return channelLogo;
    }

    public void setChannelLogo(String channelLogo) {
        this.channelLogo = site + channelLogo;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    private void createNewsItem() throws IOException {

        String logo = extractInfo(Constants.LOGO_START_PATTERN, Constants.LOGO_END_PATTERN, 5, 6);
        setChannelLogo(logo);
        //System.out.println(logo);
        //ago">
        String postTime = "Posted " + extractInfo(Constants.POST_TIME_START_PATTERN, Constants.POST_TIME_END_PATTERN, 5, 8) + " ago";
        if(postTime.contains("<")) {
            postTime = postTime.replace("<", "");
        }
        setPostTime(postTime);

        String headline = extractInfo(Constants.HEADLINE_START_PATTERN, Constants.HEADLINE_END_PATTERN, 12, -2);
        setHeadline(headline);

        String summary = extractInfo(Constants.SUMMARY_START_PATTERN, Constants.SUMMARY_END_PATTERN, 5, 0);
        setSummary(summary);

        try {
            String coverImgUrl = "https://bing.com" + extractInfo("data-src-hq=", "&amp;pid", 12, 1);
            coverImgUrl = coverImgUrl.replace("\"", "");
            if (coverImgUrl.contains(" newsitem")) return;
            // System.out.println(coverImgUrl);
            URL url = new URL(coverImgUrl);
            cover = ImageIO.read(url);
        } catch (IOException e) {
            URL url = new URL("https://www.shutterstock.com/shutterstock/videos/1090538971/thumb/1.jpg?ip=x480");
            cover = ImageIO.read(url);
        }
    }

    private String extractInfo(String startPattern, String endPattern, int startInc, int endInc) {
        int infoBeginIndex = itemHTML.indexOf(startPattern);
        int infoEndIndex = itemHTML.indexOf(endPattern);
        infoBeginIndex += startInc;
        infoEndIndex += endInc;

        if(infoBeginIndex == -1 || infoEndIndex == -1 || infoEndIndex < infoBeginIndex) {
            return Constants.NOT_AVAILABLE;
        }

        String info = itemHTML.substring(infoBeginIndex, infoEndIndex);

        return info;
    }


    @Override
    public String toString() {
        return "Logo:" + this.channelLogo + "\n" + "Time Posted: " + this.postTime + "\nHeadline: " + this.headline + " \nSummary: " + this.summary + "\n";
    }

    public Image getCover() {
        return cover;
    }


}
