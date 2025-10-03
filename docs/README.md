# Twin User Guide

Twin is a simple chatbot that helps you manage tasks such as **todos**, **deadlines**, and **events**.

---

## Features

:information_source: **Notes about the command format**:

- Words in `UPPER_CASE` are parameters to be supplied by the user.  
  e.g. in `todo TASK_DESCRIPTION`, `TASK_DESCRIPTION` is a parameter which can be used as `todo read book`.

- Items in square brackets are optional.  
  e.g. `event DESCRIPTION /from START /to END` requires all three parts, but commands like `list` take no parameters.

- Parameters can be in any order if clearly labelled with `/from`, `/to`, `/by`.

- Extraneous parameters for commands that do not take any (such as `list`, `bye`) will be ignored.  
  e.g. if the command specifies `list 123`, it will be interpreted as `list`.

---


### Adding a Todo : `todo`

Adds a simple task without any date/time.

**Format:**
todo TASK_DESCRIPTION


**Examples:**
todo read book
todo buy groceries


---

### Adding a Deadline : `deadline`

Adds a task that must be done before a specific date/time.

**Format:**
deadline TASK_DESCRIPTION /by DEADLINE


**Examples:**
deadline submit report /by Monday
deadline return book /by 2025-10-10



---

### Adding an Event : `event`

Adds an event that starts and ends at specific times.

**Format:**
event TASK_DESCRIPTION /from START_TIME /to END_TIME


**Examples:**
event project meeting /from 2pm /to 4pm
event orientation camp /from 2025-08-01 /to 2025-08-03


---

### Listing all tasks : `list`

Shows a list of all tasks in the chatbot.

**Format:**
list


---

### Marking a task as done : `mark`

Marks an existing task as completed.

**Format:**
mark INDEX


- `INDEX` must be a positive integer (1, 2, 3, …​).
- The index refers to the number shown in the task list.

**Example:**
mark 1


---

### Unmarking a task : `unmark`

Marks an existing task as **not done yet**.

**Format:**
unmark INDEX

**Example:**
unmark 2

---

### Deleting a task : `delete`

Deletes a task from the list.

**Format:**
delete INDEX


**Examples:**
list
delete 2 (deletes the 2nd task shown in the list)


---

### Exiting the program : `bye`

Exits the chatbot.

**Format:**
bye


---

## Saving the data

Twin automatically saves the task list to your hard disk after any command that modifies the data (e.g. `add`, `delete`, `mark`).  
There is no need to save manually.

---

## Command Summary

| Action       | Format                                   | Examples |
|--------------|------------------------------------------|----------|
| List         | `list`                                   | — |
| Add Todo     | `todo TASK_DESCRIPTION`                  | `todo read book` |
| Add Deadline | `deadline TASK_DESCRIPTION /by DEADLINE` | `deadline submit report /by Monday` |
| Add Event    | `event TASK_DESCRIPTION /from START /to END` | `event meeting /from 2pm /to 4pm` |
| Mark         | `mark INDEX`                             | `mark 1` |
| Unmark       | `unmark INDEX`                           | `unmark 2` |
| Delete       | `delete INDEX`                           | `delete 2` |
| Exit         | `bye`                                    | — |

---