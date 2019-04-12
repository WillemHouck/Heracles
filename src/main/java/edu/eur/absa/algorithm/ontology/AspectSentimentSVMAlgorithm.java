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
	private Instances allWekaData2;
	private Instances allWekaData3;
	private Instances allWekaData4;
	private Instances allWekaData5;
	private Instances allWekaData6;
	private Instances allWekaData7;
	private Instances allWekaData8;
	private Instances allWekaData9;
	private Instances allWekaData10;
	private Instances allWekaData11;
	private Instances allWekaData12;
	private Instances allWekaData13;
	private Instances allWekaData14;
	private Instances allWekaData15;
	private Instances allWekaData16;
	private Instances allWekaData17;
	private Instances allWekaData18;
	private Instances allWekaData19;
	private Instances allWekaData20;
	private Instances allWekaData21;
	private Instances allWekaData22;
	private Instances allWekaData23;
	private Instances allWekaData24;
	private Instances allWekaData25;
	private Instances allWekaData26;
	private Instances allWekaData27;
	private Instances allWekaData28;
	private Instances allWekaData29;
	private Instances allWekaData30;
	private Instances allWekaData31;
	private Instances allWekaData32;
	private Instances allWekaData33;
	private Instances allWekaData34;
	private Instances allWekaData35;
	private Instances allWekaData36;
	private Instances allWekaData37;
	private Instances allWekaData38;
	private Instances allWekaData39;
	private Instances allWekaData40;
	private Instances allWekaData41;
	private Instances allWekaData42;
	private Instances allWekaData43;
	private Instances allWekaData44;
	private Instances allWekaData45;
	private Instances allWekaData46;
	private Instances allWekaData47;
	private Instances allWekaData48;
	private Instances allWekaData49;
	private Instances allWekaData50;
	private Instances allWekaData51;
	private Instances allWekaData52;
	private Instances allWekaData53;
	private Instances allWekaData54;
	private Instances allWekaData55;
	private Instances allWekaData56;
	private Instances allWekaData57;
	private Instances allWekaData58;
	private Instances allWekaData59;
	private Instances allWekaData60;
	private Instances allWekaData61;
	private Instances allWekaData62;
	private Instances allWekaData63;
	private Instances allWekaData64;
	private Instances allWekaData65;
	private Instances allWekaData66;
	private Instances allWekaData67;
	private Instances allWekaData68;
	private Instances allWekaData69;
	private Instances allWekaData70;
	private Instances allWekaData71;
	private Instances allWekaData72;
	private Instances allWekaData73;
	private Instances allWekaData74;
	private Instances allWekaData75;
	private Instances allWekaData76;
	private Instances allWekaData77;
	private Instances allWekaData78;
	private Instances allWekaData79;
	private Instances allWekaData80;
	private Instances allWekaData81;
	private Instances allWekaData82;
	private Instances allWekaData83;
	private Instances allWekaData84;
	private Instances allWekaData85;
	private Instances allWekaData86;
	private Instances allWekaData87;
	private Instances allWekaData88;
	private Instances allWekaData89;
	private Instances allWekaData90;
	private Instances allWekaData91;
	private Instances allWekaData92;
	private Instances allWekaData93;
	private Instances allWekaData94;
	private Instances allWekaData95;
	private Instances allWekaData96;
	private Instances allWekaData97;
	private Instances allWekaData98;
	private Instances allWekaData99;
	private Instances allWekaData100;
	private Instances allWekaData101;
	private Instances allWekaData102;
	private Instances allWekaData103;
	private Instances allWekaData104;
	private Instances allWekaData105;
	private Instances allWekaData106;
	private Instances allWekaData107;
	private Instances allWekaData108;
	private Instances allWekaData109;
	private Instances allWekaData110;
	private Instances allWekaData111;
	private Instances allWekaData112;
	private Instances allWekaData113;
	private Instances allWekaData114;
	private Instances allWekaData115;
	private Instances allWekaData116;
	private Instances allWekaData117;
	private Instances allWekaData118;
	private Instances allWekaData119;
	private Instances allWekaData120;
	private Instances allWekaData121;
	private Instances allWekaData122;
	private Instances allWekaData123;
	private Instances allWekaData124;
	private Instances allWekaData125;
	private Instances allWekaData126;
	private Instances allWekaData127;
	private Instances allWekaData128;
	private Instances allWekaData129;
	private Instances allWekaData130;
	private Instances allWekaData131;
	private Instances allWekaData132;
	private Instances allWekaData133;
	private Instances allWekaData134;
	private Instances allWekaData135;
	private Instances allWekaData136;
	private Instances allWekaData137;
	private Instances allWekaData138;
	private Instances allWekaData139;
	private Instances allWekaData140;
	private Instances allWekaData141;
	private Instances allWekaData142;
	private Instances allWekaData143;
	private Instances allWekaData144;
	private Instances allWekaData145;
	private Instances allWekaData146;
	private Instances allWekaData147;
	private Instances allWekaData148;
	private Instances allWekaData149;
	private Instances allWekaData150;
	private Instances allWekaData151;
	private Instances allWekaData152;
	private Instances allWekaData153;
	private Instances allWekaData154;
	private Instances allWekaData155;
	private Instances allWekaData156;
	private Instances allWekaData157;
	private Instances allWekaData158;
	private Instances allWekaData159;
	private Instances allWekaData160;
	private Instances allWekaData161;
	private Instances allWekaData162;
	private Instances allWekaData163;
	private Instances allWekaData164;
	private Instances allWekaData165;
	private Instances allWekaData166;
	private Instances allWekaData167;
	private Instances allWekaData168;
	private Instances allWekaData169;
	private Instances allWekaData170;
	private Instances allWekaData171;
	private Instances allWekaData172;
	private Instances allWekaData173;
	private Instances allWekaData174;
	private Instances allWekaData175;
	private Instances allWekaData176;
	private Instances allWekaData177;
	private Instances allWekaData178;
	private Instances allWekaData179;
	private Instances allWekaData180;
	private Instances allWekaData181;
	private Instances allWekaData182;
	private Instances allWekaData183;
	private Instances allWekaData184;
	private Instances allWekaData185;
	private Instances allWekaData186;
	private Instances allWekaData187;
	private Instances allWekaData188;
	private Instances allWekaData189;
	private Instances allWekaData190;
	private Instances allWekaData191;
	private Instances allWekaData192;
	private Instances allWekaData193;
	private Instances allWekaData194;
	private Instances allWekaData195;
	private Instances allWekaData196;
	private Instances allWekaData197;
    private HashMap<Span, Instance> wekaInstances0 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances1 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances2 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances3 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances4 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances5 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances6 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances7 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances8 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances9 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances10 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances11 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances12 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances13 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances14 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances15 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances16 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances17 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances18 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances19 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances20 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances21 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances22 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances23 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances24 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances25 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances26 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances27 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances28 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances29 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances30 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances31 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances32 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances33 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances34 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances35 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances36 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances37 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances38 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances39 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances40 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances41 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances42 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances43 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances44 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances45 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances46 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances47 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances48 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances49 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances50 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances51 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances52 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances53 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances54 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances55 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances56 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances57 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances58 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances59 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances60 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances61 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances62 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances63 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances64 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances65 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances66 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances67 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances68 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances69 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances70 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances71 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances72 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances73 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances74 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances75 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances76 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances77 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances78 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances79 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances80 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances81 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances82 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances83 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances84 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances85 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances86 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances87 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances88 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances89 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances90 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances91 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances92 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances93 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances94 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances95 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances96 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances97 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances98 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances99 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances100 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances101 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances102 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances103 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances104 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances105 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances106 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances107 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances108 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances109 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances110 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances111 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances112 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances113 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances114 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances115 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances116 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances117 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances118 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances119 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances120 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances121 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances122 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances123 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances124 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances125 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances126 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances127 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances128 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances129 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances130 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances131 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances132 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances133 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances134 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances135 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances136 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances137 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances138 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances139 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances140 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances141 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances142 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances143 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances144 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances145 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances146 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances147 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances148 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances149 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances150 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances151 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances152 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances153 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances154 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances155 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances156 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances157 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances158 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances159 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances160 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances161 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances162 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances163 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances164 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances165 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances166 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances167 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances168 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances169 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances170 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances171 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances172 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances173 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances174 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances175 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances176 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances177 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances178 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances179 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances180 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances181 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances182 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances183 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances184 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances185 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances186 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances187 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances188 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances189 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances190 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances191 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances192 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances193 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances194 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances195 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances196 = new HashMap<>();
	private HashMap<Span, Instance> wekaInstances197 = new HashMap<>();
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
//		evaluators.add(new AnnotationLabelEvaluator("opinion","category",failureAnalysis));
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
		ontAlg.setProperty("ont_ns", "http://www.semanticweb.org/karoliina/ontologies/2017/4/Laptop");
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
		
		ArrayList<String> laptopAspects = ReasoningOntology.getLaptopsAspects();
		for (int x = 0; x < laptopAspects.size(); x++)
		{			
			String aspectCurrent = laptopAspects.get(x);
			Framework.log("Preprocessing " + x + ") " + aspectCurrent);
		
		
		if (hasProperty("use_ontology")){
//			 ont =new ReasoningOntology(Main.EXTERNALDATA_PATH + "RestaurantSentiment.owl");
//			 ont =new ReasoningOntology(Framework.EXTERNALDATA_PATH + "RestaurantSentimentExpanded.owl");
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
			//TreeSet<Span> opinionsForReview = reviewSpan.getDataset().getSpans(reviewSpan, "opinion");
			TreeSet<Span> sentencesForReview = reviewSpan.getDataset().getSpans(reviewSpan, "sentence");
			
			for (Span span : sentencesForReview){
				//Framework.log("Opinion span: "+span.toString());
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
//					Framework.log(span.toString());
//					Framework.log(span.first().getId() + "\t" + span.last().getId());
//					for (Word w: span) {
//						Framework.log(w.toString() + "\t" + w.getId());
//					}
//					Framework.log(dataset.getSpans(span.first()).toString());
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
								listOfAttributes.putIfAbsent(laptopAspects.get(x), new Attribute(laptopAspects.get(x)));
								instanceValues.put(listOfAttributes.get(laptopAspects.get(x)), 1.0);
							}
					}	
					
				}
			}
		}
		
		ArrayList<Attribute> attributes = new ArrayList<>();
		attributes.addAll(listOfAttributes.values());
		
		if (classLabels.isEmpty()) 
		{
					classLabels.addAll(ReasoningOntology.getLaptopsAspects());    //Change this for laptops					
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
			if (x == 2)
			{
				allWekaData2 = new Instances(label, attributes, 0);
				allWekaData2.setClass(aspectTarget);
			}
			if (x == 3)
			{
				allWekaData3 = new Instances(label, attributes, 0);
				allWekaData3.setClass(aspectTarget);
			}
			if (x == 4)
			{
				allWekaData4 = new Instances(label, attributes, 0);
				allWekaData4.setClass(aspectTarget);
			}
			if (x == 5)
			{
				allWekaData5 = new Instances(label, attributes, 0);
				allWekaData5.setClass(aspectTarget);
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
			if (x == 9)
			{
				allWekaData9 = new Instances(label, attributes, 0);
				allWekaData9.setClass(aspectTarget);
			}
			if (x == 10)
			{
				allWekaData10 = new Instances(label, attributes, 0);
				allWekaData10.setClass(aspectTarget);
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
			if (x == 14)
			{
				allWekaData14 = new Instances(label, attributes, 0);
				allWekaData14.setClass(aspectTarget);
			}
			if (x == 15)
			{
				allWekaData15 = new Instances(label, attributes, 0);
				allWekaData15.setClass(aspectTarget);
			}
			if (x == 16)
			{
				allWekaData16 = new Instances(label, attributes, 0);
				allWekaData16.setClass(aspectTarget);
			}
			if (x == 17)
			{
				allWekaData17 = new Instances(label, attributes, 0);
				allWekaData17.setClass(aspectTarget);
			}
			if (x == 18)
			{
				allWekaData18 = new Instances(label, attributes, 0);
				allWekaData18.setClass(aspectTarget);
			}
			if (x == 19)
			{
				allWekaData19 = new Instances(label, attributes, 0);
				allWekaData19.setClass(aspectTarget);
			}
			if (x == 20)
			{
				allWekaData20 = new Instances(label, attributes, 0);
				allWekaData20.setClass(aspectTarget);
			}
			if (x == 21)
			{
				allWekaData21 = new Instances(label, attributes, 0);
				allWekaData21.setClass(aspectTarget);
			}
			if (x == 22)
			{
				allWekaData22 = new Instances(label, attributes, 0);
				allWekaData22.setClass(aspectTarget);
			}
			if (x == 23)
			{
				allWekaData23 = new Instances(label, attributes, 0);
				allWekaData23.setClass(aspectTarget);
			}
			if (x == 24)
			{
				allWekaData24 = new Instances(label, attributes, 0);
				allWekaData24.setClass(aspectTarget);
			}
			if (x == 25)
			{
				allWekaData25 = new Instances(label, attributes, 0);
				allWekaData25.setClass(aspectTarget);
			}
			if (x == 26)
			{
				allWekaData26 = new Instances(label, attributes, 0);
				allWekaData26.setClass(aspectTarget);
			}
			if (x == 27)
			{
				allWekaData27 = new Instances(label, attributes, 0);
				allWekaData27.setClass(aspectTarget);
			}
			if (x == 28)
			{
				allWekaData28 = new Instances(label, attributes, 0);
				allWekaData28.setClass(aspectTarget);
			}
			if (x == 29)
			{
				allWekaData29 = new Instances(label, attributes, 0);
				allWekaData29.setClass(aspectTarget);
			}
			if (x == 30)
			{
				allWekaData30 = new Instances(label, attributes, 0);
				allWekaData30.setClass(aspectTarget);
			}
			if (x == 31)
			{
				allWekaData31 = new Instances(label, attributes, 0);
				allWekaData31.setClass(aspectTarget);
			}
			if (x == 32)
			{
				allWekaData32 = new Instances(label, attributes, 0);
				allWekaData32.setClass(aspectTarget);
			}
			if (x == 33)
			{
				allWekaData33 = new Instances(label, attributes, 0);
				allWekaData33.setClass(aspectTarget);
			}
			if (x == 34)
			{
				allWekaData34 = new Instances(label, attributes, 0);
				allWekaData34.setClass(aspectTarget);
			}
			if (x == 35)
			{
				allWekaData35 = new Instances(label, attributes, 0);
				allWekaData35.setClass(aspectTarget);
			}
			if (x == 36)
			{
				allWekaData36 = new Instances(label, attributes, 0);
				allWekaData36.setClass(aspectTarget);
			}
			if (x == 37)
			{
				allWekaData37 = new Instances(label, attributes, 0);
				allWekaData37.setClass(aspectTarget);
			}
			if (x == 38)
			{
				allWekaData38 = new Instances(label, attributes, 0);
				allWekaData38.setClass(aspectTarget);
			}
			if (x == 39)
			{
				allWekaData39 = new Instances(label, attributes, 0);
				allWekaData39.setClass(aspectTarget);
			}
			if (x == 40)
			{
				allWekaData40 = new Instances(label, attributes, 0);
				allWekaData40.setClass(aspectTarget);
			}
			if (x == 41)
			{
				allWekaData41 = new Instances(label, attributes, 0);
				allWekaData41.setClass(aspectTarget);
			}
			if (x == 42)
			{
				allWekaData42 = new Instances(label, attributes, 0);
				allWekaData42.setClass(aspectTarget);
			}
			if (x == 43)
			{
				allWekaData43 = new Instances(label, attributes, 0);
				allWekaData43.setClass(aspectTarget);
			}
			if (x == 44)
			{
				allWekaData44 = new Instances(label, attributes, 0);
				allWekaData44.setClass(aspectTarget);
			}
			if (x == 45)
			{
				allWekaData45 = new Instances(label, attributes, 0);
				allWekaData45.setClass(aspectTarget);
			}
			if (x == 46)
			{
				allWekaData46 = new Instances(label, attributes, 0);
				allWekaData46.setClass(aspectTarget);
			}
			if (x == 47)
			{
				allWekaData47 = new Instances(label, attributes, 0);
				allWekaData47.setClass(aspectTarget);
			}
			if (x == 48)
			{
				allWekaData48 = new Instances(label, attributes, 0);
				allWekaData48.setClass(aspectTarget);
			}
			if (x == 49)
			{
				allWekaData49 = new Instances(label, attributes, 0);
				allWekaData49.setClass(aspectTarget);
			}
			if (x == 50)
			{
				allWekaData50 = new Instances(label, attributes, 0);
				allWekaData50.setClass(aspectTarget);
			}
			if (x == 51)
			{
				allWekaData51 = new Instances(label, attributes, 0);
				allWekaData51.setClass(aspectTarget);
			}
			if (x == 52)
			{
				allWekaData52 = new Instances(label, attributes, 0);
				allWekaData52.setClass(aspectTarget);
			}
			if (x == 53)
			{
				allWekaData53 = new Instances(label, attributes, 0);
				allWekaData53.setClass(aspectTarget);
			}
			if (x == 54)
			{
				allWekaData54 = new Instances(label, attributes, 0);
				allWekaData54.setClass(aspectTarget);
			}
			if (x == 55)
			{
				allWekaData55 = new Instances(label, attributes, 0);
				allWekaData55.setClass(aspectTarget);
			}
			if (x == 56)
			{
				allWekaData56 = new Instances(label, attributes, 0);
				allWekaData56.setClass(aspectTarget);
			}
			if (x == 57)
			{
				allWekaData57 = new Instances(label, attributes, 0);
				allWekaData57.setClass(aspectTarget);
			}
			if (x == 58)
			{
				allWekaData58 = new Instances(label, attributes, 0);
				allWekaData58.setClass(aspectTarget);
			}
			if (x == 59)
			{
				allWekaData59 = new Instances(label, attributes, 0);
				allWekaData59.setClass(aspectTarget);
			}
			if (x == 60)
			{
				allWekaData60 = new Instances(label, attributes, 0);
				allWekaData60.setClass(aspectTarget);
			}
			if (x == 61)
			{
				allWekaData61 = new Instances(label, attributes, 0);
				allWekaData61.setClass(aspectTarget);
			}
			if (x == 62)
			{
				allWekaData62 = new Instances(label, attributes, 0);
				allWekaData62.setClass(aspectTarget);
			}
			if (x == 63)
			{
				allWekaData63 = new Instances(label, attributes, 0);
				allWekaData63.setClass(aspectTarget);
			}
			if (x == 64)
			{
				allWekaData64 = new Instances(label, attributes, 0);
				allWekaData64.setClass(aspectTarget);
			}
			if (x == 65)
			{
				allWekaData65 = new Instances(label, attributes, 0);
				allWekaData65.setClass(aspectTarget);
			}
			if (x == 66)
			{
				allWekaData66 = new Instances(label, attributes, 0);
				allWekaData66.setClass(aspectTarget);
			}
			if (x == 67)
			{
				allWekaData67 = new Instances(label, attributes, 0);
				allWekaData67.setClass(aspectTarget);
			}
			if (x == 68)
			{
				allWekaData68 = new Instances(label, attributes, 0);
				allWekaData68.setClass(aspectTarget);
			}
			if (x == 69)
			{
				allWekaData69 = new Instances(label, attributes, 0);
				allWekaData69.setClass(aspectTarget);
			}
			if (x == 70)
			{
				allWekaData70 = new Instances(label, attributes, 0);
				allWekaData70.setClass(aspectTarget);
			}
			if (x == 71)
			{
				allWekaData71 = new Instances(label, attributes, 0);
				allWekaData71.setClass(aspectTarget);
			}
			if (x == 72)
			{
				allWekaData72 = new Instances(label, attributes, 0);
				allWekaData72.setClass(aspectTarget);
			}
			if (x == 73)
			{
				allWekaData73 = new Instances(label, attributes, 0);
				allWekaData73.setClass(aspectTarget);
			}
			if (x == 74)
			{
				allWekaData74 = new Instances(label, attributes, 0);
				allWekaData74.setClass(aspectTarget);
			}
			if (x == 75)
			{
				allWekaData75 = new Instances(label, attributes, 0);
				allWekaData75.setClass(aspectTarget);
			}
			if (x == 76)
			{
				allWekaData76 = new Instances(label, attributes, 0);
				allWekaData76.setClass(aspectTarget);
			}
			if (x == 77)
			{
				allWekaData77 = new Instances(label, attributes, 0);
				allWekaData77.setClass(aspectTarget);
			}
			if (x == 78)
			{
				allWekaData78 = new Instances(label, attributes, 0);
				allWekaData78.setClass(aspectTarget);
			}
			if (x == 79)
			{
				allWekaData79 = new Instances(label, attributes, 0);
				allWekaData79.setClass(aspectTarget);
			}
			if (x == 80)
			{
				allWekaData80 = new Instances(label, attributes, 0);
				allWekaData80.setClass(aspectTarget);
			}
			if (x == 81)
			{
				allWekaData81 = new Instances(label, attributes, 0);
				allWekaData81.setClass(aspectTarget);
			}
			if (x == 82)
			{
				allWekaData82 = new Instances(label, attributes, 0);
				allWekaData82.setClass(aspectTarget);
			}
			if (x == 83)
			{
				allWekaData83 = new Instances(label, attributes, 0);
				allWekaData83.setClass(aspectTarget);
			}
			if (x == 84)
			{
				allWekaData84 = new Instances(label, attributes, 0);
				allWekaData84.setClass(aspectTarget);
			}
			if (x == 85)
			{
				allWekaData85 = new Instances(label, attributes, 0);
				allWekaData85.setClass(aspectTarget);
			}
			if (x == 86)
			{
				allWekaData86 = new Instances(label, attributes, 0);
				allWekaData86.setClass(aspectTarget);
			}
			if (x == 87)
			{
				allWekaData87 = new Instances(label, attributes, 0);
				allWekaData87.setClass(aspectTarget);
			}
			if (x == 88)
			{
				allWekaData88 = new Instances(label, attributes, 0);
				allWekaData88.setClass(aspectTarget);
			}
			if (x == 89)
			{
				allWekaData89 = new Instances(label, attributes, 0);
				allWekaData89.setClass(aspectTarget);
			}
			if (x == 90)
			{
				allWekaData90 = new Instances(label, attributes, 0);
				allWekaData90.setClass(aspectTarget);
			}
			if (x == 91)
			{
				allWekaData91 = new Instances(label, attributes, 0);
				allWekaData91.setClass(aspectTarget);
			}
			if (x == 92)
			{
				allWekaData92 = new Instances(label, attributes, 0);
				allWekaData92.setClass(aspectTarget);
			}
			if (x == 93)
			{
				allWekaData93 = new Instances(label, attributes, 0);
				allWekaData93.setClass(aspectTarget);
			}
			if (x == 94)
			{
				allWekaData94 = new Instances(label, attributes, 0);
				allWekaData94.setClass(aspectTarget);
			}
			if (x == 95)
			{
				allWekaData95 = new Instances(label, attributes, 0);
				allWekaData95.setClass(aspectTarget);
			}
			if (x == 96)
			{
				allWekaData96 = new Instances(label, attributes, 0);
				allWekaData96.setClass(aspectTarget);
			}
			if (x == 97)
			{
				allWekaData97 = new Instances(label, attributes, 0);
				allWekaData97.setClass(aspectTarget);
			}
			if (x == 98)
			{
				allWekaData98 = new Instances(label, attributes, 0);
				allWekaData98.setClass(aspectTarget);
			}
			if (x == 99)
			{
				allWekaData99 = new Instances(label, attributes, 0);
				allWekaData99.setClass(aspectTarget);
			}
			if (x == 100)
			{
				allWekaData100 = new Instances(label, attributes, 0);
				allWekaData100.setClass(aspectTarget);
			}
			if (x == 101)
			{
				allWekaData101 = new Instances(label, attributes, 0);
				allWekaData101.setClass(aspectTarget);
			}
			if (x == 102)
			{
				allWekaData102 = new Instances(label, attributes, 0);
				allWekaData102.setClass(aspectTarget);
			}
			if (x == 103)
			{
				allWekaData103 = new Instances(label, attributes, 0);
				allWekaData103.setClass(aspectTarget);
			}
			if (x == 104)
			{
				allWekaData104 = new Instances(label, attributes, 0);
				allWekaData104.setClass(aspectTarget);
			}
			if (x == 105)
			{
				allWekaData105 = new Instances(label, attributes, 0);
				allWekaData105.setClass(aspectTarget);
			}
			if (x == 106)
			{
				allWekaData106 = new Instances(label, attributes, 0);
				allWekaData106.setClass(aspectTarget);
			}
			if (x == 107)
			{
				allWekaData107 = new Instances(label, attributes, 0);
				allWekaData107.setClass(aspectTarget);
			}
			if (x == 108)
			{
				allWekaData108 = new Instances(label, attributes, 0);
				allWekaData108.setClass(aspectTarget);
			}
			if (x == 109)
			{
				allWekaData109 = new Instances(label, attributes, 0);
				allWekaData109.setClass(aspectTarget);
			}
			if (x == 110)
			{
				allWekaData110 = new Instances(label, attributes, 0);
				allWekaData110.setClass(aspectTarget);
			}
			if (x == 111)
			{
				allWekaData111 = new Instances(label, attributes, 0);
				allWekaData111.setClass(aspectTarget);
			}
			if (x == 112)
			{
				allWekaData112 = new Instances(label, attributes, 0);
				allWekaData112.setClass(aspectTarget);
			}
			if (x == 113)
			{
				allWekaData113 = new Instances(label, attributes, 0);
				allWekaData113.setClass(aspectTarget);
			}
			if (x == 114)
			{
				allWekaData114 = new Instances(label, attributes, 0);
				allWekaData114.setClass(aspectTarget);
			}
			if (x == 115)
			{
				allWekaData115 = new Instances(label, attributes, 0);
				allWekaData115.setClass(aspectTarget);
			}
			if (x == 116)
			{
				allWekaData116 = new Instances(label, attributes, 0);
				allWekaData116.setClass(aspectTarget);
			}
			if (x == 117)
			{
				allWekaData117 = new Instances(label, attributes, 0);
				allWekaData117.setClass(aspectTarget);
			}
			if (x == 118)
			{
				allWekaData118 = new Instances(label, attributes, 0);
				allWekaData118.setClass(aspectTarget);
			}
			if (x == 119)
			{
				allWekaData119 = new Instances(label, attributes, 0);
				allWekaData119.setClass(aspectTarget);
			}
			if (x == 120)
			{
				allWekaData120 = new Instances(label, attributes, 0);
				allWekaData120.setClass(aspectTarget);
			}
			if (x == 121)
			{
				allWekaData121 = new Instances(label, attributes, 0);
				allWekaData121.setClass(aspectTarget);
			}
			if (x == 122)
			{
				allWekaData122 = new Instances(label, attributes, 0);
				allWekaData122.setClass(aspectTarget);
			}
			if (x == 123)
			{
				allWekaData123 = new Instances(label, attributes, 0);
				allWekaData123.setClass(aspectTarget);
			}
			if (x == 124)
			{
				allWekaData124 = new Instances(label, attributes, 0);
				allWekaData124.setClass(aspectTarget);
			}
			if (x == 125)
			{
				allWekaData125 = new Instances(label, attributes, 0);
				allWekaData125.setClass(aspectTarget);
			}
			if (x == 126)
			{
				allWekaData126 = new Instances(label, attributes, 0);
				allWekaData126.setClass(aspectTarget);
			}
			if (x == 127)
			{
				allWekaData127 = new Instances(label, attributes, 0);
				allWekaData127.setClass(aspectTarget);
			}
			if (x == 128)
			{
				allWekaData128 = new Instances(label, attributes, 0);
				allWekaData128.setClass(aspectTarget);
			}
			if (x == 129)
			{
				allWekaData129 = new Instances(label, attributes, 0);
				allWekaData129.setClass(aspectTarget);
			}
			if (x == 130)
			{
				allWekaData130 = new Instances(label, attributes, 0);
				allWekaData130.setClass(aspectTarget);
			}
			if (x == 131)
			{
				allWekaData131 = new Instances(label, attributes, 0);
				allWekaData131.setClass(aspectTarget);
			}
			if (x == 132)
			{
				allWekaData132 = new Instances(label, attributes, 0);
				allWekaData132.setClass(aspectTarget);
			}
			if (x == 133)
			{
				allWekaData133 = new Instances(label, attributes, 0);
				allWekaData133.setClass(aspectTarget);
			}
			if (x == 134)
			{
				allWekaData134 = new Instances(label, attributes, 0);
				allWekaData134.setClass(aspectTarget);
			}
			if (x == 135)
			{
				allWekaData135 = new Instances(label, attributes, 0);
				allWekaData135.setClass(aspectTarget);
			}
			if (x == 136)
			{
				allWekaData136 = new Instances(label, attributes, 0);
				allWekaData136.setClass(aspectTarget);
			}
			if (x == 137)
			{
				allWekaData137 = new Instances(label, attributes, 0);
				allWekaData137.setClass(aspectTarget);
			}
			if (x == 138)
			{
				allWekaData138 = new Instances(label, attributes, 0);
				allWekaData138.setClass(aspectTarget);
			}
			if (x == 139)
			{
				allWekaData139 = new Instances(label, attributes, 0);
				allWekaData139.setClass(aspectTarget);
			}
			if (x == 140)
			{
				allWekaData140 = new Instances(label, attributes, 0);
				allWekaData140.setClass(aspectTarget);
			}
			if (x == 141)
			{
				allWekaData141 = new Instances(label, attributes, 0);
				allWekaData141.setClass(aspectTarget);
			}
			if (x == 142)
			{
				allWekaData142 = new Instances(label, attributes, 0);
				allWekaData142.setClass(aspectTarget);
			}
			if (x == 143)
			{
				allWekaData143 = new Instances(label, attributes, 0);
				allWekaData143.setClass(aspectTarget);
			}
			if (x == 144)
			{
				allWekaData144 = new Instances(label, attributes, 0);
				allWekaData144.setClass(aspectTarget);
			}
			if (x == 145)
			{
				allWekaData145 = new Instances(label, attributes, 0);
				allWekaData145.setClass(aspectTarget);
			}
			if (x == 146)
			{
				allWekaData146 = new Instances(label, attributes, 0);
				allWekaData146.setClass(aspectTarget);
			}
			if (x == 147)
			{
				allWekaData147 = new Instances(label, attributes, 0);
				allWekaData147.setClass(aspectTarget);
			}
			if (x == 148)
			{
				allWekaData148 = new Instances(label, attributes, 0);
				allWekaData148.setClass(aspectTarget);
			}
			if (x == 149)
			{
				allWekaData149 = new Instances(label, attributes, 0);
				allWekaData149.setClass(aspectTarget);
			}
			if (x == 150)
			{
				allWekaData150 = new Instances(label, attributes, 0);
				allWekaData150.setClass(aspectTarget);
			}
			if (x == 151)
			{
				allWekaData151 = new Instances(label, attributes, 0);
				allWekaData151.setClass(aspectTarget);
			}
			if (x == 152)
			{
				allWekaData152 = new Instances(label, attributes, 0);
				allWekaData152.setClass(aspectTarget);
			}
			if (x == 153)
			{
				allWekaData153 = new Instances(label, attributes, 0);
				allWekaData153.setClass(aspectTarget);
			}
			if (x == 154)
			{
				allWekaData154 = new Instances(label, attributes, 0);
				allWekaData154.setClass(aspectTarget);
			}
			if (x == 155)
			{
				allWekaData155 = new Instances(label, attributes, 0);
				allWekaData155.setClass(aspectTarget);
			}
			if (x == 156)
			{
				allWekaData156 = new Instances(label, attributes, 0);
				allWekaData156.setClass(aspectTarget);
			}
			if (x == 157)
			{
				allWekaData157 = new Instances(label, attributes, 0);
				allWekaData157.setClass(aspectTarget);
			}
			if (x == 158)
			{
				allWekaData158 = new Instances(label, attributes, 0);
				allWekaData158.setClass(aspectTarget);
			}
			if (x == 159)
			{
				allWekaData159 = new Instances(label, attributes, 0);
				allWekaData159.setClass(aspectTarget);
			}
			if (x == 160)
			{
				allWekaData160 = new Instances(label, attributes, 0);
				allWekaData160.setClass(aspectTarget);
			}
			if (x == 161)
			{
				allWekaData161 = new Instances(label, attributes, 0);
				allWekaData161.setClass(aspectTarget);
			}
			if (x == 162)
			{
				allWekaData162 = new Instances(label, attributes, 0);
				allWekaData162.setClass(aspectTarget);
			}
			if (x == 163)
			{
				allWekaData163 = new Instances(label, attributes, 0);
				allWekaData163.setClass(aspectTarget);
			}
			if (x == 164)
			{
				allWekaData164 = new Instances(label, attributes, 0);
				allWekaData164.setClass(aspectTarget);
			}
			if (x == 165)
			{
				allWekaData165 = new Instances(label, attributes, 0);
				allWekaData165.setClass(aspectTarget);
			}
			if (x == 166)
			{
				allWekaData166 = new Instances(label, attributes, 0);
				allWekaData166.setClass(aspectTarget);
			}
			if (x == 167)
			{
				allWekaData167 = new Instances(label, attributes, 0);
				allWekaData167.setClass(aspectTarget);
			}
			if (x == 168)
			{
				allWekaData168 = new Instances(label, attributes, 0);
				allWekaData168.setClass(aspectTarget);
			}
			if (x == 169)
			{
				allWekaData169 = new Instances(label, attributes, 0);
				allWekaData169.setClass(aspectTarget);
			}
			if (x == 170)
			{
				allWekaData170 = new Instances(label, attributes, 0);
				allWekaData170.setClass(aspectTarget);
			}
			if (x == 171)
			{
				allWekaData171 = new Instances(label, attributes, 0);
				allWekaData171.setClass(aspectTarget);
			}
			if (x == 172)
			{
				allWekaData172 = new Instances(label, attributes, 0);
				allWekaData172.setClass(aspectTarget);
			}
			if (x == 173)
			{
				allWekaData173 = new Instances(label, attributes, 0);
				allWekaData173.setClass(aspectTarget);
			}
			if (x == 174)
			{
				allWekaData174 = new Instances(label, attributes, 0);
				allWekaData174.setClass(aspectTarget);
			}
			if (x == 175)
			{
				allWekaData175 = new Instances(label, attributes, 0);
				allWekaData175.setClass(aspectTarget);
			}
			if (x == 176)
			{
				allWekaData176 = new Instances(label, attributes, 0);
				allWekaData176.setClass(aspectTarget);
			}
			if (x == 177)
			{
				allWekaData177 = new Instances(label, attributes, 0);
				allWekaData177.setClass(aspectTarget);
			}
			if (x == 178)
			{
				allWekaData178 = new Instances(label, attributes, 0);
				allWekaData178.setClass(aspectTarget);
			}
			if (x == 179)
			{
				allWekaData179 = new Instances(label, attributes, 0);
				allWekaData179.setClass(aspectTarget);
			}
			if (x == 180)
			{
				allWekaData180 = new Instances(label, attributes, 0);
				allWekaData180.setClass(aspectTarget);
			}
			if (x == 181)
			{
				allWekaData181 = new Instances(label, attributes, 0);
				allWekaData181.setClass(aspectTarget);
			}
			if (x == 182)
			{
				allWekaData182 = new Instances(label, attributes, 0);
				allWekaData182.setClass(aspectTarget);
			}
			if (x == 183)
			{
				allWekaData183 = new Instances(label, attributes, 0);
				allWekaData183.setClass(aspectTarget);
			}
			if (x == 184)
			{
				allWekaData184 = new Instances(label, attributes, 0);
				allWekaData184.setClass(aspectTarget);
			}
			if (x == 185)
			{
				allWekaData185 = new Instances(label, attributes, 0);
				allWekaData185.setClass(aspectTarget);
			}
			if (x == 186)
			{
				allWekaData186 = new Instances(label, attributes, 0);
				allWekaData186.setClass(aspectTarget);
			}
			if (x == 187)
			{
				allWekaData187 = new Instances(label, attributes, 0);
				allWekaData187.setClass(aspectTarget);
			}
			if (x == 188)
			{
				allWekaData188 = new Instances(label, attributes, 0);
				allWekaData188.setClass(aspectTarget);
			}
			if (x == 189)
			{
				allWekaData189 = new Instances(label, attributes, 0);
				allWekaData189.setClass(aspectTarget);
			}
			if (x == 190)
			{
				allWekaData190 = new Instances(label, attributes, 0);
				allWekaData190.setClass(aspectTarget);
			}
			if (x == 191)
			{
				allWekaData191 = new Instances(label, attributes, 0);
				allWekaData191.setClass(aspectTarget);
			}
			if (x == 192)
			{
				allWekaData192 = new Instances(label, attributes, 0);
				allWekaData192.setClass(aspectTarget);
			}
			if (x == 193)
			{
				allWekaData193 = new Instances(label, attributes, 0);
				allWekaData193.setClass(aspectTarget);
			}
			if (x == 194)
			{
				allWekaData194 = new Instances(label, attributes, 0);
				allWekaData194.setClass(aspectTarget);
			}
			if (x == 195)
			{
				allWekaData195 = new Instances(label, attributes, 0);
				allWekaData195.setClass(aspectTarget);
			}
			if (x == 196)
			{
				allWekaData196 = new Instances(label, attributes, 0);
				allWekaData196.setClass(aspectTarget);
			}
			if (x == 197)
			{
				allWekaData197 = new Instances(label, attributes, 0);
				allWekaData197.setClass(aspectTarget);
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
				if (x == 2)
				{
					i.setDataset(allWekaData2);
				}
				if (x == 3)
				{
					i.setDataset(allWekaData3);
				}
				if (x == 4)
				{
					i.setDataset(allWekaData4);
				}
				if (x == 5)
				{
					i.setDataset(allWekaData5);
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
				if (x == 9)
				{
					i.setDataset(allWekaData9);
				}
				if (x == 10)
				{
					i.setDataset(allWekaData10);
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
				if (x == 14)
				{
					i.setDataset(allWekaData14);
				}
				if (x == 15)
				{
					i.setDataset(allWekaData15);
				}
				if (x == 16)
				{
					i.setDataset(allWekaData16);
				}
				if (x == 17)
				{
					i.setDataset(allWekaData17);
				}
				if (x == 18)
				{
					i.setDataset(allWekaData18);
				}
				if (x == 19)
				{
					i.setDataset(allWekaData19);
				}
				if (x == 20)
				{
					i.setDataset(allWekaData20);
				}
				if (x == 21)
				{
					i.setDataset(allWekaData21);
				}
				if (x == 22)
				{
					i.setDataset(allWekaData22);
				}
				if (x == 23)
				{
					i.setDataset(allWekaData23);
				}
				if (x == 24)
				{
					i.setDataset(allWekaData24);
				}
				if (x == 25)
				{
					i.setDataset(allWekaData25);
				}
				if (x == 26)
				{
					i.setDataset(allWekaData26);
				}
				if (x == 27)
				{
					i.setDataset(allWekaData27);
				}
				if (x == 28)
				{
					i.setDataset(allWekaData28);
				}
				if (x == 29)
				{
					i.setDataset(allWekaData29);
				}
				if (x == 30)
				{
					i.setDataset(allWekaData30);
				}
				if (x == 31)
				{
					i.setDataset(allWekaData31);
				}
				if (x == 32)
				{
					i.setDataset(allWekaData32);
				}
				if (x == 33)
				{
					i.setDataset(allWekaData33);
				}
				if (x == 34)
				{
					i.setDataset(allWekaData34);
				}
				if (x == 35)
				{
					i.setDataset(allWekaData35);
				}
				if (x == 36)
				{
					i.setDataset(allWekaData36);
				}
				if (x == 37)
				{
					i.setDataset(allWekaData37);
				}
				if (x == 38)
				{
					i.setDataset(allWekaData38);
				}
				if (x == 39)
				{
					i.setDataset(allWekaData39);
				}
				if (x == 40)
				{
					i.setDataset(allWekaData40);
				}
				if (x == 41)
				{
					i.setDataset(allWekaData41);
				}
				if (x == 42)
				{
					i.setDataset(allWekaData42);
				}
				if (x == 43)
				{
					i.setDataset(allWekaData43);
				}
				if (x == 44)
				{
					i.setDataset(allWekaData44);
				}
				if (x == 45)
				{
					i.setDataset(allWekaData45);
				}
				if (x == 46)
				{
					i.setDataset(allWekaData46);
				}
				if (x == 47)
				{
					i.setDataset(allWekaData47);
				}
				if (x == 48)
				{
					i.setDataset(allWekaData48);
				}
				if (x == 49)
				{
					i.setDataset(allWekaData49);
				}
				if (x == 50)
				{
					i.setDataset(allWekaData50);
				}
				if (x == 51)
				{
					i.setDataset(allWekaData51);
				}
				if (x == 52)
				{
					i.setDataset(allWekaData52);
				}
				if (x == 53)
				{
					i.setDataset(allWekaData53);
				}
				if (x == 54)
				{
					i.setDataset(allWekaData54);
				}
				if (x == 55)
				{
					i.setDataset(allWekaData55);
				}
				if (x == 56)
				{
					i.setDataset(allWekaData56);
				}
				if (x == 57)
				{
					i.setDataset(allWekaData57);
				}
				if (x == 58)
				{
					i.setDataset(allWekaData58);
				}
				if (x == 59)
				{
					i.setDataset(allWekaData59);
				}
				if (x == 60)
				{
					i.setDataset(allWekaData60);
				}
				if (x == 61)
				{
					i.setDataset(allWekaData61);
				}
				if (x == 62)
				{
					i.setDataset(allWekaData62);
				}
				if (x == 63)
				{
					i.setDataset(allWekaData63);
				}
				if (x == 64)
				{
					i.setDataset(allWekaData64);
				}
				if (x == 65)
				{
					i.setDataset(allWekaData65);
				}
				if (x == 66)
				{
					i.setDataset(allWekaData66);
				}
				if (x == 67)
				{
					i.setDataset(allWekaData67);
				}
				if (x == 68)
				{
					i.setDataset(allWekaData68);
				}
				if (x == 69)
				{
					i.setDataset(allWekaData69);
				}
				if (x == 70)
				{
					i.setDataset(allWekaData70);
				}
				if (x == 71)
				{
					i.setDataset(allWekaData71);
				}
				if (x == 72)
				{
					i.setDataset(allWekaData72);
				}
				if (x == 73)
				{
					i.setDataset(allWekaData73);
				}
				if (x == 74)
				{
					i.setDataset(allWekaData74);
				}
				if (x == 75)
				{
					i.setDataset(allWekaData75);
				}
				if (x == 76)
				{
					i.setDataset(allWekaData76);
				}
				if (x == 77)
				{
					i.setDataset(allWekaData77);
				}
				if (x == 78)
				{
					i.setDataset(allWekaData78);
				}
				if (x == 79)
				{
					i.setDataset(allWekaData79);
				}
				if (x == 80)
				{
					i.setDataset(allWekaData80);
				}
				if (x == 81)
				{
					i.setDataset(allWekaData81);
				}
				if (x == 82)
				{
					i.setDataset(allWekaData82);
				}
				if (x == 83)
				{
					i.setDataset(allWekaData83);
				}
				if (x == 84)
				{
					i.setDataset(allWekaData84);
				}
				if (x == 85)
				{
					i.setDataset(allWekaData85);
				}
				if (x == 86)
				{
					i.setDataset(allWekaData86);
				}
				if (x == 87)
				{
					i.setDataset(allWekaData87);
				}
				if (x == 88)
				{
					i.setDataset(allWekaData88);
				}
				if (x == 89)
				{
					i.setDataset(allWekaData89);
				}
				if (x == 90)
				{
					i.setDataset(allWekaData90);
				}
				if (x == 91)
				{
					i.setDataset(allWekaData91);
				}
				if (x == 92)
				{
					i.setDataset(allWekaData92);
				}
				if (x == 93)
				{
					i.setDataset(allWekaData93);
				}
				if (x == 94)
				{
					i.setDataset(allWekaData94);
				}
				if (x == 95)
				{
					i.setDataset(allWekaData95);
				}
				if (x == 96)
				{
					i.setDataset(allWekaData96);
				}
				if (x == 97)
				{
					i.setDataset(allWekaData97);
				}
				if (x == 98)
				{
					i.setDataset(allWekaData98);
				}
				if (x == 99)
				{
					i.setDataset(allWekaData99);
				}
				if (x == 100)
				{
					i.setDataset(allWekaData100);
				}
				if (x == 101)
				{
					i.setDataset(allWekaData101);
				}
				if (x == 102)
				{
					i.setDataset(allWekaData102);
				}
				if (x == 103)
				{
					i.setDataset(allWekaData103);
				}
				if (x == 104)
				{
					i.setDataset(allWekaData104);
				}
				if (x == 105)
				{
					i.setDataset(allWekaData105);
				}
				if (x == 106)
				{
					i.setDataset(allWekaData106);
				}
				if (x == 107)
				{
					i.setDataset(allWekaData107);
				}
				if (x == 108)
				{
					i.setDataset(allWekaData108);
				}
				if (x == 109)
				{
					i.setDataset(allWekaData109);
				}
				if (x == 110)
				{
					i.setDataset(allWekaData110);
				}
				if (x == 111)
				{
					i.setDataset(allWekaData111);
				}
				if (x == 112)
				{
					i.setDataset(allWekaData112);
				}
				if (x == 113)
				{
					i.setDataset(allWekaData113);
				}
				if (x == 114)
				{
					i.setDataset(allWekaData114);
				}
				if (x == 115)
				{
					i.setDataset(allWekaData115);
				}
				if (x == 116)
				{
					i.setDataset(allWekaData116);
				}
				if (x == 117)
				{
					i.setDataset(allWekaData117);
				}
				if (x == 118)
				{
					i.setDataset(allWekaData118);
				}
				if (x == 119)
				{
					i.setDataset(allWekaData119);
				}
				if (x == 120)
				{
					i.setDataset(allWekaData120);
				}
				if (x == 121)
				{
					i.setDataset(allWekaData121);
				}
				if (x == 122)
				{
					i.setDataset(allWekaData122);
				}
				if (x == 123)
				{
					i.setDataset(allWekaData123);
				}
				if (x == 124)
				{
					i.setDataset(allWekaData124);
				}
				if (x == 125)
				{
					i.setDataset(allWekaData125);
				}
				if (x == 126)
				{
					i.setDataset(allWekaData126);
				}
				if (x == 127)
				{
					i.setDataset(allWekaData127);
				}
				if (x == 128)
				{
					i.setDataset(allWekaData128);
				}
				if (x == 129)
				{
					i.setDataset(allWekaData129);
				}
				if (x == 130)
				{
					i.setDataset(allWekaData130);
				}
				if (x == 131)
				{
					i.setDataset(allWekaData131);
				}
				if (x == 132)
				{
					i.setDataset(allWekaData132);
				}
				if (x == 133)
				{
					i.setDataset(allWekaData133);
				}
				if (x == 134)
				{
					i.setDataset(allWekaData134);
				}
				if (x == 135)
				{
					i.setDataset(allWekaData135);
				}
				if (x == 136)
				{
					i.setDataset(allWekaData136);
				}
				if (x == 137)
				{
					i.setDataset(allWekaData137);
				}
				if (x == 138)
				{
					i.setDataset(allWekaData138);
				}
				if (x == 139)
				{
					i.setDataset(allWekaData139);
				}
				if (x == 140)
				{
					i.setDataset(allWekaData140);
				}
				if (x == 141)
				{
					i.setDataset(allWekaData141);
				}
				if (x == 142)
				{
					i.setDataset(allWekaData142);
				}
				if (x == 143)
				{
					i.setDataset(allWekaData143);
				}
				if (x == 144)
				{
					i.setDataset(allWekaData144);
				}
				if (x == 145)
				{
					i.setDataset(allWekaData145);
				}
				if (x == 146)
				{
					i.setDataset(allWekaData146);
				}
				if (x == 147)
				{
					i.setDataset(allWekaData147);
				}
				if (x == 148)
				{
					i.setDataset(allWekaData148);
				}
				if (x == 149)
				{
					i.setDataset(allWekaData149);
				}
				if (x == 150)
				{
					i.setDataset(allWekaData150);
				}
				if (x == 151)
				{
					i.setDataset(allWekaData151);
				}
				if (x == 152)
				{
					i.setDataset(allWekaData152);
				}
				if (x == 153)
				{
					i.setDataset(allWekaData153);
				}
				if (x == 154)
				{
					i.setDataset(allWekaData154);
				}
				if (x == 155)
				{
					i.setDataset(allWekaData155);
				}
				if (x == 156)
				{
					i.setDataset(allWekaData156);
				}
				if (x == 157)
				{
					i.setDataset(allWekaData157);
				}
				if (x == 158)
				{
					i.setDataset(allWekaData158);
				}
				if (x == 159)
				{
					i.setDataset(allWekaData159);
				}
				if (x == 160)
				{
					i.setDataset(allWekaData160);
				}
				if (x == 161)
				{
					i.setDataset(allWekaData161);
				}
				if (x == 162)
				{
					i.setDataset(allWekaData162);
				}
				if (x == 163)
				{
					i.setDataset(allWekaData163);
				}
				if (x == 164)
				{
					i.setDataset(allWekaData164);
				}
				if (x == 165)
				{
					i.setDataset(allWekaData165);
				}
				if (x == 166)
				{
					i.setDataset(allWekaData166);
				}
				if (x == 167)
				{
					i.setDataset(allWekaData167);
				}
				if (x == 168)
				{
					i.setDataset(allWekaData168);
				}
				if (x == 169)
				{
					i.setDataset(allWekaData169);
				}
				if (x == 170)
				{
					i.setDataset(allWekaData170);
				}
				if (x == 171)
				{
					i.setDataset(allWekaData171);
				}
				if (x == 172)
				{
					i.setDataset(allWekaData172);
				}
				if (x == 173)
				{
					i.setDataset(allWekaData173);
				}
				if (x == 174)
				{
					i.setDataset(allWekaData174);
				}
				if (x == 175)
				{
					i.setDataset(allWekaData175);
				}
				if (x == 176)
				{
					i.setDataset(allWekaData176);
				}
				if (x == 177)
				{
					i.setDataset(allWekaData177);
				}
				if (x == 178)
				{
					i.setDataset(allWekaData178);
				}
				if (x == 179)
				{
					i.setDataset(allWekaData179);
				}
				if (x == 180)
				{
					i.setDataset(allWekaData180);
				}
				if (x == 181)
				{
					i.setDataset(allWekaData181);
				}
				if (x == 182)
				{
					i.setDataset(allWekaData182);
				}
				if (x == 183)
				{
					i.setDataset(allWekaData183);
				}
				if (x == 184)
				{
					i.setDataset(allWekaData184);
				}
				if (x == 185)
				{
					i.setDataset(allWekaData185);
				}
				if (x == 186)
				{
					i.setDataset(allWekaData186);
				}
				if (x == 187)
				{
					i.setDataset(allWekaData187);
				}
				if (x == 188)
				{
					i.setDataset(allWekaData188);
				}
				if (x == 189)
				{
					i.setDataset(allWekaData189);
				}
				if (x == 190)
				{
					i.setDataset(allWekaData190);
				}
				if (x == 191)
				{
					i.setDataset(allWekaData191);
				}
				if (x == 192)
				{
					i.setDataset(allWekaData192);
				}
				if (x == 193)
				{
					i.setDataset(allWekaData193);
				}
				if (x == 194)
				{
					i.setDataset(allWekaData194);
				}
				if (x == 195)
				{
					i.setDataset(allWekaData195);
				}
				if (x == 196)
				{
					i.setDataset(allWekaData196);
				}
				if (x == 197)
				{
					i.setDataset(allWekaData197);
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
				
//				Framework.debug(""+i.toString());
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
				if (x == 2)
				{
					wekaInstances2.put(s, i);
					allWekaData2.add(i);
				}
				if (x == 3)
				{
					wekaInstances3.put(s, i);
					allWekaData3.add(i);
				}
				if (x == 4)
				{
					wekaInstances4.put(s, i);
					allWekaData4.add(i);
				}
				if (x == 5)
				{
					wekaInstances5.put(s, i);
					allWekaData5.add(i);
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
				if (x == 9)
				{
					wekaInstances9.put(s, i);
					allWekaData9.add(i);
				}
				if (x == 10)
				{
					wekaInstances10.put(s, i);
					allWekaData10.add(i);
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
				if (x == 14)
				{
					wekaInstances14.put(s, i);
					allWekaData14.add(i);
				}
				if (x == 15)
				{
					wekaInstances15.put(s, i);
					allWekaData15.add(i);
				}
				if (x == 16)
				{
					wekaInstances16.put(s, i);
					allWekaData16.add(i);
				}
				if (x == 17)
				{
					wekaInstances17.put(s, i);
					allWekaData17.add(i);
				}
				if (x == 18)
				{
					wekaInstances18.put(s, i);
					allWekaData18.add(i);
				}
				if (x == 19)
				{
					wekaInstances19.put(s, i);
					allWekaData19.add(i);
				}
				if (x == 20)
				{
					wekaInstances20.put(s, i);
					allWekaData20.add(i);
				}
				if (x == 21)
				{
					wekaInstances21.put(s, i);
					allWekaData21.add(i);
				}
				if (x == 22)
				{
					wekaInstances22.put(s, i);
					allWekaData22.add(i);
				}
				if (x == 23)
				{
					wekaInstances23.put(s, i);
					allWekaData23.add(i);
				}
				if (x == 24)
				{
					wekaInstances24.put(s, i);
					allWekaData24.add(i);
				}
				if (x == 25)
				{
					wekaInstances25.put(s, i);
					allWekaData25.add(i);
				}
				if (x == 26)
				{
					wekaInstances26.put(s, i);
					allWekaData26.add(i);
				}
				if (x == 27)
				{
					wekaInstances27.put(s, i);
					allWekaData27.add(i);
				}
				if (x == 28)
				{
					wekaInstances28.put(s, i);
					allWekaData28.add(i);
				}
				if (x == 29)
				{
					wekaInstances29.put(s, i);
					allWekaData29.add(i);
				}
				if (x == 30)
				{
					wekaInstances30.put(s, i);
					allWekaData30.add(i);
				}
				if (x == 31)
				{
					wekaInstances31.put(s, i);
					allWekaData31.add(i);
				}
				if (x == 32)
				{
					wekaInstances32.put(s, i);
					allWekaData32.add(i);
				}
				if (x == 33)
				{
					wekaInstances33.put(s, i);
					allWekaData33.add(i);
				}
				if (x == 34)
				{
					wekaInstances34.put(s, i);
					allWekaData34.add(i);
				}
				if (x == 35)
				{
					wekaInstances35.put(s, i);
					allWekaData35.add(i);
				}
				if (x == 36)
				{
					wekaInstances36.put(s, i);
					allWekaData36.add(i);
				}
				if (x == 37)
				{
					wekaInstances37.put(s, i);
					allWekaData37.add(i);
				}
				if (x == 38)
				{
					wekaInstances38.put(s, i);
					allWekaData38.add(i);
				}
				if (x == 39)
				{
					wekaInstances39.put(s, i);
					allWekaData39.add(i);
				}
				if (x == 40)
				{
					wekaInstances40.put(s, i);
					allWekaData40.add(i);
				}
				if (x == 41)
				{
					wekaInstances41.put(s, i);
					allWekaData41.add(i);
				}
				if (x == 42)
				{
					wekaInstances42.put(s, i);
					allWekaData42.add(i);
				}
				if (x == 43)
				{
					wekaInstances43.put(s, i);
					allWekaData43.add(i);
				}
				if (x == 44)
				{
					wekaInstances44.put(s, i);
					allWekaData44.add(i);
				}
				if (x == 45)
				{
					wekaInstances45.put(s, i);
					allWekaData45.add(i);
				}
				if (x == 46)
				{
					wekaInstances46.put(s, i);
					allWekaData46.add(i);
				}
				if (x == 47)
				{
					wekaInstances47.put(s, i);
					allWekaData47.add(i);
				}
				if (x == 48)
				{
					wekaInstances48.put(s, i);
					allWekaData48.add(i);
				}
				if (x == 49)
				{
					wekaInstances49.put(s, i);
					allWekaData49.add(i);
				}
				if (x == 50)
				{
					wekaInstances50.put(s, i);
					allWekaData50.add(i);
				}
				if (x == 51)
				{
					wekaInstances51.put(s, i);
					allWekaData51.add(i);
				}
				if (x == 52)
				{
					wekaInstances52.put(s, i);
					allWekaData52.add(i);
				}
				if (x == 53)
				{
					wekaInstances53.put(s, i);
					allWekaData53.add(i);
				}
				if (x == 54)
				{
					wekaInstances54.put(s, i);
					allWekaData54.add(i);
				}
				if (x == 55)
				{
					wekaInstances55.put(s, i);
					allWekaData55.add(i);
				}
				if (x == 56)
				{
					wekaInstances56.put(s, i);
					allWekaData56.add(i);
				}
				if (x == 57)
				{
					wekaInstances57.put(s, i);
					allWekaData57.add(i);
				}
				if (x == 58)
				{
					wekaInstances58.put(s, i);
					allWekaData58.add(i);
				}
				if (x == 59)
				{
					wekaInstances59.put(s, i);
					allWekaData59.add(i);
				}
				if (x == 60)
				{
					wekaInstances60.put(s, i);
					allWekaData60.add(i);
				}
				if (x == 61)
				{
					wekaInstances61.put(s, i);
					allWekaData61.add(i);
				}
				if (x == 62)
				{
					wekaInstances62.put(s, i);
					allWekaData62.add(i);
				}
				if (x == 63)
				{
					wekaInstances63.put(s, i);
					allWekaData63.add(i);
				}
				if (x == 64)
				{
					wekaInstances64.put(s, i);
					allWekaData64.add(i);
				}
				if (x == 65)
				{
					wekaInstances65.put(s, i);
					allWekaData65.add(i);
				}
				if (x == 66)
				{
					wekaInstances66.put(s, i);
					allWekaData66.add(i);
				}
				if (x == 67)
				{
					wekaInstances67.put(s, i);
					allWekaData67.add(i);
				}
				if (x == 68)
				{
					wekaInstances68.put(s, i);
					allWekaData68.add(i);
				}
				if (x == 69)
				{
					wekaInstances69.put(s, i);
					allWekaData69.add(i);
				}
				if (x == 70)
				{
					wekaInstances70.put(s, i);
					allWekaData70.add(i);
				}
				if (x == 71)
				{
					wekaInstances71.put(s, i);
					allWekaData71.add(i);
				}
				if (x == 72)
				{
					wekaInstances72.put(s, i);
					allWekaData72.add(i);
				}
				if (x == 73)
				{
					wekaInstances73.put(s, i);
					allWekaData73.add(i);
				}
				if (x == 74)
				{
					wekaInstances74.put(s, i);
					allWekaData74.add(i);
				}
				if (x == 75)
				{
					wekaInstances75.put(s, i);
					allWekaData75.add(i);
				}
				if (x == 76)
				{
					wekaInstances76.put(s, i);
					allWekaData76.add(i);
				}
				if (x == 77)
				{
					wekaInstances77.put(s, i);
					allWekaData77.add(i);
				}
				if (x == 78)
				{
					wekaInstances78.put(s, i);
					allWekaData78.add(i);
				}
				if (x == 79)
				{
					wekaInstances79.put(s, i);
					allWekaData79.add(i);
				}
				if (x == 80)
				{
					wekaInstances80.put(s, i);
					allWekaData80.add(i);
				}
				if (x == 81)
				{
					wekaInstances81.put(s, i);
					allWekaData81.add(i);
				}
				if (x == 82)
				{
					wekaInstances82.put(s, i);
					allWekaData82.add(i);
				}
				if (x == 83)
				{
					wekaInstances83.put(s, i);
					allWekaData83.add(i);
				}
				if (x == 84)
				{
					wekaInstances84.put(s, i);
					allWekaData84.add(i);
				}
				if (x == 85)
				{
					wekaInstances85.put(s, i);
					allWekaData85.add(i);
				}
				if (x == 86)
				{
					wekaInstances86.put(s, i);
					allWekaData86.add(i);
				}
				if (x == 87)
				{
					wekaInstances87.put(s, i);
					allWekaData87.add(i);
				}
				if (x == 88)
				{
					wekaInstances88.put(s, i);
					allWekaData88.add(i);
				}
				if (x == 89)
				{
					wekaInstances89.put(s, i);
					allWekaData89.add(i);
				}
				if (x == 90)
				{
					wekaInstances90.put(s, i);
					allWekaData90.add(i);
				}
				if (x == 91)
				{
					wekaInstances91.put(s, i);
					allWekaData91.add(i);
				}
				if (x == 92)
				{
					wekaInstances92.put(s, i);
					allWekaData92.add(i);
				}
				if (x == 93)
				{
					wekaInstances93.put(s, i);
					allWekaData93.add(i);
				}
				if (x == 94)
				{
					wekaInstances94.put(s, i);
					allWekaData94.add(i);
				}
				if (x == 95)
				{
					wekaInstances95.put(s, i);
					allWekaData95.add(i);
				}
				if (x == 96)
				{
					wekaInstances96.put(s, i);
					allWekaData96.add(i);
				}
				if (x == 97)
				{
					wekaInstances97.put(s, i);
					allWekaData97.add(i);
				}
				if (x == 98)
				{
					wekaInstances98.put(s, i);
					allWekaData98.add(i);
				}
				if (x == 99)
				{
					wekaInstances99.put(s, i);
					allWekaData99.add(i);
				}
				if (x == 100)
				{
					wekaInstances100.put(s, i);
					allWekaData100.add(i);
				}
				if (x == 101)
				{
					wekaInstances101.put(s, i);
					allWekaData101.add(i);
				}
				if (x == 102)
				{
					wekaInstances102.put(s, i);
					allWekaData102.add(i);
				}
				if (x == 103)
				{
					wekaInstances103.put(s, i);
					allWekaData103.add(i);
				}
				if (x == 104)
				{
					wekaInstances104.put(s, i);
					allWekaData104.add(i);
				}
				if (x == 105)
				{
					wekaInstances105.put(s, i);
					allWekaData105.add(i);
				}
				if (x == 106)
				{
					wekaInstances106.put(s, i);
					allWekaData106.add(i);
				}
				if (x == 107)
				{
					wekaInstances107.put(s, i);
					allWekaData107.add(i);
				}
				if (x == 108)
				{
					wekaInstances108.put(s, i);
					allWekaData108.add(i);
				}
				if (x == 109)
				{
					wekaInstances109.put(s, i);
					allWekaData109.add(i);
				}
				if (x == 110)
				{
					wekaInstances110.put(s, i);
					allWekaData110.add(i);
				}
				if (x == 111)
				{
					wekaInstances111.put(s, i);
					allWekaData111.add(i);
				}
				if (x == 112)
				{
					wekaInstances112.put(s, i);
					allWekaData112.add(i);
				}
				if (x == 113)
				{
					wekaInstances113.put(s, i);
					allWekaData113.add(i);
				}
				if (x == 114)
				{
					wekaInstances114.put(s, i);
					allWekaData114.add(i);
				}
				if (x == 115)
				{
					wekaInstances115.put(s, i);
					allWekaData115.add(i);
				}
				if (x == 116)
				{
					wekaInstances116.put(s, i);
					allWekaData116.add(i);
				}
				if (x == 117)
				{
					wekaInstances117.put(s, i);
					allWekaData117.add(i);
				}
				if (x == 118)
				{
					wekaInstances118.put(s, i);
					allWekaData118.add(i);
				}
				if (x == 119)
				{
					wekaInstances119.put(s, i);
					allWekaData119.add(i);
				}
				if (x == 120)
				{
					wekaInstances120.put(s, i);
					allWekaData120.add(i);
				}
				if (x == 121)
				{
					wekaInstances121.put(s, i);
					allWekaData121.add(i);
				}
				if (x == 122)
				{
					wekaInstances122.put(s, i);
					allWekaData122.add(i);
				}
				if (x == 123)
				{
					wekaInstances123.put(s, i);
					allWekaData123.add(i);
				}
				if (x == 124)
				{
					wekaInstances124.put(s, i);
					allWekaData124.add(i);
				}
				if (x == 125)
				{
					wekaInstances125.put(s, i);
					allWekaData125.add(i);
				}
				if (x == 126)
				{
					wekaInstances126.put(s, i);
					allWekaData126.add(i);
				}
				if (x == 127)
				{
					wekaInstances127.put(s, i);
					allWekaData127.add(i);
				}
				if (x == 128)
				{
					wekaInstances128.put(s, i);
					allWekaData128.add(i);
				}
				if (x == 129)
				{
					wekaInstances129.put(s, i);
					allWekaData129.add(i);
				}
				if (x == 130)
				{
					wekaInstances130.put(s, i);
					allWekaData130.add(i);
				}
				if (x == 131)
				{
					wekaInstances131.put(s, i);
					allWekaData131.add(i);
				}
				if (x == 132)
				{
					wekaInstances132.put(s, i);
					allWekaData132.add(i);
				}
				if (x == 133)
				{
					wekaInstances133.put(s, i);
					allWekaData133.add(i);
				}
				if (x == 134)
				{
					wekaInstances134.put(s, i);
					allWekaData134.add(i);
				}
				if (x == 135)
				{
					wekaInstances135.put(s, i);
					allWekaData135.add(i);
				}
				if (x == 136)
				{
					wekaInstances136.put(s, i);
					allWekaData136.add(i);
				}
				if (x == 137)
				{
					wekaInstances137.put(s, i);
					allWekaData137.add(i);
				}
				if (x == 138)
				{
					wekaInstances138.put(s, i);
					allWekaData138.add(i);
				}
				if (x == 139)
				{
					wekaInstances139.put(s, i);
					allWekaData139.add(i);
				}
				if (x == 140)
				{
					wekaInstances140.put(s, i);
					allWekaData140.add(i);
				}
				if (x == 141)
				{
					wekaInstances141.put(s, i);
					allWekaData141.add(i);
				}
				if (x == 142)
				{
					wekaInstances142.put(s, i);
					allWekaData142.add(i);
				}
				if (x == 143)
				{
					wekaInstances143.put(s, i);
					allWekaData143.add(i);
				}
				if (x == 144)
				{
					wekaInstances144.put(s, i);
					allWekaData144.add(i);
				}
				if (x == 145)
				{
					wekaInstances145.put(s, i);
					allWekaData145.add(i);
				}
				if (x == 146)
				{
					wekaInstances146.put(s, i);
					allWekaData146.add(i);
				}
				if (x == 147)
				{
					wekaInstances147.put(s, i);
					allWekaData147.add(i);
				}
				if (x == 148)
				{
					wekaInstances148.put(s, i);
					allWekaData148.add(i);
				}
				if (x == 149)
				{
					wekaInstances149.put(s, i);
					allWekaData149.add(i);
				}
				if (x == 150)
				{
					wekaInstances150.put(s, i);
					allWekaData150.add(i);
				}
				if (x == 151)
				{
					wekaInstances151.put(s, i);
					allWekaData151.add(i);
				}
				if (x == 152)
				{
					wekaInstances152.put(s, i);
					allWekaData152.add(i);
				}
				if (x == 153)
				{
					wekaInstances153.put(s, i);
					allWekaData153.add(i);
				}
				if (x == 154)
				{
					wekaInstances154.put(s, i);
					allWekaData154.add(i);
				}
				if (x == 155)
				{
					wekaInstances155.put(s, i);
					allWekaData155.add(i);
				}
				if (x == 156)
				{
					wekaInstances156.put(s, i);
					allWekaData156.add(i);
				}
				if (x == 157)
				{
					wekaInstances157.put(s, i);
					allWekaData157.add(i);
				}
				if (x == 158)
				{
					wekaInstances158.put(s, i);
					allWekaData158.add(i);
				}
				if (x == 159)
				{
					wekaInstances159.put(s, i);
					allWekaData159.add(i);
				}
				if (x == 160)
				{
					wekaInstances160.put(s, i);
					allWekaData160.add(i);
				}
				if (x == 161)
				{
					wekaInstances161.put(s, i);
					allWekaData161.add(i);
				}
				if (x == 162)
				{
					wekaInstances162.put(s, i);
					allWekaData162.add(i);
				}
				if (x == 163)
				{
					wekaInstances163.put(s, i);
					allWekaData163.add(i);
				}
				if (x == 164)
				{
					wekaInstances164.put(s, i);
					allWekaData164.add(i);
				}
				if (x == 165)
				{
					wekaInstances165.put(s, i);
					allWekaData165.add(i);
				}
				if (x == 166)
				{
					wekaInstances166.put(s, i);
					allWekaData166.add(i);
				}
				if (x == 167)
				{
					wekaInstances167.put(s, i);
					allWekaData167.add(i);
				}
				if (x == 168)
				{
					wekaInstances168.put(s, i);
					allWekaData168.add(i);
				}
				if (x == 169)
				{
					wekaInstances169.put(s, i);
					allWekaData169.add(i);
				}
				if (x == 170)
				{
					wekaInstances170.put(s, i);
					allWekaData170.add(i);
				}
				if (x == 171)
				{
					wekaInstances171.put(s, i);
					allWekaData171.add(i);
				}
				if (x == 172)
				{
					wekaInstances172.put(s, i);
					allWekaData172.add(i);
				}
				if (x == 173)
				{
					wekaInstances173.put(s, i);
					allWekaData173.add(i);
				}
				if (x == 174)
				{
					wekaInstances174.put(s, i);
					allWekaData174.add(i);
				}
				if (x == 175)
				{
					wekaInstances175.put(s, i);
					allWekaData175.add(i);
				}
				if (x == 176)
				{
					wekaInstances176.put(s, i);
					allWekaData176.add(i);
				}
				if (x == 177)
				{
					wekaInstances177.put(s, i);
					allWekaData177.add(i);
				}
				if (x == 178)
				{
					wekaInstances178.put(s, i);
					allWekaData178.add(i);
				}
				if (x == 179)
				{
					wekaInstances179.put(s, i);
					allWekaData179.add(i);
				}
				if (x == 180)
				{
					wekaInstances180.put(s, i);
					allWekaData180.add(i);
				}
				if (x == 181)
				{
					wekaInstances181.put(s, i);
					allWekaData181.add(i);
				}
				if (x == 182)
				{
					wekaInstances182.put(s, i);
					allWekaData182.add(i);
				}
				if (x == 183)
				{
					wekaInstances183.put(s, i);
					allWekaData183.add(i);
				}
				if (x == 184)
				{
					wekaInstances184.put(s, i);
					allWekaData184.add(i);
				}
				if (x == 185)
				{
					wekaInstances185.put(s, i);
					allWekaData185.add(i);
				}
				if (x == 186)
				{
					wekaInstances186.put(s, i);
					allWekaData186.add(i);
				}
				if (x == 187)
				{
					wekaInstances187.put(s, i);
					allWekaData187.add(i);
				}
				if (x == 188)
				{
					wekaInstances188.put(s, i);
					allWekaData188.add(i);
				}
				if (x == 189)
				{
					wekaInstances189.put(s, i);
					allWekaData189.add(i);
				}
				if (x == 190)
				{
					wekaInstances190.put(s, i);
					allWekaData190.add(i);
				}
				if (x == 191)
				{
					wekaInstances191.put(s, i);
					allWekaData191.add(i);
				}
				if (x == 192)
				{
					wekaInstances192.put(s, i);
					allWekaData192.add(i);
				}
				if (x == 193)
				{
					wekaInstances193.put(s, i);
					allWekaData193.add(i);
				}
				if (x == 194)
				{
					wekaInstances194.put(s, i);
					allWekaData194.add(i);
				}
				if (x == 195)
				{
					wekaInstances195.put(s, i);
					allWekaData195.add(i);
				}
				if (x == 196)
				{
					wekaInstances196.put(s, i);
					allWekaData196.add(i);
				}
				if (x == 197)
				{
					wekaInstances197.put(s, i);
					allWekaData197.add(i);
				}
			}
			}
//		System.exit(0);
	}

	@Override
	public void train() {
		Framework.log(getLabel() + " - Training ...");
		
		ArrayList<String> laptopAspects = ReasoningOntology.getLaptopsAspects();
		for (int x = 0; x < laptopAspects.size(); x++)
		{

		SMO model = null;
		String aspectCurrent = laptopAspects.get(x);
		Instances allWekaDataCurrent = null;
		HashMap<Span, Instance> wekaInstancesCurrent = new HashMap<>();
		Framework.log("Training " + x + ") " + aspectCurrent);
		if (x == 0)
		{
			wekaInstancesCurrent = wekaInstances0;
			allWekaDataCurrent = allWekaData0;
		}
		if (x == 1)
		{
			wekaInstancesCurrent = wekaInstances1;
			allWekaDataCurrent = allWekaData1;
		}
		if (x == 2)
		{
			wekaInstancesCurrent = wekaInstances2;
			allWekaDataCurrent = allWekaData2;
		}
		if (x == 3)
		{
			wekaInstancesCurrent = wekaInstances3;
			allWekaDataCurrent = allWekaData3;
		}
		if (x == 4)
		{
			wekaInstancesCurrent = wekaInstances4;
			allWekaDataCurrent = allWekaData4;
		}
		if (x == 5)
		{
			wekaInstancesCurrent = wekaInstances5;
			allWekaDataCurrent = allWekaData5;
		}
		if (x == 6)
		{
			wekaInstancesCurrent = wekaInstances6;
			allWekaDataCurrent = allWekaData6;
		}
		if (x == 7)
		{
			wekaInstancesCurrent = wekaInstances7;
			allWekaDataCurrent = allWekaData7;
		}
		if (x == 8)
		{
			wekaInstancesCurrent = wekaInstances8;
			allWekaDataCurrent = allWekaData8;
		}
		if (x == 9)
		{
			wekaInstancesCurrent = wekaInstances9;
			allWekaDataCurrent = allWekaData9;
		}
		if (x == 10)
		{
			wekaInstancesCurrent = wekaInstances10;
			allWekaDataCurrent = allWekaData10;
		}
		if (x == 11)
		{
			wekaInstancesCurrent = wekaInstances11;
			allWekaDataCurrent = allWekaData11;
		}
		if (x == 12)
		{
			wekaInstancesCurrent = wekaInstances12;
			allWekaDataCurrent = allWekaData12;
		}
		if (x == 13)
		{
			wekaInstancesCurrent = wekaInstances13;
			allWekaDataCurrent = allWekaData13;
		}
		if (x == 14)
		{
			wekaInstancesCurrent = wekaInstances14;
			allWekaDataCurrent = allWekaData14;
		}
		if (x == 15)
		{
			wekaInstancesCurrent = wekaInstances15;
			allWekaDataCurrent = allWekaData15;
		}
		if (x == 16)
		{
			wekaInstancesCurrent = wekaInstances16;
			allWekaDataCurrent = allWekaData16;
		}
		if (x == 17)
		{
			wekaInstancesCurrent = wekaInstances17;
			allWekaDataCurrent = allWekaData17;
		}
		if (x == 18)
		{
			wekaInstancesCurrent = wekaInstances18;
			allWekaDataCurrent = allWekaData18;
		}
		if (x == 19)
		{
			wekaInstancesCurrent = wekaInstances19;
			allWekaDataCurrent = allWekaData19;
		}
		if (x == 20)
		{
			wekaInstancesCurrent = wekaInstances20;
			allWekaDataCurrent = allWekaData20;
		}
		if (x == 21)
		{
			wekaInstancesCurrent = wekaInstances21;
			allWekaDataCurrent = allWekaData21;
		}
		if (x == 22)
		{
			wekaInstancesCurrent = wekaInstances22;
			allWekaDataCurrent = allWekaData22;
		}
		if (x == 23)
		{
			wekaInstancesCurrent = wekaInstances23;
			allWekaDataCurrent = allWekaData23;
		}
		if (x == 24)
		{
			wekaInstancesCurrent = wekaInstances24;
			allWekaDataCurrent = allWekaData24;
		}
		if (x == 25)
		{
			wekaInstancesCurrent = wekaInstances25;
			allWekaDataCurrent = allWekaData25;
		}
		if (x == 26)
		{
			wekaInstancesCurrent = wekaInstances26;
			allWekaDataCurrent = allWekaData26;
		}
		if (x == 27)
		{
			wekaInstancesCurrent = wekaInstances27;
			allWekaDataCurrent = allWekaData27;
		}
		if (x == 28)
		{
			wekaInstancesCurrent = wekaInstances28;
			allWekaDataCurrent = allWekaData28;
		}
		if (x == 29)
		{
			wekaInstancesCurrent = wekaInstances29;
			allWekaDataCurrent = allWekaData29;
		}
		if (x == 30)
		{
			wekaInstancesCurrent = wekaInstances30;
			allWekaDataCurrent = allWekaData30;
		}
		if (x == 31)
		{
			wekaInstancesCurrent = wekaInstances31;
			allWekaDataCurrent = allWekaData31;
		}
		if (x == 32)
		{
			wekaInstancesCurrent = wekaInstances32;
			allWekaDataCurrent = allWekaData32;
		}
		if (x == 33)
		{
			wekaInstancesCurrent = wekaInstances33;
			allWekaDataCurrent = allWekaData33;
		}
		if (x == 34)
		{
			wekaInstancesCurrent = wekaInstances34;
			allWekaDataCurrent = allWekaData34;
		}
		if (x == 35)
		{
			wekaInstancesCurrent = wekaInstances35;
			allWekaDataCurrent = allWekaData35;
		}
		if (x == 36)
		{
			wekaInstancesCurrent = wekaInstances36;
			allWekaDataCurrent = allWekaData36;
		}
		if (x == 37)
		{
			wekaInstancesCurrent = wekaInstances37;
			allWekaDataCurrent = allWekaData37;
		}
		if (x == 38)
		{
			wekaInstancesCurrent = wekaInstances38;
			allWekaDataCurrent = allWekaData38;
		}
		if (x == 39)
		{
			wekaInstancesCurrent = wekaInstances39;
			allWekaDataCurrent = allWekaData39;
		}
		if (x == 40)
		{
			wekaInstancesCurrent = wekaInstances40;
			allWekaDataCurrent = allWekaData40;
		}
		if (x == 41)
		{
			wekaInstancesCurrent = wekaInstances41;
			allWekaDataCurrent = allWekaData41;
		}
		if (x == 42)
		{
			wekaInstancesCurrent = wekaInstances42;
			allWekaDataCurrent = allWekaData42;
		}
		if (x == 43)
		{
			wekaInstancesCurrent = wekaInstances43;
			allWekaDataCurrent = allWekaData43;
		}
		if (x == 44)
		{
			wekaInstancesCurrent = wekaInstances44;
			allWekaDataCurrent = allWekaData44;
		}
		if (x == 45)
		{
			wekaInstancesCurrent = wekaInstances45;
			allWekaDataCurrent = allWekaData45;
		}
		if (x == 46)
		{
			wekaInstancesCurrent = wekaInstances46;
			allWekaDataCurrent = allWekaData46;
		}
		if (x == 47)
		{
			wekaInstancesCurrent = wekaInstances47;
			allWekaDataCurrent = allWekaData47;
		}
		if (x == 48)
		{
			wekaInstancesCurrent = wekaInstances48;
			allWekaDataCurrent = allWekaData48;
		}
		if (x == 49)
		{
			wekaInstancesCurrent = wekaInstances49;
			allWekaDataCurrent = allWekaData49;
		}
		if (x == 50)
		{
			wekaInstancesCurrent = wekaInstances50;
			allWekaDataCurrent = allWekaData50;
		}
		if (x == 51)
		{
			wekaInstancesCurrent = wekaInstances51;
			allWekaDataCurrent = allWekaData51;
		}
		if (x == 52)
		{
			wekaInstancesCurrent = wekaInstances52;
			allWekaDataCurrent = allWekaData52;
		}
		if (x == 53)
		{
			wekaInstancesCurrent = wekaInstances53;
			allWekaDataCurrent = allWekaData53;
		}
		if (x == 54)
		{
			wekaInstancesCurrent = wekaInstances54;
			allWekaDataCurrent = allWekaData54;
		}
		if (x == 55)
		{
			wekaInstancesCurrent = wekaInstances55;
			allWekaDataCurrent = allWekaData55;
		}
		if (x == 56)
		{
			wekaInstancesCurrent = wekaInstances56;
			allWekaDataCurrent = allWekaData56;
		}
		if (x == 57)
		{
			wekaInstancesCurrent = wekaInstances57;
			allWekaDataCurrent = allWekaData57;
		}
		if (x == 58)
		{
			wekaInstancesCurrent = wekaInstances58;
			allWekaDataCurrent = allWekaData58;
		}
		if (x == 59)
		{
			wekaInstancesCurrent = wekaInstances59;
			allWekaDataCurrent = allWekaData59;
		}
		if (x == 60)
		{
			wekaInstancesCurrent = wekaInstances60;
			allWekaDataCurrent = allWekaData60;
		}
		if (x == 61)
		{
			wekaInstancesCurrent = wekaInstances61;
			allWekaDataCurrent = allWekaData61;
		}
		if (x == 62)
		{
			wekaInstancesCurrent = wekaInstances62;
			allWekaDataCurrent = allWekaData62;
		}
		if (x == 63)
		{
			wekaInstancesCurrent = wekaInstances63;
			allWekaDataCurrent = allWekaData63;
		}
		if (x == 64)
		{
			wekaInstancesCurrent = wekaInstances64;
			allWekaDataCurrent = allWekaData64;
		}
		if (x == 65)
		{
			wekaInstancesCurrent = wekaInstances65;
			allWekaDataCurrent = allWekaData65;
		}
		if (x == 66)
		{
			wekaInstancesCurrent = wekaInstances66;
			allWekaDataCurrent = allWekaData66;
		}
		if (x == 67)
		{
			wekaInstancesCurrent = wekaInstances67;
			allWekaDataCurrent = allWekaData67;
		}
		if (x == 68)
		{
			wekaInstancesCurrent = wekaInstances68;
			allWekaDataCurrent = allWekaData68;
		}
		if (x == 69)
		{
			wekaInstancesCurrent = wekaInstances69;
			allWekaDataCurrent = allWekaData69;
		}
		if (x == 70)
		{
			wekaInstancesCurrent = wekaInstances70;
			allWekaDataCurrent = allWekaData70;
		}
		if (x == 71)
		{
			wekaInstancesCurrent = wekaInstances71;
			allWekaDataCurrent = allWekaData71;
		}
		if (x == 72)
		{
			wekaInstancesCurrent = wekaInstances72;
			allWekaDataCurrent = allWekaData72;
		}
		if (x == 73)
		{
			wekaInstancesCurrent = wekaInstances73;
			allWekaDataCurrent = allWekaData73;
		}
		if (x == 74)
		{
			wekaInstancesCurrent = wekaInstances74;
			allWekaDataCurrent = allWekaData74;
		}
		if (x == 75)
		{
			wekaInstancesCurrent = wekaInstances75;
			allWekaDataCurrent = allWekaData75;
		}
		if (x == 76)
		{
			wekaInstancesCurrent = wekaInstances76;
			allWekaDataCurrent = allWekaData76;
		}
		if (x == 77)
		{
			wekaInstancesCurrent = wekaInstances77;
			allWekaDataCurrent = allWekaData77;
		}
		if (x == 78)
		{
			wekaInstancesCurrent = wekaInstances78;
			allWekaDataCurrent = allWekaData78;
		}
		if (x == 79)
		{
			wekaInstancesCurrent = wekaInstances79;
			allWekaDataCurrent = allWekaData79;
		}
		if (x == 80)
		{
			wekaInstancesCurrent = wekaInstances80;
			allWekaDataCurrent = allWekaData80;
		}
		if (x == 81)
		{
			wekaInstancesCurrent = wekaInstances81;
			allWekaDataCurrent = allWekaData81;
		}
		if (x == 82)
		{
			wekaInstancesCurrent = wekaInstances82;
			allWekaDataCurrent = allWekaData82;
		}
		if (x == 83)
		{
			wekaInstancesCurrent = wekaInstances83;
			allWekaDataCurrent = allWekaData83;
		}
		if (x == 84)
		{
			wekaInstancesCurrent = wekaInstances84;
			allWekaDataCurrent = allWekaData84;
		}
		if (x == 85)
		{
			wekaInstancesCurrent = wekaInstances85;
			allWekaDataCurrent = allWekaData85;
		}
		if (x == 86)
		{
			wekaInstancesCurrent = wekaInstances86;
			allWekaDataCurrent = allWekaData86;
		}
		if (x == 87)
		{
			wekaInstancesCurrent = wekaInstances87;
			allWekaDataCurrent = allWekaData87;
		}
		if (x == 88)
		{
			wekaInstancesCurrent = wekaInstances88;
			allWekaDataCurrent = allWekaData88;
		}
		if (x == 89)
		{
			wekaInstancesCurrent = wekaInstances89;
			allWekaDataCurrent = allWekaData89;
		}
		if (x == 90)
		{
			wekaInstancesCurrent = wekaInstances90;
			allWekaDataCurrent = allWekaData90;
		}
		if (x == 91)
		{
			wekaInstancesCurrent = wekaInstances91;
			allWekaDataCurrent = allWekaData91;
		}
		if (x == 92)
		{
			wekaInstancesCurrent = wekaInstances92;
			allWekaDataCurrent = allWekaData92;
		}
		if (x == 93)
		{
			wekaInstancesCurrent = wekaInstances93;
			allWekaDataCurrent = allWekaData93;
		}
		if (x == 94)
		{
			wekaInstancesCurrent = wekaInstances94;
			allWekaDataCurrent = allWekaData94;
		}
		if (x == 95)
		{
			wekaInstancesCurrent = wekaInstances95;
			allWekaDataCurrent = allWekaData95;
		}
		if (x == 96)
		{
			wekaInstancesCurrent = wekaInstances96;
			allWekaDataCurrent = allWekaData96;
		}
		if (x == 97)
		{
			wekaInstancesCurrent = wekaInstances97;
			allWekaDataCurrent = allWekaData97;
		}
		if (x == 98)
		{
			wekaInstancesCurrent = wekaInstances98;
			allWekaDataCurrent = allWekaData98;
		}
		if (x == 99)
		{
			wekaInstancesCurrent = wekaInstances99;
			allWekaDataCurrent = allWekaData99;
		}
		if (x == 100)
		{
			wekaInstancesCurrent = wekaInstances100;
			allWekaDataCurrent = allWekaData100;
		}
		if (x == 101)
		{
			wekaInstancesCurrent = wekaInstances101;
			allWekaDataCurrent = allWekaData101;
		}
		if (x == 102)
		{
			wekaInstancesCurrent = wekaInstances102;
			allWekaDataCurrent = allWekaData102;
		}
		if (x == 103)
		{
			wekaInstancesCurrent = wekaInstances103;
			allWekaDataCurrent = allWekaData103;
		}
		if (x == 104)
		{
			wekaInstancesCurrent = wekaInstances104;
			allWekaDataCurrent = allWekaData104;
		}
		if (x == 105)
		{
			wekaInstancesCurrent = wekaInstances105;
			allWekaDataCurrent = allWekaData105;
		}
		if (x == 106)
		{
			wekaInstancesCurrent = wekaInstances106;
			allWekaDataCurrent = allWekaData106;
		}
		if (x == 107)
		{
			wekaInstancesCurrent = wekaInstances107;
			allWekaDataCurrent = allWekaData107;
		}
		if (x == 108)
		{
			wekaInstancesCurrent = wekaInstances108;
			allWekaDataCurrent = allWekaData108;
		}
		if (x == 109)
		{
			wekaInstancesCurrent = wekaInstances109;
			allWekaDataCurrent = allWekaData109;
		}
		if (x == 110)
		{
			wekaInstancesCurrent = wekaInstances110;
			allWekaDataCurrent = allWekaData110;
		}
		if (x == 111)
		{
			wekaInstancesCurrent = wekaInstances111;
			allWekaDataCurrent = allWekaData111;
		}
		if (x == 112)
		{
			wekaInstancesCurrent = wekaInstances112;
			allWekaDataCurrent = allWekaData112;
		}
		if (x == 113)
		{
			wekaInstancesCurrent = wekaInstances113;
			allWekaDataCurrent = allWekaData113;
		}
		if (x == 114)
		{
			wekaInstancesCurrent = wekaInstances114;
			allWekaDataCurrent = allWekaData114;
		}
		if (x == 115)
		{
			wekaInstancesCurrent = wekaInstances115;
			allWekaDataCurrent = allWekaData115;
		}
		if (x == 116)
		{
			wekaInstancesCurrent = wekaInstances116;
			allWekaDataCurrent = allWekaData116;
		}
		if (x == 117)
		{
			wekaInstancesCurrent = wekaInstances117;
			allWekaDataCurrent = allWekaData117;
		}
		if (x == 118)
		{
			wekaInstancesCurrent = wekaInstances118;
			allWekaDataCurrent = allWekaData118;
		}
		if (x == 119)
		{
			wekaInstancesCurrent = wekaInstances119;
			allWekaDataCurrent = allWekaData119;
		}
		if (x == 120)
		{
			wekaInstancesCurrent = wekaInstances120;
			allWekaDataCurrent = allWekaData120;
		}
		if (x == 121)
		{
			wekaInstancesCurrent = wekaInstances121;
			allWekaDataCurrent = allWekaData121;
		}
		if (x == 122)
		{
			wekaInstancesCurrent = wekaInstances122;
			allWekaDataCurrent = allWekaData122;
		}
		if (x == 123)
		{
			wekaInstancesCurrent = wekaInstances123;
			allWekaDataCurrent = allWekaData123;
		}
		if (x == 124)
		{
			wekaInstancesCurrent = wekaInstances124;
			allWekaDataCurrent = allWekaData124;
		}
		if (x == 125)
		{
			wekaInstancesCurrent = wekaInstances125;
			allWekaDataCurrent = allWekaData125;
		}
		if (x == 126)
		{
			wekaInstancesCurrent = wekaInstances126;
			allWekaDataCurrent = allWekaData126;
		}
		if (x == 127)
		{
			wekaInstancesCurrent = wekaInstances127;
			allWekaDataCurrent = allWekaData127;
		}
		if (x == 128)
		{
			wekaInstancesCurrent = wekaInstances128;
			allWekaDataCurrent = allWekaData128;
		}
		if (x == 129)
		{
			wekaInstancesCurrent = wekaInstances129;
			allWekaDataCurrent = allWekaData129;
		}
		if (x == 130)
		{
			wekaInstancesCurrent = wekaInstances130;
			allWekaDataCurrent = allWekaData130;
		}
		if (x == 131)
		{
			wekaInstancesCurrent = wekaInstances131;
			allWekaDataCurrent = allWekaData131;
		}
		if (x == 132)
		{
			wekaInstancesCurrent = wekaInstances132;
			allWekaDataCurrent = allWekaData132;
		}
		if (x == 133)
		{
			wekaInstancesCurrent = wekaInstances133;
			allWekaDataCurrent = allWekaData133;
		}
		if (x == 134)
		{
			wekaInstancesCurrent = wekaInstances134;
			allWekaDataCurrent = allWekaData134;
		}
		if (x == 135)
		{
			wekaInstancesCurrent = wekaInstances135;
			allWekaDataCurrent = allWekaData135;
		}
		if (x == 136)
		{
			wekaInstancesCurrent = wekaInstances136;
			allWekaDataCurrent = allWekaData136;
		}
		if (x == 137)
		{
			wekaInstancesCurrent = wekaInstances137;
			allWekaDataCurrent = allWekaData137;
		}
		if (x == 138)
		{
			wekaInstancesCurrent = wekaInstances138;
			allWekaDataCurrent = allWekaData138;
		}
		if (x == 139)
		{
			wekaInstancesCurrent = wekaInstances139;
			allWekaDataCurrent = allWekaData139;
		}
		if (x == 140)
		{
			wekaInstancesCurrent = wekaInstances140;
			allWekaDataCurrent = allWekaData140;
		}
		if (x == 141)
		{
			wekaInstancesCurrent = wekaInstances141;
			allWekaDataCurrent = allWekaData141;
		}
		if (x == 142)
		{
			wekaInstancesCurrent = wekaInstances142;
			allWekaDataCurrent = allWekaData142;
		}
		if (x == 143)
		{
			wekaInstancesCurrent = wekaInstances143;
			allWekaDataCurrent = allWekaData143;
		}
		if (x == 144)
		{
			wekaInstancesCurrent = wekaInstances144;
			allWekaDataCurrent = allWekaData144;
		}
		if (x == 145)
		{
			wekaInstancesCurrent = wekaInstances145;
			allWekaDataCurrent = allWekaData145;
		}
		if (x == 146)
		{
			wekaInstancesCurrent = wekaInstances146;
			allWekaDataCurrent = allWekaData146;
		}
		if (x == 147)
		{
			wekaInstancesCurrent = wekaInstances147;
			allWekaDataCurrent = allWekaData147;
		}
		if (x == 148)
		{
			wekaInstancesCurrent = wekaInstances148;
			allWekaDataCurrent = allWekaData148;
		}
		if (x == 149)
		{
			wekaInstancesCurrent = wekaInstances149;
			allWekaDataCurrent = allWekaData149;
		}
		if (x == 150)
		{
			wekaInstancesCurrent = wekaInstances150;
			allWekaDataCurrent = allWekaData150;
		}
		if (x == 151)
		{
			wekaInstancesCurrent = wekaInstances151;
			allWekaDataCurrent = allWekaData151;
		}
		if (x == 152)
		{
			wekaInstancesCurrent = wekaInstances152;
			allWekaDataCurrent = allWekaData152;
		}
		if (x == 153)
		{
			wekaInstancesCurrent = wekaInstances153;
			allWekaDataCurrent = allWekaData153;
		}
		if (x == 154)
		{
			wekaInstancesCurrent = wekaInstances154;
			allWekaDataCurrent = allWekaData154;
		}
		if (x == 155)
		{
			wekaInstancesCurrent = wekaInstances155;
			allWekaDataCurrent = allWekaData155;
		}
		if (x == 156)
		{
			wekaInstancesCurrent = wekaInstances156;
			allWekaDataCurrent = allWekaData156;
		}
		if (x == 157)
		{
			wekaInstancesCurrent = wekaInstances157;
			allWekaDataCurrent = allWekaData157;
		}
		if (x == 158)
		{
			wekaInstancesCurrent = wekaInstances158;
			allWekaDataCurrent = allWekaData158;
		}
		if (x == 159)
		{
			wekaInstancesCurrent = wekaInstances159;
			allWekaDataCurrent = allWekaData159;
		}
		if (x == 160)
		{
			wekaInstancesCurrent = wekaInstances160;
			allWekaDataCurrent = allWekaData160;
		}
		if (x == 161)
		{
			wekaInstancesCurrent = wekaInstances161;
			allWekaDataCurrent = allWekaData161;
		}
		if (x == 162)
		{
			wekaInstancesCurrent = wekaInstances162;
			allWekaDataCurrent = allWekaData162;
		}
		if (x == 163)
		{
			wekaInstancesCurrent = wekaInstances163;
			allWekaDataCurrent = allWekaData163;
		}
		if (x == 164)
		{
			wekaInstancesCurrent = wekaInstances164;
			allWekaDataCurrent = allWekaData164;
		}
		if (x == 165)
		{
			wekaInstancesCurrent = wekaInstances165;
			allWekaDataCurrent = allWekaData165;
		}
		if (x == 166)
		{
			wekaInstancesCurrent = wekaInstances166;
			allWekaDataCurrent = allWekaData166;
		}
		if (x == 167)
		{
			wekaInstancesCurrent = wekaInstances167;
			allWekaDataCurrent = allWekaData167;
		}
		if (x == 168)
		{
			wekaInstancesCurrent = wekaInstances168;
			allWekaDataCurrent = allWekaData168;
		}
		if (x == 169)
		{
			wekaInstancesCurrent = wekaInstances169;
			allWekaDataCurrent = allWekaData169;
		}
		if (x == 170)
		{
			wekaInstancesCurrent = wekaInstances170;
			allWekaDataCurrent = allWekaData170;
		}
		if (x == 171)
		{
			wekaInstancesCurrent = wekaInstances171;
			allWekaDataCurrent = allWekaData171;
		}
		if (x == 172)
		{
			wekaInstancesCurrent = wekaInstances172;
			allWekaDataCurrent = allWekaData172;
		}
		if (x == 173)
		{
			wekaInstancesCurrent = wekaInstances173;
			allWekaDataCurrent = allWekaData173;
		}
		if (x == 174)
		{
			wekaInstancesCurrent = wekaInstances174;
			allWekaDataCurrent = allWekaData174;
		}
		if (x == 175)
		{
			wekaInstancesCurrent = wekaInstances175;
			allWekaDataCurrent = allWekaData175;
		}
		if (x == 176)
		{
			wekaInstancesCurrent = wekaInstances176;
			allWekaDataCurrent = allWekaData176;
		}
		if (x == 177)
		{
			wekaInstancesCurrent = wekaInstances177;
			allWekaDataCurrent = allWekaData177;
		}
		if (x == 178)
		{
			wekaInstancesCurrent = wekaInstances178;
			allWekaDataCurrent = allWekaData178;
		}
		if (x == 179)
		{
			wekaInstancesCurrent = wekaInstances179;
			allWekaDataCurrent = allWekaData179;
		}
		if (x == 180)
		{
			wekaInstancesCurrent = wekaInstances180;
			allWekaDataCurrent = allWekaData180;
		}
		if (x == 181)
		{
			wekaInstancesCurrent = wekaInstances181;
			allWekaDataCurrent = allWekaData181;
		}
		if (x == 182)
		{
			wekaInstancesCurrent = wekaInstances182;
			allWekaDataCurrent = allWekaData182;
		}
		if (x == 183)
		{
			wekaInstancesCurrent = wekaInstances183;
			allWekaDataCurrent = allWekaData183;
		}
		if (x == 184)
		{
			wekaInstancesCurrent = wekaInstances184;
			allWekaDataCurrent = allWekaData184;
		}
		if (x == 185)
		{
			wekaInstancesCurrent = wekaInstances185;
			allWekaDataCurrent = allWekaData185;
		}
		if (x == 186)
		{
			wekaInstancesCurrent = wekaInstances186;
			allWekaDataCurrent = allWekaData186;
		}
		if (x == 187)
		{
			wekaInstancesCurrent = wekaInstances187;
			allWekaDataCurrent = allWekaData187;
		}
		if (x == 188)
		{
			wekaInstancesCurrent = wekaInstances188;
			allWekaDataCurrent = allWekaData188;
		}
		if (x == 189)
		{
			wekaInstancesCurrent = wekaInstances189;
			allWekaDataCurrent = allWekaData189;
		}
		if (x == 190)
		{
			wekaInstancesCurrent = wekaInstances190;
			allWekaDataCurrent = allWekaData190;
		}
		if (x == 191)
		{
			wekaInstancesCurrent = wekaInstances191;
			allWekaDataCurrent = allWekaData191;
		}
		if (x == 192)
		{
			wekaInstancesCurrent = wekaInstances192;
			allWekaDataCurrent = allWekaData192;
		}
		if (x == 193)
		{
			wekaInstancesCurrent = wekaInstances193;
			allWekaDataCurrent = allWekaData193;
		}
		if (x == 194)
		{
			wekaInstancesCurrent = wekaInstances194;
			allWekaDataCurrent = allWekaData194;
		}
		if (x == 195)
		{
			wekaInstancesCurrent = wekaInstances195;
			allWekaDataCurrent = allWekaData195;
		}
		if (x == 196)
		{
			wekaInstancesCurrent = wekaInstances196;
			allWekaDataCurrent = allWekaData196;
		}
		if (x == 197)
		{
			wekaInstancesCurrent = wekaInstances197;
			allWekaDataCurrent = allWekaData197;
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
//			model.setFilterType(new SelectedTag(SMOreg.FILTER_NONE, SMOreg.TAGS_FILTER));
			if (!hasProperty("linear"))
				model.setKernel(new RBFKernel(trainingData, 25007, Math.pow(10, bestGamma)));
			model.setC(Math.pow(10, bestC));
			
			model.buildClassifier(trainingData);
			
			SMO tempModel = (SMO) model;
			modelsList.put(aspectCurrent, tempModel);    //save model for current aspect
			
			eval = new Evaluation(trainingData);
			
			//get in-sample performance
			double[] inSamplePredictions = eval.evaluateModel(model, trainingData);
//			FastVector<NominalPrediction> stringPredictions = eval.predictions();
			ArrayList< weka.classifiers.evaluation.Prediction> stringPredictions = eval.predictions();
			for (int i = 0; i < trainingSpans.size(); i++){
				Span s = trainingSpans.get(i);
				Prediction p = new Prediction(s);
//				p.getAnnotations().put("polarity", stringPredictions.get(i).toString());
				int temp = (int) inSamplePredictions[i];
				
				if (temp == 1)
				{
					p.putAnnotation("category",  aspectCurrent);
					
					if (!this.predictions.containsKey(s))
						this.predictions.put(s, new HashSet<Prediction>());
					this.predictions.get(s).add(p);
					
				}
				//this.predictions.put(s, p.getSingletonSet());
			}
			
//			Framework.log(this.evaluate(this.getEvaluators().iterator().next(), trainingSet).getEvaluationResults());
			
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
		Framework.log(this.evaluate(this.getEvaluators().iterator().next(), getCombinedTrainingData()).getEvaluationResults());
		
		}		
		}

		

	@Override
	public void predict() {
		Framework.log(getLabel() + " - Predicting ...");
		
		ArrayList<String> laptopAspects = ReasoningOntology.getLaptopsAspects();
		for (int x = 0; x < laptopAspects.size(); x++)
		{

//		SMO model = null;
		String aspectCurrent = laptopAspects.get(x);
		Instances allWekaDataCurrent = null;
		HashMap<Span, Instance> wekaInstancesCurrent = new HashMap<>();
		Framework.log("Predicting " + x + ") " + aspectCurrent);
		if (x == 0)
		{
			wekaInstancesCurrent = wekaInstances0;
			allWekaDataCurrent = allWekaData0;
		}
		if (x == 1)
		{
			wekaInstancesCurrent = wekaInstances1;
			allWekaDataCurrent = allWekaData1;
		}
		if (x == 2)
		{
			wekaInstancesCurrent = wekaInstances2;
			allWekaDataCurrent = allWekaData2;
		}
		if (x == 3)
		{
			wekaInstancesCurrent = wekaInstances3;
			allWekaDataCurrent = allWekaData3;
		}
		if (x == 4)
		{
			wekaInstancesCurrent = wekaInstances4;
			allWekaDataCurrent = allWekaData4;
		}
		if (x == 5)
		{
			wekaInstancesCurrent = wekaInstances5;
			allWekaDataCurrent = allWekaData5;
		}
		if (x == 6)
		{
			wekaInstancesCurrent = wekaInstances6;
			allWekaDataCurrent = allWekaData6;
		}
		if (x == 7)
		{
			wekaInstancesCurrent = wekaInstances7;
			allWekaDataCurrent = allWekaData7;
		}
		if (x == 8)
		{
			wekaInstancesCurrent = wekaInstances8;
			allWekaDataCurrent = allWekaData8;
		}
		if (x == 9)
		{
			wekaInstancesCurrent = wekaInstances9;
			allWekaDataCurrent = allWekaData9;
		}
		if (x == 10)
		{
			wekaInstancesCurrent = wekaInstances10;
			allWekaDataCurrent = allWekaData10;
		}
		if (x == 11)
		{
			wekaInstancesCurrent = wekaInstances11;
			allWekaDataCurrent = allWekaData11;
		}
		if (x == 12)
		{
			wekaInstancesCurrent = wekaInstances12;
			allWekaDataCurrent = allWekaData12;
		}
		if (x == 13)
		{
			wekaInstancesCurrent = wekaInstances13;
			allWekaDataCurrent = allWekaData13;
		}
		if (x == 14)
		{
			wekaInstancesCurrent = wekaInstances14;
			allWekaDataCurrent = allWekaData14;
		}
		if (x == 15)
		{
			wekaInstancesCurrent = wekaInstances15;
			allWekaDataCurrent = allWekaData15;
		}
		if (x == 16)
		{
			wekaInstancesCurrent = wekaInstances16;
			allWekaDataCurrent = allWekaData16;
		}
		if (x == 17)
		{
			wekaInstancesCurrent = wekaInstances17;
			allWekaDataCurrent = allWekaData17;
		}
		if (x == 18)
		{
			wekaInstancesCurrent = wekaInstances18;
			allWekaDataCurrent = allWekaData18;
		}
		if (x == 19)
		{
			wekaInstancesCurrent = wekaInstances19;
			allWekaDataCurrent = allWekaData19;
		}
		if (x == 20)
		{
			wekaInstancesCurrent = wekaInstances20;
			allWekaDataCurrent = allWekaData20;
		}
		if (x == 21)
		{
			wekaInstancesCurrent = wekaInstances21;
			allWekaDataCurrent = allWekaData21;
		}
		if (x == 22)
		{
			wekaInstancesCurrent = wekaInstances22;
			allWekaDataCurrent = allWekaData22;
		}
		if (x == 23)
		{
			wekaInstancesCurrent = wekaInstances23;
			allWekaDataCurrent = allWekaData23;
		}
		if (x == 24)
		{
			wekaInstancesCurrent = wekaInstances24;
			allWekaDataCurrent = allWekaData24;
		}
		if (x == 25)
		{
			wekaInstancesCurrent = wekaInstances25;
			allWekaDataCurrent = allWekaData25;
		}
		if (x == 26)
		{
			wekaInstancesCurrent = wekaInstances26;
			allWekaDataCurrent = allWekaData26;
		}
		if (x == 27)
		{
			wekaInstancesCurrent = wekaInstances27;
			allWekaDataCurrent = allWekaData27;
		}
		if (x == 28)
		{
			wekaInstancesCurrent = wekaInstances28;
			allWekaDataCurrent = allWekaData28;
		}
		if (x == 29)
		{
			wekaInstancesCurrent = wekaInstances29;
			allWekaDataCurrent = allWekaData29;
		}
		if (x == 30)
		{
			wekaInstancesCurrent = wekaInstances30;
			allWekaDataCurrent = allWekaData30;
		}
		if (x == 31)
		{
			wekaInstancesCurrent = wekaInstances31;
			allWekaDataCurrent = allWekaData31;
		}
		if (x == 32)
		{
			wekaInstancesCurrent = wekaInstances32;
			allWekaDataCurrent = allWekaData32;
		}
		if (x == 33)
		{
			wekaInstancesCurrent = wekaInstances33;
			allWekaDataCurrent = allWekaData33;
		}
		if (x == 34)
		{
			wekaInstancesCurrent = wekaInstances34;
			allWekaDataCurrent = allWekaData34;
		}
		if (x == 35)
		{
			wekaInstancesCurrent = wekaInstances35;
			allWekaDataCurrent = allWekaData35;
		}
		if (x == 36)
		{
			wekaInstancesCurrent = wekaInstances36;
			allWekaDataCurrent = allWekaData36;
		}
		if (x == 37)
		{
			wekaInstancesCurrent = wekaInstances37;
			allWekaDataCurrent = allWekaData37;
		}
		if (x == 38)
		{
			wekaInstancesCurrent = wekaInstances38;
			allWekaDataCurrent = allWekaData38;
		}
		if (x == 39)
		{
			wekaInstancesCurrent = wekaInstances39;
			allWekaDataCurrent = allWekaData39;
		}
		if (x == 40)
		{
			wekaInstancesCurrent = wekaInstances40;
			allWekaDataCurrent = allWekaData40;
		}
		if (x == 41)
		{
			wekaInstancesCurrent = wekaInstances41;
			allWekaDataCurrent = allWekaData41;
		}
		if (x == 42)
		{
			wekaInstancesCurrent = wekaInstances42;
			allWekaDataCurrent = allWekaData42;
		}
		if (x == 43)
		{
			wekaInstancesCurrent = wekaInstances43;
			allWekaDataCurrent = allWekaData43;
		}
		if (x == 44)
		{
			wekaInstancesCurrent = wekaInstances44;
			allWekaDataCurrent = allWekaData44;
		}
		if (x == 45)
		{
			wekaInstancesCurrent = wekaInstances45;
			allWekaDataCurrent = allWekaData45;
		}
		if (x == 46)
		{
			wekaInstancesCurrent = wekaInstances46;
			allWekaDataCurrent = allWekaData46;
		}
		if (x == 47)
		{
			wekaInstancesCurrent = wekaInstances47;
			allWekaDataCurrent = allWekaData47;
		}
		if (x == 48)
		{
			wekaInstancesCurrent = wekaInstances48;
			allWekaDataCurrent = allWekaData48;
		}
		if (x == 49)
		{
			wekaInstancesCurrent = wekaInstances49;
			allWekaDataCurrent = allWekaData49;
		}
		if (x == 50)
		{
			wekaInstancesCurrent = wekaInstances50;
			allWekaDataCurrent = allWekaData50;
		}
		if (x == 51)
		{
			wekaInstancesCurrent = wekaInstances51;
			allWekaDataCurrent = allWekaData51;
		}
		if (x == 52)
		{
			wekaInstancesCurrent = wekaInstances52;
			allWekaDataCurrent = allWekaData52;
		}
		if (x == 53)
		{
			wekaInstancesCurrent = wekaInstances53;
			allWekaDataCurrent = allWekaData53;
		}
		if (x == 54)
		{
			wekaInstancesCurrent = wekaInstances54;
			allWekaDataCurrent = allWekaData54;
		}
		if (x == 55)
		{
			wekaInstancesCurrent = wekaInstances55;
			allWekaDataCurrent = allWekaData55;
		}
		if (x == 56)
		{
			wekaInstancesCurrent = wekaInstances56;
			allWekaDataCurrent = allWekaData56;
		}
		if (x == 57)
		{
			wekaInstancesCurrent = wekaInstances57;
			allWekaDataCurrent = allWekaData57;
		}
		if (x == 58)
		{
			wekaInstancesCurrent = wekaInstances58;
			allWekaDataCurrent = allWekaData58;
		}
		if (x == 59)
		{
			wekaInstancesCurrent = wekaInstances59;
			allWekaDataCurrent = allWekaData59;
		}
		if (x == 60)
		{
			wekaInstancesCurrent = wekaInstances60;
			allWekaDataCurrent = allWekaData60;
		}
		if (x == 61)
		{
			wekaInstancesCurrent = wekaInstances61;
			allWekaDataCurrent = allWekaData61;
		}
		if (x == 62)
		{
			wekaInstancesCurrent = wekaInstances62;
			allWekaDataCurrent = allWekaData62;
		}
		if (x == 63)
		{
			wekaInstancesCurrent = wekaInstances63;
			allWekaDataCurrent = allWekaData63;
		}
		if (x == 64)
		{
			wekaInstancesCurrent = wekaInstances64;
			allWekaDataCurrent = allWekaData64;
		}
		if (x == 65)
		{
			wekaInstancesCurrent = wekaInstances65;
			allWekaDataCurrent = allWekaData65;
		}
		if (x == 66)
		{
			wekaInstancesCurrent = wekaInstances66;
			allWekaDataCurrent = allWekaData66;
		}
		if (x == 67)
		{
			wekaInstancesCurrent = wekaInstances67;
			allWekaDataCurrent = allWekaData67;
		}
		if (x == 68)
		{
			wekaInstancesCurrent = wekaInstances68;
			allWekaDataCurrent = allWekaData68;
		}
		if (x == 69)
		{
			wekaInstancesCurrent = wekaInstances69;
			allWekaDataCurrent = allWekaData69;
		}
		if (x == 70)
		{
			wekaInstancesCurrent = wekaInstances70;
			allWekaDataCurrent = allWekaData70;
		}
		if (x == 71)
		{
			wekaInstancesCurrent = wekaInstances71;
			allWekaDataCurrent = allWekaData71;
		}
		if (x == 72)
		{
			wekaInstancesCurrent = wekaInstances72;
			allWekaDataCurrent = allWekaData72;
		}
		if (x == 73)
		{
			wekaInstancesCurrent = wekaInstances73;
			allWekaDataCurrent = allWekaData73;
		}
		if (x == 74)
		{
			wekaInstancesCurrent = wekaInstances74;
			allWekaDataCurrent = allWekaData74;
		}
		if (x == 75)
		{
			wekaInstancesCurrent = wekaInstances75;
			allWekaDataCurrent = allWekaData75;
		}
		if (x == 76)
		{
			wekaInstancesCurrent = wekaInstances76;
			allWekaDataCurrent = allWekaData76;
		}
		if (x == 77)
		{
			wekaInstancesCurrent = wekaInstances77;
			allWekaDataCurrent = allWekaData77;
		}
		if (x == 78)
		{
			wekaInstancesCurrent = wekaInstances78;
			allWekaDataCurrent = allWekaData78;
		}
		if (x == 79)
		{
			wekaInstancesCurrent = wekaInstances79;
			allWekaDataCurrent = allWekaData79;
		}
		if (x == 80)
		{
			wekaInstancesCurrent = wekaInstances80;
			allWekaDataCurrent = allWekaData80;
		}
		if (x == 81)
		{
			wekaInstancesCurrent = wekaInstances81;
			allWekaDataCurrent = allWekaData81;
		}
		if (x == 82)
		{
			wekaInstancesCurrent = wekaInstances82;
			allWekaDataCurrent = allWekaData82;
		}
		if (x == 83)
		{
			wekaInstancesCurrent = wekaInstances83;
			allWekaDataCurrent = allWekaData83;
		}
		if (x == 84)
		{
			wekaInstancesCurrent = wekaInstances84;
			allWekaDataCurrent = allWekaData84;
		}
		if (x == 85)
		{
			wekaInstancesCurrent = wekaInstances85;
			allWekaDataCurrent = allWekaData85;
		}
		if (x == 86)
		{
			wekaInstancesCurrent = wekaInstances86;
			allWekaDataCurrent = allWekaData86;
		}
		if (x == 87)
		{
			wekaInstancesCurrent = wekaInstances87;
			allWekaDataCurrent = allWekaData87;
		}
		if (x == 88)
		{
			wekaInstancesCurrent = wekaInstances88;
			allWekaDataCurrent = allWekaData88;
		}
		if (x == 89)
		{
			wekaInstancesCurrent = wekaInstances89;
			allWekaDataCurrent = allWekaData89;
		}
		if (x == 90)
		{
			wekaInstancesCurrent = wekaInstances90;
			allWekaDataCurrent = allWekaData90;
		}
		if (x == 91)
		{
			wekaInstancesCurrent = wekaInstances91;
			allWekaDataCurrent = allWekaData91;
		}
		if (x == 92)
		{
			wekaInstancesCurrent = wekaInstances92;
			allWekaDataCurrent = allWekaData92;
		}
		if (x == 93)
		{
			wekaInstancesCurrent = wekaInstances93;
			allWekaDataCurrent = allWekaData93;
		}
		if (x == 94)
		{
			wekaInstancesCurrent = wekaInstances94;
			allWekaDataCurrent = allWekaData94;
		}
		if (x == 95)
		{
			wekaInstancesCurrent = wekaInstances95;
			allWekaDataCurrent = allWekaData95;
		}
		if (x == 96)
		{
			wekaInstancesCurrent = wekaInstances96;
			allWekaDataCurrent = allWekaData96;
		}
		if (x == 97)
		{
			wekaInstancesCurrent = wekaInstances97;
			allWekaDataCurrent = allWekaData97;
		}
		if (x == 98)
		{
			wekaInstancesCurrent = wekaInstances98;
			allWekaDataCurrent = allWekaData98;
		}
		if (x == 99)
		{
			wekaInstancesCurrent = wekaInstances99;
			allWekaDataCurrent = allWekaData99;
		}
		if (x == 100)
		{
			wekaInstancesCurrent = wekaInstances100;
			allWekaDataCurrent = allWekaData100;
		}
		if (x == 101)
		{
			wekaInstancesCurrent = wekaInstances101;
			allWekaDataCurrent = allWekaData101;
		}
		if (x == 102)
		{
			wekaInstancesCurrent = wekaInstances102;
			allWekaDataCurrent = allWekaData102;
		}
		if (x == 103)
		{
			wekaInstancesCurrent = wekaInstances103;
			allWekaDataCurrent = allWekaData103;
		}
		if (x == 104)
		{
			wekaInstancesCurrent = wekaInstances104;
			allWekaDataCurrent = allWekaData104;
		}
		if (x == 105)
		{
			wekaInstancesCurrent = wekaInstances105;
			allWekaDataCurrent = allWekaData105;
		}
		if (x == 106)
		{
			wekaInstancesCurrent = wekaInstances106;
			allWekaDataCurrent = allWekaData106;
		}
		if (x == 107)
		{
			wekaInstancesCurrent = wekaInstances107;
			allWekaDataCurrent = allWekaData107;
		}
		if (x == 108)
		{
			wekaInstancesCurrent = wekaInstances108;
			allWekaDataCurrent = allWekaData108;
		}
		if (x == 109)
		{
			wekaInstancesCurrent = wekaInstances109;
			allWekaDataCurrent = allWekaData109;
		}
		if (x == 110)
		{
			wekaInstancesCurrent = wekaInstances110;
			allWekaDataCurrent = allWekaData110;
		}
		if (x == 111)
		{
			wekaInstancesCurrent = wekaInstances111;
			allWekaDataCurrent = allWekaData111;
		}
		if (x == 112)
		{
			wekaInstancesCurrent = wekaInstances112;
			allWekaDataCurrent = allWekaData112;
		}
		if (x == 113)
		{
			wekaInstancesCurrent = wekaInstances113;
			allWekaDataCurrent = allWekaData113;
		}
		if (x == 114)
		{
			wekaInstancesCurrent = wekaInstances114;
			allWekaDataCurrent = allWekaData114;
		}
		if (x == 115)
		{
			wekaInstancesCurrent = wekaInstances115;
			allWekaDataCurrent = allWekaData115;
		}
		if (x == 116)
		{
			wekaInstancesCurrent = wekaInstances116;
			allWekaDataCurrent = allWekaData116;
		}
		if (x == 117)
		{
			wekaInstancesCurrent = wekaInstances117;
			allWekaDataCurrent = allWekaData117;
		}
		if (x == 118)
		{
			wekaInstancesCurrent = wekaInstances118;
			allWekaDataCurrent = allWekaData118;
		}
		if (x == 119)
		{
			wekaInstancesCurrent = wekaInstances119;
			allWekaDataCurrent = allWekaData119;
		}
		if (x == 120)
		{
			wekaInstancesCurrent = wekaInstances120;
			allWekaDataCurrent = allWekaData120;
		}
		if (x == 121)
		{
			wekaInstancesCurrent = wekaInstances121;
			allWekaDataCurrent = allWekaData121;
		}
		if (x == 122)
		{
			wekaInstancesCurrent = wekaInstances122;
			allWekaDataCurrent = allWekaData122;
		}
		if (x == 123)
		{
			wekaInstancesCurrent = wekaInstances123;
			allWekaDataCurrent = allWekaData123;
		}
		if (x == 124)
		{
			wekaInstancesCurrent = wekaInstances124;
			allWekaDataCurrent = allWekaData124;
		}
		if (x == 125)
		{
			wekaInstancesCurrent = wekaInstances125;
			allWekaDataCurrent = allWekaData125;
		}
		if (x == 126)
		{
			wekaInstancesCurrent = wekaInstances126;
			allWekaDataCurrent = allWekaData126;
		}
		if (x == 127)
		{
			wekaInstancesCurrent = wekaInstances127;
			allWekaDataCurrent = allWekaData127;
		}
		if (x == 128)
		{
			wekaInstancesCurrent = wekaInstances128;
			allWekaDataCurrent = allWekaData128;
		}
		if (x == 129)
		{
			wekaInstancesCurrent = wekaInstances129;
			allWekaDataCurrent = allWekaData129;
		}
		if (x == 130)
		{
			wekaInstancesCurrent = wekaInstances130;
			allWekaDataCurrent = allWekaData130;
		}
		if (x == 131)
		{
			wekaInstancesCurrent = wekaInstances131;
			allWekaDataCurrent = allWekaData131;
		}
		if (x == 132)
		{
			wekaInstancesCurrent = wekaInstances132;
			allWekaDataCurrent = allWekaData132;
		}
		if (x == 133)
		{
			wekaInstancesCurrent = wekaInstances133;
			allWekaDataCurrent = allWekaData133;
		}
		if (x == 134)
		{
			wekaInstancesCurrent = wekaInstances134;
			allWekaDataCurrent = allWekaData134;
		}
		if (x == 135)
		{
			wekaInstancesCurrent = wekaInstances135;
			allWekaDataCurrent = allWekaData135;
		}
		if (x == 136)
		{
			wekaInstancesCurrent = wekaInstances136;
			allWekaDataCurrent = allWekaData136;
		}
		if (x == 137)
		{
			wekaInstancesCurrent = wekaInstances137;
			allWekaDataCurrent = allWekaData137;
		}
		if (x == 138)
		{
			wekaInstancesCurrent = wekaInstances138;
			allWekaDataCurrent = allWekaData138;
		}
		if (x == 139)
		{
			wekaInstancesCurrent = wekaInstances139;
			allWekaDataCurrent = allWekaData139;
		}
		if (x == 140)
		{
			wekaInstancesCurrent = wekaInstances140;
			allWekaDataCurrent = allWekaData140;
		}
		if (x == 141)
		{
			wekaInstancesCurrent = wekaInstances141;
			allWekaDataCurrent = allWekaData141;
		}
		if (x == 142)
		{
			wekaInstancesCurrent = wekaInstances142;
			allWekaDataCurrent = allWekaData142;
		}
		if (x == 143)
		{
			wekaInstancesCurrent = wekaInstances143;
			allWekaDataCurrent = allWekaData143;
		}
		if (x == 144)
		{
			wekaInstancesCurrent = wekaInstances144;
			allWekaDataCurrent = allWekaData144;
		}
		if (x == 145)
		{
			wekaInstancesCurrent = wekaInstances145;
			allWekaDataCurrent = allWekaData145;
		}
		if (x == 146)
		{
			wekaInstancesCurrent = wekaInstances146;
			allWekaDataCurrent = allWekaData146;
		}
		if (x == 147)
		{
			wekaInstancesCurrent = wekaInstances147;
			allWekaDataCurrent = allWekaData147;
		}
		if (x == 148)
		{
			wekaInstancesCurrent = wekaInstances148;
			allWekaDataCurrent = allWekaData148;
		}
		if (x == 149)
		{
			wekaInstancesCurrent = wekaInstances149;
			allWekaDataCurrent = allWekaData149;
		}
		if (x == 150)
		{
			wekaInstancesCurrent = wekaInstances150;
			allWekaDataCurrent = allWekaData150;
		}
		if (x == 151)
		{
			wekaInstancesCurrent = wekaInstances151;
			allWekaDataCurrent = allWekaData151;
		}
		if (x == 152)
		{
			wekaInstancesCurrent = wekaInstances152;
			allWekaDataCurrent = allWekaData152;
		}
		if (x == 153)
		{
			wekaInstancesCurrent = wekaInstances153;
			allWekaDataCurrent = allWekaData153;
		}
		if (x == 154)
		{
			wekaInstancesCurrent = wekaInstances154;
			allWekaDataCurrent = allWekaData154;
		}
		if (x == 155)
		{
			wekaInstancesCurrent = wekaInstances155;
			allWekaDataCurrent = allWekaData155;
		}
		if (x == 156)
		{
			wekaInstancesCurrent = wekaInstances156;
			allWekaDataCurrent = allWekaData156;
		}
		if (x == 157)
		{
			wekaInstancesCurrent = wekaInstances157;
			allWekaDataCurrent = allWekaData157;
		}
		if (x == 158)
		{
			wekaInstancesCurrent = wekaInstances158;
			allWekaDataCurrent = allWekaData158;
		}
		if (x == 159)
		{
			wekaInstancesCurrent = wekaInstances159;
			allWekaDataCurrent = allWekaData159;
		}
		if (x == 160)
		{
			wekaInstancesCurrent = wekaInstances160;
			allWekaDataCurrent = allWekaData160;
		}
		if (x == 161)
		{
			wekaInstancesCurrent = wekaInstances161;
			allWekaDataCurrent = allWekaData161;
		}
		if (x == 162)
		{
			wekaInstancesCurrent = wekaInstances162;
			allWekaDataCurrent = allWekaData162;
		}
		if (x == 163)
		{
			wekaInstancesCurrent = wekaInstances163;
			allWekaDataCurrent = allWekaData163;
		}
		if (x == 164)
		{
			wekaInstancesCurrent = wekaInstances164;
			allWekaDataCurrent = allWekaData164;
		}
		if (x == 165)
		{
			wekaInstancesCurrent = wekaInstances165;
			allWekaDataCurrent = allWekaData165;
		}
		if (x == 166)
		{
			wekaInstancesCurrent = wekaInstances166;
			allWekaDataCurrent = allWekaData166;
		}
		if (x == 167)
		{
			wekaInstancesCurrent = wekaInstances167;
			allWekaDataCurrent = allWekaData167;
		}
		if (x == 168)
		{
			wekaInstancesCurrent = wekaInstances168;
			allWekaDataCurrent = allWekaData168;
		}
		if (x == 169)
		{
			wekaInstancesCurrent = wekaInstances169;
			allWekaDataCurrent = allWekaData169;
		}
		if (x == 170)
		{
			wekaInstancesCurrent = wekaInstances170;
			allWekaDataCurrent = allWekaData170;
		}
		if (x == 171)
		{
			wekaInstancesCurrent = wekaInstances171;
			allWekaDataCurrent = allWekaData171;
		}
		if (x == 172)
		{
			wekaInstancesCurrent = wekaInstances172;
			allWekaDataCurrent = allWekaData172;
		}
		if (x == 173)
		{
			wekaInstancesCurrent = wekaInstances173;
			allWekaDataCurrent = allWekaData173;
		}
		if (x == 174)
		{
			wekaInstancesCurrent = wekaInstances174;
			allWekaDataCurrent = allWekaData174;
		}
		if (x == 175)
		{
			wekaInstancesCurrent = wekaInstances175;
			allWekaDataCurrent = allWekaData175;
		}
		if (x == 176)
		{
			wekaInstancesCurrent = wekaInstances176;
			allWekaDataCurrent = allWekaData176;
		}
		if (x == 177)
		{
			wekaInstancesCurrent = wekaInstances177;
			allWekaDataCurrent = allWekaData177;
		}
		if (x == 178)
		{
			wekaInstancesCurrent = wekaInstances178;
			allWekaDataCurrent = allWekaData178;
		}
		if (x == 179)
		{
			wekaInstancesCurrent = wekaInstances179;
			allWekaDataCurrent = allWekaData179;
		}
		if (x == 180)
		{
			wekaInstancesCurrent = wekaInstances180;
			allWekaDataCurrent = allWekaData180;
		}
		if (x == 181)
		{
			wekaInstancesCurrent = wekaInstances181;
			allWekaDataCurrent = allWekaData181;
		}
		if (x == 182)
		{
			wekaInstancesCurrent = wekaInstances182;
			allWekaDataCurrent = allWekaData182;
		}
		if (x == 183)
		{
			wekaInstancesCurrent = wekaInstances183;
			allWekaDataCurrent = allWekaData183;
		}
		if (x == 184)
		{
			wekaInstancesCurrent = wekaInstances184;
			allWekaDataCurrent = allWekaData184;
		}
		if (x == 185)
		{
			wekaInstancesCurrent = wekaInstances185;
			allWekaDataCurrent = allWekaData185;
		}
		if (x == 186)
		{
			wekaInstancesCurrent = wekaInstances186;
			allWekaDataCurrent = allWekaData186;
		}
		if (x == 187)
		{
			wekaInstancesCurrent = wekaInstances187;
			allWekaDataCurrent = allWekaData187;
		}
		if (x == 188)
		{
			wekaInstancesCurrent = wekaInstances188;
			allWekaDataCurrent = allWekaData188;
		}
		if (x == 189)
		{
			wekaInstancesCurrent = wekaInstances189;
			allWekaDataCurrent = allWekaData189;
		}
		if (x == 190)
		{
			wekaInstancesCurrent = wekaInstances190;
			allWekaDataCurrent = allWekaData190;
		}
		if (x == 191)
		{
			wekaInstancesCurrent = wekaInstances191;
			allWekaDataCurrent = allWekaData191;
		}
		if (x == 192)
		{
			wekaInstancesCurrent = wekaInstances192;
			allWekaDataCurrent = allWekaData192;
		}
		if (x == 193)
		{
			wekaInstancesCurrent = wekaInstances193;
			allWekaDataCurrent = allWekaData193;
		}
		if (x == 194)
		{
			wekaInstancesCurrent = wekaInstances194;
			allWekaDataCurrent = allWekaData194;
		}
		if (x == 195)
		{
			wekaInstancesCurrent = wekaInstances195;
			allWekaDataCurrent = allWekaData195;
		}
		if (x == 196)
		{
			wekaInstancesCurrent = wekaInstances196;
			allWekaDataCurrent = allWekaData196;
		}
		if (x == 197)
		{
			wekaInstancesCurrent = wekaInstances197;
			allWekaDataCurrent = allWekaData197;
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
//				Main.debug(""+stringPredictions.get(i).actual() + "\t" + stringPredictions.get(i).predicted() + "\t" + predictions[i]);
//				p.getAnnotations().put("polarity", stringPredictions.get(i).toString());
				int temp = (int) predictions[i];
				if (temp == 1)
				{
					p.putAnnotation("category",  aspectCurrent);
					if (!this.predictions.containsKey(s))
						this.predictions.put(s, new HashSet<Prediction>());
					this.predictions.get(s).add(p);
				}
				//this.predictions.put(s, p.getSingletonSet());
			}
			
//			Framework.log(this.evaluate(this.getEvaluators().iterator().next(), TestSet).getEvaluationResults());

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
//		distance = Math.max(distance, 0.25);
//		
//		distance = distance > 1 ? 0.0 : 1.0;
		
//		distance = Math.max(0.0,1.0 - distance / 3.0);
		
		return distance;
	}
	
	public double getWordDistanceWeight(Word source, Word w){
		double distance = Math.abs(source.getOrder() - w.getOrder());
		distance = distance > 4 ? 0.25 : 1.0;
//		distance = 1.0 / Math.max(1.0,distance);
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
    		//Span review = getReview(sentence);            
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
