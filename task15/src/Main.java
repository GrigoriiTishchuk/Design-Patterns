public class Main {
    public static void main(String[] args) {
        // Client interacts exclusively with the NewDateInterface via the Adapter
        NewDateInterface date = new CalendarToNewDateAdapter();
        date.setYear(2026);
        date.setMonth(11);
        date.setDay(5);
        System.out.println("Initial Date");
        printDate(date);

        int advanceAmount = 45;
        System.out.println("\nAdvancing date by " + advanceAmount + " days");
        date.advanceDays(advanceAmount);
        System.out.println("\nDate After Advancing");
        printDate(date);
    }

    private static void printDate(NewDateInterface date) {
        System.out.println("Year:  " + date.getYear());
        System.out.println("Month: " + date.getMonth());
        System.out.println("Day:   " + date.getDay());
        System.out.println("Formatted: " + date.getDay() + "." + date.getMonth() + "." + date.getYear());
    }
}