# AutoBattler

> A turn-based RPG auto-battler built in Java — developed as a personal project to practice object-oriented design, design patterns, and unit testing.

Two teams of fighters face off in automatic combat. Each round, all fighters are sorted by speed and act in order, using their unique ability when conditions are met. The last team standing wins.

The project is currently **in progress** — the core combat system and story mode are functional, with additional chapters and test coverage planned.

---

## Tech stack

- **Java 17**
- **Maven** — build and dependency management
- **JUnit 4** — unit testing
- **Mockito 2** — mocking in tests
- **JaCoCo** — code coverage reporting
- **OpenCSV** — CSV data handling

---

## Getting started

**Prerequisites:** Java 17+ and Maven 3.x installed.

```bash
# Clone the repository
git clone https://github.com/T-Guyon/AutoBattler.git
cd AutoBattler

# Compile and run
mvn compile
mvn exec:java -Dexec.mainClass="AutoBattler.Game"
```

**Run tests:**

```bash
mvn test
```

**Generate JaCoCo coverage report:**

```bash
mvn test site
# Report available at target/site/jacoco/index.html
```

---

## Project architecture

```
src/
├── main/java/AutoBattler/
│   ├── entities/       # Fighter hierarchy (abstract base + all character classes)
│   ├── teams/          # Team composition and management
│   ├── battle/         # Combat engine, turn ordering, comparators
│   ├── game/           # Game mode entry points (Story, PvP, Manual, Test)
│   ├── story/          # Scene manager, dialogues, player choices
│   └── ui/             # Menus
└── test/java/AutoBattler/
    └── GameTest.java
```

The packages follow a clear separation of concerns — the combat logic in `battle` is completely independent from the narrative in `story`, and game modes in `game` act only as thin orchestrators that delegate to both.

---

## Object-oriented design

The class hierarchy is built around an abstract `Fighter` class that defines the contract every character must fulfill, whether hero or enemy.

```
Fighter  (abstract)
├── Hero  (abstract)
│   ├── Warrior
│   ├── Berserker
│   ├── Paladin
│   ├── Archer
│   ├── Mage
│   └── Thief
└── Monster  (abstract)
    ├── Goblin
    ├── BossGoblin
    ├── Slime
    ├── BabySlime
    ├── Spider
    ├── MiniSpider
    ├── Bat
    └── Rat
```

Each concrete class overrides `takeDamage()` or `attack()` to implement its special ability, and provides its own `specialAbility()` and `lore()` descriptions. This means adding a new character is a matter of extending `Hero` or `Monster` and implementing the four abstract methods — no existing code needs to change.

---

## Design patterns

**Prototype** — `Fighter` declares `clone()` as abstract. Every subclass implements it by passing `this` to its copy constructor. This is used in the combat engine to copy both teams before each fight attempt, preserving the original state so the player can retry without penalty.

**Strategy** — Turn order is determined by pluggable `Comparator<Fighter>` implementations. `ComparatorSpeed` sorts fighters by descending speed (with ID as a tiebreaker), while `ComparatorHp` sorts by ascending HP — used by the Archer to pick its target. Swapping sorting logic requires no changes to the fight engine.

**Template Method** — `Fighter` defines the skeleton of what every character must expose: `clone()`, `getFullName()`, `specialAbility()`, and `lore()`. Subclasses fill in the specifics. The combat loop calls these methods polymorphically without caring about the concrete type.

---

## Game modes

**Story mode** — a narrative experience split into chapters. The player names their hero, then progresses through scenes driven by dialogues and choices. Fights are embedded into the story and fully retriable thanks to team cloning. Only the prologue and chapter 1 are currently implemented.

**PvP mode** — two players each compose a team from the available roster, then watch their fighters battle automatically.

**Manual mode** — a sandbox for exploring character stats and lore before launching a custom fight with any team composition.

**Test mode** — runs hardcoded team compositions to validate combat behavior quickly, without going through menus.

---

## Roster

### Heroes

| Class | HP | ATK | DEF | SPD | Special ability |
|---|---|---|---|---|---|
| Warrior | 220 | 30 | 25 | 20 | 60% chance to counterattack after taking damage |
| Berserker | 220 | 55 | 10 | 50 | Attacks twice per turn when HP ≤ 80 |
| Paladin | 200 | 45 | 25 | 10 | Heals 10 HP on each attack (max 200 HP) |
| Archer | 170 | 55 | 5 | 60 | Always targets the lowest-HP enemy |
| Mage | 160 | 70 | 0 | 30 | Deals magic damage that bypasses defense |
| Thief | 145 | 40 | 20 | 40 | 50% chance to dodge incoming attacks |

### Enemies

Enemies range from basic units (Rat, Bat, Baby Slime) used in early encounters to more complex monsters like the Goblin — whose attack scales up with the number of Goblin allies still alive — and Boss variants that cap each chapter.

---

## Roadmap

- [ ] Complete chapter 2 and beyond
- [ ] Expand unit test coverage (JUnit + Mockito)
- [ ] Add more enemy types and boss encounters
- [ ] Screenshots / demo GIF

---

## Author

[T-Guyon] — L2 Computer Science student  
[https://github.com/T-Guyon] · [https://www.linkedin.com/in/th-guyon/]
