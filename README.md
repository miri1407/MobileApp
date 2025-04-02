Time Travelers: History Age Comparison App

Purpose of the App
Time Travelers is an educational Android application designed to engage students in history by comparing their age to the ages at which famous historical figures passed away. This app serves as an innovative tool for educators like Sarah to inspire young minds and make history more relatable and engaging. By creating this personal connection between students and historical figures, the app aims to spark curiosity about these individuals and their contributions to society.
App Overview
The Time Travelers app offers a simple yet engaging user experience:

Users enter their age (between 20 and 100)
The app matches their age with a historical figure who passed away at that exact age
Users learn about the historical figure through an image, brief description, and their age at death
A clear button allows users to reset the app and try another age

The app features a history-themed interface with parchment-like backgrounds and scrolls, antiqua-style fonts, and a user interface that resembles historical documents.
Design Considerations
UI Design Philosophy
The interface was carefully crafted with the following considerations:

Educational Engagement: The design balances educational content with engaging visuals to keep students interested
Age-Appropriate UI: Clean, readable fonts and straightforward navigation suitable for students of various ages
Historical Authenticity: Visual elements (colors, fonts, imagery) that evoke historical documents and artifacts
Accessibility: High contrast text and adequate touch targets for all users
Simplicity: Focused functionality with minimal distractions

Technical Design
The app employs several key architectural and design patterns:

Single Activity Architecture: Simplified navigation and state management
Data Classes: Clean separation of data models using Kotlin data classes
Input Validation: Robust error handling for user inputs
Unit Testing: Comprehensive test coverage of core functionality

Implementation Details
Core Features
1. Age Input and Validation
The app implements robust input validation:

Ensures only integers are entered (using InputFilter)
Validates age range (20-100)
Provides clear error messages for invalid inputs

kotlinCopy// Age input validation
if (userAge < 20 || userAge > 100) {
    showError("The age is out of range. Please enter an age between 20 and 100.")
    return
}
2. Historical Figure Database
The app contains a curated list of 15 historical figures from diverse backgrounds:

Political leaders (Nelson Mandela, Alexander the Great)
Scientists (Albert Einstein, Marie Curie, Nikola Tesla)
Artists (Frida Kahlo, Wolfgang Amadeus Mozart)
Writers (William Shakespeare, Jane Austen)
And many more

Each historical figure entry includes:

Name
Age at death
Brief description
Image resource

3. Matching Algorithm
The app uses a simple but effective algorithm to match user age with historical figures:
kotlinCopyprivate fun findHistoricalFigureByAge(age: Int): HistoricalFigure? {
    // Find exact match for age
    return historicalFigures.find { it.ageAtDeath == age }
}
4. Result Display
When a match is found, the app displays:

Image of the historical figure
Name and age at death
Brief description of their significance
All within a styled card that maintains the historical theme

5. Reset Functionality
The clear button allows users to start over:

Clears input field
Hides result display
Returns to input screen

Error Handling
The app provides user-friendly error messages for various scenarios:

Empty Input: "Please enter your age"
Out of Range: "The age is out of range. Please enter an age between 20 and 100."
Invalid Format: "The age is an invalid format. Please enter a whole number."
No Match Found: "No historical figure found for this age. Try another age!"

These messages are designed to guide users without frustration, maintaining the educational tone of the application.
GitHub Integration
Repository Structure
The GitHub repository is organized to support maintainability and collaboration:
Copy/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/historyagecomparison/
│   │   │   │   ├── MainActivity.kt
│   │   │   │   └── ...
│   │   │   └── res/
│   │   │       ├── layout/
│   │   │       ├── drawable/
│   │   │       └── values/
│   │   └── test/
│   │       └── java/com/example/historyagecomparison/
│   │           └── AgeClassificationTest.kt
│   └── build.gradle
├── .github/workflows/
│   └── android.yml
└── README.md
GitHub Actions for CI/CD
The project implements GitHub Actions to ensure code quality and provide automated builds:

Automated Testing: Runs unit tests on every push and pull request
Build Validation: Ensures the app builds successfully on each code change
APK Generation: Creates debug APKs that can be downloaded as artifacts
Execution Environment: Runs on Ubuntu with JDK 17

The workflow configuration file (.github/workflows/android.yml) defines these automated processes, enabling seamless integration and deployment.
Testing Strategy
The app includes a comprehensive test suite focused on the core functionality:

Age Classification Tests: Verify that the correct historical figures are matched with input ages
Input Validation Tests: Ensure the app properly
