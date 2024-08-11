import groovyjarjarpicocli.CommandLine.usage

plugins {
	java
	id("org.springframework.boot") version "3.2.2"
	id("io.spring.dependency-management") version "1.1.4"
	`maven-publish`
}

group = "com.github.pavelvil.spring.boot.starter"
version = "1.0.0"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-aop")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

publishing {
	publications {
		create<MavenPublication>("mavenJava") {
			from(components["java"])
			versionMapping {
				usage("java-api") {
					fromResolutionOf("runtimeClasspath")
				}
				usage("java-runtime") {
					fromResolutionResult()
				}
			}
		}
	}

	repositories {
		mavenLocal()
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}