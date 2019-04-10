package edu.eur.absa.algorithm.ontology;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import weka.attributeSelection.ASEvaluation;
import weka.attributeSelection.ASSearch;
import weka.attributeSelection.AttributeSetEvaluator;
import weka.attributeSelection.BestFirst;
import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.PrincipalComponents;
import weka.classifiers.Evaluation;
import weka.classifiers.evaluation.NominalPrediction;
import weka.classifiers.functions.SMO;
import weka.classifiers.functions.SMOreg;
import weka.classifiers.functions.supportVector.RBFKernel;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SelectedTag;
import weka.core.SparseInstance;
import weka.core.converters.CSVLoader;
import weka.filters.supervised.attribute.AttributeSelection;
import edu.eur.absa.Framework;
import edu.eur.absa.algorithm.AbstractAlgorithm;
import edu.eur.absa.algorithm.Prediction;
import edu.eur.absa.evaluation.evaluators.AnnotationLabelEvaluator;
import edu.eur.absa.evaluation.evaluators.AnnotationValueEvaluator;
import edu.eur.absa.evaluation.evaluators.SpanLabelEvaluator;
import edu.eur.absa.external.NRCReviewSentimentLexicon;
import edu.eur.absa.external.ReasoningOntology;
import edu.eur.absa.model.DataEntity;
import edu.eur.absa.model.Dataset;
import edu.eur.absa.model.Relation;
import edu.eur.absa.model.Span;
import edu.eur.absa.model.Word;

public class AspectSentimentSVMAlgorithm extends AbstractAlgorithm {

	private Instances allWekaData0;
	private Instances allWekaData1;
	private Instances allWekaData4;
	private Instances allWekaData6;
	private Instances allWekaData7;
	private Instances allWekaData8;
	private Instances allWekaData11;
	private Instances allWekaData12;
	private Instances allWekaData13;
	private Instances allWekaData15;
	private Instances allWekaData20;
	private Instances allWekaData25;
	private HashMap<Span, Instance> wekaInstances0 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances1 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances4 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances6 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances7 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances8 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances11 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances12 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances13 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances15 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances20 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances25 = new HashMap<>();
	private AttributeSelection featureSelector;
	private Evaluation eval;
//	private StockMarketLexicon sentLex = StockMarketLexicon.getInstance();
//	private FinanceOntology ont =new FinanceOntology(Main.EXTERNALDATA_PATH + "finance.owl");
	private ReasoningOntology ont; 
//	private ReasoningOntology ont =new ReasoningOntology(Main.EXTERNALDATA_PATH + "RestaurantSentimentExpanded.owl");
	private HashMap<String, SMO> modelsList = new HashMap<String, SMO>();
	
	
	
	private NRCReviewSentimentLexicon revSentUnigrams;
	private NRCReviewSentimentLexicon revSentBigrams;
	
	public static final int RESTAURANTS = 0;
	public static final int LAPTOPS = 1;
	
	private int indivId = 0;
	private ArrayList<String> classLabels = new ArrayList<String>();
	
	private OntologySentimentAlgorithm ontAlg = new OntologySentimentAlgorithm("OntologySentimentAlgorithm","review");
	
	public AspectSentimentSVMAlgorithm(String analysisSpan, boolean failureAnalysis) {
		this(analysisSpan, failureAnalysis, RESTAURANTS);
		
		
	}
	
	public AspectSentimentSVMAlgorithm(String analysisSpan, boolean failureAnalysis, int reviewType) {
		this("AspectSentimentSVMAlgorithm",analysisSpan, failureAnalysis, reviewType);
	
	}
	
	public AspectSentimentSVMAlgorithm(String label, String analysisSpan, boolean failureAnalysis, int reviewType) {
		super(label,analysisSpan);
		evaluators.add(new SpanLabelEvaluator("opinion", "category"));
		
		if (reviewType == RESTAURANTS){
			revSentUnigrams = new NRCReviewSentimentLexicon(NRCReviewSentimentLexicon.RESTAURANTS_UNIGRAM);
			revSentBigrams = new NRCReviewSentimentLexicon(NRCReviewSentimentLexicon.RESTAURANTS_BIGRAM);
		}
		if (reviewType == LAPTOPS){
			revSentUnigrams = new NRCReviewSentimentLexicon(NRCReviewSentimentLexicon.LAPTOPS_UNIGRAM);
			revSentBigrams = new NRCReviewSentimentLexicon(NRCReviewSentimentLexicon.LAPTOPS_BIGRAM);
		}
		
	}
	
	protected void setDataSubsets(ArrayList<HashSet<Span>> dataSubSets, Dataset dataset){
		super.setDataSubSets(dataSubSets, dataset);
		ontAlg.setBinaryProperties("use_sentence");
		if (hasProperty("ont")){
			ontAlg.setProperty("ont", getProperty("ont"));
		} else {
			ontAlg.setProperty("ont", "RestaurantSentimentExpanded.owl");
		}
		ontAlg.setProperty("ont_ns", "http://www.kimschouten.com/sentiment/restaurant");
		ontAlg.setDataSubSets(dataSubSets, dataset);
	}

	@Override
	protected void cleanAlgorithm() {
		Framework.log(getLabel()+" - Cleaning");
		eval = null;
		featureSelector = null;
		modelsList = new HashMap<String, SMO>();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void preprocess() {
		Framework.log(getLabel() + " - Preprocessing ...");
		
		ArrayList<String> restaurantAspects = ReasoningOntology.getRestaurantAspects();
		for (int x = 0; x < restaurantAspects.size(); x++)
		{
			if (x == 2 || x == 3 || x == 5 || x == 9 || x == 10 || x == 14 || x == 16 || x == 17 || x == 18 || x == 19 || x == 21 || x == 22 || x == 23 || x == 24 || x == 26 || x == 27 || x == 28 || x == 29)
			{
				continue;
			}
			
			String aspectCurrent = restaurantAspects.get(x);
			Framework.log("Preprocessing " + aspectCurrent);
		
		
		if (hasProperty("use_ontology")){
			 ont = ReasoningOntology.getOntology(Framework.EXTERNALDATA_PATH + getProperty("ont"));
		}
		
		//collect all attributes and their values for all the spans
		HashMap<String,Attribute> listOfAttributes = new HashMap<>();
		HashMap<Span,HashMap<Attribute, Double>> allInstanceValues = new HashMap<>();
		HashMap<Span,ArrayList<String>> targetValues = new HashMap<>();
		//add span level features
		if (hasProperty("use_stanford_sentence_sentiment"))
			listOfAttributes.put("stanfordSentiment", new Attribute("stanfordSentiment"));
		if (hasProperty("use_stanford_opinion_sentiment"))
			listOfAttributes.put("stanfordOpinionSentiment", new Attribute("stanfordOpinionSentiment"));		
		String[] wordFeatureArray = new String[0];
		if (hasProperty("use_word_annotations")){
			wordFeatureArray = getProperty("use_word_annotations").split(" ");
			if (wordFeatureArray.length == 1 && wordFeatureArray[0].equals(""))
				wordFeatureArray = new String[]{};
		} else {
			wordFeatureArray = new String[]{"lemma"};
		}
			

		
		
		
		for (Span reviewSpan : getCombinedData()){
//			this.extractStatements(span);
			TreeSet<Span> sentencesForReview = reviewSpan.getDataset().getSpans(reviewSpan, "sentence");
			
			for (Span span : sentencesForReview){
				HashMap<Attribute, Double> instanceValues = new HashMap<>();
				allInstanceValues.put(span,instanceValues);
				
				// get opinions per sentence, then get categories
				TreeSet<Span> opinionsInSentence = new TreeSet<Span>();
				opinionsInSentence = getOpinionsFromSentence(span);
				ArrayList<String> AllAspectsInSentence = new ArrayList<String>();
				for (Span opinion : opinionsInSentence) {
					AllAspectsInSentence.add(opinion.getAnnotation("category", String.class));
				}
				
				if(!AllAspectsInSentence.isEmpty()) {
					targetValues.put(span, AllAspectsInSentence); 
				}			
				
				TreeSet<Word> scope;
				Span sentence = null;
				try {
				sentence = span;
				} catch (Exception e) {
					e.printStackTrace();
					Framework.log(span.toString());
					Framework.log(span.first().getId() + "\t" + span.last().getId());
					for (Word w: span) {
						Framework.log(w.toString() + "\t" + w.getId());
					}
					Framework.log(dataset.getSpans(span.first()).toString());
				}
				
				
				
				if (hasProperty("use_sentence")){
					scope = sentence.getWords();
//					scope = span.getDataset().getSpans("sentence", span.first()).first();
//					scope = span.getTextualUnit();
				} 
				else if (hasProperty("use_review")){
					scope = span.getTextualUnit().getWords();
				} 
			else 
				{
					scope = span.getWords();
				}
				
			
				
				for (Word word : scope){
					//Annotations ann = word.getAnnotations();
					
					for (String attr : wordFeatureArray){
							
							//if not using NER, or the NER label is O (so no NE) then use the lemma
							//lemma but not a ner or we don't use ners
							String attribute = word.getAnnotationEntryText(attr);
							
							
							if (!listOfAttributes.containsKey(attribute)){
	//							Main.debug(ann.getEntryText(attr));
								listOfAttributes.put(attribute, new Attribute(attribute));
							}
													
						
						double instanceValue = 0.0;
						
						if (!hasProperty("use_nrc_sentiment") && !hasProperty("use_stanford_sentiment")){
							//presence only
							instanceValue = 1.0;
							//frequency
//							instanceValue = instanceValues.getOrDefault(listOfAttributes.get(ann.getEntryText(attr)),0.0)+1.0;
							
						}
						
						
						instanceValues.put(listOfAttributes.get(word.getAnnotationEntryText(attr)), instanceValue);
						
					}
										
					
				}
				
				
				if (hasProperty("use_ontology")){
					ArrayList<ArrayList<Integer>> foundAspects = ontAlg.Opinions(sentence, sentencesForReview, ont);
					
					for (int i = 0; i < foundAspects.size(); i++)
					{
							if (foundAspects.get(i).get(x) == 1)
							{
								listOfAttributes.putIfAbsent(restaurantAspects.get(x), new Attribute(restaurantAspects.get(x)));
								instanceValues.put(listOfAttributes.get(restaurantAspects.get(x)), 1.0);
							}
					}	
					
				}
			}
		}
		
		ArrayList<Attribute> attributes = new ArrayList<>();
		attributes.addAll(listOfAttributes.values());
		
		if (classLabels.isEmpty()) 
		{
					classLabels.addAll(ReasoningOntology.getRestaurantAspects());    //Change this for laptops					
					if (hasProperty("predict_null"))
					{
						classLabels.add("no_category");
					}
			}
			
			ArrayList<String> singleAspect = new ArrayList<String>();
			singleAspect.add(aspectCurrent + "NotFound");
			singleAspect.add(aspectCurrent);
			Attribute aspectTarget = new Attribute("category", singleAspect); 
			attributes.add(aspectTarget);
			if (x == 0)
			{
				allWekaData0 = new Instances(label, attributes, 0);
				allWekaData0.setClass(aspectTarget);
			}
			if (x == 1)
			{
				allWekaData1 = new Instances(label, attributes, 0);
				allWekaData1.setClass(aspectTarget);
			}
			if (x == 4)
			{
				allWekaData4 = new Instances(label, attributes, 0);
				allWekaData4.setClass(aspectTarget);
			}
			if (x == 6)
			{
				allWekaData6 = new Instances(label, attributes, 0);
				allWekaData6.setClass(aspectTarget);
			}
			if (x == 7)
			{
				allWekaData7 = new Instances(label, attributes, 0);
				allWekaData7.setClass(aspectTarget);
			}
			if (x == 8)
			{
				allWekaData8 = new Instances(label, attributes, 0);
				allWekaData8.setClass(aspectTarget);
			}
			if (x == 11)
			{
				allWekaData11 = new Instances(label, attributes, 0);
				allWekaData11.setClass(aspectTarget);
			}
			if (x == 12)
			{
				allWekaData12 = new Instances(label, attributes, 0);
				allWekaData12.setClass(aspectTarget);
			}
			if (x == 13)
			{
				allWekaData13 = new Instances(label, attributes, 0);
				allWekaData13.setClass(aspectTarget);
			}
			if (x == 15)
			{
				allWekaData15 = new Instances(label, attributes, 0);
				allWekaData15.setClass(aspectTarget);
			}
			if (x == 20)
			{
				allWekaData20 = new Instances(label, attributes, 0);
				allWekaData20.setClass(aspectTarget);
			}
			if (x == 25)
			{
				allWekaData25 = new Instances(label, attributes, 0);
				allWekaData25.setClass(aspectTarget);
			}
		
			
			for (Span s : allInstanceValues.keySet()){
				HashMap<Attribute, Double> instanceData = allInstanceValues.get(s);
				Instance i = new SparseInstance(attributes.size());
				if (x == 0)
				{
					i.setDataset(allWekaData0);
				}
				if (x == 1)
				{
					i.setDataset(allWekaData1);
				}
				if (x == 4)
				{
					i.setDataset(allWekaData4);
				}
				if (x == 6)
				{
					i.setDataset(allWekaData6);
				}
				if (x == 7)
				{
					i.setDataset(allWekaData7);
				}
				if (x == 8)
				{
					i.setDataset(allWekaData8);
				}
				if (x == 11)
				{
					i.setDataset(allWekaData11);
				}
				if (x == 12)
				{
					i.setDataset(allWekaData12);
				}
				if (x == 13)
				{
					i.setDataset(allWekaData13);
				}
				if (x == 15)
				{
					i.setDataset(allWekaData15);
				}
				if (x == 20)
				{
					i.setDataset(allWekaData20);
				}
				if (x == 25)
				{
					i.setDataset(allWekaData25);
				}
				
				features.put(s, new HashSet<String>());
				for (Attribute att : attributes){
					//if this attribute is present, put its value in there, otherwise, put a 0 (which will not be saved due to the
					// instance being a SparseInstance
	//				if (instanceData.containsKey(att))
						i.setValue(att, instanceData.getOrDefault(att, 0.0));
						if (instanceData.containsKey(att))
							features.get(s).add(att.name()+"\t"+instanceData.get(att)+"\n");
					
				}
				
				if (targetValues.containsKey(s) && targetValues.get(s).contains(aspectCurrent)){ //if sentence has current aspect	
							i.setClassValue(aspectCurrent);
							
				}
				
				if (x == 0)
				{
					wekaInstances0.put(s, i);
					allWekaData0.add(i);
				}
				if (x == 1)
				{
					wekaInstances1.put(s, i);
					allWekaData1.add(i);
				}
				if (x == 4)
				{
					wekaInstances4.put(s, i);
					allWekaData4.add(i);
				}
				if (x == 6)
				{
					wekaInstances6.put(s, i);
					allWekaData6.add(i);
				}
				if (x == 7)
				{
					wekaInstances7.put(s, i);
					allWekaData7.add(i);
				}
				if (x == 8)
				{
					wekaInstances8.put(s, i);
					allWekaData8.add(i);
				}
				if (x == 11)
				{
					wekaInstances11.put(s, i);
					allWekaData11.add(i);
				}
				if (x == 12)
				{
					wekaInstances12.put(s, i);
					allWekaData12.add(i);
				}
				if (x == 13)
				{
					wekaInstances13.put(s, i);
					allWekaData13.add(i);
				}
				if (x == 15)
				{
					wekaInstances15.put(s, i);
					allWekaData15.add(i);
				}
				if (x == 20)
				{
					wekaInstances20.put(s, i);
					allWekaData20.add(i);
				}
				if (x == 25)
				{
					wekaInstances25.put(s, i);
					allWekaData25.add(i);
				}
			}
			}
//		System.exit(0);
	}

	@Override
	public void train() {
		Framework.log(getLabel() + " - Training ...");
		
		ArrayList<String> restaurantAspects = ReasoningOntology.getRestaurantAspects();
		for (int x = 0; x < restaurantAspects.size(); x++)
		{
			if (x == 2 || x == 3 || x == 5 || x == 9 || x == 10 || x == 14 || x == 16 || x == 17 || x == 18 || x == 19 || x == 21 || x == 22 || x == 23 || x == 24 || x == 26 || x == 27 || x == 28 || x == 29)
			{
				continue;
			}
		SMO model = null;
		String aspectCurrent = restaurantAspects.get(x);
		Instances allWekaDataCurrent = null;
		HashMap<Span, Instance> wekaInstancesCurrent = new HashMap<>();
		Framework.log("Training " + aspectCurrent);
		if (x == 0)
		{
			allWekaDataCurrent = allWekaData0;
			wekaInstancesCurrent = wekaInstances0;
		}
		if (x == 1)
		{
			allWekaDataCurrent = allWekaData1;
			wekaInstancesCurrent = wekaInstances1;
		}
		if (x == 4)
		{
			allWekaDataCurrent = allWekaData4;
			wekaInstancesCurrent = wekaInstances4;
		}
		if (x == 6)
		{
			allWekaDataCurrent = allWekaData6;
			wekaInstancesCurrent = wekaInstances6;
		}
		if (x == 7)
		{
			allWekaDataCurrent = allWekaData7;
			wekaInstancesCurrent = wekaInstances7;
		}
		if (x == 8)
		{
			allWekaDataCurrent = allWekaData8;
			wekaInstancesCurrent = wekaInstances8;
		}
		if (x == 11)
		{
			allWekaDataCurrent = allWekaData11;
			wekaInstancesCurrent = wekaInstances11;
		}
		if (x == 12)
		{
			allWekaDataCurrent = allWekaData12;
			wekaInstancesCurrent = wekaInstances12;
		}
		if (x == 13)
		{
			allWekaDataCurrent = allWekaData13;
			wekaInstancesCurrent = wekaInstances13;
		}
		if (x == 15)
		{
			allWekaDataCurrent = allWekaData15;
			wekaInstancesCurrent = wekaInstances15;
		}
		if (x == 20)
		{
			allWekaDataCurrent = allWekaData20;
			wekaInstancesCurrent = wekaInstances20;
		}
		if (x == 25)
		{
			allWekaDataCurrent = allWekaData25;
			wekaInstancesCurrent = wekaInstances25;
		}
		
		Instances trainingData = new Instances(allWekaDataCurrent, 0);
		Instances partialTrainingData = new Instances(allWekaDataCurrent, 0);
		Instances validationData = new Instances(allWekaDataCurrent, 0);
		ArrayList<Span> trainingSpans = new ArrayList<Span>();
		HashSet<DataEntity> trainingSet = new HashSet<DataEntity>();
		if (hasProperty("use_feature_selection") || hasProperty("use_hyperparameter_optimization")){
			for (Span reviewSpan : this.getTrainingData().get(0)){
				for (Span s : reviewSpan.getDataset().getSpans(reviewSpan, "sentence")){
					partialTrainingData.add(wekaInstancesCurrent.get(s));
//					trainingSpans.add(s);
				}
			}
			for (Span reviewSpan : this.getTrainingData().get(1)){
				for (Span s : reviewSpan.getDataset().getSpans(reviewSpan, "sentence")){
					validationData.add(wekaInstancesCurrent.get(s));
				}
			}
		}
		for (Span reviewSpan : getCombinedTrainingData()){
			for (Span s : reviewSpan.getDataset().getSpans(reviewSpan, "sentence")){
				trainingData.add(wekaInstancesCurrent.get(s));
				trainingSpans.add(s);
			}
		}
		
		trainingSet.addAll(trainingSpans);
		
		

		
		
		
		try {
			double bestGamma = 0;
			double bestC = 0;
			if (hasProperty("use_hyperparameter_optimization")){
				double bestF1 = 0;
				for (int gamma = -6; gamma <= -2; gamma++){
					//c = -1;
					for (int c =  -1 * gamma - 4; c <= 5; c++){
						
						model = new SMO();
						model.setFilterType(new SelectedTag(SMO.FILTER_NORMALIZE, SMO.TAGS_FILTER));
						if (!hasProperty("linear"))
							model.setKernel(new RBFKernel(partialTrainingData, 25007, Math.pow(10, gamma)));
						model.setC(Math.pow(10, c));
						model.buildClassifier(partialTrainingData);
						
						
					
						eval = new Evaluation(validationData);
						eval.evaluateModel(model, validationData);
						
						double f1 = eval.weightedFMeasure();
						if (f1 > bestF1){
							bestF1 = f1;
							bestGamma = gamma;
							bestC = c;
						}
						Framework.log("Optimization round...\tC="+Math.pow(10, c)+"\tGamma="+Math.pow(10, gamma)+"\tF1:"+f1);
					}
					
				}
				Framework.log("Best performing gamma: "+Math.pow(10,bestGamma)+"\tBest performing C: "+Math.pow(10,bestC)+"\tResulting in F1="+bestF1+" on validationdata");
			} else {
				bestGamma = -4;	//-2 or -1
				bestC = 3;		//2
			}
			
			model = new SMO();
			model.setFilterType(new SelectedTag(SMO.FILTER_NORMALIZE, SMO.TAGS_FILTER));
			if (!hasProperty("linear"))
				model.setKernel(new RBFKernel(trainingData, 25007, Math.pow(10, bestGamma)));
			model.setC(Math.pow(10, bestC));
			
			model.buildClassifier(trainingData);
			
			SMO tempModel = (SMO) model;
			modelsList.put(aspectCurrent, tempModel);    //save model for current aspect
			
			eval = new Evaluation(trainingData);
			
			//get in-sample performance
			double[] inSamplePredictions = eval.evaluateModel(model, trainingData);
			ArrayList< weka.classifiers.evaluation.Prediction> stringPredictions = eval.predictions();
			for (int i = 0; i < trainingSpans.size(); i++){
				Span s = trainingSpans.get(i);
				Prediction p = new Prediction(s);
				int temp = (int) inSamplePredictions[i];
				
				if (temp == 1)
				{
					p.putAnnotation("category",  aspectCurrent);
					
					if (!this.predictions.containsKey(s))
						this.predictions.put(s, new HashSet<Prediction>());
					this.predictions.get(s).add(p);
					
				}
			}
			
			
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
		Framework.log(this.evaluate(this.getEvaluators().iterator().next(), getCombinedTrainingData()).getEvaluationResults());
		
		}
		
		
		}

		

	@Override
	public void predict() {
		Framework.log(getLabel() + " - Predicting ...");
		
		ArrayList<String> restaurantAspects = ReasoningOntology.getRestaurantAspects();
		for (int x = 0; x < restaurantAspects.size(); x++)
		{
			if (x == 2 || x == 3 || x == 5 || x == 9 || x == 10 || x == 14 || x == 16 || x == 17 || x == 18 || x == 19 || x == 21 || x == 22 || x == 23 || x == 24 || x == 26 || x == 27 || x == 28 || x == 29)
			{
				continue;
			}
		String aspectCurrent = restaurantAspects.get(x);
		Instances allWekaDataCurrent = null;
		HashMap<Span, Instance> wekaInstancesCurrent = new HashMap<>();
		Framework.log("Predicting " + aspectCurrent);
		if (x == 0)
		{
			allWekaDataCurrent = allWekaData0;
			wekaInstancesCurrent = wekaInstances0;
		}
		if (x == 1)
		{
			allWekaDataCurrent = allWekaData1;
			wekaInstancesCurrent = wekaInstances1;
		}
		if (x == 4)
		{
			allWekaDataCurrent = allWekaData4;
			wekaInstancesCurrent = wekaInstances4;
		}
		if (x == 6)
		{
			allWekaDataCurrent = allWekaData6;
			wekaInstancesCurrent = wekaInstances6;
		}
		if (x == 7)
		{
			allWekaDataCurrent = allWekaData7;
			wekaInstancesCurrent = wekaInstances7;
		}
		if (x == 8)
		{
			allWekaDataCurrent = allWekaData8;
			wekaInstancesCurrent = wekaInstances8;
		}
		if (x == 11)
		{
			allWekaDataCurrent = allWekaData11;
			wekaInstancesCurrent = wekaInstances11;
		}
		if (x == 12)
		{
			allWekaDataCurrent = allWekaData12;
			wekaInstancesCurrent = wekaInstances12;
		}
		if (x == 13)
		{
			allWekaDataCurrent = allWekaData13;
			wekaInstancesCurrent = wekaInstances13;
		}
		if (x == 15)
		{
			allWekaDataCurrent = allWekaData15;
			wekaInstancesCurrent = wekaInstances15;
		}
		if (x == 20)
		{
			allWekaDataCurrent = allWekaData20;
			wekaInstancesCurrent = wekaInstances20;
		}
		if (x == 25)
		{
			allWekaDataCurrent = allWekaData25;
			wekaInstancesCurrent = wekaInstances25;
		}
		
		Instances testData = new Instances(allWekaDataCurrent, 0);
		ArrayList<Span> testSpans = new ArrayList<Span>();
		for (Span reviewSpan : getTestData()){
			for (Span s : reviewSpan.getDataset().getSpans(reviewSpan, "sentence")){
				testData.add(wekaInstancesCurrent.get(s));
				testSpans.add(s);
			}
		}
		HashSet<DataEntity> TestSet = new HashSet<DataEntity>();
		TestSet.addAll(testSpans);
		

		SMO modelPerAspect = modelsList.get(aspectCurrent);
		
		try {
						
			eval = new Evaluation(testData);
			double[] predictions = eval.evaluateModel(modelPerAspect, testData);
			//FastVector<NominalPrediction> stringPredictions = eval.predictions();
			ArrayList< weka.classifiers.evaluation.Prediction> stringPredictions = eval.predictions();
			System.out.println(eval.toSummaryString("\nResults\n======\n", false));
			System.out.println(eval.toClassDetailsString());
			for (int i = 0; i < testSpans.size(); i++){
				Span s = testSpans.get(i);
				Prediction p = new Prediction(s);
				int temp = (int) predictions[i];
				if (temp == 1)
				{
					p.putAnnotation("category",  aspectCurrent);
					if (!this.predictions.containsKey(s))
						this.predictions.put(s, new HashSet<Prediction>());
					this.predictions.get(s).add(p);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Framework.log(this.evaluate(this.getEvaluators().iterator().next(), getTestData()).getEvaluationResults());
		}
		
		}
		
	
	
	
	public Span getSentence(Span opinionSpan){
		TreeSet<Span> sentences = opinionSpan.getDataset().getSpans("sentence", opinionSpan.first());
		sentences.addAll(opinionSpan.getDataset().getSpans("sentence", opinionSpan.last()));
		return sentences.first();
	}
	
	public TreeSet<Word> getDepWindow(TreeSet<Word> span, int distance){
		TreeSet<Word> scope = new TreeSet<Word>();
		scope.addAll(span);
		for (Word word : span){
			for (Relation rel : word.getRelations().getRelationsToChildren("deps")){
				if (rel.getChild() instanceof Word)
					scope.add((Word)rel.getChild());
			}
			for (Relation rel : word.getRelations().getRelationsToParents("deps")){
				if (rel.getParent() instanceof Word)
					scope.add((Word)rel.getParent());
			}
		}
		if (distance > 0){
			return getDepWindow(scope, distance-1);
		} else {
			return scope;
		}
	}
	
	public double getSentimentScore(ArrayList<Double> sentimentScores){
		if (sentimentScores == null || sentimentScores.isEmpty())
			return 0.0;
		
		double score = 0;
		if (sentimentScores.size()> 0){
			for (int i = 0; i < 5; i++){
				score += sentimentScores.get(i)*(i-2);
			}
		}
		return score;
	}

	public double getDepDistanceWeight(Word w){
		double distance = (w.getAnnotation("depDistance"));
		
		distance = 1.0 / Math.max(1.0,distance);

		return distance;
	}
	
	public double getWordDistanceWeight(Word source, Word w){
		double distance = Math.abs(source.getOrder() - w.getOrder());
		distance = distance > 4 ? 0.25 : 1.0;
		return distance;
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
            Span review = sentence.getTextualUnit();
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
	
	
	public void extractStatements(Span sentenceSpan){
		Dataset dataset = sentenceSpan.getDataset();
		
//		Main.debug("\n"+sentenceSpan.toString());
//		HashSet<Relation> children = sentenceSpan.getRelations().getAllRelationsToChildren();
//		Word root = null;
//		if (children.size() == 1){
//			root = (Word) children.iterator().next().getChild();
//			for (Relation r : root.getRelations().getAllRelationsToChildren()){
//				Main.debug("\t"+r);
//			}
//		}
//		Main.debug(""+root);
//		
		
		HashMap<String, HashSet<Relation>> relations = new HashMap<>();
		
		for (Relation rel : dataset.getRelations("deps")){
			String gramType = rel.getAnnotation("relationShortName");
			if (!relations.containsKey(gramType))
				relations.put(gramType, new HashSet<Relation>());
			relations.get(gramType).add(rel);
			
		}
		
		for (String gramType : relations.keySet()){
			Framework.debug(gramType+": "+relations.get(gramType).size());
		}
		for (String gramType : new String[]{"dobj"}){
			Framework.debug("RelationType: "+gramType);
			for (Relation r : relations.get(gramType)){
				DataEntity parent = r.getParent();
				TreeSet<Relation> parentPhrases = parent.getRelations().getRelationsToChildren("syntacticHead");
				
				DataEntity child = r.getChild();
				TreeSet<Relation> childPhrases = child.getRelations().getRelationsToChildren("syntacticHead");
				
				Framework.debug(""+parent.getAnnotation("lemma") + " " +
						parent.getAnnotation("pos") + " " +
						parent.getAnnotation("nerLabel") + " " +
						" -> " + child.getAnnotation("lemma") + " " +
						child.getAnnotation("pos") + " " +
						child.getAnnotation("nerLabel") + "\t" +
						((Word)parent).getTextualUnit().getAnnotation("text") + "\t" +
						((Word)parent).getTextualUnit().getAnnotationEntryText("polarity")
						);
				
//				if (parentPhrases != null){
//					for (Relation rel : parentPhrases){
//						Main.debug("Parent phrase: "+((Span)rel.getChild()).getAnnotations().get("text"));
//					}
//				}
				if (childPhrases != null){
					Span bestSpan=null;
					for (Relation rel : childPhrases){
						Span currentSpan = (Span)rel.getChild();
						if (!currentSpan.contains((Word)parent)){
							//we don't want a noun phrase so big it contains the verb
							//but it should be as big as possible
							if (bestSpan == null || bestSpan.size() < currentSpan.size()){
								bestSpan = currentSpan;
							}
						}
					}
					if (bestSpan!=null){
						Framework.debug("Child phrase: "+bestSpan.getAnnotation("text"));
					}
				}
			}
		}
		
		System.exit(0);
//		Main.debug(sentenceSpan.getTextualUnit().getRelations().getAllRelationsToChildren().toString());
//		Main.debug(sentenceSpan.getTextualUnit().getRelations().getAllRelationsToChildren().toString());
		
	}
	
	
	
}
