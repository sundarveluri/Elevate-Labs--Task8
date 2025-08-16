# Elevate-Labs--Task8
Console-Based Quiz Application

Overview:

This is a simple console-based quiz application written in Java. The application presents a series of multiple-choice questions to the user, accepts their answers via the console, and calculates their score based on correct responses. It demonstrates the use of object-oriented programming, control flow, and basic input/output handling in Java.

Features:

Displays multiple-choice questions with four options.

Validates user input to ensure it is a number between 1 and 4.

Tracks the user's score and provides feedback for each answer.

Shows the final score and percentage at the end of the quiz.

How It Works:

The application consists of three main components:

Question class: Represents a single quiz question with its text, options, and the correct answer index.

Quiz class: Manages the quiz logic, including storing questions, handling user input, and calculating the score.

QuizApp class: Contains the main method to start the quiz.

Questions are predefined in the initializeQuestions method of the Quiz class.

The user is prompted to enter a number (1-4) for each question.

Input validation ensures that only valid numbers are accepted; otherwise, the user is asked to retry.

After all questions are answered, the final score and percentage are displayed.

Project Structure:

QuizApp.java: Contains all the code for the quiz application, including the Question and Quiz classes, and the main method to run the program.

README.md: This file, providing an overview and instructions for the project.

How to Add Questions:

To add new questions, modify the initializeQuestions method in the Quiz class. Add a new Question object to the questions list with the following format:

questions.add(new Question(
    "Your question text here?",
    new String[]{"1. Option1", "2. Option2", "3. Option3", "4. Option4"},
    correctAnswerIndex // 1-4, corresponding to the correct option
));

Future Improvements:

Add a feature to load questions from a file.

Implement a timer for each question.

Add categories for questions and allow users to select a category.

Provide a retry option to restart the quiz
