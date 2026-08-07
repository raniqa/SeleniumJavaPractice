# Selenium Java Practice 

This repository contains my hands-on Selenium WebDriver practice using **Java** and **Maven**. The project is organized topic-wise as I progress through different Selenium automation concepts. It is continuously updated as I learn and implement new Selenium features and best practices.

---

# Technologies Used

- Java
- Selenium WebDriver
- Maven
- Git
- GitHub

---

# Project Structure

```text
SeleniumJavaPractice
│
├── src
│   │
│   ├── main
│   │   │
│   │   ├── java
│   │   │   │
│   │   │   ├── base
│   │   │   │   └── BaseClass.java
│   │   │   │
│   │   │   ├── pages
│   │   │   │
│   │   │   └── utilities
│   │   │
│   │   └── resources
│   │
│   └── test
│       │
│       ├── java
│       │   │
│       │   ├── webelementbasics
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
│       │   ├── waits
│       │   │   ├── ImplicitWaitPractice.java
│       │   │   ├── ExplicitWaitPractice.java
│       │   │   ├── FluentWaitPractice.java
│       │   │   └── ExpectedConditionsPractice.java
│       │   │
│       │   ├── alerts
│       │   │   ├── SimpleAlertPractice.java
│       │   │   ├── ConfirmationAlertPractice.java
│       │   │   ├── PromptAlertPractice.java
│       │   │   └── AlertHandlingUsingWait.java
│       │   │
│       │   ├── frames
│       │   │   ├── SingleFramePractice.java
│       │   │   ├── NestedFramesPractice.java
│       │   │   └── MultipleFramesPractice.java
│       │   │
│       │   ├── windowhandling
│       │   │   ├── SingleWindowPractice.java
│       │   │   └── MultipleWindowPractice.java
│       │   │
│       │   ├── actionsclass
│       │   │   ├── MouseHoverPractice.java
│       │   │   ├── RightClickPractice.java
│       │   │   ├── DoubleClickPractice.java
│       │   │   ├── DragAndDropPractice.java
│       │   │   ├── ClickAndHoldPractice.java
│       │   │   └── KeyboardActionsPractice.java
│       │   │
│       │   ├── javascriptexecutor
│       │   │   ├── HighlightElementPractice.java
│       │   │   ├── JavaScriptClickPractice.java
│       │   │   ├── JavaScriptSendKeysPractice.java
│       │   │   ├── ScrollToElementPractice.java
│       │   │   ├── ScrollToBottomPractice.java
│       │   │   └── ScrollToTopPractice.java
│       │   │
│       │   ├── webtable
│       │   │   ├── StaticWebTablePractice.java
│       │   │   ├── DynamicWebTablePractice.java
│       │   │   ├── PrintTableDataPractice.java
│       │   │   ├── PrintBookNamesPractice.java
│       │   │   ├── ReadSpecificCellPractice.java
│       │   │   ├── CountSeleniumBooksPractice.java
│       │   │   ├── CalculateTotalPricePractice.java
│       │   │   ├── BooksAbovePricePractice.java
│       │   │   └── HighestPricedBookPractice.java
│       │   │
│       │   ├── datepicker
│       │   │   ├── HTMLDatePickerPractice.java
│       │   │   ├── DateTimePicker.java
│       │   │   ├── CustomCalendarNextPrevious.java
│       │   │   └── CustomCalendarMonthYearDropdown.java
│       │   │
│       │   ├── chromeoptions
│       │   │   ├── BrowserWindowOptionsPractice.java
│       │   │   ├── BrowserSecurityOptionsPractice.java
│       │   │   ├── DisablePasswordManagerPractice.java
│       │   │   └── RemoveAutomationMessagePractice.java
│       │   │
│       │   └── testng
│       │       ├── TestNGIntroPractice.java
│       │       ├── TestNGAnnotationsPractice.java
│       │       ├── AlwaysRunAttributePractice.java
│       │       ├── DependsOnMethodsPractice.java
│       │       ├── DescriptionAttributePractice.java
│       │       ├── EnabledAttributePractice.java
│       │       ├── TimeoutAttributePractice.java
│       │       ├── HardAssertPractice.java
│       │       ├── SoftAssertPractice.java
│       │       ├── DataProviderLoginPractice.java
│       │       └── DataProviderSearchProductPractice.java
│       │
│       └── resources
│
├── pom.xml
├── testng.xml
└── README.md
```

---

# Topics Covered

## Web Elements

* Text Box
* Buttons
* Check Boxes
* Radio Buttons
* Links
* Broken Links
* Broken Images
* Tool Tips

---

## Dropdowns

* Select Dropdowns
* Dynamic Dropdowns
* Multi Select Dropdowns
* Auto Suggestion Dropdowns

---

## Wait Handling

* Implicit Wait
* Explicit Wait
* Fluent Wait
* ExpectedConditions

---

## Alerts

* Simple JavaScript Alerts
* Confirmation Alerts
* Prompt Alerts
* Alert Handling using Explicit Wait

---

## Frames

* Switching to Frames using Index
* Switching to Frames using Name/ID
* Switching to Frames using WebElement
* Nested Frames
* Switching Back to Default Content

---

## Window Handling

* Single Window Handling
* Multiple Window Handling
* Switching Between Parent and Child Windows

---

## Actions Class

* Mouse Hover
* Right Click (Context Click)
* Double Click
* Drag and Drop
* Click and Hold
* Keyboard Actions

---

## JavaScript Executor

* Click Using JavaScript
* Enter Text Using JavaScript
* Highlight Web Elements
* Scroll to an Element
* Scroll to the Bottom of the Page
* Scroll to the Top of the Page

---

## Web Tables

* Static Web Table Handling
* Dynamic Web Table Handling
* Finding Row and Column Count Dynamically
* Printing Complete Table Data
* Reading Specific Cell Values
* Extracting Data Based on Conditions
* Dynamic XPath Handling
* XPath Axes (`following-sibling`)
* Performing Calculations Using Table Data
* Filtering Table Data Based on Conditions

---

## Date Picker

* HTML Date Picker
* Date & Time Picker
* Custom Calendar using Next/Previous Navigation
* Custom Calendar using Month & Year Dropdowns

---

## Chrome Options

* Browser Window Options

  * Start Maximized
  * Incognito Mode
  * Headless Mode

* Browser Security Options

  * Disable Notifications
  * Disable Location Permission
  * Disable Camera Permission
  * Disable Microphone Permission

* Disable Password Manager

  * Disable "Save Password" Prompt
  * Disable Password Leak Detection

* Remove Automation Message

  * Remove the "Chrome is being controlled by automated test software" infobar

---

# TestNG Framework

## TestNG Introduction

* Introduction to TestNG
* Advantages of TestNG over JUnit
* TestNG Test Execution Flow

---

## TestNG Annotations

* `@Test`
* `@BeforeTest`
* `@AfterTest`
* `@BeforeMethod`
* `@AfterMethod`
* `@BeforeClass`
* `@AfterClass`
* Understanding Annotation Execution Order

---

## TestNG Attributes

### Priority

* Controlling Test Execution Order

### Description

* Adding Description to Test Methods

### Enabled

* Enabling and Disabling Test Methods

### Timeout

* Handling Test Execution Time Limits

### DependsOnMethods

* Creating Test Dependencies

### AlwaysRun

* Executing Methods Regardless of Dependency Failure

---

## TestNG Assertions

### Hard Assertions

* Validating Test Results using Hard Assert
* `assertEquals()`
* `assertNotEquals()`
* `assertTrue()`
* `assertFalse()`
* Test Execution Behavior When Hard Assertion Fails

### Soft Assertions

* Validating Multiple Conditions in a Single Test
* Using `SoftAssert`
* Difference Between Hard Assert and Soft Assert
* `assertAll()` Method
* Test Execution Behavior When Soft Assertion Fails

---

## TestNG DataProvider

* Introduction to `@DataProvider`
* Data-Driven Testing using TestNG
* Providing Multiple Test Data Sets to a Single Test Method
* Passing Multiple Parameters from `@DataProvider` to `@Test`
* Executing the Same Test Method with Different Test Data
* Using Hardcoded Test Data within the Java Class
* Login Testing using `@DataProvider`
* Product Search Testing using `@DataProvider`

### DataProvider Practice Programs

* `DataProviderLoginPractice.java`
* `DataProviderSearchProductPractice.java`

---

# Project Design

* Common browser setup is maintained in a reusable `BaseClass`.
* Test classes are organized topic-wise using separate packages.
* Maven is used for dependency management.
* TestNG is used as the testing framework for test execution, assertions, attributes, and data-driven testing.
* Explicit waits are used where synchronization is required.
* The project structure is designed to support future expansion using the Page Object Model (POM).

---

# Upcoming Topics

## TestNG

* `@Parameters`
* `testng.xml`
* Passing parameters through `testng.xml`
* `@Optional`
* TestNG Groups
* Include Groups
* Exclude Groups
* Include Methods
* Exclude Methods

## Data-Driven Testing

* External Test Data
* Apache POI
* Reading Test Data from Excel
* Excel Integration with TestNG `@DataProvider`

## Selenium

* File Upload & Download
* SVG Elements
* Shadow DOM
* Nested Shadow DOM

## Selenium Framework

* Page Object Model (POM)
* Page Factory
* Utility Classes
* Configuration / Properties Files
* Log4j
* Extent Reports

## Advanced Automation

* Jenkins CI/CD
* Selenium Grid


---

# How to Run

1. Clone the repository.
2. Import it as a Maven project in Eclipse.
3. Update Maven dependencies.
4. Run the required Java class as a **Java Application**.

---

# Learning Goal

This repository documents my journey in learning Selenium automation and serves as a reference for practicing Selenium WebDriver concepts using Java and Maven. It will continue to evolve as I progress toward building a complete automation framework.

---

# Author

**Rani**

Aspiring QA Automation Engineer | Java | Selenium WebDriver | Maven | Git | GitHub | ISTQB CTFL & CTFL-AT Certified