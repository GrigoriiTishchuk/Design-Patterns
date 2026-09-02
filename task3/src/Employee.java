public class Employee extends Organization {
    private double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public double showSalary() {
        return salary;
    }

    @Override
    public String convertToXML(int indentLevel) {
        StringBuilder xml = new StringBuilder();
        String indent = " ".repeat(indentLevel);
        xml.append(indent).append("<Employee>\n");
        xml.append(indent).append("  <Name>").append(name).append("</Name>\n");
        xml.append(indent).append("  <Salary>").append(salary).append("</Salary>\n");
        xml.append(indent).append("</Employee>\n");
        return xml.toString();
    }
}
