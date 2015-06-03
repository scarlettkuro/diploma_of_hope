This is my diploma about cellular automata in cryptography.
Build is on Maven. JDK : 1.8 (using JavaFX in Byrd)

It is two projects now. 
-------------------------
ACme is main project. It is library for cryptography on cellular automata (CA).
ACme consists of automatas, their local rules, cypher strategies and cyphers, collecting of this crap. 

[Updating info] It supports :
Automata types: Regular (Plain), Block

--Regular (Plain): with N inputs to one output
--Block: with input and output to some group of elements

Strategies: Straight 
--Straight:data passes 10 times throw the automata

Strategies use some concrete CA to perform transformations.
I support such CA now:
--Trivial automata: doesn't change anything
-------------------------
Byrd is the project, that use ACme library for file-to-file encryption and decryption

UI is on .fxml with a controller
-------------------------
I am working on NIST and DIEHard tests support
