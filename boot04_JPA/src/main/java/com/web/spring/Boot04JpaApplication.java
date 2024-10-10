package com.web.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.spring.entity.Custom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
//Spring Framework에서 빈으로 제공되는 것들을 사용하기 위해서는 CommandLineRunner를 상속받아 사용하면 됨
@SpringBootApplication
public class Boot04JpaApplication implements CommandLineRunner{
	
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	@Override
	public void run(String... args) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			
			//jpa 관련 코드를 순서대로 작성
			//저장...perdidtance
//			Custom c = new Custom();
//			c.setName("김종각2");
//			c.setPassword("4321");
//			c.setEmail("kim@gmail.com");
//			
//			entityManager.persist(c);
			
			//검색...find
//			Custom find1 = entityManager.find(Custom.class, 1);
//			System.out.println("1번에 해당하는 고객 정보 : " + find1);
			
			//삭제...remove
//			Custom find3 = entityManager.find(Custom.class, 3);
//			System.out.println("3번에 해당하는 고객 정보 : " + find3);
//			entityManager.remove(find3);
			
//			Custom find2 = entityManager.find(Custom.class, 2);
//			System.out.println("2번에 해당하는 고객 정보 : " + find2);
//			Custom find22 = entityManager.find(Custom.class, 2);
//			if (find2==find22) System.out.println("동일한 객체입니다~!");
			//select가 두 번 호출되지 않고 한 번 호출됨 - persistanceContext와 관련 있음
			
			//persist + find -> but 쿼리문이 하나 나옴. 왜? -> persist 시에 1차 캐시에 저장됨. 그 후 find 시에는 1차 캐시에 있는 데이터를 찾음
//			Custom c = new Custom();
//			c.setName("James");
//			c.setPassword("7777");
//			c.setEmail("james@gmail.com");
//			
//			entityManager.persist(c);
//			
//			Custom find4 = entityManager.find(Custom.class, 4);
//			System.out.println(" 4번에 해당하는 고객 정보 : " + find4);
			
			//수정...JPA에는 update가 존재하지 않음
			//4번 고객의 정보를 수정 -> 
			Custom find4 = entityManager.find(Custom.class, 4); //find
			find4.setPassword("9999"); //비번 변경
			System.out.println("4번 고객의 정보 : " + find4);
			
			
			entityTransaction.commit();
		}catch(Exception e) {
			entityTransaction.rollback();
		}finally {
			entityManager.close();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Boot04JpaApplication.class, args);
	}


}
