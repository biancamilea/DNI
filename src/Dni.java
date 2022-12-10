public class Dni {
    // Fields
    private int number;
    private char letter;

    // Constructors
    public Dni() {
        // Initialize the number and letter to default values
        this.number = 0;
        this.letter = 'A';
    }

    public Dni(int number, char letter) {
        this.number = number;
        this.letter = letter;

        // Check if the letter is incorrect and set the number to negative if it is
        if (!isValidLetter(letter)) {
            this.number = -1;
        }
    }

    public Dni(int number) {
        this.number = number;
        this.letter = calculateLetter(number);
    }

    public Dni(String s) {
        // Parse the number and letter from the string
        this.number = Integer.parseInt(s.substring(0, s.length() - 1));
        this.letter = s.charAt(s.length() - 1);

        // Check if the letter is incorrect and set the number to negative if it is
        if (!isValidLetter(letter)) {
            this.number = -1;
        }
    }

    // Methods
    public int getNumber() {
        return this.number;
    }

    public char getLetter() {
        return this.letter;
    }

    public void setNumber(int number) {
        this.number = number;
        this.letter = calculateLetter(number);
    }

    public String toString() {
        return this.number + "" + this.letter;
    }

    public String toFormattedString() {
        // Use the String.format method to insert dots after every third digit
        return String.format("%d.%03d.%03d-%c", this.number / 10000000, (this.number / 10000) % 1000, (this.number / 10) % 1000, this.letter);
    }

    public boolean correctDni() {
        return this.number >= 0 && isValidLetter(this.letter);
    }

    // Static methods
    public static char letterForDni(int number) {
        return calculateLetter(number);
    }

    public static String NifForDni(int number) {
        char letter = calculateLetter(number);
        return number + "" + letter;
    }

    // Private helper methods
    private static char calculateLetter(int number) {
        String letters = "TRWAGMYFPDXBNJZSQVHLCKE";
        int mod = number % 23;
        char letter = letters.charAt(mod);
        return letter;
    }

    private static boolean isValidLetter(char letter) {
        // Check if the letter is one of the valid letters for a Dni
        String letters = "TRWAGMYFPDXBNJZSQVHLCKE";
        return letters.indexOf(letter) >= 0;
    }
}
