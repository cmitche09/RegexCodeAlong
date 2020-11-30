public class Module4 {
    /*
    MODULE 4 - Matching via Character Classes
    */

    public static void main(String[] args) {
    }

    private static void testEscapeCharacters() {
        boolean matches = " (212) 345-6789 ".matches("^\\s*\\(\\d{3}\\)\\s*\\d{3}-\\d{4}\\s*$");
        System.out.println(matches); //true
    }


}
