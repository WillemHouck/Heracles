package edu.eur.absa.evaluation.evaluators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import edu.eur.absa.algorithm.Prediction;
import edu.eur.absa.Framework;
import edu.eur.absa.evaluation.results.ClassificationResults;
import edu.eur.absa.evaluation.results.EvaluationResults;
import edu.eur.absa.evaluation.results.GroupedClassificationResults;
import edu.eur.absa.model.Span;
import edu.eur.absa.model.DataEntity;

public class AnnotationLabelEvaluator implements Evaluator {

	private String spanType;
	private String annotationType;
	private boolean failureAnalysis = false;
	private boolean groupBy = false;
	
	
	public AnnotationLabelEvaluator(String spanType, String annotationType){
		this.spanType = spanType;
		this.annotationType = annotationType;
	}
	
	public AnnotationLabelEvaluator(String spanType, String annotationType, boolean failureAnalysis){
		this.spanType = spanType;
		this.annotationType = annotationType;
		this.failureAnalysis = failureAnalysis;
	}
	
	public AnnotationLabelEvaluator(String spanType, String annotationType, boolean failureAnalysis, boolean groupBy){
		this.spanType = spanType;
		this.annotationType = annotationType;
		this.failureAnalysis = failureAnalysis;
		this.groupBy = groupBy;
	}
	
	
	
	
	@Override
	public EvaluationResults evaluate(HashSet<? extends DataEntity> testSet,
			HashMap<? extends DataEntity, HashSet<Prediction>> predictions, HashMap<? extends DataEntity, HashSet<String>> features) {
		HashMap<String, Integer> truePos = new HashMap<>();
		HashMap<String, Integer> falsePos = new HashMap<>();
		HashMap<String, Integer> falseNeg = new HashMap<>();
		
//		int truePos=0;
//		int falsePos=0;
//		int falseNeg=0;
		
		for (DataEntity parentAnn : testSet){
			Span parentSpan = (Span)parentAnn;
			HashSet<Span> analysisSpans = new HashSet<>();
			if (parentSpan.getType().equals(spanType)){
				analysisSpans.add(parentSpan);
			} else {
				analysisSpans.addAll(parentSpan.getCoveredSpans(parentSpan.getDataset().getSpans(spanType)));
			}
			
			for (Span span : analysisSpans)
			{
				
				TreeSet<Span> opinionsPerSentence = getOpinionsFromSentence(span);
				ArrayList<String> aspectsPerSentence = new ArrayList<String>();
				while (opinionsPerSentence.iterator().hasNext())
				{
					Span opinion = opinionsPerSentence.iterator().next();
					String opinionAspect = opinion.getAnnotation(annotationType);
					aspectsPerSentence.add(opinionAspect);
				}
				
				boolean annotated = false;
				boolean predicted = false;
				String group = "";
				
					
				if (predictions.containsKey(span)){
					
					HashSet<Prediction> preds = predictions.get(span);
					//only a single prediction is performed for this type of problem
					ArrayList<String> predsAspects = new ArrayList<String>();
					while (preds.iterator().hasNext())
					{
						Prediction temp = preds.iterator().next();
						String aspect = temp.getAnnotation(annotationType);
						predsAspects.add(aspect);
					}
					
					
					if (predsAspects.size() >= aspectsPerSentence.size())
					{
						ArrayList<String> predsCopy = predsAspects;
						ArrayList<String> aspectsPerSentenceCopy = aspectsPerSentence;
						while (predsAspects.iterator().hasNext())
						{
							Object annotObj = "";
							Object predObj = "";
							String singlePredAspect = predsAspects.iterator().next();
							if (aspectsPerSentenceCopy.contains(singlePredAspect))
							{
								annotated = true;
								predicted = true;
								aspectsPerSentenceCopy.remove(singlePredAspect);
								annotObj = singlePredAspect;
								predObj = singlePredAspect;
							}
							else
							{
								predicted = true;
								annotated = false;
							}
							
							boolean triggerFailureAnalysis = true;
							if (predicted && annotated)
							{
								//check the values
								if (predObj.equals(annotObj)){
									truePos.put(group, truePos.getOrDefault(group,0)+1);
									if (groupBy)
										truePos.put("All", truePos.getOrDefault("All",0)+1);
									triggerFailureAnalysis = false;
								} else {
									falsePos.put(group, falsePos.getOrDefault(group,0)+1);
									falseNeg.put(group, falseNeg.getOrDefault(group,0)+1);
									if (groupBy){
										falsePos.put("All", falsePos.getOrDefault("All",0)+1);
										falseNeg.put("All", falseNeg.getOrDefault("All",0)+1);
									}
								}
							} else if (predicted && !annotated){
								falsePos.put(group, falsePos.getOrDefault(group,0)+1);
								if (groupBy){
									falsePos.put("All", falsePos.getOrDefault("All",0)+1);
								}
							}
						}
						
						for (int i = 0; i < aspectsPerSentenceCopy.size(); i++)
						{
							annotated = true;
							predicted = false;

							boolean triggerFailureAnalysis = true;				
							if (!predicted && annotated)
							{
								falseNeg.put(group, falseNeg.getOrDefault(group,0)+1);
								if (groupBy){
									falseNeg.put("All", falseNeg.getOrDefault("All",0)+1);
								}
			//					Main.debug("False neg:\n"+parentSpan.getAnnotations()+"\n"+singlePrediction.getAnnotations());
								
							}
						}						
					}
					
					
					else if (opinionsPerSentence.size() > preds.size())
					{
						ArrayList<String> predsCopy = predsAspects;
						ArrayList<String> aspectsPerSentenceCopy = aspectsPerSentence;
						while (aspectsPerSentence.iterator().hasNext())
						{
							Object annotObj = "";
							Object predObj = "";
							String singleAspectsPerSentence = aspectsPerSentence.iterator().next();
							if (predsCopy.contains(singleAspectsPerSentence))
							{
								annotated = true;
								predicted = true;
								predsCopy.remove(singleAspectsPerSentence);
								annotObj = singleAspectsPerSentence;
								predObj = singleAspectsPerSentence;
							}
							else
							{
								annotated = true;
								predicted = false;
							}
							
							boolean triggerFailureAnalysis = true;
							if (predicted && annotated){
								//check the values
								if (predObj.equals(annotObj)){
									truePos.put(group, truePos.getOrDefault(group,0)+1);
									if (groupBy)
										truePos.put("All", truePos.getOrDefault("All",0)+1);
									triggerFailureAnalysis = false;
								} else {
									falsePos.put(group, falsePos.getOrDefault(group,0)+1);
									falseNeg.put(group, falseNeg.getOrDefault(group,0)+1);
									if (groupBy){
										falsePos.put("All", falsePos.getOrDefault("All",0)+1);
										falseNeg.put("All", falseNeg.getOrDefault("All",0)+1);
									}
								}
							}
							else if (!predicted && annotated){
								falseNeg.put(group, falseNeg.getOrDefault(group,0)+1);
								if (groupBy){
									falseNeg.put("All", falseNeg.getOrDefault("All",0)+1);
								}
			//					Main.debug("False neg:\n"+parentSpan.getAnnotations()+"\n"+singlePrediction.getAnnotations());
								
							}			
						}
						
						for (int i = 0; i < predsCopy.size(); i++)
						{
							annotated = false;
							predicted = true;
							
							boolean triggerFailureAnalysis = true;						
							if (predicted && !annotated)
							{
								falsePos.put(group, falsePos.getOrDefault(group,0)+1);
								if (groupBy){
									falsePos.put("All", falsePos.getOrDefault("All",0)+1);
								}
							}						
						}
					}
				
			}
		}
	}
		if (!groupBy){
			return new ClassificationResults(getLabel(), truePos.getOrDefault("",0), falsePos.getOrDefault("",0), falseNeg.getOrDefault("",0));
		} else {
			return new GroupedClassificationResults(getLabel(), truePos, falsePos, falseNeg);
		}
		
	}
	
	public Span getSentence(Span opinionSpan)
	{

		TreeSet<Span> sentences = new TreeSet<Span>();
		sentences.addAll(opinionSpan.getDataset().getSpans("sentence", opinionSpan.first()));
		sentences.addAll(opinionSpan.getDataset().getSpans("sentence", opinionSpan.last()));
		if (sentences.isEmpty()) 
		{
			Framework.log("No sentences?");
			Framework.log("Content opinionSpan: "+opinionSpan.size());
			Framework.log("Textual unit: "+opinionSpan.getTextualUnit().toString());
			TreeSet<Span> sentenceList = opinionSpan.getDataset().getSpans(opinionSpan.getTextualUnit(), "sentence");
			for (Span sentence : sentenceList) 
			{
				Framework.log(sentence.contains(opinionSpan.first()) + "\t" + sentence.contains(opinionSpan.last()) + "\t" + sentence.getWords());
			}
		}
		return sentences.first();
	}
	
	public Span getReview(Span sentenceSpan)
	{

		TreeSet<Span> reviews = new TreeSet<Span>();
		reviews.addAll(sentenceSpan.getDataset().getSpans("review", sentenceSpan.first()));
		reviews.addAll(sentenceSpan.getDataset().getSpans("review", sentenceSpan.last()));
		if (reviews.isEmpty()) 
		{
			Framework.log("No reviews?");
			Framework.log("Content sentenceSpan: "+sentenceSpan.size());
			Framework.log("Textual unit: "+sentenceSpan.getTextualUnit().toString());
			TreeSet<Span> reviewList = sentenceSpan.getDataset().getSpans(sentenceSpan.getTextualUnit(), "sentence");
			for (Span review : reviewList) 
			{
				Framework.log(review.contains(sentenceSpan.first()) + "\t" + review.contains(sentenceSpan.last()) + "\t" + review.getWords());
			}
		}
		return reviews.first();
	}
	
	public TreeSet<Span> getOpinionsFromSentence(Span sentence)
	{		
			Span review = getReview(sentence);			
			TreeSet<Span> opinionsForReview = review.getDataset().getSpans(review, "opinion");		
			TreeSet<Span> opinionsPerSentence = new TreeSet<Span>();
			
			for (Span opinion : opinionsForReview)
			{
				Span sentence1 = getSentence(opinion);
				
				if (sentence1.equals(sentence))
				{
					opinionsPerSentence.add(opinion);

				}
			}			
		return opinionsPerSentence;
	}

	@Override
	public String getLabel() {
		return "Classification results of annotation label '"+annotationType+"':";
	}

}
