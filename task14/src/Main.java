public class Main {
    public static void main(String[] args) {
        System.out.println("Building Gaming Computer");
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector(gamingBuilder);
        director.constructComputer();
        Computer gamingPC = gamingBuilder.getResult();
        System.out.println(gamingPC);

        System.out.println("Building Office Computer");
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        director = new ComputerDirector(officeBuilder);
        director.constructComputer();
        Computer officePC = officeBuilder.getResult();
        System.out.println(officePC);
    }
}
