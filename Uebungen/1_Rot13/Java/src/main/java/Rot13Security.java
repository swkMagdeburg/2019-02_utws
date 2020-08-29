public class Rot13Security {
    public String Encrypt(String input) {
        if ((input == null) || (input.equals(""))) {
            return "";
        }

        input = input
                .replaceAll("ä", "AE")
                .replaceAll("ö", "OE")
                .replaceAll("ü", "UE")
                .replaceAll("Ä", "AE")
                .replaceAll("Ö", "OE")
                .replaceAll("Ü", "UE")
                .toUpperCase();

        var encrypted = new StringBuilder();
        for (var character : input.toCharArray()) {
            encrypted.append(Shift(character));
        }

        return encrypted.toString();
    }

    private char Shift(char character) {
        var rangeFrom = (int) 'A';
        var rangeTo = (int) 'Z';

        var characterCode = (int) character;

        if (characterCode >= rangeFrom && characterCode <= rangeTo) {
            characterCode += 13;
            if (characterCode > rangeTo) {
                characterCode -= 26;
            }

            character = (char) characterCode;
        }

        return character;
    }
}
