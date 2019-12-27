import java.util.*;
//comments correcting

public class ChatManager {

    private Scanner scanner = new Scanner(System.in);
    private List<Member> members = new ArrayList<>();
    private List<Member> activeMembers = new ArrayList<>();

    public void createChatMembers() {
        System.out.println("enter number of chat members");
        int numberOfChatMembers = scanner.nextInt();

        for (int i = 0; i < numberOfChatMembers; i++) {
            System.out.println("enter member name");
            String name = scanner.next();

            System.out.println("is Active Member ? Y/N");
            String answer = scanner.next();
            boolean isActive = false;
            if(answer.equals("Y") || answer.equals("y")){
                isActive = true;
            }

            Member member = new Member(i, name, isActive);
            members.add(member);
            if(isActive){
                activeMembers.add(member);
            }
        }
    }

    public void startChat() {
        while (activeMembers.size() > 0){
            Random rand = new Random();
            int indexOfSender = rand.nextInt(activeMembers.size());
            Member sender = activeMembers.get(indexOfSender);

            System.out.println("Select action \n1 : Sand Message \n2 : Exit");
            int selectedAction = scanner.nextInt();

            if (selectedAction == 1) {
                sendMessage(sender);
            } else {
                exit(sender);
            }
        }
        System.out.println("No any active member...");
    }

    void sendMessage(Member sender) {
        System.out.println("Please enter your message");
        String messageText = scanner.next();
        Date date = new Date();
        String dateTxt = String.format("%tc", date);
        System.out.println(dateTxt + " " + sender.getName() + " " + messageText);
    }

    private void exit(Member member) {
        activeMembers.remove(member);
    }
}