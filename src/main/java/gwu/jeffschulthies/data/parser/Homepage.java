package gwu.jeffschulthies.data.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Created by Jeff Schulthies
 * .
 */
public class Homepage {
    private static final String WpId            = "hot-topics-wrapper";
    private static final String TimesSelect     = "section.trb_outfit_primaryItem.trb_outfit_section";
    private static final String TimesAttribute  = "data-content-url";

    public String retrieveHomepage(Document doc, String newsSource) {
        if(newsSource.equals("WashingtonPost")) {
            return retrieveHomepageWP(doc);
        } else if(newsSource.equals("LATimes")) {
            return retrieveHomepageTimes(doc);
        } else {
            return "News source not supported";
        }
    }

    private String retrieveHomepageWP(Document doc) {
        Element headlines = doc.getElementById(WpId);
        Element link = headlines.getElementsByTag("a").first();
        return link.attr("href");
    }

    private String retrieveHomepageTimes(Document doc) {
        Element headline = doc.select(TimesSelect).first();
        //Specifically for LATimes.
        String timesArticleLocation = headline.attr(TimesAttribute);
        return "http://www.latimes.com" + timesArticleLocation;
    }

    /*
     * New news sources will go here
     */

}
