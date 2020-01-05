import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ChatManager {

    private Member[] members;
    private Member[] activeMembers;

    public void createChatMembers(Scanner scanner) {
        System.out.println("enter number of chat members");
        int numberOfChatMembers = scanner.nextInt();
        members = new Member[numberOfChatMembers];
        for (int i = 0; i < numberOfChatMembers; i++) {
            System.out.println("enter member name");
            String name = scanner.next();
            System.out.println("is Active Member ? Yes/No");
            String answer = scanner.next();
            boolean isActive = false;
            if (answer.equalsIgnoreCase("yes")) {
                isActive = true;
            }

            Member member = new Member(i, name, isActive);
            members[i] = member;
        }
        createActiveChatMembers();
    }

    private void createActiveChatMembers() {
        int numberOfActiveMembers = 0;
        int indexOfActiveMember = 0;
        for (Member member : members) {
            if (member.isActive()) {
                ++numberOfActiveMembers;
            }
        }
        activeMembers = new Member[numberOfActiveMembers];
        for (Member member : members) {
            if (member.isActive()) {
                activeMembers[indexOfActiveMember] = member;
                ++indexOfActiveMember;
            }
        }
    }

    public void startChat(Scanner scanner) {
        while (activeMembers.length > 0) {
            Random rand = new Random();
            int indexOfSender = rand.nextInt(activeMembers.length);
            Member sender = activeMembers[indexOfSender];

            System.out.println("Select action \n1 : Sand Message \n2 : Exit");
            int selectedAction = scanner.nextInt();

            if (selectedAction == 1) {
                sendMessage(scanner, sender);
            } else {
                exit(sender);
            }
        }
        System.out.println("No any active member...");
    }

    void sendMessage(Scanner scanner, Member sender) {
        System.out.println("Please enter your message");
        String messageText = scanner.next();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        String text = date.format(formatter);
        LocalDate parsedDate = LocalDate.parse(text, formatter);
        System.out.println(parsedDate + " " + sender.getName() + " " + messageText);
    }

    private void exit(Member member) {
        Member[] updatedActiveMembers = new Member[activeMembers.length - 1];
        int index = 0;
        for (Member m : activeMembers) {
            if (m.equals(member)) {
                continue;
            }
            updatedActiveMembers[index] = m;
            ++index;
        }
        activeMembers = updatedActiveMembers;
    }
}