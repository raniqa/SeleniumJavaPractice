# Selenium Java Practice

This repository contains my hands-on Selenium WebDriver practice using **Java**, **Maven**, and **TestNG**. The project is organized topic-wise as I progress through different Selenium automation concepts.

## Technologies Used

- Java
- Selenium WebDriver
- Maven
- TestNG
- Git
- GitHub

## Project Structure

```text
SeleniumJavaPractice
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── base
│   │   │   │   └── BaseClass.java
│   │   │   ├── pages
│   │   │   └── utilities
│   │   └── resources
│   │
│   └── test
│       ├── java
│       │   ├── webelements
│       │   │   ├── TextBoxPractice.java
│       │   │   ├── ButtonPractice.java
│       │   │   ├── CheckBoxPractice.java
│       │   │   ├── RadioButtonPractice.java
│       │   │   ├── LinksPractice.java
│       │   │   ├── BrokenLinksPractice.java
│       │   │   ├── BrokenImagesPractice.java
│       │   │   └── ToolTipPractice.java
│       │   │
│       │   ├── dropdowns
│       │   │   ├── SelectDropdownPractice.java
│       │   │   ├── DynamicDropdownPractice.java
│       │   │   ├── MultiSelectDropdownPractice.java
│       │   │   └── AutoSuggestionDropdownPractice.java
│       │   │
│       │   └── alerts
│       │       ├── ConfirmationAlertPractice.java
│       │       ├── PromptAlertPractice.java
│       │       ├── SimpleAlertPractice.java
│       │       └── AlertHandlingUsingWait.java
│       │
│       └── resources
│
├── pom.xml
└── README.md
```

## Topics Completed

### Web Elements

- Text Box
- Buttons
- Check Boxes
- Radio Buttons
- Links
- Broken Links
- Broken Images
- Tool Tips

### Dropdowns

- Handling Select Dropdowns using Selenium `Select` class
- Handling Dynamic Dropdowns
- Handling Multi Select Dropdowns
- Handling Auto Suggestion Dropdowns

### Alerts

- Simple JavaScript Alerts
- Confirmation Alerts (Accept/Dismiss)
- Prompt Alerts (sendKeys handling)
- Handling Alerts using Explicit Wait

## Project Design

- Common browser setup is maintained in a reusable `BaseClass`.
- Test classes are organized topic-wise using separate packages.
- Maven is used for dependency management.
- TestNG is used for assertions and test execution.
- The project structure is designed to support future expansion using Page Object Model (POM).

## Upcoming Topics

- Frames
- Window Handling
- Actions Class
- Waits
- JavaScript Executor
- Web Tables
- File Upload & Download
- TestNG Framework
- Page Object Model (POM)
- Data Driven Testing
- CI/CD Integration

## How to Run

1. Clone the repository.
2. Import it as a Maven project in Eclipse.
3. Update Maven dependencies.
4. Run the required test class.
5. Execute TestNG tests as the framework expands.

## Learning Goal

This repository documents my journey in learning Selenium automation and serves as a reference for practicing Selenium WebDriver concepts using Java, Maven, and TestNG.

## Author

Rani