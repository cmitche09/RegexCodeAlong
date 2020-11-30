import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Playpen {
    public static void main(String[] args) {

        /*

        MODULE 3

         */

        // String Matches - if it matches all of the string then it will print true;
        // Ex: A
            System.out.println("abcdefg".matches(".b.d.f."));// output: true
        // Ex: B
            System.out.println("abcdefg".matches("cd")); // output: false


        // String Split - searches for matches, then splits string around those and returns array;
        // Ex: A - split on the ',' character
            System.out.println(Arrays.asList("23,42,64,hike".split(","))); // [23, 42, 64, hike]
        // Ex: B - split on the 'space' character
            System.out.println(Arrays.asList("Anne of the 1000 days".split(" "))); // [Anne, of, the, 1000, days]
        // Ex: C - split on something that isn't in the string
            System.out.println(Arrays.asList("Anne of the 1000 days".split("xxxx"))); // [Anne of the 1000 days]
        // Ex: D - split on an empty string
            System.out.println(Arrays.asList("Anne of the 1000 days".split(""))); // [A, n, n, e,  , o, f,  , t, h, e,  , 1, 0, 0, 0,  , d, a, y, s]
        // Ex: E - split on 'period'
            System.out.println(Arrays.asList("Anne of the 1000 days".split("."))); // []
        // Ex: F - split repeated string on the character repeated
            System.out.println(Arrays.asList("aaaaa".split("a"))); // []

        Pattern pattern = Pattern.compile(",");
        String[] split = pattern.split("12,34,56,78");
        System.out.println(Arrays.asList(split)); // [12, 34, 56, 78]

        Pattern pattern1 = Pattern.compile(",");
        Matcher matcher = pattern1.matcher("12,34,56,78");
        System.out.println(Arrays.asList(split)); // [12, 34, 56, 78]

        validateMasterCardNumber();


    }

    public static void validateMasterCardNumber() {
        Pattern pattern = Pattern.compile("^(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}$");
        boolean matches;
        matches = pattern.matcher("5112345678890123").matches();
        System.out.println(matches); //true
        matches = pattern.matcher("2221012345678901").matches();
        System.out.println(matches); //true
        matches = pattern.matcher("2721012345678901").matches();
        System.out.println(matches); //false


        Collection<String> numbers = Arrays.asList(
                "5112345678890123",
                "2221012345678901",
                "2721012345678901");

        List<String> valids = numbers.stream().filter(pattern.asPredicate())
                .collect(Collectors.toList());
        System.out.println(valids); //[5112345678890123, 2221012345678901]
    }
}
