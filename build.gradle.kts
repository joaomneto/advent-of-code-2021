plugins {
    kotlin("jvm") version "1.5.31"
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-test")
    implementation("org.jetbrains.kotlin:kotlin-script-runtime")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
