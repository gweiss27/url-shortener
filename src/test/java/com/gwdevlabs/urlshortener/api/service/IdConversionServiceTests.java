package com.gwdevlabs.urlshortener.api.service;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IdConversionServiceTests {

    private IdConversionService idConversionService;

    public IdConversionServiceTests() {
        this.idConversionService = new IdConversionService();
    }

    @Test
    public void success_getshorturlkey_given_id_1() {

        // given
        long id = 1;
        String expected = "b";

        // test
        assertEquals("Method did not return expected shortUrlKey for provided ID"
            , expected, this.idConversionService.encode(id));

    }

    @Test
    public void success_getshorturlkey_given_id_486() {

        // given
        long id = 486;
        String expected = "h0";

        // test
        assertEquals("Method did not return expected shortUrlKey for provided ID"
            , expected, this.idConversionService.encode(id));
    }

    @Test
    public void success_getshorturlkey_given_id_5934_as_long() {

        // given
        long id = 5934L;
        String expected = "bHS";

        // test
        assertEquals("Method did not return expected shortUrlKey for provided ID"
            , expected, this.idConversionService.encode(id));
    }

    @Test
    public void success_getshorturlkey_given_max_id() {

        // given
        long id = Long.MAX_VALUE;
        String expected = "k9viXaIfiWh";

        // test
        assertEquals("Method did not return expected shortUrlKey for provided ID"
            , expected, this.idConversionService.encode(id));
    }

    @Test
    public void success_getid_given_shorturlkey_b() {

        // given
        String shortUrlKey = "b";
        long expected = 1;

        // test
        assertEquals("Method did not return expected ID for provided shortUrlKey"
            , expected, this.idConversionService.decode(shortUrlKey));
    }

    @Test
    public void success_getid_given_shorturlkey_b6Pc9l() {

        // given
        String shortUrlKey = "b6Pc9l";
        long expected = 1782943249;

        // test
        assertEquals("Method did not return expected ID for provided shortUrlKey"
            , expected, this.idConversionService.decode(shortUrlKey));
    }
}
