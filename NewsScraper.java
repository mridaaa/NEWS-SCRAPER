public class NewsScraper {
    public String getHTML(String url) {
        URLReader ur = new URLReader(url);
        String html = ur.readURL();
        return html;
    }

    public String getHeadlines(String html, String pattern) {
        int beginIndex = html.indexOf(pattern);

        // Default to 0, Assign in the while loop
        int endIndex = 0;

        String newsItemHTML = " ";

        while (beginIndex >= 0 && endIndex >= 0) {
            // end index for the current look up is the begin index for the next lookup
            // Next look up
            endIndex = html.indexOf(pattern, beginIndex + 1);
            if (endIndex < 0) {
                break;
            }

            newsItemHTML = html.substring(beginIndex, endIndex);
            NewsItem newsItem = new NewsItem(newsItemHTML);
            System.out.println(newsItem.getSummary());
            // Begin index for next look up is the end index of the last look up
            beginIndex = endIndex;

        }
        return null;
    }

    public static void main(String[] args) {
        NewsScraper ns = new NewsScraper();
        String html = ns.getHTML("https://www.bing.com/news/search?q=2024+election");
        ns.getHeadlines(html, "<div class=\"news-card newsitem cardcommon\"");
    }

    public String getFirst(String headlines) {
        return null;
    }
}