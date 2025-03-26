---
layout: page
title: User Guide
---

# **Welcome to the NeuroSync User Guide!**

NeuroSync helps psychiatrists **manage patient records and session notes efficiently**. Choose a topic below to get step-by-step instructions, troubleshoot issues, and maximize your productivity!

---

## 🔍 **Search the User Guide**
<input type="text" id="search-box" placeholder="Search this guide..." onkeyup="searchFunction()">
<ul id="search-results"></ul>

<script>
function searchFunction() {
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById("search-box");
    filter = input.value.toUpperCase();
    ul = document.getElementById("search-results");
    ul.innerHTML = "";

    document.querySelectorAll("h1, h2, h3, p, li, code").forEach(function(el) {
        txtValue = el.textContent || el.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            var li = document.createElement("li");
            li.innerHTML = '<a href="#' + el.id + '">' + txtValue.substring(0, 50) + '...</a>';
            ul.appendChild(li);
        }
    });
}
</script>

[🔝 Back to Top](#welcome-to-the-neurosync-user-guide)

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

## 📢 **Introduction** {#introduction}

### What does NeuroSync do?
NeuroSync **keeps track of patient details and session notes effortlessly**. No more searching through paper files—find what you need **instantly** using powerful search and filter commands.

**Why Use NeuroSync?**
✅ **Fast & Simple** - No unnecessary clicks, just type commands.
✅ **Powerful Search & Filters** - Retrieve patient data in seconds.
✅ **Organized & Secure** - Keep confidential data well-structured.

[🔝 Back to Top](#welcome-to-the-neurosync-user-guide)

---

## 🚀 **Getting Started** {#getting-started}

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

## 💡 **Core Features** {#core-features}

- 📁 **Manage Patient Records** - Add, edit, and delete patient details.
- 📝 **Session Notes** - Keep track of discussions, diagnoses, and treatments.
- 🔎 **Powerful Search & Filters** - Quickly retrieve any patient or note.
- ⚡ **Command-Based Interface** - Fast, efficient, and easy to use.

[🔝 Back to Top](#welcome-to-the-neurosync-user-guide)

---

## 🧭 **Command Summary** {#command-summary}

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

## 🎯 **Commands & Usage** {#commands--usage}

Each command is designed to make patient and session management **fast and intuitive**.

### **Adding a Patient** {#adding-a-patient}
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

[🔝 Back to Top](#welcome-to-the-neurosync-user-guide)

---

🚀 *Enjoy using NeuroSync!*
