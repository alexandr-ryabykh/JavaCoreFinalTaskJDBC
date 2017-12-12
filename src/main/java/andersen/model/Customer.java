package andersen.model;

import java.util.Set;

public class Customer implements Id {

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private Set<Project> projects;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String address, Set<Project> projects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.projects = projects;
    }

    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Project project : projects) {
            builder.append(project.getId()).append(",");
        }
        String projectsString = builder.substring(0, builder.length() - 1);
        return id + ";" + firstName + ";" + lastName + ";" + address + ";" + projectsString;
    }
}
