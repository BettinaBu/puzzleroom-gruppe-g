# Zusammenarbeit im Gruppen-Fork

Die Moodle-Gruppen **A, B und C** arbeiten jeweils in **zwei Zweierteams**. **Gruppe G** arbeitet mit fünf Personen in **einem Zweierteam und einem Dreierteam**. Beide Arbeitsteams entwickeln im selben Fork der Gruppe.

## Aufteilen und Rollen wechseln

* Startvorschlag: Team 1 beginnt mit Einbahn, Team 2 mit Eis. Das erste freie Team übernimmt anschließend `fastmove`. Stimmt euch kurz ab, wenn ihr beide die `FieldFactory` ändert.
* Im Paar schreibt der **Driver** den Code. Der **Navigator** verfolgt die Spielregeln und prüft die nächsten Schritte. Im Dreierteam übernimmt die dritte Person Beispiele und Randfälle.
* Wechselt die Rollen z. B. nach jedem Test. Wechselt in Gruppe G zwischen den Aufgaben auch die Besetzung von Paar und Dreierteam.
* **Jede Person erstellt im eigenen Konto mindestens ein Issue und einen Pull Request mit mindestens einem eigenen Commit** (außer Merge-Commits). Teilt dafür auch Tests oder Teilaufgaben als kleine Issues auf. Nennt beim Pair Programming alle Beteiligten im PR. Verlinkt eure Beiträge in der [Abgabevorlage](../ABGABE.md).

## Vom Issue zum Merge

1. Öffnet **Issues → New issue → Aufgabe** im Gruppen-Fork. Beschreibt das erwartete Verhalten. Ein Beispiel für ein Issue wäre **Einbahn nach links testen**: „Steht die Figur auf `>`, wird der Zug nach links abgelehnt und die Position bleibt gleich.“
2. Wechselt lokal auf `main`, holt mit `git pull --ff-only` den aktuellen Stand und erstellt einen Branch, z. B. `feature/einbahn-links-testen`.
3. Arbeitet im Paar. Führt die Tests lokal aus, committet die zur Aufgabe gehörenden Änderungen und pusht euren Branch in den Gruppen-Fork.
4. Öffnet einen Pull Request. Wählt als **base repository euren Gruppen-Fork** und als **base branch `main`**. Verknüpft das Issue in der PR-Beschreibung mit `Closes #4`, wenn euer Issue die Nummer 4 hat.
5. Eine Person aus dem **anderen Arbeitsteam** liest Änderungen und Tests und hinterlässt ein Review. Eine hilfreiche Rückfrage wäre „Prüft euer Test auch die Position nach dem abgelehnten Zug?“
6. Klärt Rückmeldungen. Sobald Review, Build und Tests erfolgreich sind, führt ihr den PR zusammen. Beide Teams aktualisieren danach ihr lokales `main`.
