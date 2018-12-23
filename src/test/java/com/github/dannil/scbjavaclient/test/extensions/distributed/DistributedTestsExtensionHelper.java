package com.github.dannil.scbjavaclient.test.extensions.distributed;

import java.util.Optional;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DistributedTestsExtensionHelper implements BeforeAllCallback {

    private static final Namespace NAMESPACE = Namespace.create("com", "github", "dannil", "scbjavaclient", "test",
            "extensions", "distributed");
    
    //private static final String DISTRIBUTED_ITS = "scb.distributedITs";
    private static final String DISTRIBUTED_ITS_MACHINES = "scb.distributedITs.machines";
    private static final String DISTRIBUTED_ITS_MACHINE = "scb.distributedITs.machine";
    
    private static final Logger LOGGER = LoggerFactory.getLogger(DistributedTestsExtensionHelper.class);
    
    private static int testNumber = 1;

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        LOGGER.debug("beforeAll");

        Store store = context.getStore(NAMESPACE);

        Optional<String> opMachinesParameter = Optional.ofNullable(System.getProperty(DISTRIBUTED_ITS_MACHINES));
        Optional<String> opMachineParameter = Optional.ofNullable(System.getProperty(DISTRIBUTED_ITS_MACHINE));
        //System.out.println("OPM: " + opMachinesParameter.get());
        
        if (opMachinesParameter.isPresent() && opMachineParameter.isPresent()) {
            LOGGER.debug("hello");
            Class<?> testClazz = context.getRequiredTestClass();
            store.put(testClazz.getName(), testNumber);
            testNumber++;
        }
    }

}
