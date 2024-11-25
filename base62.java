public class base62 {

    // Define the characters used for Base62 encoding
    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    // Encode a unique ID into a Base62 string
    public static String encode(int num) {
        StringBuilder encodedString = new StringBuilder();
        // Base62 uses 62 characters
        int base = BASE62.length();

        // Convert the number to Base62
        while (num > 0) {
            int remainder = num % base;
            encodedString.append(BASE62.charAt(remainder));
            num /= base;
        }

        // Return the encoded string in reverse order
        return encodedString.reverse().toString();
    }

    // Decode a Base62 string back into a number (for reverse lookup if needed)
    public static int decode(String shortUrl) {
        int decodedNumber = 0;
        int base = BASE62.length();

        for (int i = 0; i < shortUrl.length(); i++) {
            decodedNumber = decodedNumber * base + BASE62.indexOf(shortUrl.charAt(i));
        }

        return decodedNumber;
    }

    public static void main(String[] args) {
        // Example usage
        int uniqueId = 123456;  // This would typically be the ID from your database
        String shortUrl = encode(uniqueId);
        System.out.println("Shortened URL: " + shortUrl);

        int decodedId = decode(shortUrl);
        System.out.println("Decoded ID: " + decodedId);
    }
}

