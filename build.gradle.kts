plugins {
	java
	id("org.springframework.boot") version "3.3.4"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "br.com.eadtt"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.kafka:spring-kafka")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	// springfox (depreciado) e springdoc
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")

	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	// não vamos codificar para o driver então ele so esta disponivel em runtime
	runtimeOnly("org.postgresql:postgresql:42.7.4")
	testImplementation("org.assertj:assertj-core")

	testImplementation("org.testcontainers:testcontainers:1.20.3")
	testImplementation("org.testcontainers:postgresql:1.20.3")
	testImplementation("org.testcontainers:kafka:1.20.3")
	testImplementation("org.testcontainers:junit-jupiter:1.20.3")


}

tasks.withType<Test> {
	useJUnitPlatform()
}
