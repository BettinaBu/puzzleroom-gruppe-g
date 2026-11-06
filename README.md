# Puzzleroom – Softwareentwicklungsmodelle

In Puzzleroom steuert ihr eine Figur durch einen Rätselraum. Das Spiel kann Räume laden und die Figur schrittweise bewegen. Eure Gruppe ergänzt Einbahnfelder, Eis und den Befehl `fastmove`.

## Einen Gruppen-Fork anlegen

1. **Eine Person pro Moodle-Gruppe** öffnet [g4e817/puzzleroom-template](https://github.com/g4e817/puzzleroom-template) und klickt auf **Fork**. Wählt das eigene GitHub-Konto und den Branch `main`. Benennt den Fork passend zur Gruppe, z. B. `puzzleroom-gruppe-a`.
2. Ladet die übrigen Mitglieder unter **Settings → Collaborators** in diesen Fork ein. Alle nehmen die Einladung an und klonen **denselben Gruppen-Fork**.
3. Aktiviert bei Bedarf **Issues** unter **Settings → General → Features** und den Workflow unter **Actions**.
4. Meldet in Moodle den Fork-Link sowie die Zuordnung von Namen und GitHub-Benutzernamen. In den öffentlichen Abgabeunterlagen verwendet ihr eure GitHub-Benutzernamen.

## In IntelliJ starten

1. Öffnet den geklonten Projektordner in IntelliJ und ladet die `pom.xml` als Maven-Projekt. Wählt **JDK 21** für Projekt und Maven. Nutzt Maven 3.9 oder neuer.
2. Führt im Projektordner `mvn --batch-mode clean verify` aus, alternativ in IntelliJ **Maven → Lifecycle → verify**. Im Starter laufen **7 Tests**.
3. Startet die Klasse [Main](src/main/java/at/edu/c02/puzzleroom/Main.java). Gebt die folgenden Zeilen einzeln in die **Run-Konsole des Spiels** ein. Die Datei [test.maze](test.maze) liegt im Projektordner. Dieser Ordner ist das Arbeitsverzeichnis der Startkonfiguration.

```text
load test.maze
move down
move right
move right
move up
quit
```

Nach dem vierten Zug meldet das Spiel `You finished the maze in 4 steps.`

## Arbeiten und abgeben

| | |
| --- | --- |
| [Aufgaben](docs/AUFGABEN.md) | Spielregeln, Beispiele und Mindestumfang der Tests für A, B und C |
| [Zusammenarbeit](docs/ZUSAMMENARBEIT.md) | Arbeitsteams, Issues, eigene Pull Requests und gegenseitige Reviews |
| [Abgabe](docs/ABGABE.md) | Release im Gruppen-Fork erstellen und in Moodle einreichen |
| [Abgabevorlage](ABGABE.md) | Tests, Beiträge und Reviews eurer Gruppe dokumentieren |

Der Starter basiert auf [Mattis Turin-Zelenkos Puzzleroom](https://github.com/Valerionn/puzzleroom-template/tree/2c13fe6efab4b4fa7cab112289730d3f163b37b0).
