public class Main {
    public static void main(String[] args) {
        Department IT_Department = new Department("IT Department");
        Department Marketing_Department = new Department("Marketing Department");
        Department QA_Department = new Department("QA Department");

        Employee ceo = new Employee("Grigorii", 70000);
        Employee itManager = new Employee("Olena", 50000);
        Employee marketingManager = new Employee("Valterri", 45000);
        Employee marketingSpecialist = new Employee("Maksim", 40000);
        Employee qaManager = new Employee("Grok", 45000);
        Employee qaSpecialist = new Employee("Misha", 30000);

        IT_Department.add(ceo);
        IT_Department.add(Marketing_Department);
        IT_Department.add(QA_Department);
        IT_Department.add(itManager);

        Marketing_Department.add(marketingManager);
        Marketing_Department.add(marketingSpecialist);

        QA_Department.add(qaManager);
        QA_Department.add(qaSpecialist);

        System.out.println(IT_Department.convertToXML(0));

        System.out.println("Total Salary of Company: " + IT_Department.showSalary());
        System.out.println("Total Salary of Marketing Department: " + Marketing_Department.showSalary());
        System.out.println("Total Salary of QA Department: " + QA_Department.showSalary());

        System.out.println("Deleting QA Specialist from QA Department...");
        QA_Department.remove(qaSpecialist);
        System.out.println("Total Salary of QA Department after deletion: " + QA_Department.showSalary());
        System.out.println(IT_Department.convertToXML(0));

    }
}
