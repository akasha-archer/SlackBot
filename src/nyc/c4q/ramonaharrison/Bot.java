package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.model.Channel;
import nyc.c4q.ramonaharrison.model.Event;
import nyc.c4q.ramonaharrison.model.Message;
import nyc.c4q.ramonaharrison.network.*;
import nyc.c4q.ramonaharrison.network.response.*;

import java.util.ArrayList;
import java.util.List;
import java.lang.CharSequence;
import java.lang.*;
import java.util.Scanner;

/**
 * Created by Ramona Harrison
 * on 8/26/16
 */

public class Bot {
    // TODO: implement your bot logic!

    private List<String> prScannedMessages = new ArrayList<String>();
    private String mLastTimeStamp = "";

    private boolean isThereNewUserInput(){
        ListMessagesResponse listMessagesResponse = Slack.listMessages(Slack.BOTS_CHANNEL_ID);
        List<Message> messages = listMessagesResponse.getMessages();
        String newTimeStamp = messages.get(0).getTs();
        if(!mLastTimeStamp.equals(newTimeStamp)){
            mLastTimeStamp = newTimeStamp;
            return true;
        }
        return !mLastTimeStamp.equals(newTimeStamp);
    }

    private void addToMessageList(String message) {
        String[] splited = message.split("\\s+");
        for (String word : splited) {
            prScannedMessages.add(word);
        }
    }


    public void checkForWord() {
        int count = 0;
        for (String word : prScannedMessages) {
            if (word.equalsIgnoreCase("history") || word.equalsIgnoreCase("historytroll") || word.equalsIgnoreCase("today")) {
                count++;
                System.out.println("word found");
            }
        }
        if(count > 0){
            getAnEvent();
        }
    }

    public int checkForWord(String word) {
        if (word.equalsIgnoreCase("history") || word.equalsIgnoreCase("historytroll") || word.equalsIgnoreCase("today")) {
            getAnEvent();
            System.out.println("word found");
            return 1;
        }
        return 0;
    }

    public void keepCheckingForWord(){
        while (true) {
            if(isThereNewUserInput()){
                ListMessagesResponse listMessagesResponse = Slack.listMessages(Slack.BOTS_CHANNEL_ID);
                List<Message> messages = listMessagesResponse.getMessages();
                String[] splitted = messages.get(0).getText().split("\\s+");
                int count = 0;
                for (String word : splitted) {
                    count += checkForWord(word);
                    if(count > 0){
                        break;
                    }
                }
            }
        }
    }


    /**
     * Sample method: tests the Slack API. Prints a message indicating success or failure.
     */
    public void testApi() {
        Response apiTest = Slack.testApi();
        System.out.println("API OK: " + apiTest.isOk() + "\n");
    }

    /**
     * Sample method: prints all public AccessCode3-3 channel names and ids. Prints an error message on failure.
     */
    public void listChannels() {
        ListChannelsResponse listChannelsResponse = Slack.listChannels();

        if (listChannelsResponse.isOk()) {
            List<Channel> channels = listChannelsResponse.getChannels();

            System.out.println("\nChannels: ");
            for (Channel channel : channels) {
                System.out.println("name: " + channel.getName() + ", id:" + channel.getId());
            }
        } else {
            System.err.print("Error listing channels: " + listChannelsResponse.getError());
        }
    }

    /**
     * Sample method: prints up to the last 100 messages from a given channel. Prints an error message on failure.
     * or failure.
     *
     * @param channelId id of the given channel.
     */
    public void listMessages(String channelId) {
        ListMessagesResponse listMessagesResponse = Slack.listMessages(channelId);

        if (listMessagesResponse.isOk()) {
            List<Message> messages = listMessagesResponse.getMessages();

            System.out.println("\nMessages: ");

            int temp = 0;

            for (Message message : messages) {

                System.out.println();
                System.out.println("Timestamp: " + message.getTs());
                if(temp == 0){
                    mLastTimeStamp = message.getTs();
                }
                System.out.println("Message: " + message.getText());
                addToMessageList(message.getText());
                temp++;
                if (temp == 5) {
                    break;
                }
            }

        } else {
            System.err.print("Error listing messages: " + listMessagesResponse.getError());
        }
    }

    /**
     * Sample method: sends a plain text message to the #bots channel. Prints a message indicating success or failure.
     *
     * @param text message text.
     */
    public void sendMessageToBotsChannel(String text) {
        SendMessageResponse sendMessageResponse = Slack.sendMessage(text);

        if (sendMessageResponse.isOk()) {
            System.out.println("Message sent successfully!");
        } else {
            System.err.print("Error sending message: " + sendMessageResponse.getError());
        }
    }

    /**
     * Sample method: deletes a message from the #bots channel. Prints a message indicating success or failure.
     *
     * @param messageTs unique timestamp of the message to be deleted.
     */
    public void deleteMessageInBotsChannel(String messageTs) {
        DeleteMessageResponse deleteMessageResponse = Slack.deleteMessage(messageTs);

        if (deleteMessageResponse.isOk()) {
            System.out.println("Message deleted successfully!");
        } else {
            System.err.print("Error sending message: " + deleteMessageResponse.getError());
        }
    }

    public void getAnEvent() {
        sendMessageToBotsChannel(TodayInHistory.getTodayInHistory().getRandomEvent().toString());
    }


}
