package gwu.jeffschulthies.data;

import gwu.jeffschulthies.data.fileio.FileOutput;
import gwu.jeffschulthies.data.parser.Parser;
import gwu.jeffschulthies.data.retrieval.RetrievePage;
import org.jsoup.nodes.Document;
import java.util.Scanner;

/**
 * Created by Jeff Schulthies
 * .
 */
public class DataWrapper {
    public static void main(String[] args) throws Exception{
        //WashingtonPost, LATimes
        try {
            Scanner scnr = new Scanner(System.in);
            System.out.println("Enter a homepage");
            System.out.println("E.g. http://www.washingtonpost.com/regional/");
            String url = scnr.nextLine();
            System.out.println("Type 'WashingtonPost' or 'LATimes'");
            String newsSource = scnr.nextLine();
            createFile(url, newsSource);
        } catch(NullPointerException e) {
            System.out.println("You have entered a website that is not valid");
        }

    }

    public static void createFile(String newsSourceUrl,String newsSource) throws Exception{

        RetrievePage data = new RetrievePage();
        Parser parse = new Parser();
        FileOutput fileOutput = new FileOutput();

        //Retrieves homepage.
        //Eg. http://www.washingtonpost.com/regional/
        data.retrieveWebPage(newsSourceUrl);

        //Retrieves first article url
        String articleUrl = parse.homepage.retrieveHomepage(data.getFrontPage(), newsSource);

        //Sets first article url
        data.retrieveFirstArticle(articleUrl);
        Document article = data.getFirstArticle();

        //Retrieves headline, body, links
        String headline = parse.headline.retrieveArticleHeadline(article, newsSource);
        String body     = parse.body.retrieveArticle(article, newsSource);
        String links    = parse.links.retrieveArticleLinks(article, newsSource);

        //Retrieves Date
        String date = fileOutput.getDate();

        //Writes to local directory
        fileOutput.fileWriter(date + "-" + headline + ".txt",
                articleUrl,
                headline,
                body,
                links);
    }

}
