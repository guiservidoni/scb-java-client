/*
 * Copyright 2018 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.dannil.scbjavaclient.http.HttpProtocol;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

@Suite
public class SCBClientBuilderIT {

    private SCBClientBuilder builder;
    
    @BeforeEach
    public void setup() {
        this.builder = new SCBClientBuilder();
    }
    
    @Test
    public void setLocale() {
        Locale locale = new Locale("fr", "FR");
        
        this.builder.setLocale(locale);
        
        SCBClient c = this.builder.build();
        assertEquals(new Locale("fr", "FR"), c.getLocale());
    }
    
    @Test
    public void setHttpProtocolAsHttp() {
        HttpProtocol protocol = HttpProtocol.HTTP;
        
        this.builder.setHttpProtocol(protocol);
        
        SCBClient c = this.builder.build();
        assertEquals(HttpProtocol.HTTP, c.getHttpProtocol());
    }
    
    @Test
    public void setHttpProtocolAsHttps() {
        HttpProtocol protocol = HttpProtocol.HTTPS;
        
        this.builder.setHttpProtocol(protocol);
        
        SCBClient c = this.builder.build();
        assertEquals(HttpProtocol.HTTPS, c.getHttpProtocol());
    }
    
}
