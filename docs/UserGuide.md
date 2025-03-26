---
layout: page
title: User Guide
---

# **Welcome to the NeuroSync User Guide!**

NeuroSync helps psychiatrists **manage patient records and session notes efficiently**. Choose a topic below to get step-by-step instructions, troubleshoot issues, and maximize your productivity!

---

## 📜 Table of Contents
1. [Introduction](#introduction)
2. [Getting Started](#getting-started)
3. [Core Features](#core-features)
4. [Command Summary](#command-summary)
5. [Commands & Usage](#commands--usage)
   - [Adding a Patient](#adding-a-patient)
   - [Editing a Patient](#editing-a-patient)
   - [Deleting a Patient](#deleting-a-patient)
   - [Managing Notes](#managing-notes)
   - [Filtering Notes](#filtering-notes)
6. [FAQs & Troubleshooting](#faqs--troubleshooting)
7. [Technology Stack](#technology-stack)
8. [Contact & Support](#contact--support)

[🔝 Back to Top](#welcome-to-the-neurosync-user-guide)

---

## 📢 **Introduction**

### What does NeuroSync do?
NeuroSync **keeps track of patient details and session notes effortlessly**. No more searching through paper files—find what you need **instantly** using powerful search and filter commands.

**Why Use NeuroSync?**
✅ **Fast & Simple** - No unnecessary clicks, just type commands.
✅ **Powerful Search & Filters** - Retrieve patient data in seconds.
✅ **Organized & Secure** - Keep confidential data well-structured.

[🔝 Back to Top](#welcome-to-the-neurosync-user-guide)

---

## 🚀 **Getting Started**

### **1️⃣ Download & Install**
1. **Download** the latest release from [NeuroSync Releases](https://github.com/AY2223S1-CS2103T-W14-4/tp/releases).
2. Place the `NeuroSync.jar` file in your preferred directory.
3. Open **Terminal/Command Prompt**.
4. Navigate to the folder containing `NeuroSync.jar`.
5. Run the app using:
   ```bash
   java -jar NeuroSync.jar
   ```

### **2️⃣ System Requirements**
- **Java**: Version 17 or later
- **OS Compatibility**: Windows, macOS, Linux

[🔝 Back to Top](#welcome-to-the-neurosync-user-guide)

---

## 💡 **Core Features**

- 📁 **Manage Patient Records** - Add, edit, and delete patient details.
- 📝 **Session Notes** - Keep track of discussions, diagnoses, and treatments.
- 🔎 **Powerful Search & Filters** - Quickly retrieve any patient or note.
- ⚡ **Command-Based Interface** - Fast, efficient, and easy to use.

[🔝 Back to Top](#welcome-to-the-neurosync-user-guide)

---

## 🧭 **Command Summary**

| **Action**       | **Command Syntax** |
|-----------------|-----------------------------------------------------------------------------------------|
| **Add**         | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` |
| **Edit**        | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​` |
| **Delete**      | `delete INDEX` |
| **Add Note**    | `note INDEX nt/TITLE nc/CONTENT` |
| **Edit Note**   | `editnote INDEX nt/TITLE nc/CONTENT` |
| **Delete Note** | `deletenote INDEX nt/TITLE` |
| **View Notes**  | `viewnotes INDEX` |
| **Filter Note** | `filternote INDEX nt/TITLE_KEYWORD` |
| **Find Patient** | `find KEYWORD [MORE_KEYWORDS]` |
| **List Patients** | `list` |
| **Clear Data** | `clear` |
| **Help** | `help` |

[🔝 Back to Top](#welcome-to-the-neurosync-user-guide)

---

## 🎯 **Commands & Usage**

Each command is designed to make patient and session management **fast and intuitive**.

### **Adding a Patient**
```bash
add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​
```
Example:
```bash
add n/John Doe p/98005442 e/john.doe@email.com a/123 Clementi Street t/ADHD
```
✔️ **Expected Output:**
```
Patient added: John Doe (Phone: 98005442, Email: john.doe@email.com)
```
⚠️ **Warning:** Avoid duplicate names for clarity.
💡 **Tip:** Use **tags** (`t/`) to categorize patients (e.g., `t/Anxiety`).

---

### **Filtering Notes**
```bash
filternote INDEX nt/TITLE_KEYWORD
```
Example:
```bash
filternote 1 nt/anxiety
```
✔️ **Expected Output:**
```
Showing notes for Patient 1 with keyword: "anxiety"
```
💡 **Tip:** Use **specific keywords** for precise results.

---

### **Editing a Patient**
```bash
edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​
```
Example:
```bash
edit 1 p/91234567 e/johnd@example.com
```
✔️ **Expected Output:**
```
Updated patient: John Doe (Phone: 91234567, Email: johnd@example.com)
```
💡 **Tip:** You **don’t need** to enter all fields—only what you want to change!

[🔝 Back to Top](#welcome-to-the-neurosync-user-guide)

---

## ❓ **FAQs & Troubleshooting**

**Q: Where is my data stored?**  
**A:** Your data is saved in `addressbook.json` inside the `/data` folder.

**Q: Can I undo a deletion?**  
**A:** No. There is **no undo** feature, so backup your data frequently.

**Q: How do I transfer data to another device?**  
**A:** Copy the `addressbook.json` file from `/data` and paste it into the same directory on the new device.

**Q: What happens when I run `clear`?**  
**A:** It **deletes all data permanently**. Use it with caution.

[🔝 Back to Top](#welcome-to-the-neurosync-user-guide)

---

🚀 *Enjoy using NeuroSync!*
