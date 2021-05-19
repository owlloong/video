package com.test.hadoop.mahout;

import java.io.File;
import java.io.IOException;
import java.util.List;


import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
public class UserCFByLocalData {

    final static int NEIGHBORHOOD_NUM = 2;
    final static int RECOMMENDER_NUM = 3;

    public static void main(String[] args) throws IOException, TasteException {
    	
    	String path = UserCFByLocalData.class.getClassLoader().getResource("").getPath();
    	
        String file = path + "datafile/item.csv";
        DataModel model = new FileDataModel(new File(file));
    	//用户相似度，使用基于皮尔逊相关系数计算相似度
//    	UserSimilarity user = new PearsonCorrelationSimilarity(model);
        UserSimilarity user = new EuclideanDistanceSimilarity(model);
        
    	//选择邻居用户，使用NearestNUserNeighborhood实现UserNeighborhood接口，选择邻近的NEIGHBORHOOD_NUM个用户
        NearestNUserNeighborhood neighbor = new NearestNUserNeighborhood(NEIGHBORHOOD_NUM, user, model);

        Recommender r = new GenericUserBasedRecommender(model, neighbor, user);
        
// 	基于item的推荐，没有选择邻居步骤
//		ItemSimilarity itemSimilarity = new PearsonCorrelationSimilarity(model);
//		Recommender recommender2 = new GenericItemBasedRecommender(model, itemSimilarity);

        
        LongPrimitiveIterator iter = model.getUserIDs();

        while (iter.hasNext()) {
           // long uid = iter.nextLong();
        	long uerId = iter.nextLong();
            
          //给用户uerId推荐RECOMMENDER_NUM个物品
            List<RecommendedItem> list = r.recommend(uerId, RECOMMENDER_NUM);
            System.out.printf("uerId:%s", uerId);
            for (RecommendedItem ritem : list) {
                System.out.printf("(%s,%f)", ritem.getItemID(), ritem.getValue());
                
            }
            System.out.println();
            
        }
    }

}
