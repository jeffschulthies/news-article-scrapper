package data.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.sql.Time;

/**
 * Created by Jeff Schulthies
 * .
 */
public class ArticleHeadline {
    private final static String WpElement       = "article-topper";
    private final static String TimesSelection  = "title";

    public String retrieveArticleHeadline(Document doc, String newsSource) {
        if(newsSource.equals("WashingtonPost")) {
            return retrieveArticleHeadlineWP(doc);
        } else if(newsSource.equals("LATimes")) {
            return retrieveArticleHeadlineTimes(doc);
        } else {
            return "News source not supported";
        }

    }

    //Washington Post
    private String retrieveArticleHeadlineWP(Document doc) {
        //Element bodyText = doc.select("headline-kicker").first();
        Element headLineText = doc.getElementById(WpElement);
        Element headLine = headLineText.getElementsByTag("h1").first();
        return headLine.text();
    }

    //LA Times
    private String retrieveArticleHeadlineTimes(Document doc) {
        Element headLineText = doc.select(TimesSelection).first();
        return headLineText.text();
    }

    /*
     * New news sources will go here
     */


}
