package com.test.hadoop.mahout;
import java.io.File;
import java.io.IOException;
import java.util.List;


import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.IRStatistics;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.eval.RecommenderIRStatsEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.GenericRecommenderIRStatsEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

public class ItemCFByLocalData {
	public static void main(String[] args) throws TasteException, IOException {
    	String path = UserCFByLocalData.class.getClassLoader().getResource("").getPath();
    	
        String file = path + "datafile/item.csv";
		File  modelFile = new File(file);
		 
		DataModel model = new FileDataModel(modelFile);
		 
		// Build the same recommender for testing that we did last time(为测试构建与上次相同的推荐程序：):
		RecommenderBuilder recommenderBuilder = new RecommenderBuilder() {
		    @Override
		    public Recommender buildRecommender(DataModel model) throws TasteException {
		        ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);
		        return new GenericItemBasedRecommender(model, similarity);
		    }
		};
		 
		//获取推荐结果
		List<RecommendedItem> recommendations = recommenderBuilder.buildRecommender(model).recommend(1, 4);
		 
		for (RecommendedItem recommendation : recommendations) {
		    System.out.println(recommendation);
		}
		 
		//计算评分
		RecommenderEvaluator evaluator =
		        new AverageAbsoluteDifferenceRecommenderEvaluator();
		// Use 70% of the data to train; test using the other 30%.(使用70%的数据进行培训；使用其他30%的数据进行测试。)
		double score = evaluator.evaluate(recommenderBuilder, null, model, 0.7, 1.0);
		System.out.println(score);
		 
		//计算查全率和查准率
		RecommenderIRStatsEvaluator statsEvaluator = new GenericRecommenderIRStatsEvaluator();
		 
		// Evaluate precision and recall "at 2":(评估精度并在“2”时召回：)
		IRStatistics stats = statsEvaluator.evaluate(recommenderBuilder,
		        null, model, null, 4,
		        GenericRecommenderIRStatsEvaluator.CHOOSE_THRESHOLD,
		        1.0);
		System.out.println(stats.getPrecision());

	}
}
