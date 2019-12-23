public class Main {

    public static void main(String[] args) {
        //starting chat
        ChatManager chatManager = new ChatManager();
        chatManager.createChatMembers();
        chatManager.startChat();
    }
}