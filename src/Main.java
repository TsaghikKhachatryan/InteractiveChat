import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //starting chat
        Scanner scanner = new Scanner(System.in);
        ChatManager chatManager = new ChatManager();
        chatManager.createChatMembers(scanner);
        chatManager.startChat(scanner);
    }
}