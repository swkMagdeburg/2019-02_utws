plugins {
    base
}

allprojects {
    group = "de.kramhal.utws"
    version = "1.0"
    repositories {
        jcenter()
    }
}

subprojects {
    apply(plugin = "java-library")

    dependencies {
        "testImplementation"("org.junit.jupiter:junit-jupiter-api:5.3.1")
        "testImplementation"("org.junit.jupiter:junit-jupiter-params:5.0.1")
        "testRuntimeOnly"("org.junit.jupiter:junit-jupiter-engine:5.3.1")
        "testCompile"("org.mockito:mockito-junit-jupiter:2.24.5")
    }
}

dependencies {
    subprojects.forEach {
        archives(it)
    }
}