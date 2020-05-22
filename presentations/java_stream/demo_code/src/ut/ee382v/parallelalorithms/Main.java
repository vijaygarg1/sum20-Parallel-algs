package ut.ee382v.parallelalorithms;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        List<ClassDemo> classes = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        feedDemoData(classes, students);

        // For each - print list of class, and students
        //classes.forEach(System.out::println);
        students.forEach(System.out::println);
//
//        students.stream()
//                .map(s -> {
//                    ClassDemo classInfo = classes.stream().filter(c -> c.id == s.classId).findFirst().orElse(null);
//                    return new Object() {ClassDemo classDemo = classInfo; Student studentInfo = s;};
//                })
//                .forEach(o -> {
//                    System.out.println(String.format("%s takes %s", o.studentInfo, o.classDemo != null ? o.classDemo.name : "no class"));
//                });


        // List students in a class
//        Map<Integer, List<Student>> studentByClass = students.stream()
//                .collect(Collectors.groupingBy(Student::getClassId));


//        //For loop version
//        Map<Integer, List<Student>> studentByClassForLoop = new HashMap<>();
//        for(ClassDemo classDemo: classes) {
//            if(!studentByClassForLoop.containsKey(classDemo.id)) {
//                studentByClassForLoop.put(classDemo.id, new LinkedList<Student>());
//            }
//        }
//        studentByClassForLoop.put(Integer.valueOf("-1"), new LinkedList<>());
//        for (Student student: students) {
//            studentByClassForLoop.get(student.classId).add(student);
//        }
//
//
////        studentByClass.keySet().stream()
////                .forEach(k -> {
////                    ClassDemo classInfo = classes.stream().filter(c -> c.id == k).findFirst().orElse(null);
////
////                    if(classInfo != null) {
////                        System.out.println(classInfo.toString() + " has students: ");
////                    } else {
////                        System.out.println("Students do not take any classes: ");
////                    }
////                    studentByClass.get(k)
////                            .stream()
////                            .forEach(System.out::println);
////
////                });
//
//
//
//        // Print out part
//        for (Integer i: studentByClassForLoop.keySet()) {
//            ClassDemo classInfo = null;
//            for (ClassDemo classDemo: classes) {
//                if(classDemo.id == i) {
//                    classInfo = classDemo;
//                }
//            }
//            if(classInfo != null) {
//                System.out.println(classInfo.toString() + " has students: ");
//            } else {
//                System.out.println("Students do not take any classes: ");
//            }
//            for (Student student: students) {
//                if(student.classId == i) {
//                    System.out.println(student);
//                }
//            }
//        }
//
//    }

    static void feedDemoData(List<ClassDemo> classList, List<Student> studentList) {
        classList.add(new ClassDemo(1, "Parallel Algorithms"));
        classList.add(new ClassDemo(2, "Sequntial Algorithms"));
        classList.add(new ClassDemo(3, "Networking"));
        classList.add(new ClassDemo(4, "Data Mining"));
        classList.add(new ClassDemo(5, "Mobile Computing"));
        classList.add(new ClassDemo(6, "System Design"));

        Random random = new Random();
        String[] firstNames = {"Sophia", "Jackson", "Emma", "Aiden", "Olivia", "Lucas", "Ava", "Liam", "Mia", "Noah",
                "Isabella", "Ethan", "Riley", "Mason", "Aria", "Caden", "Zoe", "Oliver", "Charlotte", "Elija"};
        String[] lastNames = {"Smith", "Jones", "Williams", "Taylor", "Brown", "Davies", "Evans", "Wilson", "Thomas", "Johnson"};
        studentList.addAll(IntStream.rangeClosed(0, 20)
                .parallel()
                .mapToObj(i -> {
                    int classId = 1 + random.nextInt(classList.size());
                    if(classId > classList.size()) {
                        classId = -1;
                    }
                    int firstNameIndex = random.nextInt(firstNames.length);
                    String gender = firstNameIndex % 2 == 0 ? "F" : "M";
                    double gpa = random.nextDouble() * 4;
                    return new Student(i, firstNames[firstNameIndex], lastNames[random.nextInt(lastNames.length)], gender, classId, gpa);
                })
                // .forEach(s -> studentList.add(s))  ------ trap: due to stream is a parallel stream
                .collect(Collectors.toList()));

    }
}
