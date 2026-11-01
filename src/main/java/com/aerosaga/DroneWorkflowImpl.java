package com.aerosaga;

import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Workflow;
import io.temporal.workflow.Saga;
import java.time.Duration;

public class DroneWorkflowImpl implements DroneWorkflow {

    private final DroneActivities activities =
        Workflow.newActivityStub(
                DroneActivities.class,
                ActivityOptions.newBuilder()
                        .setStartToCloseTimeout(Duration.ofMinutes(1))
                        .setRetryOptions(
                                RetryOptions.newBuilder()
                                        .setMaximumAttempts(2)
                                        .build()
                        )
                        .build()
        );

   @Override
public void takeoff() {

    Workflow.getLogger(DroneWorkflowImpl.class)
            .info("AeroSaga mission started.");

    activities.takeoff();

    Workflow.getLogger(DroneWorkflowImpl.class)
            .info("Takeoff completed.");

    activities.navigateToDestination();

    Workflow.getLogger(DroneWorkflowImpl.class)
            .info("Navigation completed.");

    Saga saga = new Saga(
            new Saga.Options.Builder()
                    .setParallelCompensation(false)
                    .build()
    );

    // Register return-to-base as compensation
    saga.addCompensation(activities::returnToBase);

    try {
        activities.deliverPackage();

        Workflow.getLogger(DroneWorkflowImpl.class)
                .info("Package delivery completed.");

    } catch (RuntimeException e) {

        Workflow.getLogger(DroneWorkflowImpl.class)
                .info("Package delivery failed. Returning to base.");

        saga.compensate();

        throw e;
    }
}
}