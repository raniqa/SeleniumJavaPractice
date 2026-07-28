# Selenium Java Practice

This repository contains my hands-on Selenium WebDriver practice using **Java** and **Maven**. The project is organized topic-wise as I learn and implement different Selenium WebDriver concepts through practical examples.

## Technologies Used

- Java
- Selenium WebDriver
- Maven
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
│       │   ├── alerts
│       │   │   ├── SimpleAlertPractice.java
│       │   │   ├── ConfirmationAlertPractice.java
│       │   │   ├── PromptAlertPractice.java
│       │   │   └── AlertHandlingUsingWait.java
│       │   │
│       │   ├── actionsclass
│       │   │   ├── ContextClickPractice.java
│       │   │   ├── DoubleClickPractice.java
│       │   │   ├── DragAndDropPractice.java
│       │   │   ├── DragAndDropUsingActions.java
│       │   │   ├── KeyboardActionPractice.java
│       │   │   ├── MouseHoverPractice.java
│       │   │   └── SliderPractice.java
│       │   │
│       │   ├── frames
│       │   │   ├── SingleFramePractice.java
│       │   │   └── NestedFramesPractice.java
│       │   │
│       │   └── windowhandling
│       │       ├── SingleWindowPractice.java
│       │       └── MultipleWindowsPractice.java
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

- Select Dropdowns
- Dynamic Dropdowns
- Multi Select Dropdowns
- Auto Suggestion Dropdowns

### Alerts

- Simple JavaScript Alerts
- Confirmation Alerts
- Prompt Alerts
- Handling Alerts using Explicit Wait

### Frames

- Single Frame Handling
- Nested Frames

### Window Handling

- Single Window Handling
- Multiple Window Handling

### Actions Class

- Mouse Hover
- Double Click
- Context Click (Right Click)
- Drag and Drop
- Drag and Drop using Actions Class
- Keyboard Actions
- Slider Handling

## Project Design

- Common browser setup is maintained in a reusable `BaseClass`.
- Test classes are organized topic-wise into separate packages.
- Maven is used for dependency management.
- The project structure is designed to support future expansion using the Page Object Model (POM).

## Upcoming Topics

- Waits
- JavaScript Executor
- Web Tables
- File Upload & Download
- TestNG
- Page Object Model (POM)
- Data Driven Testing
- CI/CD Integration

## How to Run

1. Clone the repository.
2. Import it as a Maven project in Eclipse.
3. Update Maven dependencies.
4. Run the desired Java class as a Java Application.

## Learning Goal

This repository documents my journey of learning Selenium WebDriver through hands-on practice. Each package focuses on a specific Selenium concept, making it easy to revisit topics and track my progress as I continue learning automation testing.

## Author

**Rani**