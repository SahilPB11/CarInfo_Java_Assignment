## Car Info Assignment: Cricket Match Data Analysis

This project demonstrates how to fetch and analyze cricket match data from an API using Java and Maven.

### Project Structure

- **src/main/java/car/info**: Contains the core Java code.
  - **ApiClient.java**: Handles making API requests to fetch data.
  - **CricketMatches.java**: Parses and processes the fetched data to calculate metrics.
  - **CricketMatchesTest.java**: Unit test for `parseScore` method.
  - **ApiClientTest.java**: Unit test for `fetchData` method.
- **src/test/java/car/info**: Contains unit tests for the code.
- **pom.xml**: Maven project configuration file.

### Running the Project

1. **Install Maven**: If you don't have Maven installed, download and install it from [https://maven.apache.org/](https://maven.apache.org/).
2. **Clone the project**: Clone this repository to your local machine.
3. **Build the project**: Open a terminal or command prompt, navigate to the project directory and run:
   ```bash
   mvn clean install
   ```
4. **Run the application**: After successful build, execute the main class:
   ```bash
   mvn exec:java -Dexec.mainClass="car.info.CricketMatches"
   ```
   This will fetch data from the API, analyze it, and print the results to the console.

### Code Explanation

**ApiClient.java**

- This class handles the communication with the API.
- It uses the `OkHttpClient` library to make HTTP requests.
- The `fetchData()` method:
  - Constructs a request to the API with the provided URL and API key.
  - Sends the request and retrieves the response.
  - Returns the fetched JSON data as a string if the request is successful, otherwise returns null.

**CricketMatches.java**

- This class is responsible for processing the fetched data.
- The `main()` method:
  - Creates an `ApiClient` instance with the API URL and key.
  - Calls `fetchData()` to retrieve the JSON data.
  - Parses the JSON data using the Gson library.
  - Iterates through each match in the "data" array.
  - Calculates the highest score, the team with the highest score, and the number of matches with a total score over 300.
  - Prints the results to the console.
- The `parseScore()` method:
  - Takes a score string as input (e.g., "250/7").
  - Extracts the numerical part of the score (e.g., "250").
  - Returns the score as an integer.

**Unit Tests**

- The project includes unit tests to ensure the functionality of the code.
- `CricketMatchesTest.java` tests the `parseScore()` method for various valid and invalid input scenarios.
- `ApiClientTest.java` tests the `fetchData()` method by ensuring it correctly retrieves data from the API.

**Intention and Design**

- The code is designed to be modular, with separate classes for API communication and data processing.
- It utilizes well-established libraries like `okhttp` and `gson` for efficient and robust operation.
- The unit tests provide confidence in the code's functionality.
- The code is commented to explain the logic and make it easier to understand.

