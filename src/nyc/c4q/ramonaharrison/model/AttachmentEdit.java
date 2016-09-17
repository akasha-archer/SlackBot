package nyc.c4q.ramonaharrison.model;

import java.util.Random;

/**
 * Created by akashaarcher on 9/17/16.
 */
public class AttachmentEdit {

    Random rand = new Random();
    public String getAttachment() {
        String[] webList= new String[21];
        webList[0]= "http://images.clipartpanda.com/history-clip-art-eTMoMRqTn.gif";
        webList[1]= "http://www.hettinger.k12.nd.us/jasonlefebre/files/2012/09/slide-History.jpg";
        webList[2]= "http://www.hillsdale.us/images/hc-history-title.jpg";
        webList[3]= "http://blog.coinpip.com/wp-content/uploads/2014/12/History11.jpg";
        webList[4]= "http://ponderingprinciples.com/wp-content/uploads/2015/06/History-Cloud.jpg";
        webList[5]= "https://quotescover.com/wp-content/uploads/If-history-repeats-itself-and__quotes-by-George-Bernard-Shaw-30.png";
        webList[6]= "http://www.ncas.rutgers.edu/sites/fasn/files/photos/history-home.jpg";
        webList[7]= "http://www.businessresearchguide.com/wp-content/uploads/2012/05/best-online-history-degrees.jpg";
        webList[8]= "http://static1.squarespace.com/static/52ae8d8be4b042887e9f8813/t/57252f2c1d07c02f9c239e45/1462054702827/History%2BChannel-Logo-.jpg?format=300w";
        webList[9]= "http://feelgrafix.com/data_images/out/9/830847-history-wallpaper.jpg";
        webList[10]= "http://www.greengablesrushville.com/wp-content/uploads/WHO-WE-ARE-HISTORY.jpg";
        webList[11]= "http://www.thenewsleaders.net/wp-content/uploads/2015/03/history.jpg";
        webList[12]= "http://www.relatably.com/q/img/history-quotes/bill-maher-comedian-quote-if-you-think-you-have-it-tough-read-history.jpg";
        webList[13]= "http://www.bcheritagefairs.ca/wp-content/uploads/2013/10/History-gives-answers....png";
        webList[14]= "http://img.picturequotes.com/2/7/6246/the-study-of-history-is-the-beginning-of-political-wisdom-quote-1.jpg";
        webList[15]= "http://media-cache-ec0.pinimg.com/originals/78/9d/b0/789db0526cb1c9e65efb12c610fab84b.jpg";
        webList[16]= "http://i.quoteaddicts.com/media/quotes/1/3556-history-maya-angelou-quotes.jpg";
        webList[17]= "http://quotes.lifehack.org/media/quotes/quote-Tom-Petty-i-love-history-doesnt-matter-what-era-206448.png";
        webList[18]= "http://ilovehistory.utah.gov/images/slides/caution-diamond.jpg";
        webList[19]= "http://www.slate.com/content/dam/slate/articles/news_and_politics/history/2016/01/160106_HIST_Men-01.jpg.CROP.promo-xlarge2.jpg";
        webList[20]= "http://www.relatably.com/q/img/history-quotes/History-2.jpg";

        return webList[getRandNumb()];
    }
    private int getRandNumb(){
        int max = 20;
        int min = 0;
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
