package data.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by Jeff Schulthies
 * .
 */
public class ArticleBody {
    private final static String WpSelect    = "article";
    private final static String TimesSelect = "div.trb_article_page";

    public String retrieveArticle(Document doc, String newsSource) {
        if(newsSource.equals("WashingtonPost")) {
            return retrieveArticleWP(doc);
        } else if(newsSource.equals("LATimes")) {
            return retrieveArticleTimes(doc);
        } else {
            return "News source not supported";
        }
    }

    //Washington Post
    private String retrieveArticleWP(Document doc) {
        Elements bodyText = doc.select(WpSelect);
        String paragraph = "";
        for (Element body : bodyText) {
            paragraph += body.text();
        }
        return paragraph;
    }

    //LA Times
    private String retrieveArticleTimes(Document doc) {
        Element bodyText= doc.select(TimesSelect).first();
        return bodyText.text();
    }

    /*
     * New news sources will go here
     */

}
