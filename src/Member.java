
public class Member {
    private int id;
    private String name;
    private boolean active;

    public Member(int id, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }
}