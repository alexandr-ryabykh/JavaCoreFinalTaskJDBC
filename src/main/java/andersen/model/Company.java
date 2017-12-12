package andersen.model;

import java.util.Set;

public class Company implements Id {

    private Long id;
    private String name;
    private Set<Project> projects;

    public Company() {
    }

    public Company(String name, Set<Project> projects) {
        this.name = name;
        this.projects = projects;
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

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    /*@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Project project : projects) {
            builder.append(project.getId()).append(",");
        }
        String projectsString = builder.substring(0, builder.length() - 1);
        return id + ";" + name + ";" + projectsString;
    }*/
/*private Project project;
    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", project_id='" + project.getId() +
                '}';
    }*/
private Project proj;
    @Override
    public String toString() {
        return "Company{" +
                "id=" + id /*+ ", project id=" + proj.getId()*/ +
                '}';
    }
}
