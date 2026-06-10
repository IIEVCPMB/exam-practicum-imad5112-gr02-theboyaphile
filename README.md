[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/3HAo3iZi)
<img width="1719" height="1009" alt="image" src="https://github.com/user-attachments/assets/a9d37eb0-37bc-4e69-8ea1-8df8133d7574" />
<img width="1734" height="1030" alt="image" src="https://github.com/user-attachments/assets/687d15a9-acae-465a-9cc1-59d4c23d1ec9" />
# Campsite Commander ⛺

A lightweight Android application designed to help campers organize, manage, and calculate their packing gear list efficiently. 

The app features a single-activity layout architecture that dynamically manages multiple user sub-views directly via view visibility transitions.

---

## 🚀 Features

* **Splash Screen:** A timed welcome portal (3-second load) that transitions seamlessly into the main system.
* **Main Dashboard:** Displays a calculated live counter of total individual items packed.
* **Detailed Gear Registry:** Reads synchronized lists to render complete profiles of items, categories, and custom notes.
* **Dynamic Gear Input:** Form validation processing for adding new camping items with instant list synchronization.

---

## 🛠️ Architecture & Core Mechanics

### 1. Single-Activity Architecture
Instead of handling heavy Fragment overhead or spawning multiple Android Intents, the entire layout is nested within a single resource container (`activity_main.xml`). Interface transitions are managed by toggling visibility flags using a helper sequence:
```kotlin
private fun showScreen(screenName: String) { ... }
