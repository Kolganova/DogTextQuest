package com.kolganova.http.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class JspHelperTest {

    @Test
    void getPathTest() {
        String jspName = "test";
        String fullJspName = "WEB-INF/jsp/" + jspName + ".jsp";
        Assertions.assertEquals(fullJspName, JspHelper.getPath(jspName));
    }
}