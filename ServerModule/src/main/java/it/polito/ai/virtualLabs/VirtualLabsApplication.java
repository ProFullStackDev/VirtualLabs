package it.polito.ai.virtualLabs;

import it.polito.ai.virtualLabs.dtos.CourseDTO;
import it.polito.ai.virtualLabs.dtos.ProfessorDTO;
import it.polito.ai.virtualLabs.dtos.StudentDTO;
import it.polito.ai.virtualLabs.dtos.UserDTO;
import it.polito.ai.virtualLabs.entities.Course;
import it.polito.ai.virtualLabs.services.TeamService;
import it.polito.ai.virtualLabs.services.VmService;
import it.polito.ai.virtualLabs.services.exceptions.team.TeamServiceException;
import org.hibernate.mapping.Array;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class VirtualLabsApplication {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Autowired
    TeamService teamService;

    @Bean
    public CommandLineRunner commander(TeamService teamService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) {
                try {
                    //here goes the code...


                    //Creazione di corsi
                    CourseDTO course = new CourseDTO();
                    course.setName("Corso_di_prova2");
                    course.setAcronym("CdP");
                    course.setEnabled(false);
                    course.setMinTeamSize(4);
                    course.setMaxTeamSize(8);

                    //Creazione di studenti

                    StudentDTO student = new StudentDTO();
                    student.setName("Dario");
                    student.setSurname("Patti");
                    student.setUsername("dario@gmail.com");
                    student.setPassword("patti");
                    student.setId("s266786");

                    StudentDTO student2 = new StudentDTO();
                    student2.setName("Mario");
                    student2.setSurname("Patti");
                    student2.setUsername("mario@gmail.com");
                    student2.setPassword("patti");
                    student2.setId("s266787");

                    //Creazione di professori

                    ProfessorDTO professor = new ProfessorDTO();
                    professor.setName("Giovanni");
                    professor.setSurname("Malnati");
                    professor.setUsername("giovanni@gmail.com");
                    professor.setPassword("malnati");
                    professor.setId("d001234");

                    ProfessorDTO professor2 = new ProfessorDTO();
                    professor2.setName("Giovanni");
                    professor2.setSurname("Falnati");
                    professor2.setUsername("fiovanni@gmail.com");
                    professor2.setPassword("malnati");
                    professor2.setId("d001235");



                    List<StudentDTO> studentList = new ArrayList<>();
                    List<ProfessorDTO> professorList = new ArrayList<>();

                    studentList.add(student);
                    studentList.add(student2);
                    professorList.add(professor);
                    professorList.add(professor2);

                    //Adders
                    //teamService.addCourse(course);
                    //teamService.addStudent(student);
                    //teamService.addProfessor(professor);

                    //teamService.addAllStudents(studentList);
                    //teamService.addAllProfessors(professorList);

                    // Getters
                    //System.out.println(teamService.getCourse("Corso_di_prova"));
                    //System.out.println(teamService.getStudent("s266786"));
                    //System.out.println(teamService.getProfessor("d001234"));
                    //System.out.println(teamService.getAllCourses());
                    //System.out.println(teamService.getAllStudents());
                    //System.out.println(teamService.getAllProfessors());

                    // Switch course status
                    //teamService.enableCourse("prova");
                    //teamService.disableCourse("prova");

                    // Courses operations
                    //teamService.addStudentToCourse("s266786", "prova");
                    //System.out.println(teamService.getEnrolledStudents("prova"));
                    //teamService.enrollAllStudents(Arrays.asList("s266786","s266787"), "prova");
                    //System.out.println(teamService.getCoursesForStudent("s266786"));

                } catch (TeamServiceException e) {
                    System.out.println(e.getMessage());
                }

            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VirtualLabsApplication.class, args);
    }

}