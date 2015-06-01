This is my diploma about cellular automata in cryptography.
Build is on Maven.
JDK : 1.8 (using JavaFX)

Cypher consists of CypherMethod and Automata that it's using

CypherMethod is a strategy of data transformation
I support such strategies now:
--Straight : only pass data through CA

Strategies use some concrete CA to perform transformations.
I support such CA now:
--Trivial automata: doesn't change anything
--Plain (regular) automata : with N inputs to one output
--Block automata : with input and output to some group of elements

UI is on .fxml with a controller

Application make file-to-file transformation

I am working on NIST and DIEHard tests support