package com.github.dannil.scbjavaclient.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class URLEndpointTest {

    @Test
    public void createWithLocaleConstructor() throws MalformedURLException {
        URL url = new URL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");

        URLEndpoint apiUrl = new URLEndpoint(url);

        assertEquals("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM/", apiUrl.toString());
    }

    @Test
    public void appendTrailingSlash() {
        URLEndpoint url = new URLEndpoint("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");

        assertEquals("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM/", url.toString());
    }

    @Test
    public void toURLWithLocale() {
        URLEndpoint url = new URLEndpoint("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");

        url = url.toURL(new Locale("en", "US"));

        assertEquals("http://api.scb.se/OV0104/v1/doris/en/ssd/AM/", url.toString());
    }

    @Test
    public void toURLWithString() {
        URLEndpoint url = new URLEndpoint("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");
        url = url.toURL("fr");

        assertEquals("http://api.scb.se/OV0104/v1/doris/fr/ssd/AM/", url.toString());
    }

    @Test
    public void toURLWithStringThreeCharacters() {
        URLEndpoint url = new URLEndpoint("http://api.scb.se/OV0104/v1/doris/sv/ssd/");

        assertEquals("http://api.scb.se/OV0104/v1/doris/ger/ssd/", url.toURL("ger").toString());
    }

    @Test
    public void getTable() {
        URLEndpoint url = new URLEndpoint("http://api.scb.se/OV0104/v1/doris/sv/ssd/BE/BE0401/BE0401A/");

        assertEquals("BE/BE0401/BE0401A/", url.getTable());
    }

    @Test
    public void equals() {
        URLEndpoint url1 = new URLEndpoint("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");
        URLEndpoint url2 = new URLEndpoint("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");

        assertEquals(url1, url2);
    }

    @Test
    public void equalsItself() {
        URLEndpoint url1 = new URLEndpoint("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");

        assertEquals(url1, url1);
    }

    @Test
    public void notEquals() {
        URLEndpoint url1 = new URLEndpoint("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");
        URLEndpoint url2 = new URLEndpoint("http://api.scb.se/OV0104/v1/doris/sv/ssd/BE");

        assertNotEquals(url1, url2);
    }

    @Test
    public void notEqualsNull() {
        URLEndpoint url1 = new URLEndpoint("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");

        assertNotEquals(url1, null);
    }

    @Test
    public void notEqualsIncompatibleObject() throws MalformedURLException {
        URLEndpoint url1 = new URLEndpoint("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");
        URL url2 = new URL("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");

        assertNotEquals(url1, url2);
    }

    @Test
    public void testHashCode() {
        URLEndpoint url1 = new URLEndpoint("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");
        URLEndpoint url2 = new URLEndpoint("http://api.scb.se/OV0104/v1/doris/sv/ssd/AM");

        assertEquals(url1.hashCode(), url2.hashCode());
    }

}
