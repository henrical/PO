JFLAGS = -classpath .
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        Animal.java \
        Dog.java \
        Cat.java \
	Rat.java \
	Bird.java \
        Main.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
