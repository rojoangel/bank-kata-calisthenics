Bank account kata
=================

The Rules
---------

1. One level of indentation per method
2. Don’t use the ELSE keyword
3. Wrap all primitives and Strings
4. First class collections
5. One dot per line
6. Don’t abbreviate
7. Keep all entities small (50 lines)
8. No classes with more than two instance variables
9. No getters/setters/properties

#### References:

-  [Object Calisthenics pdf](http://www.cs.helsinki.fi/u/luontola/tdd-2009/ext/ObjectCalisthenics.pdf)
-  [How object oriented are you feeling today? - Krzysztof Jelski](https://fr.slideshare.net/KrzysztofJelski/how-object-oriented-are-you-feeling-today)

#### Notes
Project generated with
```bash
mvn archetype:generate                        \
   "-DarchetypeGroupId=io.cucumber"           \
   "-DarchetypeArtifactId=cucumber-archetype" \
   "-DarchetypeVersion=7.5.0"                 \
   "-DgroupId=org.kata"                       \
   "-DartifactId=bank-kata-calisthenics"      \
   "-Dpackage=bank"                           \
   "-Dversion=1.0.0-SNAPSHOT"                 \
   "-DinteractiveMode=false"
```
