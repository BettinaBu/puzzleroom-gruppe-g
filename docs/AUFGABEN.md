# Aufgaben im Puzzleroom

Alle Moodle-Gruppen bearbeiten **alle drei Aufgaben**. Schreibt für **jede Aufgabe mindestens zwei neue Tests**. Die Beispiele unten helfen euch, vor der Implementierung das erwartete Verhalten festzulegen. Verwendet JUnit 4 wie in den vorhandenen [Feld- und Befehlstests](../src/test/java/at/edu/c02/puzzleroom).

Eine `.maze`-Datei beschreibt das Spielfeld zeilenweise. `o` ist der Start, `x` ist das Ziel, `#` eine Wand und ein Leerzeichen ein freies Feld. Im laufenden Spiel zeigt `*` die Position der Figur.

## A · Einbahnfeld

Ergänzt `FieldOneWay` für die vier Pfeile `^`, `v`, `<` und `>`. Die Figur kann ein Pfeilfeld von jeder Seite betreten. Sie darf es nur in Pfeilrichtung verlassen.

**Zwei Tests:** Die Figur steht jeweils auf einem `>`-Feld. Links und rechts ist ein freies Feld.

| Versuch | Erwartung |
| --- | --- |
| Nach rechts gehen | Die Bewegung gelingt und die Figur steht rechts vom Pfeil. |
| Nach links gehen | Die Bewegung liefert `false` und die Figur bleibt auf dem Pfeil. |

Der zweite Test prüft die abgelehnte Bewegung direkt auf Spielerebene. Der bestehende Konsolenbefehl `move` übersetzt ein solches `false` in eine Exception.

## B · Eisfeld

Ergänzt `FieldIce` für das Zeichen `@`. Betritt die Figur Eis, rutscht sie in derselben Richtung weiter. Sie stoppt auf dem ersten begehbaren Feld nach dem Eis. Trifft sie vorher auf eine Wand, bleibt sie auf dem letzten Eisfeld stehen.

**Zwei Tests:** Startet je einen Raum mit der gezeigten Innenzeile und Wänden darüber und darunter. Führt einmal `move right` aus.

| Innenzeile | Erwartete Endposition |
| --- | --- |
| `#o@@ x#` | Auf dem freien Feld direkt links vom Ziel. |
| `#o@@#x#` | Auf dem zweiten Eisfeld direkt vor der Wand. |

Prüft die Endposition. Ein Test, der nur eine erfolgreiche Bewegung prüft, würde ein um ein Feld zu frühes Anhalten übersehen.

## C · Mehrere Züge mit fastmove

Ergänzt `CommandFastmove` und registriert den Befehl `fastmove`. Die Argumente `u`, `d`, `l` und `r` stehen für oben, unten, links und rechts. Führt sie in der angegebenen Reihenfolge aus.

* **Bei Erfolg** zeigt das Spiel den Raum nach dem letzten Zug genau einmal an.
* **Bei einer blockierten Bewegung** löst der Befehl eine `PuzzleRoomInvalidMoveException` aus. Bereits erfolgreiche Züge bleiben wirksam. Nachfolgende Züge entfallen.

**Zwei Tests:** Ladet für jeden Fall den [Startraum](../test.maze) neu.

| Befehl | Erwartung |
| --- | --- |
| `fastmove d r r u` | Die Figur erreicht das Ziel nach vier Schritten. Am Ende wird der Raum einmal angezeigt. |
| `fastmove d d r` | Der erste Zug gelingt. Der zweite trifft die Wand. Prüft die Exception und die Position direkt unter dem Startfeld. |

## Wo im Code anfangen?

| Bereich | Einstiegsstelle |
| --- | --- |
| Feldtyp einlesen | [FieldFactory](../src/main/java/at/edu/c02/puzzleroom/fields/FieldFactory.java) ordnet jedem Zeichen einen Feldtyp zu. |
| Bewegung verstehen | [PlayerImpl](../src/main/java/at/edu/c02/puzzleroom/PlayerImpl.java) prüft zuerst `leaveField` am Ausgangsfeld und dann `enterField` am Zielfeld. |
| Befehl ergänzen | [CommandFactory](../src/main/java/at/edu/c02/puzzleroom/commands/CommandFactory.java) wählt den Befehl. [CommandMove](../src/main/java/at/edu/c02/puzzleroom/commands/CommandMove.java) zeigt, wie ein einzelner Zug funktioniert. |

Weitere Beispielräume und Implementierungstipps findet ihr in [Mattis’ ursprünglichem Aufgabenblatt](https://github.com/Valerionn/puzzleroom-template/blob/2c13fe6efab4b4fa7cab112289730d3f163b37b0/README.md).
