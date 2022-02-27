# Description

This is a breakable toy with three different ways to implemented CQRS

1. Basic CQRS. The architecture is divided in queries and command with different repositories but with a common database.

2. CQRS with synchronization to database. The architecture is separed in queries and command. Queries uses mongodb database and command uses postgresql database. For synchronizes them, i use messages with rabbitmq like event bus.

3. CQRS where all command requests are received as events.
I implemented a simple event bus. That event bus works as a layer between
command and controller. Which, in theory, allow more flexibility
and it also allows better traceability because you can save all command request.

# Start
docker-compose up

# Start dev environment
docker-compose -f docker-compose-dev.yml -p develoment_CQRS_environment up -d
