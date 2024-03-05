package com.example.LenguagExpert;

import com.example.LenguagExpert.domain.service.serviceImpl.AttendanceServiceImpl;
import com.example.LenguagExpert.domain.service.serviceImpl.TopicServiceImpl;
import com.example.LenguagExpert.persistence.entity.Attendance;
import com.example.LenguagExpert.persistence.entity.Topic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LenguagExpertApplication {

	public static void main(String[] args) {
//		SpringApplication.run(LenguagExpertApplication.class, args);

		ConfigurableApplicationContext contexto = SpringApplication.run(LenguagExpertApplication.class, args);

		TopicServiceImpl topicService = contexto.getBean(TopicServiceImpl.class);
//		AttendanceServiceImpl attendanceService = contexto.getBean(AttendanceServiceImpl.class);
//		LibroServiceImpl libroService = contexto.getBean(LibroServiceImpl.class);
//		ResumenLibroService resumenService = contexto.getBean(ResumenLibroServiceImpl.class);
//
//		LibreriaApplication app = contexto.getBean(LibreriaApplication.class);


		//create topic
//		Topic topic = new Topic();
//		topic.setTopicName("To Be verb");
//		topic.setDescription("To Be verb");
//		topic.setSemester(1);
//		topic.setWeek(1);
//		topicService.saveTopic(topic);

		//get topic by id
//		System.out.println(topicService.getTopicById(1L));
//
//		// Get all topics
//		System.out.println(topicService.getAllTopic());
//
//		//Update topic
//		Topic topicUpdate = new Topic();
//		topicUpdate.setTopicID(1L);
//		topicUpdate.setTopicName("To Be verb edited");
//		topicUpdate.setDescription("To Be verb edited");
//		topicUpdate.setSemester(1);
//		topicUpdate.setWeek(1);
//
//		topicService.updateTopic(topicUpdate);

		//Delete topic
		//topicService.deleteTopic(1L);


//		//Create attendance
//		Attendance attendance = new Attendance();
//		attendance.setStatus("test");
//		attendanceService.saveAttendance(attendance);


	}
}
