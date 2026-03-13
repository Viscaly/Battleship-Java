# Battleship Guessing Game – Navmaxia

A simple **Battleship-style game** implemented in Java. Players try to locate and destroy ships on a 7x7 grid. Ships are randomly placed, and the player has a limited number of attempts to hit them.

---

## Features

- Randomly places **single-cell ships** and **double-cell ships** on a 7x7 grid.  
- Visual board with hits (`Χ`), misses (`*`), and hidden water (`~`).  
- Provides **hints** when a ship is nearby in the same row or column.  
- Tracks hits, misses, and attempts.  
- Simple console-based gameplay.

---

## How to Play

1. Start the game by running the `Navmaxia` class.  
2. Enter a **row number** (1–7).  
3. Enter a **column number** (1–7).  
4. Hits and misses are displayed on the board:  
   - `~` = unknown water  
   - `Χ` = hit  
   - `*` = miss  
   - `S` / `D` = ships (only revealed after the game ends)  
5. Hints are provided if a ship is nearby in the same row or column.  
6. The game ends when all ships are destroyed or attempts run out.

---

## Example Board
```
1 2 3 4 5 6 7
1 ~ ~ * ~ ~ ~ ~
2 ~ Χ ~ ~ ~ ~ ~
3 ~ ~ ~ ~ ~ ~ ~
4 ~ ~ ~ ~ * ~ ~
5 ~ ~ ~ ~ ~ ~ ~
6 ~ ~ ~ Χ ~ ~ ~
7 ~ ~ ~ ~ ~ ~ ~
```

---

## Game Mechanics

- **Ships:** 2 single-cell ships, 2 double-cell ships.  
- **Attempts:** Player has 10 guesses.  
- **Scoring:** Hits and misses are counted and displayed at the end.  
- After the game ends, the board reveals all ship locations.
