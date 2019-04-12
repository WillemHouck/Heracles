# Apollo
Heracles is an existing framework that can be applied to develop and evaluate text mining algorithms. 

Apollo is based on the Heracles framework, in which the necessary adjustments and additional java files were made to create an algorithm specifically for aspect detection. This software is used to develop and evaluate several methods discussed in the research paper.

## Key features:

	•	Layered structure
	•	Wrappers for Stanford CoreNLP
	•	Link to Weka toolkit for machine learning algorithms
	•	Proper evaluation methods, including cross-validation, testing algorithms side-by-side, and t-test for statistical significance. 

## Installation:
Apollo is an Eclipse Java project, so the project can be be cloned and then imported in an existing project. To import the project Java 8 is required, thus it should be checked if the Eclipse version is recent enough. 

Since Eclipse detects the project as git-based all the functions that Git has in Eclipse can be used. Before the project can be modified Maven, which is used to link all the necessary external libraries, will download these libraries.

## Included Algorithms:
The code and resources for the Apollo framework can be found [here](https://github.com/WillemHouck/Heracles). The ontology for the [restaurant data](https://github.com/WillemHouck/Heracles/tree/master/src/main/resources/externalData) is the same as the one in Heracles. The ontology for the laptop data can be found [here](https://github.com/WillemHouck/Heracles/tree/master/src/main/resources/externalData). The raw data files can be obtained from the [SemEval-2015](http://alt.qcri.org/semeval2015/task12/index.php?id=data-and-tools) and [SemEval-2016](http://alt.qcri.org/semeval2016/task5/index.php?id=data-and-tools) sites.


