// getters + setters for top three
public class News {
    NewsItem firstItem;
    NewsItem secondItem;
    NewsItem thirdItem;

    public NewsItem getFirstItem() {
        return firstItem;
    }

    public void setFirstItem(NewsItem firstItem) {
        this.firstItem = firstItem;
    }

    public NewsItem getSecondItem() {
        return secondItem;
    }

    public void setSecondItem(NewsItem secondItem) {
        this.secondItem = secondItem;
    }

    public NewsItem getThirdItem() {
        return thirdItem;
    }

    public void setThirdItem(NewsItem thirdItem) {
        this.thirdItem = thirdItem;
    }

    public String toString() {
        return "\nFIRST---:\n" + this.firstItem + "\nSECOND:---\n" + this.secondItem + " \nTHIRD:---\n" + this.thirdItem;
    }

}
