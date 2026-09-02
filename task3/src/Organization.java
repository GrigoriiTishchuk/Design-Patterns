public abstract class Organization {
    protected String name;

    public Organization(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Organization organization) {
        throw new UnsupportedOperationException("Cannot add to this organization");
    }

    public void remove(Organization organization) {
        throw new UnsupportedOperationException("Cannot remove from this organization");
    }

    public abstract double showSalary();
    public abstract String convertToXML(int indentLevel);
}
