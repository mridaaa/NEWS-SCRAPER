public class NewsItem {
    private String headline;
    private String channelLogo;
    private String postTime;
    private String summary;
    private String itemHTML;
    private String site = "https://www.bing.com/";

    public NewsItem(String itemHTML) {
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

    private void createNewsItem() {

        String logo = extractInfo("src=\"/th?id=", "&qlt=30\"", 5, 6);
        setChannelLogo(logo);
        //System.out.println(logo);
        //ago">
        String postTime = extractInfo("ago\">", "ago\">", 5, 8);
        if(postTime.contains("<")) {
            postTime = postTime.replace("<", "");
        }
        setPostTime(postTime);

        String headline = extractInfo("data-title=\"", "data-author=", 12, -2);
        setHeadline(headline);

        String summary = extractInfo("...\">", "...</div>", 5, 0);
        setSummary(summary);

        // ...">
        //...</div>

    }

    private String extractInfo(String startPattern, String endPattern, int startInc, int endInc) {

        int infoBeginIndex = itemHTML.indexOf(startPattern);
        int infoEndIndex = itemHTML.indexOf(endPattern);
        infoBeginIndex += startInc;
        infoEndIndex += endInc;
        String info = itemHTML.substring(infoBeginIndex, infoEndIndex);

        return info;
    }

}