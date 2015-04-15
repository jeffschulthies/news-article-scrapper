package data.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * Created by Jeff Schulthies
 * .
 */
public class Parser {
    public ArticleBody body         = new ArticleBody();
    public ArticleHeadline headline = new ArticleHeadline();
    public ArticleLinks links       = new ArticleLinks();
    public Homepage homepage        = new Homepage();
}
