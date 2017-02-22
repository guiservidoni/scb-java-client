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

package com.github.dannil.scbjavaclient.utility;

import static org.junit.Assert.assertFalse;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;

import com.github.dannil.scbjavaclient.exception.SCBClientForbiddenException;
import com.github.dannil.scbjavaclient.exception.SCBClientNotFoundException;
import com.github.dannil.scbjavaclient.exception.SCBClientTooManyRequestsException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class HttpUtilityTest {

    private URI url;

    @Before
    public void setup() throws URISyntaxException {
        this.url = new URI("http://example.com");
    }

    @Test
    public void callPrivateConstructor()
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Constructor<?>[] cons = HttpUtility.class.getDeclaredConstructors();
        cons[0].setAccessible(true);
        cons[0].newInstance();
        cons[0].setAccessible(false);

        assertFalse(cons[0].isAccessible());
    }

    @Test(expected = SCBClientForbiddenException.class)
    public void httpForbidden() {
        HttpUtility.validateStatusCode(this.url, 403);
    }

    @Test(expected = SCBClientNotFoundException.class)
    public void httpNotFound() {
        HttpUtility.validateStatusCode(this.url, 404);
    }

    @Test(expected = SCBClientTooManyRequestsException.class)
    public void httpTooManyRequests() {
        HttpUtility.validateStatusCode(this.url, 429);
    }

}
