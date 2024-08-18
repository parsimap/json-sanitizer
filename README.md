## Why do we need this?
JSON files are prone to some security vulnerabilities by nature. Using JSON files that have unknown sources is definitely not a 
wise choice. So, use this JSON sanitizer to mitigate security risks.
## How to use?
If you are not familiar with Java runtime, open this project in intellij IDEA and let it handle dependencies itself; although you
may need to configure a Java sdk manually. Then run the app by navigating to `src/main/java/com/google/json/Runner.java` and executing
the `main` function; then you'll be prompted for the file name you want to sanitize. Note that you should have already placed the file 
in `jsonHome/` directory. After a successful execution, you can find your sanitized JSON file in the same directory. 
And if you are experienced with Java, well then what's more to say?
