package Krish.src.Exception;

import java.lang.reflect.Method;

public class CustomException {
    public static void main(String[] args) throws Exception {
        UserProfile profile = new UserProfile();

        // 1. Extract the class structure using Reflection
        Class<?> clazz = profile.getClass();

        // 2. Iterate through the target items (methods)
        for (Method method : clazz.getDeclaredMethods()) {

            // 3. Check if your custom annotation is present
            if (method.isAnnotationPresent(JsonElement.class)) {

                // 4. Extract the annotation object to read its values
                JsonElement annotation = method.getAnnotation(JsonElement.class);

                System.out.println("Found annotated method: " + method.getName());
                System.out.println("Annotation Key: " + annotation.key());
                System.out.println("Annotation Value: " + annotation.value());

                // 5. Optional: Execute the annotated method dynamically
                method.invoke(profile);
            }
        }
    }

    static class UserProfile {

        // Passing the required "key" attribute; "value" falls back to "n/a"
        @JsonElement(key = "username")
        public void printUsername() {
            System.out.println("Processing user...");
        }
    }
}
