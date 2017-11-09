# hashTable
A java based hash table.

Purpose
=======
Build a hash table that supports searching, insertion, deletion, printing, and integer hash key
creation based on text or string input data. In the event of collisions, this separate chaining
hash table will use a singly linked list to store duplicate keys.

Text File Commands
==================
(a) Insert

The insert command uses the single character i as the command token. The com-
mand token will be followed by a single space, then the name which will be the
characters used to calculate the hash key as defined below. The program will
then insert the key and the data in the hash table. In the event that there is a
duplicate key, the new key (and data) would be added to the appropriate slot's
linked list.


(b) Delete

The delete command uses the single character d as the command token. The
command token will be followed by a single space, then the name which will
contain the characters used to calculate the hash key as defined below. The
program will then delete that key and corresponding data from the hash table.
In the event that the key cannot be found, the program will issue an error message
and recover gracefully to continue to accept commands.


(c) Search
The insert command uses the single character s as the command token. The
command token will be followed by a single space, then the name which will
contain the characters used to calculate the hash key as defined in the formula
below.
Upon successful location of the key, the corresponding key and data shall be
output.
In the event that the key cannot be located, the program will advise the user with
a message. See the Output section for an example.

(d) Print

The print command uses the single character p as the command token. This
command will invoke the print function which will output all the slots in the hash
table and subsequently, all the data in those slots. Given the size of the test data,
the data ouput for each slot should contain the slot number, the hash key, and
the data for that key. In the event that there is more than one data element in
the slot, each element should be output, in the linked list order, until there is
no more data in the slot. (See the Output section below for detailed formatting
information.)

(e) Quit

The quit command uses the single character q as the command token. In the
event the quit command is invoked, the program exits. There is no requirement
for data persistence.

Compile/Run
===========
1. Open your terminal and go to the directory of the file.

2. Type in: java hashTable [number of entries] [text file]
	Example: java hashTable 5 5inserts.txt
