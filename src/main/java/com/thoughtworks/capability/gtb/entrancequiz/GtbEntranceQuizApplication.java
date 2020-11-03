package com.thoughtworks.capability.gtb.entrancequiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GtbEntranceQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtbEntranceQuizApplication.class, args);
	}
	//TODO GTB-知识点: + 使用了三层架构
	//TODO GTB-知识点: + 使用了Lombok
	//TODO GTB-知识点: + Bean的注入，都是使用构造器注入
}
