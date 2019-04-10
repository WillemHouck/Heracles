package edu.eur.absa.algorithm.ontology;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.json.JSONException;

import edu.eur.absa.Framework;
import edu.eur.absa.algorithm.AbstractAlgorithm;
import edu.eur.absa.algorithm.Experiment;
import edu.eur.absa.algorithm.Prediction;
import edu.eur.absa.data.DatasetJSONReader;
import edu.eur.absa.data.DatasetJSONWriter;
import edu.eur.absa.data.SemEval2015Task12ABSAReader;
import edu.eur.absa.evaluation.evaluators.AnnotationLabelEvaluator;
import edu.eur.absa.evaluation.evaluators.Evaluator;
import edu.eur.absa.evaluation.evaluators.SpanLabelEvaluator;
import edu.eur.absa.external.ReasoningOntology;
import edu.eur.absa.model.Dataset;
import edu.eur.absa.model.Relation;
import edu.eur.absa.model.Span;
import edu.eur.absa.model.Word;
import edu.eur.absa.model.exceptions.IllegalSpanException;
import edu.eur.absa.nlp.OntologyLookup;
import weka.core.Attribute;

public class OntologySentimentAlgorithm extends AbstractAlgorithm {

	private ReasoningOntology ont;
	private AbstractAlgorithm backupAlg = null;
	private boolean failureAnalysis = false;
	private HashSet<String> allCategoryURIs; 
	private ArrayList<String> classLabels = new ArrayList<String>();

	
	public OntologySentimentAlgorithm(String label,	String unitOfAnalysisSpanType) {
		super(label, unitOfAnalysisSpanType);
		evaluators.add(new SpanLabelEvaluator("opinion", "category"));
		
		
	}

	@Override
	protected void cleanAlgorithm() {
		// TODO Auto-generated method stub

	}

	public void setDataSubSets(ArrayList<HashSet<Span>> dataSubSets, Dataset dataset){
		super.setDataSubSets(dataSubSets, dataset);
		if (hasProperty("use_bow_backup")){
			
			if (backupAlg==null){
				backupAlg = new AspectSentimentSVMAlgorithm("review",false)
						.setBinaryProperties( "use_sentence","use_hyperparameter_optimization","Xignore_validation_data")
						//.setProperty("ont", getProperty("ont"))
						;
				;
				Framework.log("Using BOW backup algorithm: "+backupAlg.getLabel());		
			}
			backupAlg.setDataSubSets(dataSubSets, dataset);
			
		}
		if (hasProperty("ont")){
			ont = ReasoningOntology.getOntology(Framework.EXTERNALDATA_PATH + getProperty("ont"));
		}
	}
	
	
	@Override
	public void preprocess() {
		if (hasProperty("use_bow_backup")){
			backupAlg.preprocess();
		}
		
	}

	@Override
	public void train() {
		if (hasProperty("use_bow_backup")){
			backupAlg.train();
		}
		
	}

	@Override
	public void predict(){
		Dataset dataset;

		if (hasProperty("use_bow_backup"))
			backupAlg.predict();
		
		for (Span review : getTestData()){
			predictForReview(review);
		}
		ont.save(getProperty("ont")+"-Expanded.owl", true);
		
		
	}
	
	
	public void testData(Span review) {
		TreeSet<Span> sentencesForReview = review.getDataset().getSpans(review, "sentence");
		for (Span sentence : sentencesForReview){
			
			//Span sentence = getSentence(opinion);
			
			Prediction p = new Prediction(sentence);
			p.putAnnotation("category", "FOOD#QUALITY");
			String cat = "No aspect";
			
			if (!predictions.containsKey(sentence))
			{
				predictions.put(sentence, new HashSet<Prediction>());
			}
			predictions.get(sentence).add(p);
			
		}
	}
	
	public void predictForReview(Span review){
		Framework.log(System.currentTimeMillis()+"\tStart next review");
		ArrayList<Integer> frequencyAspectReview = new ArrayList<Integer>();
		//Initializing the frequency count
		for (int i = 0; i < ReasoningOntology.getRestaurantAspects().size(); i++)    
		{
			frequencyAspectReview.add(0);
		}
		
		//Getting the aspect frequencies from the whole (training) dataset for restaurants
		ArrayList<Integer> frequencyAspectData = new ArrayList<Integer>();
		frequencyAspectData.add(423);
		frequencyAspectData.add(80);
		frequencyAspectData.add(0);
		frequencyAspectData.add(0);
		frequencyAspectData.add(97);
		frequencyAspectData.add(0);
		frequencyAspectData.add(89);
		frequencyAspectData.add(850);
		frequencyAspectData.add(136);
		frequencyAspectData.add(0);
		frequencyAspectData.add(0);
		frequencyAspectData.add(20);
		frequencyAspectData.add(47);
		frequencyAspectData.add(32);
		frequencyAspectData.add(0);
		frequencyAspectData.add(255);
		frequencyAspectData.add(0);
		frequencyAspectData.add(0);
		frequencyAspectData.add(0);
		frequencyAspectData.add(0);
		frequencyAspectData.add(449);
		frequencyAspectData.add(0);
		frequencyAspectData.add(0);
		frequencyAspectData.add(0);
		frequencyAspectData.add(0);
		frequencyAspectData.add(28);
		frequencyAspectData.add(0);
		frequencyAspectData.add(0);
		frequencyAspectData.add(0);
		frequencyAspectData.add(0);

		
		//Getting a list of sentences in a review
		TreeSet<Span> sentencesForReview = review.getDataset().getSpans(review, "sentence");
		Framework.log("Need to assign aspects to "+sentencesForReview.size()+" sentences in this review");
		for (Span sentence : sentencesForReview)    //Loop through every sentence
		{
			
			ArrayList<ArrayList<Integer>> foundAspects = Opinions(sentence, sentencesForReview, ont);    //Getting opinions (with aspects) per sentence in a review
			
			String prediction = "No aspect";
			boolean assignedPred = false;
			
			for (ArrayList<Integer> opinion : foundAspects)    //Loop through every opinion
			{
				prediction = "FOOD#QUALITY";
				
				if (classLabels.isEmpty()) 
				{
							classLabels.addAll(ReasoningOntology.getRestaurantAspects());    
							
							if (hasProperty("predict_null"))
							{
								classLabels.add("no_category");
							}
				}
				
				//Get the frequency SO FAR
				for (int i = 0; i < opinion.size(); i++)
				{
					if (opinion.get(i).equals(1))
					{
						int temp = frequencyAspectReview.get(i);
						temp++;
						frequencyAspectReview.set(i, temp);
					}
				}				
				
				//Calculate sum
				int sum = 0;
				for (int i = 0; i < opinion.size(); i++)
				{
					sum += opinion.get(i);
				}
				
				if (sum > 1)    //More than one possible aspect
				{
				
					ArrayList<Integer> multiplicationReview = new ArrayList<Integer>();
					ArrayList<Integer> multiplicationData = new ArrayList<Integer>();
					for (int i = 0; i < frequencyAspectData.size(); i++)
					{
						multiplicationReview.add(frequencyAspectReview.get(i) * opinion.get(i));
						multiplicationData.add(frequencyAspectData.get(i) * opinion.get(i));
					}
				
					int maxFreqReview = 0;
					if (!frequencyAspectReview.isEmpty())
					{
						maxFreqReview = Collections.max(multiplicationReview);
					}
					int maxFreqData = Collections.max(multiplicationData);
					if (maxFreqData != 0 && sameValue(multiplicationReview, maxFreqReview))
					{
						int index = frequencyAspectData.indexOf(maxFreqData);
						prediction = classLabels.get(index);    //Predict the most frequent
						assignedPred = true;
					}
					else if (!sameValue(multiplicationReview, maxFreqReview) && maxFreqReview > 1)
					{
						int index = frequencyAspectReview.indexOf(maxFreqReview);
						prediction = classLabels.get(index);    //Predict the most frequent
						assignedPred = true;
					}
				
				}
				else if (sum == 1)    //Only one possible aspect
				{
					int index = opinion.indexOf(1);
					prediction = classLabels.get(index);
					assignedPred = true;
				}	
			
			if (hasProperty("use_only_bow") || (hasProperty("use_bow_backup") && !assignedPred)){
				Prediction backupPred = backupAlg.getPrediction(sentence).iterator().next();
				prediction = backupPred.getAnnotation("category");
			}
				
			if (failureAnalysis && !sentence.getAnnotation("category").equals(prediction) &&
					!sentence.getAnnotation("category").equals("no_category")){
				Framework.log("===");
				Framework.log(sentence.toString());

				
				Framework.log("===");
				Framework.log("Found aspects: "+ foundAspects);
				
			}
			
			Prediction p = new Prediction(sentence);
			p.putAnnotation("category", prediction);
			if (!predictions.containsKey(sentence))
			{
				predictions.put(sentence, new HashSet<Prediction>());
			}
			predictions.get(sentence).add(p);
			
			
			String cat = "No aspect";
			String cat_temp = "No aspect";
			
			for (int i = 0; i <opinion.size(); i++)
			{
				if (opinion.get(i) == 1)
				{	
					cat_temp = classLabels.get(i) + " and ";
				}
			}
			
			cat = cat_temp.substring(0, cat_temp.length() - 5);					
			
			
			}
		}
	}
	
	
	public ArrayList<ArrayList<Integer>> Opinions(Span sentence, TreeSet<Span> sentencesForReview, ReasoningOntology ont)
	{
		Framework.log(System.currentTimeMillis()+"\tStart findURIs() for next sentence"); 
		if (ont == null)
		{
			Framework.error("Ontology is null!");
		}
		
		if (allCategoryURIs == null || allCategoryURIs.isEmpty())
		{
			//allCategoryURIs = ont.getLexicalizedConcepts(ont.URI_Mention, ont.getNS()+"#aspect", null);
		}
		
		TreeSet<Word> scope = sentence.getWords();
		Framework.log("Scope of the sentence is " + scope);
		
		int numWords = 0;
		ArrayList<Word> wordsSentence = new ArrayList<Word>();
		ArrayList<ArrayList<Integer>> wordAspects = new ArrayList<ArrayList<Integer>>(); 
		ArrayList<ArrayList<Integer>> opinions = new ArrayList<ArrayList<Integer>>();
		Word previousWord = null;
		Word currentWord = null;
		for (Word word : scope)
		{
			numWords++;
			wordsSentence.add(word);    //List with all the words in a sentence
			boolean found = false;
			if (word.hasAnnotation("URI"))
					{
						previousWord = currentWord;
						currentWord = word;
						String URI = word.getAnnotation("URI");
						Framework.log("    Word " + word + " has a URI: " + URI);
						HashSet<String> superclasses = new HashSet<String>();
						HashSet<String> aspectsFromOnt = new HashSet<String>();
						//Get all superclasses of this word
						superclasses.addAll(ont.getSuperclasses(URI));
						
						for (String superclass : superclasses)
						{	
							
							aspectsFromOnt = ont.getAspects(superclass);
							if (!aspectsFromOnt.isEmpty())
							{
								Framework.log("        The following aspect(s): " + aspectsFromOnt + " found from " + superclass);
							}
							
							ArrayList<String> restaurantAspects = ReasoningOntology.getRestaurantAspects();    
							ArrayList<Integer> found_aspects = new ArrayList<Integer>();
							for (int i = 0; i < restaurantAspects.size(); i++)
							{
								if (aspectsFromOnt.contains(restaurantAspects.get(i)))
								{
									found_aspects.add(1);
								}
								else
								{
									found_aspects.add(0);
								}
							}
							
							int sum = 0;
							for(int i = 0; i < restaurantAspects.size(); i++)    
							{
								sum += found_aspects.get(i);
							}
							
							if (sum >= 1)
							{
								if (!wordAspects.contains(found_aspects))
								{
									wordAspects.add(found_aspects);
									found = true;
								}
								else if (wordAspects.contains(found_aspects) && (wordsSentence.indexOf(currentWord) - wordsSentence.indexOf(previousWord) > 3))
								{
									wordAspects.add(found_aspects);
									found = true;
								}
								break;
							}
						}
							
							if (wordAspects.size() >= 2)
							{
								Framework.log("        newOpinion method gives " + newOpinion(currentWord, previousWord, wordAspects.get(wordAspects.size() - 1), wordAspects.get(wordAspects.size() - 2), wordsSentence));
							}
							if (wordAspects.size() >= 2 && newOpinion(currentWord, previousWord, wordAspects.get(wordAspects.size() - 1), wordAspects.get(wordAspects.size() - 2), wordsSentence) == null)    //New opinion
							{
								if (found)
								{
									opinions.add(wordAspects.get(wordAspects.size() - 1));
								}
							}
							else if (wordAspects.size() >= 2)    //NOT a new opinion
							{
								if (found)
								{
									//Replacing last opinion with the intersection
									opinions.set(opinions.size() - 1, newOpinion(currentWord, previousWord, wordAspects.get(wordAspects.size() - 1), wordAspects.get(wordAspects.size() - 2), wordsSentence));
								}
							}
							else
							{
								if (found)
								{
									opinions.addAll(wordAspects);
								}
							}
					}
		}
		return opinions;
}

	public ArrayList<Integer> newOpinion(Word currentWord, Word previousWord, ArrayList<Integer> foundAspectsCurrent, ArrayList<Integer> foundAspectsPrevious, ArrayList<Word> wordsSentence)
	{
	    ArrayList<Integer> finalFoundAspect = new ArrayList<Integer>();
		int index1 = wordsSentence.indexOf(currentWord);
		int index2 = wordsSentence.indexOf(previousWord);
		
		if (index2 - index1 <= 3)
		{
			if (identicalArrays(foundAspectsCurrent, foundAspectsPrevious))
			{
				finalFoundAspect = foundAspectsCurrent;
			}
			else if (!identicalArrays(foundAspectsCurrent, foundAspectsPrevious) && !differentArrays(foundAspectsCurrent, foundAspectsPrevious) )   //OR or AND???
			{
				finalFoundAspect = intersectionArrays(foundAspectsCurrent, foundAspectsPrevious);
			}
			else    //New opinion cause no intersection
			{
				finalFoundAspect = null;
			}
		}
		else //New opinion
		{
			finalFoundAspect = null;
		}
		
		return finalFoundAspect;
	}
	
	//True if lists are identical
	public boolean identicalArrays(ArrayList<Integer> array1, ArrayList<Integer> array2)
	{
		boolean identical = true;
		int length = array1.size();
		for (int i = 0; i < length; i++)
		{
			if (array1.get(i) != array2.get(i))
			{
				identical = false;
				break;
			}
			
		}
		return identical;	
	}
	
	//True if lists are completely different (in terms of 1s)
	public boolean differentArrays(ArrayList<Integer> array1, ArrayList<Integer> array2)
	{
		boolean different = true;
		int length = array1.size();
		for (int i = 0; i < length; i++)
		{
			if (array1.get(i).equals(array2.get(i)) && array1.get(i) != 0)    //Elements are equal but not 0
			{
				different = false;
				break;
			}
			
		}
		return different;	
	}
	
	public ArrayList<Integer> intersectionArrays(ArrayList<Integer> array1, ArrayList<Integer> array2)
	{
		ArrayList<Integer> intersection = new  ArrayList<Integer>();
		intersection = array1;
		int length = array1.size();
		for (int i = 0; i < length; i++)
		{
			if (array1.get(i) == array2.get(i) &&  array1.get(i) == 1)
			{
				intersection.set(i, 1);
			}
			else if (array1.get(i) == array2.get(i) &&  array1.get(i) == 0)
			{
				intersection.set(i, 0);
			}
			else if (array1.get(i) != array2.get(i))
			{
				intersection.set(i, 0);
			}
			
		}
		return intersection;
	}
	
	
	public boolean sameValue(ArrayList<Integer> multiplication, int maxFreq)
	{
		boolean sameValue = false;
		int index = multiplication.indexOf(maxFreq);
		for (int i = 0; i < multiplication.size(); i++)
		{
			if (index != i && multiplication.get(i) == maxFreq)
			{
				sameValue = true;
			}
		}
		
		return sameValue;
	}	
	
}