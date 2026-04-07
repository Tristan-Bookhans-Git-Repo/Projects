# Snake — A-Star AI

Classic Snake game with a snake that uses the A-Star pathfinding algorithm to autonomously navigate, eat food, and compete against another snake.

## What it does

Two snakes compete on a shared grid: both driven by path finding algorithms. The algorithm calculates the shortest path to food while trying to avoid walls, itself, and the opponent snake. Multiple iterative versions were developed (V1–V8), with SnakeV8.jar being the final submission.

## Tech stack

- **Java**
- **Snake2020 library** (`Snake2020-v1-friendly.jar`) — game engine and rendering
- Pre-compiled JARs, no build step required

## How to run

```bash
java -jar SnakeV8.jar
```

The `Snake2020-v1-friendly.jar` library must be in the same directory (or on the classpath).

## Status

Academic exercise — complete. Final version is SnakeV8.jar.
