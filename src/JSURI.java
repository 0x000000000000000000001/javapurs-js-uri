    private static String encode(String s, String keepChars) throws java.nio.charset.CharacterCodingException {
        java.nio.charset.CharsetEncoder encoder = java.nio.charset.StandardCharsets.UTF_8.newEncoder()
            .onMalformedInput(java.nio.charset.CodingErrorAction.REPORT)
            .onUnmappableCharacter(java.nio.charset.CodingErrorAction.REPORT);
        java.nio.ByteBuffer bytes = encoder.encode(java.nio.CharBuffer.wrap(s));
        StringBuilder sb = new StringBuilder();
        while (bytes.hasRemaining()) {
            int b = bytes.get() & 0xFF;
            char c = (char) b;
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || keepChars.indexOf(c) >= 0) {
                sb.append(c);
            } else {
                sb.append('%');
                String hex = Integer.toHexString(b).toUpperCase();
                if (hex.length() == 1) sb.append('0');
                sb.append(hex);
            }
        }
        return sb.toString();
    }

    private static String decode(String s, String dontDecode) throws Exception {
        java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            if (c == '%') {
                if (i + 2 >= s.length()) throw new Exception("Invalid URI");
                int b = Integer.parseInt(s.substring(i + 1, i + 3), 16);
                char decodedC = (char) b;
                if (dontDecode.indexOf(decodedC) >= 0) {
                    buffer.write('%');
                    buffer.write(s.charAt(i + 1));
                    buffer.write(s.charAt(i + 2));
                } else {
                    buffer.write(b);
                }
                i += 3;
            } else {
                byte[] b = String.valueOf(c).getBytes("UTF-8");
                buffer.write(b, 0, b.length);
                i++;
            }
        }
        java.nio.charset.CharsetDecoder decoder = java.nio.charset.StandardCharsets.UTF_8.newDecoder()
            .onMalformedInput(java.nio.charset.CodingErrorAction.REPORT)
            .onUnmappableCharacter(java.nio.charset.CodingErrorAction.REPORT);
        java.nio.ByteBuffer bb = java.nio.ByteBuffer.wrap(buffer.toByteArray());
        return decoder.decode(bb).toString();
    }

    public static final java.util.function.Function<Object, Object> _encodeURIComponent = (failObj) -> {
        java.util.function.Function<Object, Object> fail = (java.util.function.Function<Object, Object>) failObj;
        return (java.util.function.Function<Object, Object>) (succeedObj) -> {
            java.util.function.Function<Object, Object> succeed = (java.util.function.Function<Object, Object>) succeedObj;
            return (java.util.function.Function<Object, Object>) (inputObj) -> {
                String input = (String) inputObj;
                try {
                    return succeed.apply(encode(input, "-._~"));
                } catch (Exception e) {
                    return fail.apply(e);
                }
            };
        };
    };

    public static final java.util.function.Function<Object, Object> _encodeFormURLComponent = (failObj) -> {
        java.util.function.Function<Object, Object> fail = (java.util.function.Function<Object, Object>) failObj;
        return (java.util.function.Function<Object, Object>) (succeedObj) -> {
            java.util.function.Function<Object, Object> succeed = (java.util.function.Function<Object, Object>) succeedObj;
            return (java.util.function.Function<Object, Object>) (inputObj) -> {
                String input = (String) inputObj;
                try {
                    return succeed.apply(encode(input, "-._~").replace("%20", "+"));
                } catch (Exception e) {
                    return fail.apply(e);
                }
            };
        };
    };

    public static final java.util.function.Function<Object, Object> _encodeURI = (failObj) -> {
        java.util.function.Function<Object, Object> fail = (java.util.function.Function<Object, Object>) failObj;
        return (java.util.function.Function<Object, Object>) (succeedObj) -> {
            java.util.function.Function<Object, Object> succeed = (java.util.function.Function<Object, Object>) succeedObj;
            return (java.util.function.Function<Object, Object>) (inputObj) -> {
                String input = (String) inputObj;
                try {
                    return succeed.apply(encode(input, "-._~;/?:@&=+$,#!*'()[]"));
                } catch (Exception e) {
                    return fail.apply(e);
                }
            };
        };
    };

    public static final java.util.function.Function<Object, Object> _decodeURIComponent = (failObj) -> {
        java.util.function.Function<Object, Object> fail = (java.util.function.Function<Object, Object>) failObj;
        return (java.util.function.Function<Object, Object>) (succeedObj) -> {
            java.util.function.Function<Object, Object> succeed = (java.util.function.Function<Object, Object>) succeedObj;
            return (java.util.function.Function<Object, Object>) (inputObj) -> {
                String input = (String) inputObj;
                try {
                    return succeed.apply(decode(input, ""));
                } catch (Exception e) {
                    return fail.apply(e);
                }
            };
        };
    };

    public static final java.util.function.Function<Object, Object> _decodeFormURLComponent = (failObj) -> {
        java.util.function.Function<Object, Object> fail = (java.util.function.Function<Object, Object>) failObj;
        return (java.util.function.Function<Object, Object>) (succeedObj) -> {
            java.util.function.Function<Object, Object> succeed = (java.util.function.Function<Object, Object>) succeedObj;
            return (java.util.function.Function<Object, Object>) (inputObj) -> {
                String input = (String) inputObj;
                try {
                    return succeed.apply(decode(input.replace("+", " "), ""));
                } catch (Exception e) {
                    return fail.apply(e);
                }
            };
        };
    };

    public static final java.util.function.Function<Object, Object> _decodeURI = (failObj) -> {
        java.util.function.Function<Object, Object> fail = (java.util.function.Function<Object, Object>) failObj;
        return (java.util.function.Function<Object, Object>) (succeedObj) -> {
            java.util.function.Function<Object, Object> succeed = (java.util.function.Function<Object, Object>) succeedObj;
            return (java.util.function.Function<Object, Object>) (inputObj) -> {
                String input = (String) inputObj;
                try {
                    return succeed.apply(decode(input, ";/?:@&=+$,#"));
                } catch (Exception e) {
                    return fail.apply(e);
                }
            };
        };
    };
