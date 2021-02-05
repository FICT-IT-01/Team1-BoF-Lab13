package com.kpi.it01.team1.lab13;

import com.kpi.it01.team1.lab13.exceptions.FacultyAlreadyExistsException;
import com.kpi.it01.team1.lab13.exceptions.StudentAlreadyExistsException;
import com.kpi.it01.team1.lab13.models.*;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        try {
            Institute kpi = new Institute("National Technical University of Ukraine “Igor Sikorsky Kyiv Polytechnic Institute”");

            kpi.addFaculty(new Faculty("FICT"));
            kpi.addFaculty(new Faculty("FPM"));
            kpi.addFaculty(new Faculty("FTI"));
            kpi.addFaculty(new Faculty("FMM"));
            kpi.addFaculty(new Faculty("FMF"));
            kpi.addFaculty(new Faculty("FEL"));
            kpi.addFaculty(new Faculty("FEA"));

            for (var f : kpi.getFaculties()) {
                for (int i = 0; i < ThreadLocalRandom.current().nextInt(10, 100); ++i) {
                    var studentBookNumber = Integer.valueOf(ThreadLocalRandom.current().nextInt(1, 9999)).toString();

                    f.addStudent(new Student(UUID.randomUUID().toString().substring(0, 7),
                            UUID.randomUUID().toString().substring(0, 7),
                            f.getName().substring(0, 2) +
                                    ("0000" + studentBookNumber).substring(studentBookNumber.length()),
                            "",
                            ThreadLocalRandom.current().nextFloat() * 100));
                }
            }

            System.out.println(kpi);

            System.out.println("Students at KPI: " + kpi.getStudentsAmount());
            System.out.println("Greatest amount of students at " + kpi.getBiggestFaculty().getName());
            System.out.println("Students with average mark from 95 to 100:");

            for (var student : kpi.getStudentsWithAverageMarkInRange(95, 100)) {
                System.out.println(student);
            }
        } catch (StudentAlreadyExistsException | FacultyAlreadyExistsException ex){
            System.out.println("EXCEPTION! " + e.getMessage() + "\n");
        }
    }
}
