# AeroSaga — Temporal.io Autonomous Drone Mission Control

AeroSaga is a Java-based project exploring reliable, workflow-driven autonomous drone mission control using **Temporal.io**.

## Project Overview

The project uses Temporal workflows and activities to coordinate simulated drone operations. The goal is to build a fault-tolerant mission-control system that can manage mission steps, recover from failures, and respond to emergency signals.

## Technology Stack

- Java
- Maven
- Temporal.io Java SDK
- Docker
- Git and GitHub

## Week 1 — Completed

- Set up the Maven Java project.
- Configured the Temporal SDK dependency.
- Created the drone workflow and activity interfaces.
- Implemented a simulated drone takeoff activity.
- Registered the workflow and activity with a Temporal worker.
- Started a drone mission using a workflow starter.
- Ran the workflow locally and verified its completion in the Temporal Web UI.

## Current Workflow

1. Start the Temporal worker.
2. Launch the drone mission workflow.
3. Execute the simulated takeoff activity.
4. Monitor workflow execution through Temporal Web UI.

**Note:** The current implementation simulates drone operations. It does not control physical drone hardware.

## Planned Development

- Mission orchestration and workflow state queries.
- Failure handling and compensating actions.
- Return-to-base behavior after simulated mission failures.
- Emergency interruption using Temporal signals.
- A mission-control dashboard with live status updates.

## Running the Project

### Prerequisites

- Java JDK
- Maven
- Docker Desktop
- Temporal development server

### Start the Worker

```bash
mvn exec:java "-Dexec.mainClass=com.aerosaga.DroneWorker"
```

### Start a Mission

Open a second terminal and run:

```bash
mvn exec:java "-Dexec.mainClass=com.aerosaga.DroneMissionStarter"
```

The worker and mission starter should run from the project root directory.

## Project Status

**Week 1 completed:** Local Temporal setup and simulated drone takeoff workflow.

Further features are planned for subsequent development phases.

## Week 3 – Saga Compensation Mechanism

Implemented Temporal Saga compensation logic to handle
package delivery failures.

### Features
- Added Return-to-Base activity.
- Configured activity retry attempts.
- Registered compensation actions.
- Simulated package delivery failure.
- Added recovery logic to return the drone to base.

This feature improves mission failure handling and recovery.