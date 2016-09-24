package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.network.Slack;

public class Main {

    public static void main(String[] args) {

        Bot myBot = new Bot();

        myBot.testApi();

      //  myBot.listChannels();

       myBot.listMessages(Slack.BOTS_CHANNEL_ID);

        myBot.checkForWord();
        myBot.keepCheckingForWord();

      // myBot.getAnEvent();

        // Post "Hello, world!" to the #bots channel
       // myBot.sendMessageToBotsChannel("Hola, mundo! Como se escribe java en espanol??");

        // Post a pineapple photo to the #bots channel
       // myBot.sendMessageToBotsChannel("http://placehold.it/350x250");

    }
}