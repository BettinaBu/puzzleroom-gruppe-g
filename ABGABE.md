# Puzzleroom · Abgabe der Gruppe

**Moodle-Gruppe:** G

GitHub-Benutzername| Name  | Arbeitsteam |
----------------------|----------------------|--------------------|
BettinaBu | Bettina Bulfone      | 2                              |
Murphy57100 | Abigail Kleedorfer   | 2                            |
dominik-stiegelbauer | Dominik Stiegelbauer | 2                   |
DaHof93 | David Hofer          | 1                                |
Szilhub | Szilard Petzinger    | 1                                |

## Beiträge pro Person

Ergänzt eine Zeile pro Person. Verlinkt jeweils ein selbst erstelltes Issue und einen selbst eröffneten Pull Request mit einem eigenen Arbeitscommit.

| GitHub-Benutzername | Eigener Beitrag | Eigenes Issue | Eigener PR |
| --- | --- | --- | --- |
|BettinaBu | Test Adaption | [Issue](https://github.com/BettinaBu/puzzleroom-gruppe-g/issues/2) | [PullRequest](https://github.com/BettinaBu/puzzleroom-gruppe-g/pull/7) |
|Murphy57100 | Test IceField | [Issue](https://github.com/BettinaBu/puzzleroom-gruppe-g/issues/9) | [PullRequest](https://github.com/BettinaBu/puzzleroom-gruppe-g/pull/10) |
|dominik-stiegelbauer | FastMove | [Issue](https://github.com/BettinaBu/puzzleroom-gruppe-g/issues/13) | [PullRequest](https://github.com/BettinaBu/puzzleroom-gruppe-g/pull/15) |
|DaHof93 | IceField | [Issue](https://github.com/BettinaBu/puzzleroom-gruppe-g/issues?q=is%3Aissue+state%3Aclosed+author%3ADaHof93) | [PullRequest](https://github.com/BettinaBu/puzzleroom-gruppe-g/pull/8) |
|Szilhub| Test FastMove | [Issue](https://github.com/BettinaBu/puzzleroom-gruppe-g/issues/14) | [PullRequest](https://github.com/BettinaBu/puzzleroom-gruppe-g/pull/16) |

## Aufgaben und Tests

| Aufgabe | Status | Neue Testfälle und erwartete Ergebnisse | Review-Link |
| --- | --- | --- | --- |
| A · OneWay & Test | gemerged | **`oneWayMoveInArrowDirection`**: `moveRight` liefern beide `true`. <br>**`enterFromAbove`**: `moveUp`, `moveRight`, `moveDown` liefern alle `true` <br>**`oneWayMoveAgainstArrowDirection`**: `moveRight` liefert `true`, `moveLeft` liefert `false` | Siehe [Zusammenarbeit](#zusammenarbeit) 
| B · Eis & Test | gemerged | **Eis mit freiem Feld dahinter**: `move right` lässt die Figur über beide Eisfelder rutschen. Sie stoppt auf dem freien Feld direkt links vom Ziel. <br>**Eis mit Wand dahinter**: `move right` lässt die Figur rutschen, bis die Wand sie stoppt. Sie bleibt auf dem zweiten Eisfeld direkt vor der Wand. <br> | Siehe [Zusammenarbeit](#zusammenarbeit)|
| C · fastmove & Test | gemerged | **`fastmovePositiveTest`**: `fastmove` mit vier gültigen Zügen (runter, rechts, rechts, hoch) <br>**`fastmoveNegativeTest`**: `fastmove` mit zweimal runter und einmal rechts. Der erste Zug gelingt, der zweite trifft die Wand und löst eine `PuzzleRoomInvalidMoveException` aus, der dritte Zug entfällt. <br>**`fastmoveInvalidArgumentTest`**: `fastmove` mit einer ungültigen Richtung -> `PuzzleRoomInvalidArgumentsException` ausgelöst. | Siehe [Zusammenarbeit](#zusammenarbeit) |

## fehlschlagender CI-Test
[hier](https://github.com/BettinaBu/puzzleroom-gruppe-g/pull/18)
bewusst nicht gemerged

## Zusammenarbeit

Unsere Arbeitsteams haben sich in dieser Aufgabe neu verteilt, da Abby in der Einheit leider krank war.
Im Vergleich zur Calculator-Implementierung hat sich die Abstimmung zwischen den Teams eindeutig verbessert.
Beispielsweise hat Arbeitsteam 1 das OneWay implementiert und Arbeitsteam 2 hat diesmal frühzeitig nach dem OneWay-Design gefragt, um die Tests unmittelbar an die tatsächliche Logik angepasst implementieren zu können.

Innerhalb der Gruppen haben wir versucht, regelmäßig das Coding & Pairprogramming sowie Logik- & Testimplementierung abzutauschen.
Im Flow ist uns das nicht immer gut gelungen und manchmal haben wir dann während dem Task getauscht, was natürlich nicht optimal ist.

Die größten Schwierigkeiten hatten wir bei der internen Aufgabenverteilung. Aufgrund eines Missverständnisses haben beide Gruppen unabhängig voneinander die Implementierung des Eisfelds übernommen. Aufgefallen ist die doppelte Umsetzung erst beim Erstellen des Pull Requests. Hier hat uns auf jeden Fall ein Projektmanager gefehlt, der alles koordiniert, den Überblick behält und die Aufgaben gleichmäßig verteilt.

| Aufgabe | Implementierung | Tests | Commits |
| --- | --- | --- | ---|
| A: OneWay | Arbeitsteam 1 | Arbeitsteam 2 | [Implementation](https://github.com/BettinaBu/puzzleroom-gruppe-g/pull/3/commits)<br>[Implementation2](https://github.com/BettinaBu/puzzleroom-gruppe-g/pull/5/commits)<br>[Testcases](https://github.com/BettinaBu/puzzleroom-gruppe-g/pull/4/commits)[TestAdaption](https://github.com/BettinaBu/puzzleroom-gruppe-g/pull/7/commits)|
| B: Eis | Arbeitsteam 1 | Arbeitsteam 2 |[Implementation](https://github.com/BettinaBu/puzzleroom-gruppe-g/pull/8/commits)<br>[Testcases](https://github.com/BettinaBu/puzzleroom-gruppe-g/pull/10/commits) |
| C: FastMove | Arbeitsteam 2 | Arbeitsteam 1 | [Implementation](https://github.com/BettinaBu/puzzleroom-gruppe-g/pull/15)<br>[Testcases](https://github.com/BettinaBu/puzzleroom-gruppe-g/pull/16)|

Aufteilung innerhalb der Teams:
| Aufgabe | Coder | Pairprogrammer | Review |
| --- | --- | --- | ---| 
| A: OneWay Implementation | David | Szilard | Bettina |
| A: OneWay Tests | Dominik | Bettina | David, Szilard |
| B: Eis Implementation | David | Szilard | Bettina, Dominik |
| B: Eis Tests | Abby | Bettina, Dominik | David, Szilard |
| C: FastMove Implementation | Dominik | Bettina, Abby | David Szilard |
| C: FastMove Tests | Szilard | David | Bettina, Dominik, Abby |


## Offene Punkte
Durch Krankheit und den Ausfall von Teammitgliedern sind wir nicht mehr sicher, ob die Tabelle „Aufteilung innerhalb der Teams“ (Coder, Pairprogrammer, Review) den tatsächlichen Ablauf noch korrekt wiedergibt. Insbesondere beim Eisfeld, das beide Teams parallel umgesetzt haben, lässt sich die Zuordnung im Nachhinein nicht mehr sicher rekonstruieren.

Nach dem Release gebt ihr den Stand gemäß der [Abgabeanleitung](docs/ABGABE.md) in Moodle ab.
