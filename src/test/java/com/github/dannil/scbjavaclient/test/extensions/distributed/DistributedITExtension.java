package com.github.dannil.scbjavaclient.test.extensions.distributed;

import java.util.Optional;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DistributedITExtension implements BeforeAllCallback {
    
    private static final String DISTRIBUTED_ITS = "scb.distributedITs";
    private static final String DISTRIBUTED_ITS_MACHINES = "scb.distributedITs.machines";
    private static final String DISTRIBUTED_ITS_MACHINE = "scb.distributedITs.machines";

    private static final Namespace NAMESPACE = Namespace.create("com", "github", "dannil", "scbjavaclient", "test",
            "extensions", "distributed");
    
    private static final Logger LOGGER = LoggerFactory.getLogger(DistributedITExtension.class);

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        LOGGER.debug("beforeAll");
        
        Store store = context.getStore(NAMESPACE);

        Optional<String> opMachinesParameter = Optional.ofNullable(System.getProperty(DISTRIBUTED_ITS_MACHINES));
        Optional<String> opMachineParameter = Optional.ofNullable(System.getProperty(DISTRIBUTED_ITS_MACHINE));

        if (opMachinesParameter.isPresent() && opMachineParameter.isPresent()) {
            int numberOfMachines = Integer.valueOf(opMachinesParameter.get());
            int thisMachineNumber = Integer.valueOf(opMachineParameter.get());

//            store.put(DISTRIBUTED_ITS, true);
//            store.put(DISTRIBUTED_ITS_MACHINES, numberOfMachines);
//            store.put(DISTRIBUTED_ITS_MACHINE, thisMachineNumber);
        }
    }

//    @Override
//    public void beforeEach(ExtensionContext context) throws Exception {
//        LOGGER.debug("BeforeEach");
//        
//        Store store = context.getStore(NAMESPACE);
//        Optional<Object> opDistributedITsParameter = Optional.ofNullable(store.get(DISTRIBUTED_ITS));
//        boolean runDistributedITs = (boolean) opDistributedITsParameter.orElse(false);
//
//    }

//    @Override
//    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
//        // TODO Auto-generated method stub
//        return null;
//    }

}
