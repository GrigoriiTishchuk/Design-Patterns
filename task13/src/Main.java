public class Main {
    public static void main(String[] args) {
        // Create files
        File file1 = new File("file1.txt", 10);
        File file2 = new File("file2.pdf", 20);
        File file3 = new File("file3.docs", 30);
        File file4 = new File("photo1.jpg", 31);
        File file5 = new File("photo2.svg", 16);

        // Create directories
        Directory textFiles = new Directory("dir1");
        Directory photos = new Directory("dir2");

        // Add files to directories
        textFiles.addElement(file1);
        textFiles.addElement(file2);
        textFiles.addElement(file3);

        photos.addElement(file4);
        photos.addElement(file5);

        // Add directories to root directory
        Directory rootDir = new Directory("root");
        rootDir.addElement(textFiles);
        rootDir.addElement(photos);

        // Create a visitor to calculate total size
        SizeCalculatorVisitor sizeCalculator = new SizeCalculatorVisitor();

        // Accept the visitor for the root directory
        rootDir.accept(sizeCalculator);

        // Print the total size of all files in the file system
        System.out.println("Total size of all files: " + sizeCalculator.getTotalSize());

        // Create a visitor to search for files with a specific extension
        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        rootDir.accept(searchVisitor);
        System.out.println("Searching for files with .txt extension: " + searchVisitor.getFoundFiles().size());
        for (File file : searchVisitor.getFoundFiles()) {
            System.out.println("Found files: " + file.getName()+ " with size: " + file.getSize() + "MB");
        }
    }
}
