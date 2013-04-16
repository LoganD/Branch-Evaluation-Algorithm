#!/bin/bash
# script to compile and execute stage2 algorithm written in java
rm *.class
rm output.txt
javac Main.java
java Main $1 $2
