package gwu.jeffschulthies.data.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;

/**
 * Created by Jeff Schulthies
 * .
 */
public class ArticleLinks {
    private final static String WpSelect    = "article a";
    private final static String TimesSelect = "div.trb_article_page a";

    public String retrieveArticleLinks(Document doc, String newsSource) {
        if(newsSource.equals("WashingtonPost")) {
            return retrieveArticleLinksWP(doc);
        } else if(newsSource.equals("LATimes")) {
            return retrieveArticleLinksTimes(doc);
        } else {
            return "News source not supported";
        }
    }

    //Washington Post
    private String retrieveArticleLinksWP(Document doc) {
        Elements bodyText = doc.select(WpSelect);
        String paragraph = "";
        HashMap<String, String> repeats = new HashMap<String, String>();

        for (Element body : bodyText) {
            if(!repeats.containsKey(body.attr("href"))) {
                repeats.put(body.attr("href"), body.text());
                paragraph = paragraph + " " + body.text() + " ";
                paragraph = paragraph + " [" + body.attr("href") + "] ";
            }
        }

        return paragraph;
    }

    //LA Times
    private String retrieveArticleLinksTimes(Document doc) {
        Elements bodyText = doc.select(TimesSelect);
        String paragraph = "";
        HashMap<String, String> repeats = new HashMap<String, String>();

        for (Element body : bodyText) {
            if(!repeats.containsKey(body.attr("href"))) {
                repeats.put(body.attr("href"), body.text());
                paragraph = paragraph + " " + body.text() + " ";
                paragraph = paragraph + " [" + body.attr("href") + "] ";
            }
        }

        return paragraph;
    }

    /*
    New news sources will go here
     */

}
