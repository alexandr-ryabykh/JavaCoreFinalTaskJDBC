package andersen;

import andersen.dao.CompanyDAOImpl;
import andersen.dao.DeveloperDAOImpl;
import andersen.dao.SkillDAOImpl;
import andersen.dao.TeamDAOImpl;
import andersen.model.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class TestAll {
    public static void main(String[] args) {
        //  Skill skill = new Skill();
        //   SkillDAOImpl dao = new SkillDAOImpl();
        /*skill.setId(6L);
        skill.setName("FORTRAN");
        dao.create(skill);*/
        //   dao.delete(6L);


        // System.out.println(dao.read(5L));

       /* Set<Developer> set = new HashSet<>();
        Developer dev = new Developer();
        Skill skill = new Skill();
        dev.setId(4L);
        skill.setId(5L);
        DeveloperDAOImpl dao = new DeveloperDAOImpl();
        dao.addSkills(dev, skill);*/
        //   DeveloperDAOImpl dao = new DeveloperDAOImpl();
        /*dev.setId(6L);
        dev.setFirstName("ololo");
        dev.setLastName("ffffff");
        dev.setSpeciality("DEV");
        dev.setSalary(BigDecimal.valueOf(3256.5));
        set.add(dev);*/
        //   dao.create(dev);

        //   dao.delete(4L);
//        System.out.println(dao.read(1L));
      /*  dev.setId(4L);
        dev.setFirstName("kjfsdfkbdfkjb");
        dev.setLastName("OOOOsdffgsgOO");
        dev.setSpeciality("PM");
        dev.setSalary(BigDecimal.valueOf(65151331.6));
        dao.update(dev);*/



       /* Skill skill = new Skill();
        skill.setId(5L);
        skill.setName("SCRUM");
        SkillDAOImpl dao = new SkillDAOImpl();
        dao.update(skill);*/

       /* Team team = new Team();
        TeamDAOImpl dao = new TeamDAOImpl();
        team.setId(4L);
        team.setName("hghgghhhhgghg");
        team.setDevelopers(set);
        dao.delete(4L);*/


        CompanyDAOImpl dao = new CompanyDAOImpl();
        System.out.println(dao.readProject(1L));
      /*  Company company = new Company();
        company.setId(5L);
        Project project = new Project();
        project.setId(5L);
        dao.addProjects(company,project)*/
        ;
    }
}
