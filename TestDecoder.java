public class TestDecoder {
    public static void main(String[] args) throws Exception {
        System.out.println(java.net.URLDecoder.decode("a+b%20c".replace("+", "%2B"), "UTF-8"));
        try {
            java.net.URLDecoder.decode("%FF", "UTF-8");
            System.out.println("Success %FF");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
