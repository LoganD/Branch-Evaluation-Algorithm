Branch Evaluation Algorithm
==========

Database System Implementation COMS 4112 Spring
Project 2
Java Implementation of the Branch Evaluation Algorithm

This Algorithm is described in this paper: http://www.cs.columbia.edu/~kar/pubsk/selections.pdf
The performance of memory is affected by branch misprediction penalities when executing query plans. The idea here is to optimize the query plan selection based on its potential performance. 

The following files are included:

config.txt #sample configurations
query.txt #sample probabilities
Main.java 
Term.java #class that stores helper functions
output.txt #example output using config and query
stage2.sh #the shell script that removes .class, compiles .java and accepts the input files

To run our program type:

"./stage2.sh <query_file> <config_file>"

query_file = the file containing the probabilities like query.txt
config_file = the configuration file containing the properties like config.txt

These must be supplied and are not filled in by default

The program prints to System.out



