package Training.RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExExpressions {
    public void doAllTasks(){

        String text = """
            Hello #ABCDEF and #123456
            Here are numbers: 42 17+ 8+5 100
            Some expressions: (2+3)-4, (1+(2*3)), ((2+3), (4-2)
            Breakfast at 09:00, dinner at 23:59, wrong: 37:98, 25:61
            Some fractions: .5, 2.5, 1234.56, 0.75, 5.0, 7. 
            "This is a quoted string"
            "Multiline
            quoted
            text"
            """;

    System.out.println("=== 1. HTML Color ===");
    Pattern colorPattern = Pattern.compile("#[A-Fa-f0-9]{6}");
    Matcher colorMatcher = colorPattern.matcher(text);
        while (colorMatcher.find()) {
        System.out.println("Found color: " + colorMatcher.group());
    }

        System.out.println("\n=== 2. Numbers not followed by '+' ===");
    Pattern numberNotPlus = Pattern.compile("\\b\\d+(?!\\+)");
    Matcher numberMatcher = numberNotPlus.matcher(text);
        while (numberMatcher.find()) {
        System.out.println("Found number: " + numberMatcher.group());
    }

        System.out.println("\n=== 3. Expressions with balanced brackets ===");
    String[] expressions = text.split("[,\\n]");
        for (String expr : expressions) {
        if (hasBalancedBrackets(expr)) {
            System.out.println("Balanced: " + expr.trim());
        }
    }

        System.out.println("\n=== 4. Valid time (HH:MM) ===");
    Pattern timePattern = Pattern.compile("\\b([01]\\d|2[0-3]):[0-5]\\d\\b");
    Matcher timeMatcher = timePattern.matcher(text);
        while (timeMatcher.find()) {
        System.out.println("Found time: " + timeMatcher.group());
    }

        System.out.println("\n=== 5. Fractional numbers (with dot) ===");
    Pattern fractionPattern = Pattern.compile("\\b\\d*\\.\\d+\\b");
    Matcher fractionMatcher = fractionPattern.matcher(text);
        while (fractionMatcher.find()) {
        System.out.println("Found fractional number: " + fractionMatcher.group());
    }

        System.out.println("\n=== 6. Text in quotation marks (including multiline) ===");
    Pattern quotePattern = Pattern.compile("\"([^\"]*)\"", Pattern.DOTALL);
    Matcher quoteMatcher = quotePattern.matcher(text);
        while (quoteMatcher.find()) {
        System.out.println("Quoted text: " + quoteMatcher.group(1));
    }
}

// Utility to check if brackets are balanced
public static boolean hasBalancedBrackets(String expr) {
    int balance = 0;
    for (char ch : expr.toCharArray()) {
        if (ch == '(') balance++;
        else if (ch == ')') balance--;
        if (balance < 0) return false;
    }
    return balance == 0;
}
}
