package pack;

class firstProgram {
    public static void main(String[] args) {
        hello("World!");
        hello("Katya");
    }

    public static void hello(String somebody) {
        System.out.println("Hello," + somebody + "!");
    }
}