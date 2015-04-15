package data.parser;

import data.retrieval.RetrievePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Jeff Schulthies
 * .
 */
public class ArticleHeadlineTest {

    @Test
    public void testRetrieveArticleHeadline() throws Exception {
        RetrievePage fetch = new RetrievePage();
        Parser parse       = new Parser();

        //Test 1
        fetch.retrieveFirstArticle("http://www.washingtonpost.com/world/national-security/obama-removes-cuba-from-the-list-of-state-sponsors-of-terrorism/2015/04/14/8f7dbd2e-e2d9-11e4-81ea-0649268f729e_story.html?hpid=z1");
        String headline = parse.headline.retrieveArticleHeadline(fetch.getFirstArticle(),"WashingtonPost");
        Assert.assertEquals(headline, "Obama removes Cuba from the list of state sponsors of terrorism");

        //Test 2
        fetch.retrieveFirstArticle("http://www.washingtonpost.com/blogs/federal-eye/wp/2015/04/14/the-u-s-patent-and-trademark-office-doesnt-know-if-patent-examiners-are-doing-their-jobs-watchdog-says/?hpid=z4");
        headline = parse.headline.retrieveArticleHeadline(fetch.getFirstArticle(),"WashingtonPost");
        Assert.assertEquals(headline, "Patent and Trademark Office doesn’t know if examiners are doing their jobs, watchdog says");

        //Test 3
        fetch.retrieveFirstArticle("http://www.latimes.com/local/lanow/la-me-water-supplier-approves-cut-20150414-story.html");
        headline = parse.headline.retrieveArticleHeadline(fetch.getFirstArticle(),"LATimes");
        Assert.assertEquals(headline, "Water supplier OKs 15% cut to cities, water districts in Southland - LA Times");

        //Test 4
        fetch.retrieveFirstArticle("http://www.latimes.com/science/sciencenow/la-sci-sn-medical-records-breaches-20150414-story.html");
        headline = parse.headline.retrieveArticleHeadline(fetch.getFirstArticle(),"LATimes");
        Assert.assertEquals(headline, "Digital health records are not safe, report on breaches shows - LA Times");

    }
}