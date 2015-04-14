package data.retrieval;

/**
 * Created by Jeff Schulthies
 * .
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class RetrievePage {

    private Document frontPage;
    private Document firstArticle;

    public void retrieveWebPage(String url) throws IOException{
        //Connects to web page
        try {

            frontPage =  Jsoup.connect(url).timeout(10000).get();

        } catch(IOException e) {

            System.out.println(e.toString());
            System.out.println("An error occurred while fetching the url");

        }
    }

    public void retrieveFirstArticle(String url) throws IOException{
        //Connects to article url
        try {

            firstArticle =  Jsoup.connect(url).timeout(10000).get();

        } catch(IOException e) {

            System.out.println(e.toString());
            System.out.println("An error occurred while fetching the url");

        }
    }

    //Getters and Setters
    public Document getFrontPage() {
        return frontPage;
    }

    public void setFrontPage(Document frontPage) {
        this.frontPage = frontPage;
    }

    public Document getFirstArticle() {
        return firstArticle;
    }

    public void setFirstArticle(Document firstArticle) {
        this.firstArticle = firstArticle;
    }

}
