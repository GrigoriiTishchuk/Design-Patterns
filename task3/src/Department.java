import java.util.List;
import java.util.ArrayList;

public class Department extends Organization {
    private List<Organization> subOrganizations = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void add(Organization organization) {
        subOrganizations.add(organization);
    }

    @Override
    public void remove(Organization organization) {
        subOrganizations.remove(organization);
    }
    // recursive call
    @Override
    public double showSalary() {
        double totalSalary = 0;
        for (Organization org : subOrganizations) {
            totalSalary += org.showSalary();
        }
        return totalSalary;
    }

    @Override
    public String convertToXML(int indentLevel) {
        StringBuilder xml = new StringBuilder();
        String indent = " ".repeat(indentLevel);
        xml.append(indent).append("<Department>\n");
        xml.append(indent).append("  <Name>").append(name).append("</Name>\n");
        for (Organization org : subOrganizations) {
            xml.append(org.convertToXML(indentLevel + 2));
        }
        xml.append(indent).append("</Department>\n");
        return xml.toString();
    }
}
