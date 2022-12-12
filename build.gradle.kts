plugins {
	java
	id("org.springframework.boot") version "3.0.0"
	id("io.spring.dependency-management") version "1.1.0"
	`java-library`
	`maven-publish`
}

repositories {
	mavenLocal()
	maven {
		url = uri("https://repo.maven.apache.org/maven2/")
	}
}

dependencies {
	api("org.springframework.boot:spring-boot-starter-data-jdbc:3.0.0")
	api("org.xerial:sqlite-jdbc:3.39.4.1")
	api("com.github.gwenn:sqlite-dialect:0.1.2")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("mysql:mysql-connector-java:8.0.30")
	api("org.springframework:spring-web:6.0.2")
	runtimeOnly("org.springframework.boot:spring-boot-devtools:3.0.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test:3.0.0")
	compileOnly("org.projectlombok:lombok:1.18.24")
}

group = "com.pos"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17


tasks.withType<JavaCompile>() {
	options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
	options.encoding = "UTF-8"
}

