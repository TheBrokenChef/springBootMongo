package com.chefscode.springBootMongo;

import com.chefscode.springBootMongo.model.Address;
import com.chefscode.springBootMongo.model.Gender;
import com.chefscode.springBootMongo.model.Student;
import com.chefscode.springBootMongo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@SpringBootApplication
public class SpringBootMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(StudentRepository studentRepository,
//							 MongoTemplate mongoTemplate){
//		return args ->{
//			Address address = new Address(
//					"England",
//					"London",
//					"NE9"
//			);
//			String email = "loisGriffin@yahoo.com";
//			Student student = new Student(
//					"Lois",
//					"Griffin",
//					email,
//					Gender.FEMALE,
//					address,
//					List.of("Machine Learning","Physics","Chemistry"),
//					BigDecimal.TEN,
//					LocalDateTime.now()
//			);
//
////			Optional<Student> student1 = studentRepository.findStudentByEmail(email);
////			if(student1.isPresent()){
////				System.out.println("Student with email " + email + " already exists");
////			} else {
////				System.out.println("Inserting Student with email " + student.getEmail());
////				studentRepository.insert(student);
////			}
//			studentRepository.findStudentByEmail(email)
//					.ifPresentOrElse( stu -> {
//								System.out.println("Student with email " + stu.getEmail() + " already exists");
//							},
//							() -> {
//								System.out.println("Inserting Student with email " + student.getEmail());
//								studentRepository.insert(student);
//							});
////			Query query = new Query();
////			query.addCriteria(Criteria.where("email").is(email));
////
////			List<Student> studentList = mongoTemplate.find(query, Student.class);
////
////			if(studentList.size()>1){
////				throw new IllegalStateException("Found many students with this email: " + email);
////			}
////
////			if(studentList.isEmpty()){
////				System.out.println("Inserting Student " + student);
////				studentRepository.insert(student);
////			} else {
////				System.out.println("Student with email " + email + " already exists");
////			}
//
//		};
//	}
}
