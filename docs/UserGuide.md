---
layout: page
title: User Guide
---

# **Welcome to the NeuroSync User Guide!**

NeuroSync helps psychiatrists **manage patient records and session notes efficiently**. Choose a topic below to get step-by-step instructions, troubleshoot issues, and maximize your productivity!


---

## 📜 Table of Contents {#table-of-contents}

1. [Introduction](#introduction)
2. [Getting Started](#getting-started)
3. [Core Features](#core-features)
4. [Command Summary](#command-summary)
5. [Commands & Usage](#commands--usage)
   - [View All Patients](#listing-patients)
   - [Finding a Patient](#finding-a-patient)
   - [Adding a Patient](#adding-a-patient)
   - [Editing a Patient](#editing-a-patient)
   - [Deleting a Patient](#deleting-a-patient)
   - [Viewing Notes](#viewing-notes)
   - [Filtering Notes](#filtering-notes)
   - [Adding a Note](#adding-a-note)
   - [Edit a Note](#editing-a-note)
   - [Delete a Note](#deleting-a-note)
   - [Undo](#undo)
   - [#Redo](#redo)
   - [Clear All Data](#clear-data)
   - [Help](#help)
6. [FAQs & Troubleshooting](#faqs--troubleshooting)
7. [Technology Stack](#technology-stack)
8. [Acknowledgemets](#acknowledgements)
9. [Contact & Support](#contact-support)

---

## 📢 **Introduction** {#introduction}

### What does NeuroSync do?

NeuroSync **keeps track of patient details and session notes effortlessly**. No more searching through paper files—find what you need **instantly** using powerful search and filter commands.

**Why Use NeuroSync?**<br>
✅ **Fast & Simple** - No unnecessary clicks, just type commands.<br>
✅ **Powerful Search & Filters** - Retrieve patient data in seconds.<br>
✅ **Organized & Secure** - Keep confidential data well-structured.

[🔝 Back to Top](#table-of-contents)

---

## 🚀 **Getting Started** {#getting-started}

### **1️⃣ Download & Install**

1. **Download** the latest release from [NeuroSync Releases](https://github.com/AY2425S2-CS2103T-F13-1/tp/releases).
2. Move the downloaded jar file to your preferred folder where you'd like to store your NeuroSync app
3. Check your **Java version**:
- NeuroSync runs exclusively on Java version 17
- To check your Java version, you can follow this [tutorial](https://www.java.com/en/download/help/version_manual.html)

4. Open NeuroSync:
- For Windows:
  * Open the folder where NeuroSync is saved
  * Hold **shift**, right-click in the folder, select "Open Command Window Here"
  * Type the following command and press Enter.
  ```bash
  java -jar NeuroSync.jar
  ```
- For Mac:
  * Press `Command (⌘) + Space` to open spotlight search, search for **Terminal** and open it
  * Type `cd` (followed by a space), then drag and drop the folder where NeuroSync is saved into the Terminal window
  * Press **Enter**, then type:
  ```bash
  java -jar NeuroSync.jar
  ```
  * Press **Enter**

5. You can now use NeuroSync!



### **2️⃣ System Requirements**

- **Java**: Version 17
- **OS Compatibility**: Windows, macOS, Linux

[🔝 Back to Top](#table-of-contents)

---

## 💡 **Core Features** {#core-features}

- 📁 **Manage Patient Records** - Add, edit, and delete patient details.
- 📝 **Session Notes** - Keep track of discussions, diagnoses, and treatments.
- 🔎 **Powerful Search & Filters** - Quickly retrieve any patient or note.
- ⚡ **Command-Based Interface** - Fast, efficient, and easy to use.

[🔝 Back to Top](#table-of-contents)

---

## 🧭 **Command Summary** {#command-summary}

| **Action**                            | **Command Syntax**                                                         |
|---------------------------------------|----------------------------------------------------------------------------|
| [List Patients](#listing-patients)    | `list`                                                                     |
| [Find Patient](#finding-a-patient)    | `find KEYWORD [MORE_KEYWORDS]`<br>`find John`                              |
| [Add Patient](#adding-a-patient)      | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​`<br>`add n/John Doe p/98005442 e/john.doe@email.com a/123 Clementi Street t/ADHD` |
| [Edit Patient](#editing-a-patient)    | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br>`edit 1 p/91234567 e/john.doe@newemail.com` |
| [Delete Patient](#deleting-a-patient) | `delete INDEX`<br>`delete 1` |
| [View Notes](#viewing-notes)          | `viewnotes INDEX or viewnotes all`<br>`viewnotes 1 or viewnotes all` |
| [Filter Note](#filtering-notes)       | `filternote INDEX nt/TITLE_KEYWORD`<br>`filternote 1 nt/anxiety` |
| [Add Note](#adding-a-note)            | `note INDEX nt/TITLE nc/CONTENT`<br>`note 1 nt/Mood Assessment nc/Discussed mood swings and coping strategies.` |
| [Edit Note](#editing-a-note)          | `editnote INDEX nt/TITLE nc/CONTENT`<br>`editnote 1 nt/Mood Assessment nc/Updated content with more details.` |
| [Delete Note](#deleting-a-note)       | `deletenote INDEX nt/TITLE`<br>`deletenote 1 nt/Mood Assessment` |
| [Undo](#undo)                         | `undo`                                                                     |
| [Redo](#redo)                         | `redo`                                                                     |
| [Clear Data](#clear-data)             | `clear`                                                                    |
| [Help](#help)                         | `help`                                                                     |

[🔝 Back to Top](#table-of-contents)

---

## 🎯 **Commands & Usage** {#commands--usage}

Each command is designed to make patient and session management **fast and intuitive**.

### **Listing Patients** {#listing-patients}
You can view all patients using the `list` command!

**Example:**

```bash
list
```

✔️ **Expected Output:**

```
1. John Doe (Phone: 98005442, Email: john.doe@email.com)
2. Jane Smith (Phone: 91234567, Email: jane.smith@example.com)
```

⚠️ **Warning:** This will show all patients, so be mindful if you have a large list.<br>
💡 **Tip:** Use the **Find** command to quickly locate a patient.

[🔝 Back to Top](#table-of-contents)

---

### **Finding a Patient** {#finding-a-patient}

```bash
find KEYWORD [MORE_KEYWORDS]
```

**Example:**

```bash
find John
```

✔️ **Expected Output:**

```
1. John Doe (Phone: 98005442, Email: john.doe@email.com)
```

⚠️ **Warning:** Multiple matches may be returned if you use a common name.<br>
💡 **Tip:** Use specific names or IDs to narrow your search.

[🔝 Back to Top](#table-of-contents)

---

### **Adding a Patient** {#adding-a-patient}

```bash
add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​
```

**Example:**

```bash
add n/John Doe p/98005442 e/john.doe@email.com a/123 Clementi Street t/ADHD
```

✔️ **Expected Output:**

```
Patient added: John Doe (Phone: 98005442, Email: john.doe@email.com)
```

⚠️ **Warning:** Avoid duplicate names for clarity.<br>
💡 **Tip:** Use **tags** (`t/`) to categorize patients (e.g., `t/Anxiety`).

[🔝 Back to Top](#table-of-contents)

---

### **Editing a Patient** {#editing-a-patient}

```bash
edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​
```

**Example:**

```bash
edit 1 p/91234567 e/john.doe@newemail.com
```

✔️ **Expected Output:**

```
Updated patient: John Doe (Phone: 91234567, Email: john.doe@newemail.com)
```

⚠️ **Warning:** Only update fields that need changing to avoid accidental edits.<br>
💡 **Tip:** You can edit just one piece of data, like only the phone number or email.

[🔝 Back to Top](#table-of-contents)

---

### **Deleting a Patient** {#deleting-a-patient}
You may want to delete a patient after they have recovered


```bash
delete INDEX
```

**Example:**

```bash
delete 2
```

✔️ **Expected Output:**

```
Deleted patient at index 2.
```

💡 **Tip:** Be careful when using this command, especially with large patient lists.<br>
💡 **Tip:** You can **undo** a delete using the undo command!

[🔝 Back to Top](#table-of-contents)

---

### **Viewing Notes** {#viewing-notes}
To see all notes at a glance!

```bash
viewnotes INDEX
viewnotes all    # View notes for all patients
```

**Example:**

```bash
viewnotes 1
```

✔️ **Expected Output:**

```
1. Mood Assessment - Discussed mood swings.
2. Sleep Patterns - Irregular sleep schedule.
```

⚠️ **Warning:** If a patient has many notes, it may take a moment to load.<br>
💡 **Tip:** Use **Filter Notes** to narrow down results if you have many notes.

[🔝 Back to Top](#table-of-contents)

---

### **Filtering Notes** {#filtering-notes}
To see specific notes for one patient!

```bash
filternote INDEX nt/TITLE_KEYWORD
```

**Example:**

```bash
filternote 1 nt/anxiety
```

✔️ **Expected Output:**

```
Showing notes for Patient 1 with keyword: "anxiety"
```

⚠️ **Warning:** Be specific with keywords to avoid too many results.<br>
💡 **Tip:** Keywords should be part of the note's title for better results.

[🔝 Back to Top](#table-of-contents)

---

### **Adding a Note** {#adding-a-note}
You can add notes to a patient to keep track of discussions, diagnoses, etc.

```bash
note INDEX nt/TITLE nc/CONTENT
```

**Example:**

```bash
note 1 nt/Mood Assessment nc/Discussed mood swings and coping strategies.
```

✔️ **Expected Output:**

```
Note added for Patient 1: "Mood Assessment"
```

💡 **Tip:** Keep notes short and concise, highlighting the most important aspects.

[🔝 Back to Top](#table-of-contents)

---

### **Editing a Note** {#editing-a-note}
You can always make changes to your **note content** after creating it, using the `editnote` command!

```bash
editnote INDEX nt/TITLE nc/CONTENT
```

**Example:**

```bash
editnote 1 nt/Mood Assessment nc/Updated content with more details.
```

✔️ **Expected Output:**

```
Note updated for Patient 1: "Mood Assessment"
```

💡 **Tip:** You can edit only the necessary fields without altering other details.

[🔝 Back to Top](#table-of-contents)

---

### **Deleting a Note** {#deleting-a-note}
If you made an oopsie, don't stress! You can delete the note.

```bash
deletenote INDEX nt/TITLE
```

**Example:**

```bash
deletenote 1 nt/Mood Assessment
```

✔️ **Expected Output:**

```
Deleted note: "Mood Assessment" for Patient 1.
```

💡 **Tip:** Keep backups if needed.

[🔝 Back to Top](#table-of-contents)

---

### **Undo** {#undo}
If you made a mistake, don't stress! You can **undo your previous change** using this command.

**Example:**

```bash
undo
```

✔️ **Expected Output:**

```
The previous change has been undone.
```

[🔝 Back to Top](#table-of-contents)

---

### **Redo** {#redo}
If you need to get back a change you undid, don't stress! You can **redo your previous change** using this command.

**Example:**

```bash
redo
```

✔️ **Expected Output:**

```
The patient list has gone back to the future!
```

[🔝 Back to Top](#table-of-contents)

---

### **Clear All Data** {#clear-data}
⚠️ **Warning:** Use with caution! This will instantly remove all data.<br>

**Example:**

```bash
clear
```

✔️ **Expected Output:**

```
All patient and note data cleared.
```

💡 **Tip:** You can recover your lost data using the **undo** command.

[🔝 Back to Top](#table-of-contents)

---

### **Help** {#help}
Opens a pop-up to give you the link to this User Guide

**Example:**

```bash
help
```

✔️ **Expected Output:**

```
List of available commands and syntax.
```

💡 **Tip:** Use **help** if you forget a command or need to refer to syntax quickly.

[🔝 Back to Top](#table-of-contents)

---

## ❓ **FAQs & Troubleshooting** {#faqs--troubleshooting}

**Q: Where is my data stored?**
**A:** Your data is saved in `addressbook.json` inside the `/data` folder.

**Q: Can I undo a deletion?**
**A:** Yes! There is an **undo** feature, to recover data or undo edits.

**Q: How do I transfer data to another device?**
**A:** Copy the `addressbook.json` file from `/data` and paste it into the same directory on the new device.


[🔝 Back to Top](#table-of-contents)

---

## 🙌 Acknowledgements {#acknowledgements}

This project is based on the AddressBook-Level3 project by the SE-EDU initiative.

Visit [se-education.org](https://se-education.org) for more open-source CS education projects.

[🔝 Back to Top](#table-of-contents)

---

## 📬 Contact & Support {#contact-support}

For issues and contributions, please raise an issue or pull request in the [GitHub repository](https://github.com/AY2425S2-CS2103T-F13-1/tp).

[🔝 Back to Top](#table-of-contents)

🚀 _Enjoy using NeuroSync!_
