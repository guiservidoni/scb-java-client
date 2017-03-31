/*
 * Copyright 2017 Daniel Nilsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.github.dannil.scbjavaclient.http;

import java.net.URL;
import java.util.Locale;
import java.util.Objects;

import com.github.dannil.scbjavaclient.constants.APIConstants;

/**
 * <p>Class which encapsulates the API URL, and enables relevant operations on this
 * URL.</p>
 *
 * @since 0.3.0
 */
public class URLEndpoint {

    private String url;

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param url
     *            the URL
     */
    public URLEndpoint(URL url) {
        this(url.toString());
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param url
     *            the URL
     */
    public URLEndpoint(String url) {
        this.url = url;

        char[] chars = this.url.toCharArray();
        if (chars[chars.length - 1] != '/') {
            this.url = this.url + '/';
        }
    }

    /**
     * <p>Appends the given string to the URL.</p>
     *
     * @param str
     *            the string to append
     * @return a {@link URLEndpoint} with the given string appended
     */
    public URLEndpoint append(String str) {
        return new URLEndpoint(this.url + str);
    }

    /**
     * <p>Returns the table portion of this URL.</p>
     *
     * <p>Example: URL of
     * <b>https://api.scb.se/OV0104/v1/doris/sv/ssd/BE/BE0401/BE0401A/</b> is converted to
     * <b>BE/BE0401/BE0401A/</b>.</p>
     *
     * <p>Due to speed efficiency, this method does not perform any validity check on the
     * specified URL. Calling this method without a valid URL for the API may (and
     * probably will) result in undefined behavior.</p>
     *
     * @return the table portion of this URL
     */
    public String getTable() {
        String startSegment = "ssd";

        return this.url.substring(this.url.indexOf(startSegment) + startSegment.length() + 1);
    }

    /**
     * <p>Generates a new URL to the API using the specified <code>Locale</code>.</p>
     *
     * <p>See {@link #toURL(String)} for implementation details.</p>
     *
     * @param locale
     *            the <code>Locale</code> to use
     * @return an {@link URLEndpoint} representing the URL
     */
    public URLEndpoint toURL(Locale locale) {
        return toURL(locale.getLanguage());
    }

    /**
     * <p>Generates a new URL to the API by replacing the current language tag in the URL
     * with the specified language tag.</p>
     *
     * <p>This method performs these steps to figure out what needs to be replaced:</p>
     *
     * <ol> <li>Specifies the <b>start segment</b> as the segment preceding the
     * <b>language tag segment</b> in the URL.</li>
     *
     * <li>Finds the length of the <b>language tag segment</b> by finding the next forward
     * slash following the <b>start segment</b>, as this indicates that the segment has
     * ended.</li>
     *
     * <li>Replaces the content between the start and end of the segment (forward slashes
     * excluded) with the new language tag.</li> </ol>
     *
     * <p>Example: URL of <b>https://api.scb.se/OV0104/v1/doris/sv/ssd/</b> and language
     * input of <b>en</b> is converted to
     * <b>https://api.scb.se/OV0104/v1/doris/en/ssd/</b>.</p>
     *
     * <p>Due to speed efficiency, this method does not perform any validity check on the
     * specified URL. Calling this method without a valid URL for the API may (and
     * probably will) result in undefined behavior.</p>
     *
     * @param language
     *            the language to use
     * @return an {@link URLEndpoint} representing the modified URL
     */
    public URLEndpoint toURL(String language) {
        // Specify the starting point. For this implementation, the starting
        // point is the segment preceding the language tag segment in the URL
        String startSegment = "doris";

        // Find the index where the language tag starts
        int start = this.url.indexOf(startSegment) + startSegment.length() + 1;
        // Find the index where the language tag ends
        int end = start + this.url.substring(start).indexOf('/');

        // Replace the contents between the start and end index with our new
        // language tag
        StringBuilder builder = new StringBuilder(this.url);
        builder.replace(start, end, language);

        return new URLEndpoint(builder.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.url);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof URLEndpoint)) {
            return false;
        }
        URLEndpoint other = (URLEndpoint) obj;
        return Objects.equals(this.url, other.url);
    }

    @Override
    public String toString() {
        return this.url;
    }

    /**
     * <p>Returns the root URL for the API.</p>
     *
     * @return an {@link URLEndpoint} representing the
     *         {@link com.github.dannil.scbjavaclient.constants.APIConstants#ROOT_URL
     *         ROOT_URL}
     */
    public static URLEndpoint getRootUrl() {
        return new URLEndpoint(APIConstants.ROOT_URL);
    }

    /**
     * <p>Returns the root URL for the API for a specific <code>Locale</code>.</p>
     *
     * @param locale
     *            the <code>Locale</code>
     * @return an {@link URLEndpoint} representing the
     *         {@link com.github.dannil.scbjavaclient.constants.APIConstants#ROOT_URL
     *         ROOT_URL} with a converted language tag segment matching the specified
     *         <code>Locale</code>
     */
    public static URLEndpoint getRootUrl(Locale locale) {
        return new URLEndpoint(APIConstants.ROOT_URL).toURL(locale);
    }

}
