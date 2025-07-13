# 🧪 API Automation Framework – RestAssured (Java)

### Author: Medha Wanjari
A robust, modular, and CI/CD-friendly API automation framework built using Java and RestAssured for CRUD operations on the **Restful Booker** application.

---

## 📦 Tech Stack

- **Language**: Java (JDK 22+)
- **Automation Library**: Rest Assured
- **Testing Framework**: TestNG
- **Build Tool**: Maven
- **Reporting**: Allure Reports
- **Assertions**: AssertJ (Advanced assertions)
- **Logging**: Log4j
- **JSON Libraries**: Jackson & GSON
- **Data Handling**: Apache POI
- **CI/CD**: Jenkins (Jenkinsfile Included)

---

## 📁 Framework Structure

api-automation-restassured/
│
├── src/
│ ├── test/java/
│ │ ├── tests/ # TestNG test cases
│ │ ├── utils/ # Utility classes
│ │ ├── base/ # Base test setup
│ │ └── data/ # Test data
│
├── testng.xml # Default suite file
├── testng-integration.xml # Integration test suite
├── pom.xml # Maven configuration
├── Jenkinsfile # Jenkins pipeline file
└── README.md # Project documentation


---

## 🚀 How to Run the Framework

### 1️⃣ Prerequisites
- Java 22+
- Maven 3.8+
- TestNG
- Allure CLI (see below)
- Git installed

---

### 2️⃣ Maven Configuration (`pom.xml`)

#### ✅ Surefire Plugin
```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-surefire-plugin</artifactId>
  <version>3.3.0</version>
  <configuration>
    <suiteXmlFiles>
      <suiteXmlFile>${suiteXmlFile}</suiteXmlFile>
    </suiteXmlFiles>
  </configuration>
</plugin>

✅ Allure Plugin

<plugin>
  <groupId>io.qameta.allure</groupId>
  <artifactId>allure-maven</artifactId>
  <version>2.10.0</version>
  <configuration>
    <reportVersion>2.13.0</reportVersion>
  </configuration>
</plugin>

3️⃣ Run Test Suites

# Run default suite
mvn clean test -DsuiteXmlFile=testng.xml

# Run integration suite
mvn clean test -DsuiteXmlFile=testng-integration.xml

4️⃣ Parallel Execution Support
Set the parallel mode in testng.xml:

<suite name="API Suite" parallel="methods" thread-count="2">

# Generate report
allure generate target/allure-results --clean -o allure-report

# Open in browser
allure open allure-report


🧪 Test Coverage
✅ Functional Tests
Create a booking and verify

Update booking and validate

Delete booking and ensure non-existence

Integration flow: Create → Token → Update → Delete

❌ Negative Tests
Create booking with invalid JSON

Attempt update on deleted ID

Delete non-existing booking

🔍 Validations
HTTP Status Code

Headers

Response Body Schema and Values

📮 Bonus: Postman Assignment (Practice)
Use Postman to manually test these:

Create Booking → Update Name → Validate by ID

Create Booking → Delete → Ensure Not Found

Invalid JSON for Booking

Update on Deleted Booking ID

Validate all response components: status, headers, body

💡 Future Improvements
Add Data-Driven Testing using Excel/JSON

Add Schema Validation

Introduce Retry Mechanism & Soft Assertions

Dockerized Execution

Jenkins Integration Sample Pipeline


