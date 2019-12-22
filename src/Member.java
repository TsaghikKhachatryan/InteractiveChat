
public class Member {
    private int ID;
    private String name;
    private boolean active;

    public Member(int ID, String name, boolean active) {
        this.ID = ID;
        this.name = name;
        this.active = active;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }
}