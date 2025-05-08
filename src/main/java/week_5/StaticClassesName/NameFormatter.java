package week_5.StaticClassesName;

public class NameFormatter {

    private NameFormatter() {
    }

    public static String format(String firstName, String lastName){
        String fullName;
        fullName = lastName + ", " + firstName;
        return fullName;
    }

    public static String format(String firstName, String lastName, String prefix, String suffix, String middleName) {
        StringBuilder sb = new StringBuilder();
        sb.append(lastName)
            .append(", ")
            .append(prefix)
            .append(" ")
            .append(firstName)
            .append(" ")
            .append(middleName)
            .append(", ")
            .append(suffix);
        return sb.toString();
    }
                                // Stanislav Hryshchuk
    public static String format(String fullName){

        String[] splitName = fullName.split(" ");

        return  splitName[1] + " " + splitName[0];
    }


}
