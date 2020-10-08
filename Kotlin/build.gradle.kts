import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.4.10"
}

group = "com.gildedrose"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation(kotlin("stdlib"))
	testImplementation("io.cucumber:cucumber-java8:6.7.0")
	testImplementation("io.cucumber:cucumber-junit:6.7.0")
	testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
	testImplementation("org.junit.vintage:junit-vintage-engine:5.7.0")
}

tasks.test {
	useJUnitPlatform()
	testLogging {
		events("passed", "skipped", "failed")
	}
}

// config JVM target to 1.8 for kotlin compilation tasks
tasks.withType<KotlinCompile>().configureEach {
	kotlinOptions.jvmTarget = "14"
}
