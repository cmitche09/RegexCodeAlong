import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Module6 {
    public static void main(String[] args) {
    }
    private static void display(Pattern pattern, String group){
        Matcher matcher = pattern.matcher(group);
        int count = matcher.groupCount();
        if (matcher.matches()){

            //groups are numbered from zero, up to and including the count
            for (int i = -1; i <= count + 1; i++){
                System.out.printf("%s.%s%n", i, matcher.group(i));
            }
        }
    }
    public void testNameGroup(){
        Pattern pattern = Pattern.compile(
                "(?<business>\\w+) (-(\\w+))+-(?<region>\\w+)");
        displayGroups(pattern, "securities-development-equities-valuation-asia", "business", "region");
        displayGroups(pattern, "fixed_income-development-equities-valuation-emea", "business", "region");
        displayGroups(pattern, "fx-development-america", "business", "region");

    }
    private void displayGroups(Pattern pattern, String label, String... groupNames){
        Matcher matcher = pattern.matcher(label);
        if(matcher.matches()){
            System.out.println(matcher.group(0));
            for(String name: groupNames){
                System.out.printf("%s: %s%n", name, matcher.group(name));
            }
        }
    }
}
