package cn.plus.framework.lock;

import java.text.MessageFormat;

public final class Util {

    private Util() {
    }
    public static String rtp(String query, String tablePrefix, String schedNameLiteral) {
        return MessageFormat.format(query, new Object[]{tablePrefix, schedNameLiteral});
    }
}
