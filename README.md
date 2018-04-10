# Spring Boot multi-package control

This project demonstrates the approach to make an agent based process control application, packageable into multiple deployment artifacts in a single build.

For example, you might have a requirement to support deployment both as an executable JAR and a traditional WAR archive that is deployable on Tomcat and WildFly. Furthermore, WAR archives might have application server specific deployment constraints which requires you to produce multiple specific WAR archives.

The application is a simple Spring Boot web application built by either Gradle or Maven. 

The project is split into multiple modules. The `control-core` module is central piece which contains the actual implementation, which can be composed of further modules, while several other _control_package_ modules are responsible for packaging application into a respective deployment artifact. These modules are:

 - `control-package-jar`: builds an executable JAR
 - `control-package-war`: builds a traditional WAR archive for deployment in e.g. Tomcat and TomEE.
 - `control-package-war-wildfy`: builds a WildFly specific WAR archive

The important part is that the `control-core` module should not have Spring Boot’s Gradle or Maven plugin applied but rather only using Spring Boot for dependency management.

With Gradle, [Dependency management plugin](https://github.com/spring-gradle-plugins/dependency-management-plugin) should be used together with import of Spring Boot's BOM (this happens automatically if Boot’s Gradle Plugin is applied):

```gradle
subprojects {
	apply plugin: 'java'
	apply plugin: 'io.spring.dependency-management'

	// ...

	dependencyManagement {
		imports {
			mavenBom "org.springframework.boot:spring-boot-dependencies:$springBootVersion"
		}
	}
}
```

_Package_ modules then simply depend on `control-core` module and apply the specific configuration (for example, to enable WAR packaging) and specific dependencies (such as `webjars-locator-jboss-vfs` from introduction).

The resulting build (executed using `./gradlew build` or `./mvnw package`) then generates 3 deployment artifacts.
