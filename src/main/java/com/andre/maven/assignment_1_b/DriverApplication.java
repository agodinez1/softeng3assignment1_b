package com.andre.maven.assignment_1_b;

import java.sql.Timestamp;

import org.joda.time.DateTime;

import com.andre.maven.assignment1.Course;
import com.andre.maven.assignment1.Module;
import com.andre.maven.assignment1.Student;

/**
 * Driver Application for student, course, module assignment
 *
 */
public class DriverApplication {
	private static int COUNTER = 0;

	public static void main(String[] args) {

		/*
		 * Part b) acts as a driver project creating a handful of fictional students
		 * with mock data,
		 * 
		 * adding the students to a number of modules adding a number of modules to a
		 * course. Further on, the program should print out a list of all the courses,
		 * their respective modules, and all students, their usernames, assigned modules
		 * and the course(s) they are registered for to the console.
		 */

		// Create new course
		Course c1 = new Course("Course1", new DateTime(2018, 9, 1, 0, 0), new DateTime(2019, 4, 1, 0, 0));

		// Create 5 mock modules
		Module[] modules = new Module[5];
		for (int i = 0; i < 5; i++) {
			modules[i] = new Module("Module" + i);
		}

		// Add modules to course
		for (Module m : modules) {
			c1.addModule(m);
		}

		// Create 100 mock students and add them to modules
		// enroll student to the course
		// add the assigned module to students at the same time
		for (int i = 0; i < 40; i++) {
			Student student = createStudent();
			c1.enrollStudent(student);
			student.addStudentCourse(c1);

			if (i % 5 == 0)
				modules[0].addStudents(student);
			student.addStudentModule(modules[0]);
			if (i % 5 == 1)
				modules[1].addStudents(student);
			student.addStudentModule(modules[1]);
			if (i % 5 == 2)
				modules[2].addStudents(student);
			student.addStudentModule(modules[2]);
			if (i % 5 == 3)
				modules[3].addStudents(student);
			student.addStudentModule(modules[3]);
			if (i % 5 == 4)
				modules[4].addStudents(student);
			student.addStudentModule(modules[4]);
		}

		c1.showCourseInfo();
		c1.showCourseModules();

	}

	/**
	 * Creates a random student
	 * 
	 * @return
	 */
	public static Student createStudent() {
		// Mock student name
		String studentName = "Student_" + COUNTER;
		DateTime studentDOB = randomDate();
		int studentId = 1000 + COUNTER;

		COUNTER++;

		return new Student(studentName, studentDOB, studentId);
	}

	public static DateTime randomDate() {
		long beginTime = Timestamp.valueOf("2000-01-01 00:00:00").getTime();
		long endTime = Timestamp.valueOf("1970-01-01 00:00:00").getTime();

		long diff = endTime - beginTime + 1;
		long randomTime = beginTime + (long) (Math.random() * diff);

		return new DateTime(randomTime);
	}

}
