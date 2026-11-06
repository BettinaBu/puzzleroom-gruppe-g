# Puzzleroom abgeben

Eine Person reicht für die gesamte Moodle-Gruppe einen GitHub-Release aus **eurem Puzzleroom-Fork** ein. Den Abgabetermin geben die Lehrenden im Kurs bekannt.

## Vor dem Release

- [ ] Einbahn, Eis und `fastmove` sind auf `main` zusammengeführt.
- [ ] Mindestens zwei neue Tests pro Aufgabe prüfen die Erwartungen. Bei Einbahn und `fastmove` ist jeweils ein positiver und ein negativer Fall dabei.
- [ ] Jede Person hat mindestens ein eigenes Issue und einen eigenen PR mit einem eigenen Arbeitscommit angelegt. Das jeweils andere Arbeitsteam hat die Änderungen geprüft.
- [ ] Füllt [ABGABE.md](../ABGABE.md) mit euren GitHub-Benutzernamen, Tests, Issue-, PR- und Review-Links sowie offenen Punkten aus. Nehmt die Datei vor dem Release in `main` auf.
- [ ] `mvn --batch-mode clean verify` mit Java 21 ist erfolgreich. Unter **Actions** gibt es einen grünen Lauf für genau den Commit auf `main`, den ihr abgebt.

## Release und Moodle

1. Öffnet **Releases** im Gruppen-Fork. Erstellt den Release für den geprüften Stand mit einem neuen Tag, z. B. `v1.0.0`. Nennt ihn z. B. **Release Gruppe B** und beschreibt die erledigten Aufgaben sowie offene Punkte.
2. Nach dem Veröffentlichen kopiert ihr den Release-Link und die **vollständige Commit-ID** des markierten Standes. Für eine spätere Korrektur verwendet ihr einen neuen Tag.
3. Eine Person reicht in Moodle die **Gruppe**, **alle Mitglieder mit ihren GitHub-Benutzernamen**, **Fork-Link**, **Release-Link und Tag**, **vollständige Commit-ID**, **Link zum grünen CI-Lauf** und etwaige **offene Punkte** ein. Maßgeblich ist der letzte Release vor der angekündigten Frist.

Für das Abgabegespräch sollte jede Person ihren Beitrag am eigenen Code erklären, einen Test mit seiner Erwartung zeigen und eine Frage zum Review beantworten können.
