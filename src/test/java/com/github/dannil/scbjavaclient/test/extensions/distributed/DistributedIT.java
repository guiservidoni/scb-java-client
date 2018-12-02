package com.github.dannil.scbjavaclient.test.extensions.distributed;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.extension.ExtendWith;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ExtendWith({ DistributedITExtensionHelper.class, DistributedITExtension.class })
public @interface DistributedIT {

}
