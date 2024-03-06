package com.example.LenguagExpert;

import com.example.LenguagExpert.domain.service.serviceImpl.*;
import com.example.LenguagExpert.persistence.entity.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class LenguagExpertApplication {

	public static void main(String[] args) {
//		SpringApplication.run(LenguagExpertApplication.class, args);

		ConfigurableApplicationContext context = SpringApplication.run(LenguagExpertApplication.class, args);

		AttendanceServiceImpl attendanceService = context.getBean(AttendanceServiceImpl.class);
		ClassesServiceImpl classesService = context.getBean(ClassesServiceImpl.class);
		ClassroomServiceImpl classroomService = context.getBean(ClassroomServiceImpl.class);
		SpecialActivityServiceImpl specialActivityService = context.getBean(SpecialActivityServiceImpl.class);
		StudentServiceImpl studentService = context.getBean(StudentServiceImpl.class);
		TeacherServiceImpl teacherService = context.getBean(TeacherServiceImpl.class);
		TopicServiceImpl topicService = context.getBean(TopicServiceImpl.class);
//		LenguagExpertApplication app = contexto.getBean(LenguagExpertApplication.class);


		// Create topic
		Topic topic = new Topic();
		topic.setTopicName("To Be verb");
		topic.setDescription("To Be verb");
		topic.setSemester(1);
		topic.setWeek(1);
		topicService.saveTopic(topic);

		// Get topic by id
//		System.out.println(topicService.getTopicById(1L));
//
//		// Get all topics
//		System.out.println(topicService.getAllTopic());
//
//		// Update topic
//		Topic topicUpdate = new Topic();
//		topicUpdate.setTopicID(1L);
//		topicUpdate.setTopicName("To Be verb edited");
//		topicUpdate.setDescription("To Be verb edited");
//		topicUpdate.setSemester(1);
//		topicUpdate.setWeek(1);
//
//		topicService.updateTopic(topicUpdate);
//
//		// Delete topic
//		topicService.deleteTopic(1L);

//--------------------------------------------------------------------
//--------------------------------------------------------------------

		// Create classroom
		Classroom classroom = new Classroom();
		classroom.setName("Room A");
		classroom.setCapacity(30);
		classroom.setAvailability(true);
		classroomService.saveClassroom(classroom);
//
//		// Get classroom by id
//		classroomService.getClassroomById(1L);
//
//		// Get all classrooms
//		classroomService.getAllClassroom();
//
//		// Update classroom
//		Classroom updateclassroom = new Classroom();
//		classroom.setName("Room B");
//		classroom.setCapacity(20);
//		classroom.setAvailability(true);
//		classroomService.updateClassroom(1L,updateclassroom);
//
//		// Delete classroom
//		classroomService.deleteClassroom(1L);

//--------------------------------------------------------------------
//--------------------------------------------------------------------

		// Create teacher
		Teacher teacher = new Teacher();
		teacher.setId(1L);
		teacher.setFirstName("John");
		teacher.setLastName("Doe");
		teacher.setEmail("john.doe@example.com");
		teacher.setPhone("123456789");
		teacher.setAddress("123 Main St");
		teacherService.saveTeacher(teacher);
//
//		// Get teacher by id
//		teacherService.getTeacherById(1L);
//
//		// Get all teachers
//		teacherService.getAllTeacher();
//
//		// Update Teacher
//		Teacher teacherUpdate = new Teacher();
//		teacher.setId(1L);
//		teacher.setFirstName("John2");
//		teacher.setLastName("Doe2");
//		teacher.setEmail("john2222@example.com");
//		teacher.setPhone("222222");
//		teacher.setAddress("222 Main St");
//		teacherService.updateTeacher(1L, teacherUpdate);
//
//		// Delete Teacher
//		teacherService.deleteTeacher(1L);

//--------------------------------------------------------------------
//--------------------------------------------------------------------

//		// Create Student
		Student student = new Student();
		student.setFirstName("John");
		student.setLastName("Doe");
		student.setEmail("john.doe@example.com");
		student.setPhone("123456789");
		student.setAddress("123 Main St");
		student.setEnrollmentDate(LocalDate.of(2023, 9, 1));
		student.setStatus("Active");
		studentService.saveStudent(student);
//
//		// Get student by id
//		System.out.println(studentService.getStudentById(1L));
//
//		// Get all students
//		System.out.println(studentService.getAllStudents());
//
//		// Update student
//		Student updateStudent = new Student();
//		updateStudent.setFirstName("John2");
//		updateStudent.setLastName("Doe2");
//		updateStudent.setEmail("john2@example.com");
//		updateStudent.setPhone("2222");
//		updateStudent.setAddress("222 Main St");
//		updateStudent.setEnrollmentDate(LocalDate.of(2022, 2, 2));
//		updateStudent.setStatus("Active2");
//		studentService.updateStudent(1L,updateStudent);
//
//		// Delete student
//		studentService.deleteStudent(1L);

//--------------------------------------------------------------------
//--------------------------------------------------------------------

//		// Create classes
		Classes classes = new Classes();
		classes.setClassName("Math");
		classes.setTeacher(teacher); // Suponiendo que tienes una instancia de Teacher
		classes.setClassroom(classroom); // Suponiendo que tienes una instancia de Classroom
		classes.setSchedule("Monday 9:00 AM - 11:00 AM");
		classes.setStartDate(new Date());
		classes.setEndDate(new Date());
		classes.setTopic_id(topic); // Suponiendo que tienes una instancia de Topic
		classesService.saveClass(classes);
//
//	// Obtener una clase por su ID
//		Classes retrievedClasses = classesService.getClassById(1L);
//
//	// Obtener todas las clases
//		List<Classes> allClasses = classesService.getAllClasses();
//
//	// Actualizar una clase
//		Classes updatedClasses = new Classes();
//		updatedClasses.setClassName("Mathematics");
//		updatedClasses.setTeacher(teacher);
//		updatedClasses.setClassroom(classroom);
//		updatedClasses.setSchedule("Monday 10:00 AM - 12:00 PM");
//		updatedClasses.setStartDate(new Date());
//		updatedClasses.setEndDate(new Date());
//		updatedClasses.setTopic_id(topic);
//		classesService.updateClass(1L, updatedClasses);
//
//	// Eliminar una clase
//		classesService.deleteClass(1L);



//--------------------------------------------------------------------
//--------------------------------------------------------------------

// Create attendance
		Attendance attendance = new Attendance();
		attendance.setClass_id(classes);
		attendance.setStudent(student);
		attendance.setDate(LocalDate.now());
		attendance.setStatus("Present");
		attendanceService.saveAttendance(attendance);

// Get attendance by ID
//		Attendance retrievedAttendance = attendanceService.getAttendanceById(1L);
//
//// Get all attendance
//		List<Attendance> allAttendance = attendanceService.getAllAttendances();
//
//// Update attendance
//		Attendance updatedAttendance = new Attendance();
//		updatedAttendance.setClass_id(classes);
//		updatedAttendance.setStudent(student);
//		updatedAttendance.setDate(LocalDate.of(2024, 3, 6)); // New date
//		updatedAttendance.setStatus("Absent");
//		attendanceService.updateAttendance(1L, updatedAttendance);
//
//// Delete attendance
//		attendanceService.deleteAttendance(1L);

//--------------------------------------------------------------------
//--------------------------------------------------------------------

		// Create a special activity
		SpecialActivity specialActivity = new SpecialActivity("Special Event", "Description of the event", LocalDate.of(2024, 3, 6), "Event Location", "Event Organizer");
		specialActivity.getTeachers().add(teacher); // Assuming you have an instance of Teacher
		specialActivity.getStudents().add(student); // Assuming you have an instance of Student
		specialActivityService.saveSpecialActivity(specialActivity);

// Get a special activity by its ID
//		SpecialActivity retrievedSpecialActivity = specialActivityService.getSpecialActivityById(1L);
//
//// Get all special activities
//		List<SpecialActivity> allSpecialActivities = specialActivityService.getAllSpecialActivities();
//
//// Update a special activity
//		SpecialActivity updatedSpecialActivity = specialActivityService.getSpecialActivityById(1L); // Get the activity to update
//		updatedSpecialActivity.setActivityName("Updated Event");
//		updatedSpecialActivity.setDescription("Updated Description");
//		updatedSpecialActivity.setDate(LocalDate.of(2024, 3, 7));
//		updatedSpecialActivity.setLocation("Updated Location");
//		updatedSpecialActivity.setOrganizer("Updated Organizer");
//		updatedSpecialActivity.getTeachers().clear(); // Clear associated teachers
//		updatedSpecialActivity.getTeachers().add(teacher); // Add a new teacher
//		updatedSpecialActivity.getStudents().clear(); // Clear associated students
//		updatedSpecialActivity.getStudents().add(student); // Add a new student
//		specialActivityService.updateSpecialActivity(1L, updatedSpecialActivity);
//
//// Delete a special activity
//		specialActivityService.deleteSpecialActivity(1L);




//--------------------------------------------------------------------
//--------------------------------------------------------------------

		// Relations Student with Special Activity
			studentService.insertSpecialActivity(1L, 1L);

		// Relation Teacher with Special Activity
			teacherService.insertSpecialActivity(1L,1L);

	}
}
