public class Main {
    public static void main(String[] args) {
        Dni dni = new Dni("76515373P");
        System.out.println(dni.getLetter());
        System.out.println(dni.getNumber());
        System.out.println(dni.toString());
        System.out.println(dni.toFormattedString());
        System.out.println(dni.correctDni());
        System.out.println(Dni.letterForDni(76515373));
        System.out.println(Dni.NifForDni(76515373));
    }
}