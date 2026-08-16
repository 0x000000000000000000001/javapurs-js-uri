import java.nio.charset.*;
import java.nio.*;

public class TestEncoder {
    public static void main(String[] args) throws Exception {
        String s = "\udc00";
        CharsetEncoder encoder = StandardCharsets.UTF_8.newEncoder()
            .onMalformedInput(CodingErrorAction.REPORT)
            .onUnmappableCharacter(CodingErrorAction.REPORT);
        try {
            ByteBuffer buffer = encoder.encode(CharBuffer.wrap(s));
            System.out.println("Encoded!");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getClass().getName());
        }
    }
}
