# NeuroSync User Guide

**NeuroSync: All-In-One App for Psychiatrists!**

NeuroSync is a powerful, user-friendly desktop application that helps psychiatrists to keep track of patients’ contacts, details and notes from their sessions. No more searching through thick files of paper, just search by name and get everything you need in seconds.

---

## 💡 Key Features

- Add, edit, and delete patient records (name, phone, email, address, and tags).
- Take and organize session notes per patient.
- Filter and search notes by title.
- View all notes for any patient at a glance.
- Simple, fast, and intuitive CLI-style command interface.

---

## 👩‍⚕️ Target Users

Psychiatrists and mental health professionals who need a digital assistant to manage large volumes of patient information and session documentation.

---

## 🚀 Quick Start

1. **Download the latest release** from the [Releases](https://github.com/AY2223S1-CS2103T-W14-4/tp/releases) page.
2. Place the JAR file in your preferred directory.
3. Open your terminal.
4. Navigate to the folder containing the file.
5. Run the app with:

```bash
java -jar NeuroSync.jar
```

---

## 📘 Sample Commands

### Add a Patient

```
add n/John Doe p/98005442 e/jamesho@imh.gov.sg a/123 Clementi Street t/ADHD
```

### Edit a Patient

```
edit 1 p/91234567 e/john.doe@protonmail.com
```

### Delete a Patient

```
delete 2
```

### Add a Note

```
note 1 nt/Mood Assessment nc/Discussed mood swings, sleep patterns.
```

### View Notes

```
viewnotes 1
```

### Edit a Note

```
editnote 1 nt/Childhood Trauma nc/Seems to have behavioural issues.
```

### Delete a Note

```
deletenote 1 nt/Updated Title
```

### Filter Notes by Title

```
filternote 1 nt/Assessment
```

## 🧭 Command Summary

| Action          | Format, Examples                                                                                                                                                  |
| --------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Add**         | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/98005442 e/jamesho@imh.gov.sg a/123 Clementi Rd t/ADHD t/Violent Tendencies` |
| **Delete**      | `delete INDEX` <br> e.g., `delete 3`                                                                                                                              |
| **Edit**        | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​` <br> e.g., `edit 2 n/James Lee e/jameslee@example.com`                                     |
| **Note**        | `note INDEX nt/TITLE nc/CONTENT` <br> e.g., `note 1 nt/Session1 nc/Discussed recent anxiety episodes`                                                             |
| **Delete Note** | `deletenote INDEX nt/TITLE` <br> e.g., `deletenote 1 nt/Session1`                                                                                                 |
| **Edit Note**   | `editnote INDEX nt/TITLE nc/CONTENT` <br> e.g., `editnote 1 nt/Session 1 nc/Patient has mild Schizophrenia`                                                       |
| **View Notes**  | `viewnotes INDEX` <br> e.g., `viewnotes 1`                                                                                                                        |
| **Filter Note** | `filternote INDEX nt/TITLE_KEYWORD` <br> e.g., `filternote 1 nt/anxiety`                                                                                          |
| **Find**        | `find KEYWORD [MORE_KEYWORDS]` <br> e.g., `find James Jake`                                                                                                       |
| **List**        | `list`                                                                                                                                                            |
| **Clear**       | `clear`                                                                                                                                                           |
| **Help**        | `help`                                                                                                                                                            |

---

## ❓ Frequently Asked Questions (FAQ)

**Q1: How do I transfer my data to another computer?**  
**A:** Install NeuroSync on the other computer and run it once. Then, replace the data file created (usually in the same directory or under `/data`) with your original data file from your previous device.

**Q2: Where is the data stored?**  
**A:** Your patient and note data is saved in a file called `addressbook.json` located in the `/data` folder in the same directory where you launch `NeuroSync.jar`.

**Q3: I deleted a note/patient by accident. Can I undo it?**  
**A:** Currently, NeuroSync does not support an undo feature. We recommend regularly backing up your data file if you need to keep a revision history.

**Q4: What happens when I run `clear`?**  
**A:** The `clear` command removes all stored patient and note data. This action is irreversible, so use it with caution.

---

## 🛠 Technology Stack

- Java 17
- JavaFX for UI
- Gradle for build automation

---

## 🙌 Acknowledgements

This project is based on the AddressBook-Level3 project by the SE-EDU initiative.

Visit [se-education.org](https://se-education.org) for more open-source CS education projects.

---

## 📬 Contact

For issues and contributions, please raise an issue or pull request in the [GitHub repository](https://github.com/AY2223S1-CS2103T-W14-4/tp).
