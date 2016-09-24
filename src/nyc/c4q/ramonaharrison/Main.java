package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.network.Slack;

public class Main {

    public static void main(String[] args) {
        Bot myBot = new Bot();
        myBot.testApi();
        myBot.listMessages(Slack.BOTS_CHANNEL_ID);
        myBot.keepCheckingForWord();


    }
}