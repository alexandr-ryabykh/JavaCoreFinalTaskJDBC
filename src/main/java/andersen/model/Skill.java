package andersen.model;

public class Skill implements Id {

    private Long id;
    private String name;

    public Skill(String name) {
        this.name = name;
    }

    public Skill() {

    }

    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + ";" + name;
    }
}
